//package com.itaem.datacapture.Utils;// 2023/8/13
//
//import static android.content.Context.CONNECTIVITY_SERVICE;
//
//import android.Manifest;
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorManager;
//import android.net.ConnectivityManager;
//import android.net.Network;
//import android.net.NetworkCapabilities;
//import android.net.NetworkInfo;
//import android.os.Build;
//import android.os.SystemClock;
//import android.provider.Settings;
//import android.telephony.TelephonyManager;
//import android.text.TextUtils;
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
//        String and_id = getAndroidID(context); // android_id
//        String currentSystemTime = String.valueOf(System.currentTimeMillis()); // 设备当前时间
//        String elapsedRealtime = String.valueOf(SystemClock.elapsedRealtime()); // 开机时间到现在的毫秒数（包括睡眠时间）
//        String gaid = getGoogleId(context);
//        String imei = getIMEI(context); // 设备号
//        boolean is_usb_debug = isAppDebug(context) == 1; // 是否开启debug调试
//        boolean is_using_proxy_port = getIsWifiProxy(context) == 1; // 是否使用代理
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
//    @SuppressLint("HardwareIds")
//    public static String getAndroidID(Context context) {
//        String id = Settings.Secure.getString(
//                context.getContentResolver(),
//                Settings.Secure.ANDROID_ID
//        );
//        if ("9774d56d682e549c".equals(id)) return "";
//        return id == null ? "" : id;
//    }
////    private String getGoogleId(Context context) {
////        AdvertisingIdClient.Info adInfo = null;
////        try {
////            adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        String gaid = null; // 广告id
////        if (adInfo != null) {
////            gaid = adInfo.getId();
////        }
////        return gaid;
////    }
//    /**
//     * 获取设备的唯一标识， 需要 “android.permission.READ_Phone_STATE”权限
//     * 因为权限限制，超过29本来需要另外的权限，甲方要求不加权限，故在此直接获取设备id
//     */
//    public String getIMEI(Context context) {
//        String reStr = "";
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            reStr = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
//            // Android 10及以上版本需要动态请求权限
//        } else {
//            // Android 10以下版本可以直接获取IMEI
//            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                reStr = telephonyManager.getImei();
//            }
//        }
//        return reStr;
//    }
//
//    /**
//     * 是否开启debug调试
//     * @param context
//     * @return
//     */
//    public static int isAppDebug(Context context) {
//        boolean b = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, 0) > 0;
//        if (b) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    /**
//     * 是否开启代理
//     * @param context
//     * @return
//     */
//    public static int getIsWifiProxy(Context context) {
//        final boolean IS_ICS_OR_LATER = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
//        String proxyAddress;
//        int proxyPort;
//        if (IS_ICS_OR_LATER) {
//            proxyAddress = System.getProperty("http.proxyHost");
//            String portStr = System.getProperty("http.proxyPort");
//            proxyPort = Integer.parseInt((portStr != null ? portStr : "-1"));
//        } else {
//            proxyAddress = android.net.Proxy.getHost(context);
//            proxyPort = android.net.Proxy.getPort(context);
//        }
//        boolean b = (!TextUtils.isEmpty(proxyAddress)) && (proxyPort != -1);
//        if (b) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    /**
//     * 判断设备是否是开启VPN
//     */
//    private  boolean isVpnConnected(Context context) {
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
//        Network[] networks = cm.getAllNetworks();
//        for (Network network : networks) {
//            NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
//            if (capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 网络类型
//     * @param type
//     * @return
//     */
//    private String getNetWorkType(String type) {
//        String str;
//        switch (type) {
//            case "NETWORK_WIFI":
//                str = "wifi";
//                break;
//            case "NETWORK_2G":
//                str = "2G";
//                break;
//            case "NETWORK_3G":
//                str = "3G";
//                break;
//            case "NETWORK_4G":
//                str = "4G";
//                break;
//            case "NETWORK_5G":
//                str = "5G";
//                break;
//            case "NETWORK_NO":
//                str = "none";
//                break;
//            default:
//                str = "other";
//                break;
//        }
//        return str;
//    }
//
////    public static String getNetworkType() {
////        if (isChekSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE)) {
////            return "NETWORK_NO";
////        }
////        if (isEthernet()) {
////            return "NETWORK_ETHERNET";
////        }
////        ConnectivityManager cm =
////                (ConnectivityManager) AppUtil.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
////        if (cm == null) {
////            return null;
////        }
////        NetworkInfo info = cm.getActiveNetworkInfo();
////        if (info != null && info.isAvailable()) {
////            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
////                return "NETWORK_WIFI";
////            } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
////                switch (info.getSubtype()) {
////                    case TelephonyManager.NETWORK_TYPE_GSM:
////                    case TelephonyManager.NETWORK_TYPE_GPRS:
////                    case TelephonyManager.NETWORK_TYPE_CDMA:
////                    case TelephonyManager.NETWORK_TYPE_EDGE:
////                    case TelephonyManager.NETWORK_TYPE_1xRTT:
////                    case TelephonyManager.NETWORK_TYPE_IDEN:
////                        return "NETWORK_2G";
////
////                    case TelephonyManager.NETWORK_TYPE_TD_SCDMA:
////                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
////                    case TelephonyManager.NETWORK_TYPE_UMTS:
////                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
////                    case TelephonyManager.NETWORK_TYPE_HSDPA:
////                    case TelephonyManager.NETWORK_TYPE_HSUPA:
////                    case TelephonyManager.NETWORK_TYPE_HSPA:
////                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
////                    case TelephonyManager.NETWORK_TYPE_EHRPD:
////                    case TelephonyManager.NETWORK_TYPE_HSPAP:
////                        return "NETWORK_3G";
////
////                    case TelephonyManager.NETWORK_TYPE_IWLAN:
////                    case TelephonyManager.NETWORK_TYPE_LTE:
////                        return "NETWORK_4G";
////
////                    case TelephonyManager.NETWORK_TYPE_NR:
////                        return "NETWORK_5G";
////                    default:
////                        String subtypeName = info.getSubtypeName();
////                        if (subtypeName.equalsIgnoreCase("TD-SCDMA")
////                                || subtypeName.equalsIgnoreCase("WCDMA")
////                                || subtypeName.equalsIgnoreCase("CDMA2000")) {
////                            return "NETWORK_3G";
////                        } else {
////                            return "NETWORK_UNKNOWN";
////                        }
////                }
////            } else {
////                return "NETWORK_UNKNOWN";
////            }
////        }
////        return "NETWORK_NO";
////    }
//}
