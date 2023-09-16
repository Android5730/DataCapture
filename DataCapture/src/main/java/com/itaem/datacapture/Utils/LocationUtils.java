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
import android.os.Bundle;
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
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;
    private LocationUtils(Context context) {
        mContext = context;
        preferences = mContext.getSharedPreferences("locaiton",MODE_PRIVATE);
        edit = preferences.edit();
        getLocation(context);
    }

    //实现单例
    public static LocationUtils getInstance(Context context) {
        if (uniqueInstance == null) {
            synchronized (LocationUtils.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new LocationUtils(context);
                }
            }
        }
        return uniqueInstance;
    }

    //获取经纬度location
    private void getLocation(Context context) {
        //1.获取位置管理器
        LocationManager locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
        //2.获取位置提供器，GPS或是NetWork
        List<String> providers = locationManager.getProviders(true);
        Log.d("TAG", "打印位置提供器: ");
        if (providers!=null&&providers.size()!=0){
            for (String proviceder:providers){
                if (locationManager.isProviderEnabled(proviceder)) {
                    Log.d("TAG", "longitude：gps_toOpen" );
                    // 需要检查权限,否则编译报错,想抽取成方法都不行,还是会报错。只能这样重复 code 了。
                    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        Log.d("数据抓取:LocationUtils", "并未申请相关权限");
                        return;
                    }
                    Location location = locationManager.getLastKnownLocation(proviceder);
                    Log.d("TAG", "getLocation: "+proviceder);
                    if (location!=null){
                        setLocation(location);
                        getAddress(context,location);
                    }
                    locationManager.requestLocationUpdates(proviceder, 5000, 3, new LocationListener() {
                        @Override
                        public void onLocationChanged(@NonNull Location location) {
                            if (location!=null){
                                setLocation(location);
                                getAddress(context,location);
                                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                                    locationManager.removeUpdates(this);
                                }
                            }
                        }

                    });
                }
            }
        }
    }




    private void setLocation(Location location) {
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
        Log.d("TAG", "splocation_get"+preferences.getString("longitude",""));
        return preferences.getString("longitude","");


    }
    public String getLatitude(){
        Log.d("TAG", "splocation_get"+preferences.getString("Latitude",""));
        return preferences.getString("Latitude","");
    }

    //获取经纬度
    public Location showLocation() {
        if (location!=null){
            Log.d("TAG", "经纬度" + location.getLongitude());
            Log.d("TAG", "经纬度" + location.getLatitude());
        }
        Log.d("TAG", "location_tag" + tag);
        return location;
    }
    private AddressInfo addressInfo = new AddressInfo();
    private String address = "";
    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public String getAddress() {
        return address;
    }

    //获取地址信息:城市、街道等信息
    public String getAddress(Context context,Location location) {
        List<Address> result;
        try {
            if (location != null) {
                Geocoder gc = new Geocoder(context, Locale.getDefault());
                // 返回一个地址数组，该数组试图描述给定纬度和经度周围的区域。
                // 返回的地址应该根据提供给该类构造函数的区域设置进行本地化。
                // 结果可以通过网络查找的方式获得，这个方法可能需要一些时间来返回，因此不应该在主线程上调用。
                result = gc.getFromLocation(location.getLatitude(),
                        location.getLongitude(), 1);
                for (int i = 0; i < result.size(); i++) {
                    address = result.get(i).toString();
                }
                addressInfo.gps_latitude = String.valueOf(result.get(0).getLatitude());
                addressInfo.gps_longitude = String.valueOf(result.get(0).getLongitude());
                addressInfo.gps_address_street = result.get(0).getAddressLine(2);
                addressInfo.gps_address_province = result.get(0).getAdminArea();
                addressInfo.gps_address_city = result.get(0).getLocality();
                addressInfo.gps_address_country = result.get(0).getAddressLine(0);
                addressInfo.gps_address_countryCode = result.get(0).getCountryCode();
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
        private String gps_address_country;// 国家
        private String gps_address_countryCode;// 国家代码

        public AddressInfo() {}

        public String getGps_address_country() {
            return gps_address_country;
        }

        public String getGps_address_countryCode() {
            return gps_address_countryCode;
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

