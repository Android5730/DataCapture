package com.itaem.datacapture.Utils;// 2023/8/13

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.format.Formatter;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import com.itaem.datacapture.bean.DeviceInfoBean;
import com.itaem.datacapture.bean.NetworkBean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 作者:ITAEM 陈金城
public class NetworkBeanUtils {
    /**
     * 获取网路信息
     */
    @SuppressLint("BlockedPrivateApi")
    public static NetworkBean getNetworkBean(Context context) {
        WifiInfo wifiInfo = null;
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        // 获取WiFi信息对象
        wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        // 获取IP地址
        System.out.println("mssid" + getMacAddr());
        String ip = Formatter.formatIpAddress(wifiManager.getDhcpInfo().ipAddress);
        NetworkBean.CurrentWifiBean current_wifi;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            System.out.println("bssid" + wifiInfo.getBSSID());
            System.out.println("ssid" + wifiInfo.getSSID());
            current_wifi = new NetworkBean.CurrentWifiBean(wifiInfo.getBSSID() == null ? "" : wifiInfo.getBSSID(), wifiInfo.getBSSID() == null ? "" : wifiInfo.getBSSID()
                    , wifiInfo.getSSID() == null ? "" : wifiInfo.getSSID(), wifiInfo.getSSID() == null ? "" : wifiInfo.getSSID());
        } else {
            current_wifi = new NetworkBean.CurrentWifiBean(wifiInfo.getBSSID(), wifiInfo.getBSSID(), wifiInfo.getSSID(), wifiInfo.getSSID());
        }
        List<NetworkBean.ConfiguredWifiBean> configuredWifiBeans = new ArrayList<>();
        List<ScanResult> scanResults = wifiManager.getScanResults();
        int wifi_count = scanResults.size(); // wifi个数
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d("NetworkBeanUtils","没有获取精细定位权限——Manifest.permission.ACCESS_FINE_LOCATION");
            return null;
        }
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        int size = 0;
        if (scanResults.size()!=0){
            for (ScanResult scanResult : scanResults){
              //  WifiConfiguration config = configuredNetworks.get(size);
                configuredWifiBeans.add(new NetworkBean.ConfiguredWifiBean(
                        scanResult.BSSID, scanResult.BSSID, scanResult.SSID,scanResult.SSID
                ));
                size++;
            }
        }
        return new NetworkBean(current_wifi, ip,wifi_count,configuredWifiBeans);
    }
    public static String getMacAddr() {
        try {
            return loadFileAsString("/sys/class/net/wlan0/address")
                    .toUpperCase().substring(0, 17);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    private static String loadFileAsString(String filePath)
            throws java.io.IOException {
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }

}
