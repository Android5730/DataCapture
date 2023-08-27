//package com.itaem.datacapture.Utils;// 2023/8/13
//
//import static android.content.Context.CONNECTIVITY_SERVICE;
//import static android.content.Context.WIFI_SERVICE;
//
//import android.content.ContentResolver;
//import android.content.Context;
//import android.content.pm.PackageInfo;
//import android.content.pm.PackageManager;
//import android.database.Cursor;
//import android.location.Location;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.net.Uri;
//import android.net.wifi.WifiInfo;
//import android.net.wifi.WifiManager;
//import android.os.Build;
//import com.google.android.gms.ads.identifier.AdvertisingIdClient;
//import android.os.Handler;
//import android.os.Message;
//import android.provider.MediaStore;
//import android.provider.Settings;
//import android.telephony.TelephonyManager;
//
//import androidx.annotation.NonNull;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.Inet4Address;
//import java.net.InetAddress;
//import java.net.NetworkInterface;
//import java.net.SocketException;
//import java.util.Date;
//import java.util.Enumeration;
//
//// 作者:ITAEM 陈金城
//public class DeviceInfoUtil {
//
//    public void postDevice_info(Context context, Location location) throws Exception {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HardwareData hardwareData = new HardwareData();
//
//                String create_time = String.valueOf(new Date().getTime());// 抓取时间
//                //      int download_files = new MediaFilesData().download_files;// 下载文件个数
//                String pageName = "包名";// 包名
//                String gps_adid = getGoogleId(context);// gps_adid Google Play Services 广告 ID
//                String device_id = getIMEI(context);// 设备ID
//                //       String developmentRegion = "java";// 开发语言
//                String device_info = Build.MODEL; // 设备信息
//                String os_type = "android"; // 设备系统类型
//                String os_version = hardwareData.release; // 设备系统版本
//                String ip = getIpAddressString(); // ip
//
//                ReqBean.ExtInfoReqBean.DeviceInfoBean.BatteryStatusBean batteryState = getBatteryState(context);
//                String gps_longitude = String.valueOf(LocationUtils.getInstance(context).getLongitude()); // 经度
//                String gps_latitude = String.valueOf(LocationUtils.getInstance(context).getLatitude()); // 维度
//                String gps_address = LocationUtils.getAddress(context, location);// GPS地址
//                String address_info = LocationUtils.getAddress(context, location);// 详细地址
//                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(WIFI_SERVICE);
//                OtherData otherData = new OtherData();
//                int is_simulator = otherData.simulator; // 是否为模拟器
//                int last_login_time = (int) lastLaunch(context);// 上次活跃时间戳(秒) 需要其余权限或者用户设置许可，故采取
//                ReqBean.ExtInfoReqBean.DeviceInfoBean.NewStorageBean newStorageBean = SDCardUtils.getNewStorageBean();// 存储bean
//                //    new ReqBean.ExtInfoReqBean.DeviceInfoBean()
//                int[] mediaCount = getMediaCount(context);
//                int[] pictureCount = getPictureCount(context);
//                int[] videoCount = getVideoCount(context);
//                String[] wifiName = getWifiName(context);
//                ReqBean.ExtInfoReqBean.DeviceInfoBean.NetworkBean networkBean = null;
//                networkBean = getNetworkBean(context);
//                PackageManager packageManager = context.getPackageManager();
//                PackageInfo packageInfo = null;
//                try {
//                    packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
//
//                } catch (PackageManager.NameNotFoundException e) {
//                    e.printStackTrace();
//                }
//                int versionCode = 0;
//
//                if (packageInfo != null) {
//                    versionCode = packageInfo.versionCode;
//                }
//
//                //    StorageData storageData = StorageQueryUtil.queryWithStorageManager(new StorageData());
//                ReqBean.ExtInfoReqBean.DeviceInfoBean.HardwareBean hardwareBean = getHardwareBean(context);
//                String resolution = hardwareBean.getDevice_width() + "x" + hardwareBean.getDevice_height();
//                ReqBean.ExtInfoReqBean.DeviceInfoBean deviceInfoBean = new ReqBean.ExtInfoReqBean.DeviceInfoBean(
//                        address_info, "", mediaCount[1], batteryState.getBattery_pct(), batteryState, hardwareData.brand, String.valueOf(versionCode),
//                        Constant.version, create_time, device_id, device_info, getGeneralData(context),
//                        gps_address, gps_adid, gps_latitude, gps_longitude, hardwareBean, "", "", pictureCount[1], getIMEI(context), ip, isRooted() ? 1 : 0, is_simulator, String.valueOf(last_login_time),
//                        getMAC(context), newStorageBean.getInternal_storage_total(), networkBean, newStorageBean, os_type, os_version, getOtherDataBean(context), pageName,
//                        resolution, String.valueOf(StorageQueryUtil.queryWithStorageManager(new StorageData()).memory_card_size), newStorageBean.getInternal_storage_usable(),
//                        videoCount[1], Integer.parseInt(wifiName[1]), getIMSI(context)
//                );
//                ReqBean reqBean = new ReqBean(new ReqBean.ExtInfoReqBean(deviceInfoBean, null, null, null, null, null, null,null));
//                Message message = new Message();
//                message.arg1 = 6;
//                message.obj = reqBean;
//                handler.sendMessage(message);
//            }
//        }).start();
//    }
//
//    /**
//     * 获取音频个数(外部和内部)
//     */
//    private int[] getMediaCount(Context context) {
//        int[] MediaCount = new int[2];
//        ContentResolver contentResolver = context.getContentResolver();
///*        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//        String[] projection = {MediaStore.Audio.Media._ID};
//        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
//        Cursor cursor = contentResolver.query(uri, projection, selection, null, null);
//        int audio_external = cursor.getCount(); // 外部
//        MediaCount[0] = audio_external;
//        cursor.close();*/
///*        String[] projectionInner = {MediaStore.Audio.Media._ID};
//        String selectionInner = MediaStore.Audio.Media.IS_MUSIC + " != 0";*/
//        Uri audioUri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
//        Cursor cursorInner = context.getContentResolver().query(audioUri, null, null, null, null);
//        int audio_internal = cursorInner.getCount();// 内部
//        MediaCount[1] = audio_internal;
//        cursorInner.close();
//        return MediaCount;
//    }
//
//    /**
//     * 获取图片个数（内部、外部）
//     */
//    private int[] getPictureCount(Context context) {
//        int[] imagesCount = new int[3];
////        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//        String[] projection = {MediaStore.Images.Media._ID};
////        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
////        int images_external = cursor.getCount();// 外部图片
//        imagesCount[0] = 0;
////        cursor.close();
//        Uri uriInner = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
//        Cursor cursorInner = context.getContentResolver().query(uriInner, projection, null, null, null);
//        int images_internal = cursorInner.getCount(); // 内部图片
//        imagesCount[1] = images_internal;
//        cursorInner.close();
//        int pic_count = images_internal;
//        imagesCount[2] = pic_count;
//        return imagesCount;
//
//    }
//
//    /**
//     * 获取视频个数（内、外）
//     */
//    private int[] getVideoCount(Context context) {
//        int[] videoCount = new int[3];
//        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//        String[] projection = {MediaStore.Video.Media._ID};
////        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
////        int video_external = cursor.getCount();
//        videoCount[0] = 0;
////        cursor.close();
//        Uri uriInner = MediaStore.Video.Media.INTERNAL_CONTENT_URI;
//        Cursor cursorInner = context.getContentResolver().query(uriInner, projection, null, null, null);
//        int video_internal = cursorInner.getCount();
//        videoCount[1] = video_internal;
//        cursorInner.close();
//        videoCount[2] = video_internal;
//        return videoCount;
//    }
//
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
//     * 获取imsi
//     */
//    private String getIMSI(Context context) {
//        String imsi = "";
//        // 在代码中获取 IMSI
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//
//            // 甲方权限限制
//  /*          TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//                imsi = telephonyManager.getSubscriberId();
//            }*/
//        } else {
//            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//            imsi = telephonyManager.getSubscriberId();
//        }
//        if (imsi == null) {
//            imsi = "";
//        }
//        return imsi;
//    }
//
//    /**
//     * 获取是否连接wifi和wifi名称
//     */
//    private String[] getWifiName(Context context) {
//        String[] wifiInfoArray = new String[2];
//        String wifiName = ""; // 名称
//        int is_wifi = -1;//是否连接
//        // 获取连接管理器
//        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
//        // 获取当前网络信息
//        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
//        // 判断当前网络是否连接
//        if (networkInfo != null && networkInfo.isConnected()) {
//            // 判断当前网络是否为 WiFi
//            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
//                is_wifi = 1;
//                // 获取 WiFi 信息
//                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(WIFI_SERVICE);
//                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//                    wifiName = "";
//                } else {
//                    wifiName = wifiInfo.getSSID();
//                    // 如果获取到的 WiFi 名称以双引号开头和结尾，则去掉双引号
//                    if (wifiName.startsWith("\"") && wifiName.endsWith("\"")) {
//                        wifiName = wifiName.substring(1, wifiName.length() - 1);
//                    }
//                    // 输出 WiFi 名称
//                    System.out.println("WiFi 名称：" + wifiName);
//                }
//            }
//        }
//        if (is_wifi != 1) {
//            is_wifi = 0;
//        }
//        wifiInfoArray[0] = wifiName;
//        wifiInfoArray[1] = String.valueOf(is_wifi);
//        return wifiInfoArray;
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
//
//    /**
//     * 获取mac地址
//     */
//    private String getMAC(Context context) {
//        String macAddress = "";
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            try {
//                // wifi已经连接，这里可以判断一下
//                InputStream inputStream = new FileInputStream("/sys/class/net/wlan0/address");
//                InputStreamReader reader = new InputStreamReader(inputStream);
//                BufferedReader br = new BufferedReader(reader);
//                macAddress = br.readLine();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
///*            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//            macAddress = wifiInfo.getMacAddress();*/
//        }
//        return macAddress;
//    }
//    /**
//     * 获取google广告id
//     */
//    private String getGoogleId(Context context) {
//        AdvertisingIdClient.Info adInfo = null;
//        try {
//            adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String gaid = null; // 广告id
//        if (adInfo != null) {
//            gaid = adInfo.getId();
//        }
//        return gaid;
//    }
//
//    // 获取设备ip
//    public  String getIpAddressString() {
//        try {
//            for (Enumeration<NetworkInterface> enNetI = NetworkInterface
//                    .getNetworkInterfaces(); enNetI.hasMoreElements(); ) {
//                NetworkInterface netI = enNetI.nextElement();
//                for (Enumeration<InetAddress> enumIpAddr = netI
//                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
//                    InetAddress inetAddress = enumIpAddr.nextElement();
//                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
//                        return inetAddress.getHostAddress();
//                    }
//                }
//            }
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//}
