package com.itaem.datacapture.Utils;// 2023/8/13

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.util.Log;

import com.itaem.datacapture.bean.BatteryStatusBean;

// 作者:ITAEM 陈金城
public class BatteryStatusUtil {
    /**
     * 获取设备电量数据
     */
    public static BatteryStatusBean getBatteryState(Context context) {
        boolean is_usb_charge = false;
        boolean is_ac_charge = false;
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean is_charging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;// 是否充电
        if (is_charging) {
            int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            is_usb_charge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            is_ac_charge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
        }

        // 电池总容量
        Object mPowerProfile;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
            int capacity = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            System.out.println("电量" + capacity);
        }

        double battery_max = 0;
        if (isMIUI()) {
            battery_max = getBatteryCapacityMIUI(context);
        }
        if (battery_max==0.0){
            final String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";
            try {
                mPowerProfile = Class.forName(POWER_PROFILE_CLASS)
                        .getConstructor(Context.class)
                        .newInstance(context);

                battery_max = (double) Class
                        .forName(POWER_PROFILE_CLASS)
                        .getMethod("getBatteryCapacity")
                        .invoke(mPowerProfile);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("反射出现问题");
            }
        }

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);// 当前电量
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        double batteryPct = level * 1.0 / (float) scale;
        double battery_level = battery_max * batteryPct;// 当前电量
        return new BatteryStatusBean(String.valueOf(battery_level), String.valueOf(battery_max),
                level, is_charging ? 0 : 1, is_ac_charge ? 1 : 0, is_charging ? 0 : 1, is_usb_charge ? 1 : 0);

    }
    private static boolean isMIUI() {
        try {
            Class<?> miuiUtilsClass = Class.forName("miui.os.Build");
            return miuiUtilsClass.getField("IS_MIUI").getBoolean(null);
        } catch (Exception e) {
            Log.e("BatteryUtils", "Error checking MIUI: " + e.getMessage());
        }
        return false;
    }
    // 获取小米设备的电池容量
    private static double getBatteryCapacityMIUI(Context context) {
        double capacity = 0.0;
        try {
            IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = context.registerReceiver(null, ifilter);
            int chargeCounter = batteryStatus.getIntExtra("charge_counter", -1);
            int capacityMicroAh = batteryStatus.getIntExtra("capacity_microamp", -1);

            if (chargeCounter != -1 && capacityMicroAh != -1) {
                capacity = (double) chargeCounter / capacityMicroAh;
            }
        } catch (Exception e) {
            Log.e("BatteryUtils", "Error getting battery capacity for MIUI: " + e.getMessage());
        }
        return capacity;
    }
}
