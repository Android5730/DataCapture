package com.itaem.datacapture.bean;// 2023/8/13

import java.io.Serializable;
import java.util.List;

// 作者:ITAEM 陈金城
public  class GeneralDataBean implements Serializable {
    /**
     * allowsVOIP : true
     * and_id : string
     * currentSystemTime : 0
     * elapsedRealtime : 0
     * gaid : string
     * imei : string
     * is_usb_debug : string
     * is_using_proxy_port : string
     * is_using_vpn : string
     * language : string
     * locale_display_language : string
     * locale_iso_3_country : string
     * locale_iso_3_language : string
     * mac : string
     * mobileCountryCode : string
     * mobileNetworkCode : string
     * network_operator_name : string
     * network_type : string
     * network_type_new : string
     * phone_number : string
     * phone_type : 0
     * sensor_list : [{"maxRange":"string","minDelay":"string","name":"string","power":"string","resolution":"string","type":"string","vendor":"string","version":"string"}]
     * serviceCurrentRadioAccessTechnology : string
     * time_zone_id : string
     * uptimeMillis : 0
     * uuid : string
     * wifi_mac : string
     */

    private String and_id; // android_id
    private String currentSystemTime; // 设备当前时间
    private String elapsedRealtime; // 开机时间到现在的毫秒数（包括睡眠时间）
    private String gaid; // google advertising id(google 广告 id)
    private String imei; // 设备号
    private boolean is_usb_debug; // 是否开启debug调试
    private boolean is_using_proxy_port; // 是否使用代理
    private boolean is_using_vpn; // 是否使用vpn
    private String language; // 语言
    private String locale_display_language; // 此用户显示的语言环境语言的名称
    private String locale_iso_3_country; // 此地区的国家/地区的缩写
    private String locale_country; // 此地区的国家
    private String locale_iso_3_language; // 语言环境的三字母缩写
    private String mac; // mac 地址
    private String network_operator_name; // 网络运营商名称
    private String network_type; // 网络类型 2G、3G、4G、5G、wifi、other、none
    private String phone_number; // 手机号
    private int phone_type; // 指示设备电话类型的常量。 这表示用于传输语音呼叫的无线电的类型
    //           private String serviceCurrentRadioAccessTechnology; // 运营商无线接入技术
    private String time_zone_id; // 时区的 ID
    private String uptimeMillis; // 从开机到现在的毫秒数（不包括睡眠时间）
    private String uuid; // 唯一标识 UUID.randomUUID().toString().toUpperCase()

    public GeneralDataBean( String and_id, String currentSystemTime, String elapsedRealtime, String gaid, String imei, boolean is_usb_debug, boolean is_using_proxy_port, boolean is_using_vpn, String language, String locale_display_language, String locale_iso_3_country,String locale_country, String locale_iso_3_language, String mac, String network_operator_name, String network_type,  String phone_number, int phone_type, String time_zone_id, String uptimeMillis, String uuid) {
        this.and_id = and_id;
        this.currentSystemTime = currentSystemTime;
        this.elapsedRealtime = elapsedRealtime;
        this.gaid = gaid;
        this.imei = imei;
        this.is_usb_debug = is_usb_debug;
        this.is_using_proxy_port = is_using_proxy_port;
        this.is_using_vpn = is_using_vpn;
        this.language = language;
        this.locale_display_language = locale_display_language;
        this.locale_iso_3_country = locale_iso_3_country;
        this.locale_country = locale_country;
        this.locale_iso_3_language = locale_iso_3_language;
        this.mac = mac;
        this.network_operator_name = network_operator_name;
        this.network_type = network_type;
        this.phone_number = phone_number;
        this.phone_type = phone_type;
        //           this.serviceCurrentRadioAccessTechnology = serviceCurrentRadioAccessTechnology;
        this.time_zone_id = time_zone_id;
        this.uptimeMillis = uptimeMillis;
        this.uuid = uuid;
    }
    public String getAnd_id() {
        return and_id;
    }

    public String getCurrentSystemTime() {
        return currentSystemTime;
    }

    public String getElapsedRealtime() {
        return elapsedRealtime;
    }

    public String getGaid() {
        return gaid;
    }

    public String getImei() {
        return imei;
    }

    public boolean isIs_usb_debug() {
        return is_usb_debug;
    }

    public boolean isIs_using_proxy_port() {
        return is_using_proxy_port;
    }

    public boolean isIs_using_vpn() {
        return is_using_vpn;
    }

    public String getLanguage() {
        return language;
    }

    public String getLocale_display_language() {
        return locale_display_language;
    }

    public String getLocale_iso_3_country() {
        return locale_iso_3_country;
    }

    public String getLocale_iso_3_language() {
        return locale_iso_3_language;
    }

    public String getMac() {
        return mac;
    }

    public String getNetwork_operator_name() {
        return network_operator_name;
    }

    public String getNetwork_type() {
        return network_type;
    }



    public String getPhone_number() {
        return phone_number;
    }

    public int getPhone_type() {
        return phone_type;
    }

    public String getTime_zone_id() {
        return time_zone_id;
    }

    public String getUptimeMillis() {
        return uptimeMillis;
    }

    public String getUuid() {
        return uuid;
    }

    public String getLocale_country() {
        return locale_country;
    }
}
