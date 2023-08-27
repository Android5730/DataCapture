//package com.itaem.datacapture.Utils;// 2023/8/13
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Build;
//import android.util.DisplayMetrics;
//
//import com.itaem.datacapture.bean.DeviceInfoBean;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//// 作者:ITAEM 陈金城
//public class HardwareUtil {
//    /**
//     * 获取硬件信息
//     */
//    public DeviceInfoBean.HardwareBean getHardwareBean(Context context) {
//        HardwareData hardwareData = new HardwareData();
//        String board = hardwareData.board; // 主板
//        String brand = hardwareData.brand;// 设备品牌
//        String kernelVersion = System.getProperty("os.version");
//        String cores = String.valueOf(Runtime.getRuntime().availableProcessors());
//        DisplayMetrics metrics = new DisplayMetrics();
//        Activity activity = (Activity) context;
//        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int device_height = metrics.heightPixels;// 分辨率高
////        String device_name1 = Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
////        String device_name = Build.MODEL;
//        String device_name = Build.DEVICE; // 获取设备名称
//        int device_width = metrics.widthPixels;// 分辨率宽
//        String model = hardwareData.model;// 设备型号
//        String physical_size = hardwareData.physical_size;// 物理尺寸
//        String production_date = null;
//        try {
//            production_date = getProductionDate();// 出厂时间戳
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String release = hardwareData.release;// 系统版本
//        String sdk_version = hardwareData.sdk_version_code;// SDK版本
//        String serial_number = hardwareData.serial_number;// 设备序列号
//        return new DeviceInfoBean.HardwareBean(board, brand, cores, device_height, device_name, device_width,
//                model, physical_size, production_date, release, sdk_version, serial_number);
//    }
//
//    /**
//     * 获取出厂时间戳(设备爆空，后续解决)
//     */
//    private String getProductionDate() throws IOException {
//        String manufacture = Build.MANUFACTURER;
//        String device = Build.DEVICE;
//        String product = Build.PRODUCT;
//        String model = Build.MODEL;
//        String command = "";
//        if (model.equals("Nexus 5X")) {
//            command = "getprop ro.boot." + manufacture.toLowerCase() + "." + device.toLowerCase() + "." + product.toLowerCase() + "." + "bullhead" + ".date";
//        } else if (model.equals("Nexus 6P")) {
//            command = "getprop ro.boot." + manufacture.toLowerCase() + "." + device.toLowerCase() + "." + product.toLowerCase() + "." + "angler" + ".date";
//        } else {
//            command = "getprop ro.build.date.utc";
//        }
//        Process process = Runtime.getRuntime().exec(command);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String dateTime = reader.readLine();
//        long timestamp = Long.parseLong(dateTime.equals("") ? "0" : dateTime);
//        System.out.println("出厂时间戳" + timestamp);
//        return String.valueOf(timestamp);
//    }
//
//}
