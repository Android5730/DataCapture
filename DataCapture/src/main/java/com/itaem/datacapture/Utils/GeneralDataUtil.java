//package com.itaem.datacapture.Utils;// 2023/8/13
//
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorManager;
//import android.os.SystemClock;
//import android.provider.Settings;
//import android.telephony.TelephonyManager;
//
//import com.itaem.datacapture.bean.GeneralDataBean;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//// 作者:ITAEM 陈金城
//public class GeneralDataUtil {
//    /**
//     * 获取设备基本信息
//     */
//    private GeneralDataBean getGeneralData(Context context) {
//        GeneralData generalData = new GeneralData();
//        OtherData otherData = new OtherData();
//        String and_id = generalData.and_id; // android_id
//        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
//        String currentSystemTime = String.valueOf(System.currentTimeMillis()); // 设备当前时间
//        String elapsedRealtime = String.valueOf(SystemClock.elapsedRealtime()); // 开机时间到现在的毫秒数（包括睡眠时间）
//        String gaid = getGoogleId(context);
//        String imei = getIMEI(context); // 设备号
//        boolean is_usb_debug = otherData.is_usb_debug == 1; // 是否开启debug调试
//        boolean is_using_proxy_port = otherData.is_using_proxy_port == 1; // 是否使用代理
//        boolean is_using_vpn = isVpnConnected(context); // 是否使用vpn
//        String language = generalData.language; // 语言
//        String locale_display_language = generalData.locale_display_language; // 此用户显示的语言环境语⾔的名称
//        String locale_iso_3_country = generalData.locale_iso_3_country; // 此地区的国家/地区的缩写
//        String locale_iso_3_language = generalData.locale_iso_3_language; // 语言环境的三字母缩写
//        String mac = generalData.mac; // mac
//        String network_operator_name = generalData.network_operator_name; // 网络运营商名称
//        String network_type = getNetWorkType(generalData.network_type); // 网络类型 2G、3G、4G、5G、wifi、other、none
//        String network_type_new = getNetWorkType(generalData.network_type); // 网络类型 2G、3G、4G、5G、wifi、other、none
//        String phone_number = ""; // 手机号
//        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//        int phoneType = telephonyManager.getPhoneType(); // 指示设备电话类型的常量。 这表示用于传输语音呼叫的无线电的类型
//        String time_zone_id = generalData.time_zone_id; // 时区的 ID
//        String uptimeMillis = String.valueOf(SystemClock.uptimeMillis()); // 从开机到现在的毫秒数（不包括睡眠时间）
//        String uuid = UUID.randomUUID().toString().toUpperCase(); // 唯一标识
//        String wifi_mac = getMAC(context); //
//        // 传感器信息
//        List<GeneralDataBean.SensorListBean> sensorListBeans = getSensorListBean(context);
//        return new GeneralDataBean(and_id, currentSystemTime, elapsedRealtime,
//                gaid, imei, is_usb_debug, is_using_proxy_port, is_using_vpn, language, locale_display_language, locale_iso_3_country,
//                locale_iso_3_language, mac, network_operator_name, network_type, network_type_new,
//                phone_number, phoneType, time_zone_id, uptimeMillis, uuid, sensorListBeans);
//    }
//    /**
//     * 传感器信息
//     */
//    private List<GeneralDataBean.SensorListBean> getSensorListBean(Context context) {
//        List<GeneralDataBean.SensorListBean> sensorListBeans = new ArrayList<>();
//        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        for (int i = 0; i < sensorList.size(); i++) {
//            Sensor sensor = sensorList.get(i);
//            sensorListBeans.add(new GeneralDataBean.SensorListBean(String.valueOf(sensor.getMaximumRange()),
//                    String.valueOf(sensor.getMinDelay()), sensor.getName(), String.valueOf(sensor.getPower()),
//                    String.valueOf(sensor.getResolution()), String.valueOf(sensor.getType()),
//                    String.valueOf(sensor.getVendor()), String.valueOf(sensor.getVersion())));
//        }
//        return sensorListBeans;
//    }
//}
