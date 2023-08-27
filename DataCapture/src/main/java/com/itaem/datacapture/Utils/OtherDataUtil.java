//package com.itaem.datacapture.Utils;// 2023/8/13
//
//import android.content.Context;
//import android.os.SystemClock;
//import android.telephony.SignalStrength;
//import android.telephony.TelephonyManager;
//
//import com.itaem.datacapture.bean.DeviceInfoBean;
//
//import java.io.File;
//
//// 作者:ITAEM 陈金城
//public class OtherDataUtil {
//    /**
//     * 获取其他信息
//     *       int keyboard = 1;// 连接到设备的键盘种类   很迷
//     */
//    public  DeviceInfoBean.OtherDataBean getOtherDataBean(Context context){
//        OtherData otherData = new OtherData();
//        String level = "-1"; // 手机的信号强度 默认值-1
//        TelephonyManager telephonyManager = (TelephonyManager)context. getSystemService(Context.TELEPHONY_SERVICE);
//        SignalStrength signalStrength;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
//            signalStrength = telephonyManager.getSignalStrength();
//            if (signalStrength!=null){
//                if ((-113 + 2 * signalStrength.getGsmSignalStrength())>0){
//                    level =  String.valueOf((-113 + 2 * signalStrength.getGsmSignalStrength())*-1);
//                }else {
//                    level =String.valueOf((-113 + 2 * signalStrength.getGsmSignalStrength()));// 获取信号强度的单位为dBm
//                }
//            }
//        }
//
//        int keyboard = 1;// 连接到设备的键盘种类
//        long uptimeMillis = SystemClock.elapsedRealtime();
//        long currentTimeMillis = System.currentTimeMillis();
//        long bootTimeMillis = currentTimeMillis - uptimeMillis;
//        String bootTime = String.valueOf(bootTimeMillis/1000);
//        String last_boot_time = String.valueOf(otherData.last_boot_time);// 最后一次启动时间
//        int root_jailbreak = isRooted()?1:0 ;// 是否root
//        int simulator = otherData.simulator ;// 是否是模拟器
//        return new DeviceInfoBean.OtherDataBean(level, keyboard, last_boot_time.equals("0")?bootTime:last_boot_time, root_jailbreak, simulator);
//    }
//
//    /**
//     * 设备是否root
//     */
//    public boolean isRooted() {
//        boolean isRooted = false;
//        try {
//            File file = new File("/system/app/Superuser.apk");
//            if (file.exists()) {
//                isRooted = true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return isRooted;
//    }
//}
