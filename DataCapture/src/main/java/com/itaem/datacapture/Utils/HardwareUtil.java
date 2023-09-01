package com.itaem.datacapture.Utils;// 2023/8/13

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.itaem.datacapture.bean.DeviceInfoBean;
import com.itaem.datacapture.bean.HardwareBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

// 作者:ITAEM 陈金城
public class HardwareUtil {
    /**
     * 获取硬件信息
     */
    public static HardwareBean getHardwareBean(Context context) {
        String board = Build.BOARD; // 主板
        String brand = Build.BRAND;// 设备品牌
        String kernelVersion = System.getProperty("os.version");
        String cores = String.valueOf(Runtime.getRuntime().availableProcessors());
        DisplayMetrics metrics = new DisplayMetrics();
        Activity activity = (Activity) context;
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int device_height = metrics.heightPixels;// 分辨率高
        String device_name = Build.DEVICE; // 获取设备名称
        int device_width = metrics.widthPixels;// 分辨率宽
        String model = Build.MODEL;// 设备型号
        String physical_size = getScreenSizeOfDevice2(context);// 物理尺寸
        String production_date = null;
        try {
            production_date = getProductionDate();// 出厂时间戳
        } catch (IOException e) {
            e.printStackTrace();
        }
        String release = Build.VERSION.RELEASE;// 系统版本
        String sdk_version = String.valueOf(Build.VERSION.SDK_INT);// SDK版本
        String serial_number = getSerialNumbers();// 设备序列号
        return new HardwareBean(board, brand, cores, device_height, device_name, device_width,
                model, physical_size, production_date, release, sdk_version, serial_number);
    }
    private static String getScreenSizeOfDevice2(Context context) {
        Point point = new Point();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getRealSize(point);
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        double x = Math.pow(point.x / dm.xdpi, 2);
        double y = Math.pow(point.y / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);
        return String.valueOf(screenInches);
    }


    private static String getSerialNumbers() {
        String serial = "";
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {//9.0+
                serial = Build.getSerial();
            } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {//8.0+
                serial = Build.SERIAL;
            } else {//8.0-
                Class<?> c = Class.forName("android.os.SystemProperties");
                Method get = c.getMethod("get", String.class);
                serial = (String) get.invoke(c, "ro.serialno");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("e", "读取设备序列号异常：" + e.toString());
        }
        return serial;
    }
    /**
     * 获取出厂时间戳(设备爆空，后续解决)
     */
    private static String getProductionDate() throws IOException {
        String manufacture = Build.MANUFACTURER;
        String device = Build.DEVICE;
        String product = Build.PRODUCT;
        String model = Build.MODEL;
        String command = "";
        if (model.equals("Nexus 5X")) {
            command = "getprop ro.boot." + manufacture.toLowerCase() + "." + device.toLowerCase() + "." + product.toLowerCase() + "." + "bullhead" + ".date";
        } else if (model.equals("Nexus 6P")) {
            command = "getprop ro.boot." + manufacture.toLowerCase() + "." + device.toLowerCase() + "." + product.toLowerCase() + "." + "angler" + ".date";
        } else {
            command = "getprop ro.build.date.utc";
        }
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String dateTime = reader.readLine();
        long timestamp = Long.parseLong(dateTime.equals("") ? "0" : dateTime);
        System.out.println("出厂时间戳" + timestamp);
        return String.valueOf(timestamp);
    }

}
