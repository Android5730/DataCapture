package com.itaem.datacapture.Utils;// 2023/4/15

import static android.content.Context.LOCATION_SERVICE;
import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;


import java.util.List;
import java.util.Locale;

/**
 * 获取经纬度、位置工具类
 */
public class LocationUtils {

    @SuppressLint("StaticFieldLeak")
    private volatile static LocationUtils uniqueInstance;
    private Location location;
    private final Context mContext;
    private String tag = "";
    private static int type = -1;// 0为初次开启，1为已经开启了
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;
    private LocationUtils(Context context) {
        mContext = context;
        preferences = mContext.getSharedPreferences("locaiton",MODE_PRIVATE);
        edit = preferences.edit();
        type++;
        getLocation();
    }

    //实现单例
    public static LocationUtils getInstance(Context context) {
        if (uniqueInstance == null) {
            synchronized (LocationUtils.class) {
                if (uniqueInstance == null) {
                    type = 0;
                    uniqueInstance = new LocationUtils(context);
                }
            }
        }
        type = 1;
        return uniqueInstance;
    }

    //获取经纬度location
    private void getLocation() {
        //1.获取位置管理器
        LocationManager locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
        //2.获取位置提供器，GPS或是NetWork
        List<String> providers = locationManager.getProviders(true);
        String locationProvider;
        Log.d("TAG", "打印位置提供器: ");
        if (providers!=null&&providers.size()!=0){
            for (String proviceder:providers){
         if (locationManager.isProviderEnabled(proviceder)) {
            System.out.println("longitude：gps_toOpen" );
            // 需要检查权限,否则编译报错,想抽取成方法都不行,还是会报错。只能这样重复 code 了。
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
             Location location = locationManager.getLastKnownLocation(proviceder);
             Log.d("TAG", "getLocation: "+proviceder);
             if (location!=null){
                 setLocation(location);
             }
             locationManager.requestLocationUpdates(proviceder, 5000, 3, new LocationListener() {
                 @Override
                 public void onLocationChanged(@NonNull Location location) {
                     if (location!=null){
                         setLocation(location);
                         if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                             locationManager.removeUpdates(this);
                         }
                     }
                 }

             });
            }
        }
//        for (String proviceder:providers){
//
//            Log.d("TAG", "getLocation: "+proviceder);
//        }
//        if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
//            //如果是网络定位
//            Log.d("TAG", "如果是网络定位");
//            tag = "如果是网络定位";
//            locationProvider = LocationManager.NETWORK_PROVIDER;
//            // 需要精确的定位权限
//        } /*else if (providers.contains(LocationManager.GPS_PROVIDER)) {
//            //如果是GPS定位
//            Log.d("TAG", "如果是GPS定位");
//            locationProvider = LocationManager.GPS_PROVIDER;
//        } */else {
//            tag = "没有可用的位置提供器";
//            Log.d("TAG", "没有可用的位置提供器");
//            return;
//        }
//
//        if (locationManager.isProviderEnabled(locationProvider)) {
//            System.out.println("longitude：gps_toOpen" );
//            // 需要检查权限,否则编译报错,想抽取成方法都不行,还是会报错。只能这样重复 code 了。
//            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//
//            locationManager.requestSingleUpdate(locationProvider, new LocationListener() {
//                @Override
//                public void onLocationChanged(@NonNull Location location) {
//                    // 在这里获取到新的位置信息
//                    setLocation(location);
//                }
//
//                @Override
//                public void onStatusChanged(String provider, int status, Bundle extras) {
//                }
//
//                @Override
//                public void onProviderEnabled(String provider) {
//                }
//
//                @Override
//                public void onProviderDisabled(String provider) {
//                }
//            }, null);
////            if (type>=1){
////                //3.获取上次的位置，一般第一次运行，此值为null
////                location = locationManager.getLastKnownLocation(locationProvider);
////            }
//
//
//            // 定位失灵，部分模拟器没有定位
//            if (location != null) {
//                System.out.println("longitude_set" + location.getLongitude());
//                System.out.println("longitude_set" + location.getLatitude());
//                setLocation(location);
//            } else {
//                locationManager.requestLocationUpdates(locationProvider, 0, 0, new LocationListener() {
//                    @Override
//                    public void onLocationChanged(@NonNull Location location) {
//                        setLocation(location);
//                        locationManager.removeUpdates(this);
//                    }
//                });
//            }
//        }else {
//            System.out.println("longitude：gps_notToOpen" );
//            // 等待5秒后再尝试获取位置信息
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    getLocation();
//                }
//            }, 3000);


        }


        // 监视地理位置变化，第二个和第三个参数分别为更新的最短时间minTime和最短距离minDistace

    }




    private void setLocation(Location location) {
//        System.out.println("经纬度" + location.getLongitude());
//        System.out.println("经纬度" + location.getLatitude());
        this.location = location;
        if(location!=null){
            setData();
        }
    }
    private void setData(){
        edit.putString("longitude",String.valueOf(location.getLongitude()));
        edit.putString("Latitude",String.valueOf(location.getLatitude()));
        edit.apply();
    }
    public String getLongitude(){
        System.out.println("splocation_get"+preferences.getString("longitude",""));
        return preferences.getString("longitude","");


    }
    public String getLatitude(){
        System.out.println("splocation_get"+preferences.getString("Latitude",""));
        return preferences.getString("Latitude","");
    }
    //获取经纬度
    public Location showLocation() {
        // 取不到定位，默认值为0
//        if (location==null){
//            location = new Location("custom_provider");
//            location.setLatitude(0.0);
//            location.setLongitude(0.0);
//        }

        if (location!=null){
            System.out.println("经纬度" + location.getLongitude());
            System.out.println("经纬度" + location.getLatitude());
        }
        System.out.println("location_tag" + tag);
        return location;
    }


    //获取地址信息:城市、街道等信息
    public static String getAddress(Context context,Location location) {
        List<Address> result;
        AddressInfo addressInfo = null;
        String address = "";
        try {
            if (location != null) {
                Geocoder gc = new Geocoder(context, Locale.getDefault());
                result = gc.getFromLocation(location.getLatitude(),
                        location.getLongitude(), 1);
                for (int i = 0; i < result.size(); i++) {

                    address = result.get(i).toString();
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    public static class AddressInfo{
        private String gps_longitude;// 经度
        private String gps_latitude;// 维度
        private String gps_address_street;// 街道
        private String gps_address_province;// 省份
        private String gps_address_city;// 城市

        public AddressInfo(String gps_longitude, String gps_latitude, String gps_address_street, String gps_address_province, String gps_address_city) {
            this.gps_longitude = gps_longitude==null?"":gps_longitude;
            this.gps_latitude = gps_latitude==null?"":gps_latitude;
            this.gps_address_street = gps_address_street==null?"":gps_address_street;
            this.gps_address_province = gps_address_province==null?"":gps_address_province;
            this.gps_address_city = gps_address_city==null?"":gps_address_city;
        }

        public String getGps_longitude() {
            return gps_longitude;
        }

        public String getGps_latitude() {
            return gps_latitude;
        }

        public String getGps_address_street() {
            return gps_address_street;
        }

        public String getGps_address_province() {
            return gps_address_province;
        }

        public String getGps_address_city() {
            return gps_address_city;
        }
    }
}

