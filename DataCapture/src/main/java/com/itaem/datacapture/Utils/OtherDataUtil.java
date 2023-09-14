package com.itaem.datacapture.Utils;// 2023/8/13

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

import com.itaem.datacapture.bean.OtherDataBean;

import java.io.File;

// 作者:ITAEM 陈金城
public class OtherDataUtil {
    /**
     * 获取其他信息
     *       int keyboard = 1;// 连接到设备的键盘种类   很迷
     */
    public static OtherDataBean getOtherDataBean(Context context){
        String level = "-1"; // 手机的信号强度 默认值-1
        TelephonyManager telephonyManager = (TelephonyManager)context. getSystemService(Context.TELEPHONY_SERVICE);
        SignalStrength signalStrength;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            signalStrength = telephonyManager.getSignalStrength();
            if (signalStrength!=null){
                if ((-113 + 2 * signalStrength.getGsmSignalStrength())>0){
                    level =  String.valueOf((-113 + 2 * signalStrength.getGsmSignalStrength())*-1);
                }else {
                    level =String.valueOf((-113 + 2 * signalStrength.getGsmSignalStrength()));// 获取信号强度的单位为dBm
                }
            }
        }
//        int keyboard = 1;// 连接到设备的键盘种类
        long uptimeMillis = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        long bootTimeMillis = currentTimeMillis - uptimeMillis;
        String bootTime = String.valueOf(bootTimeMillis/1000);
        String last_boot_time = String.valueOf(getBootTime());// 最后一次启动时间
        int root_jailbreak = isRooted()?1:0 ;// 是否root
        int simulator = isEmulator(context) ;// 是否是模拟器
        return new OtherDataBean(level,last_boot_time.equals("0")?bootTime:last_boot_time, root_jailbreak, simulator);
    }

    /**
     * 设备是否root
     */
    public static boolean isRooted() {
        boolean isRooted = false;
        try {
            File file = new File("/system/app/Superuser.apk");
            if (file.exists()) {
                isRooted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRooted;
    }
    /**
     * 获取最后一次启动时间
     */
    public static long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtimeNanos() / 1000000;
    }
    /**
     * 判断是否为模拟器
     */
    public static int isEmulator(Context context) {
        boolean checkProperty = Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.toLowerCase().contains("vbox")
                || Build.FINGERPRINT.toLowerCase().contains("test-keys")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
        if (checkProperty) return 1;
        String operatorName = "";
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            String name = tm.getNetworkOperatorName();
            if (name != null) {
                operatorName = name;
            }
        }
        boolean checkOperatorName = operatorName.toLowerCase().equals("android");
        if (checkOperatorName) return 1;
        String url = "tel:" + "123456";
        Intent intent = new Intent();
        intent.setData(Uri.parse(url));
        intent.setAction(Intent.ACTION_DIAL);
        boolean checkDial = intent.resolveActivity(context.getPackageManager()) == null;
        if (checkDial) return 1;
        return 0;
    }
}
