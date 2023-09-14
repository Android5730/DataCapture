package com.itaem.datacapture.bean;// 2023/8/13

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.io.Serializable;
import java.util.List;

// 作者:ITAEM 陈金城
@SmartTable(name="网络数据")
public  class NetworkBean implements Serializable {
    /**
     * configured_wifi : [{"bssid":"string","mac":"string","name":"string","ssid":"string"}]
     * current_wifi : {"bssid":"string","mac":"string","name":"string","ssid":"string"}
     * ip : string
     * wifi_count : 0
     */
    @SmartColumn(id =1,name = "current_wifi_当前WIFI")
    private CurrentWifiBean current_wifi; // 当前WIFI
    @SmartColumn(id =2,name = "ip_网络IP（内网）")
    private String ip; // 网络IP（内网）
    @SmartColumn(id =3,name = "wifi_count_wifi 个数")
    private int wifi_count; // wifi 个数
    @SmartColumn(id =4,name = "configured_wifi_配置WIFI")
    private List<ConfiguredWifiBean> configured_wifi; // 配置WIFI,附近的wifi

    public NetworkBean(CurrentWifiBean current_wifi, String ip,int wifi_count,List<ConfiguredWifiBean> configured_wifi) {
        this.current_wifi = current_wifi;
        this.ip = ip;
        this.wifi_count = wifi_count;
        this.configured_wifi = configured_wifi;
    }

    public CurrentWifiBean getCurrent_wifi() {
        return current_wifi;
    }

    public List<ConfiguredWifiBean> getConfigured_wifi() {
        return configured_wifi;
    }

    public void setCurrent_wifi(CurrentWifiBean current_wifi) {
        this.current_wifi = current_wifi;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getWifi_count() {
        return wifi_count;
    }

    public void setWifi_count(int wifi_count) {
        this.wifi_count = wifi_count;
    }

    public void setConfigured_wifi(List<ConfiguredWifiBean> configured_wifi) {
        this.configured_wifi = configured_wifi;
    }

    @SmartTable(name="当前wifi详情")
    public static class CurrentWifiBean implements Serializable {
        /**
         * bssid : string
         * mac : string
         * name : string
         * ssid : string
         */
        @SmartColumn(id =1,name = "bssid")
        private String bssid;
        @SmartColumn(id =2,name = "mac")
        private String mac;
        @SmartColumn(id =3,name = "name")
        private String name;
        @SmartColumn(id =4,name = "ssid")
        private String ssid;

        public CurrentWifiBean(String bssid, String mac, String name, String ssid) {
            this.bssid = bssid==null||bssid.equals("02:00:00:00:00:00")?"":bssid;
            this.mac = mac==null||mac.equals("02:00:00:00:00:00")?"":mac;
            this.name = name==null||name.equals("<unknown ssid>")?"":name;
            this.ssid = ssid==null||ssid.equals("<unknown ssid>")?"":ssid;
        }

        public String getBssid() {
            return bssid;
        }

        public void setBssid(String bssid) {
            this.bssid = bssid;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSsid() {
            return ssid;
        }

        public void setSsid(String ssid) {
            this.ssid = ssid;
        }
    }
    @SmartTable(name="所有wifi详情")
    public static class ConfiguredWifiBean implements Serializable {
        /**
         * bssid : string
         * mac : string
         * name : string
         * ssid : string
         */
        @SmartColumn(id =1,name = "bssid")
        private String bssid;
        @SmartColumn(id =2,name = "mac")
        private String mac;
        @SmartColumn(id =3,name = "name")
        private String name;
        @SmartColumn(id =4,name = "ssid")
        private String ssid;

        public ConfiguredWifiBean(String bssid, String mac, String name, String ssid) {
            this.bssid = bssid==null||bssid.equals("02:00:00:00:00:00")?"":bssid;
            this.mac = mac==null||mac.equals("02:00:00:00:00:00")?"":mac;
            this.name = name==null||name.equals("<unknown ssid>")?"":name;
            this.ssid = ssid==null||ssid.equals("<unknown ssid>")?"":ssid;
        }

        public String getBssid() {
            return bssid;
        }

        public void setBssid(String bssid) {
            this.bssid = bssid;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSsid() {
            return ssid;
        }

        public void setSsid(String ssid) {
            this.ssid = ssid;
        }
    }
}
