package com.itaem.datacapture.bean;// 2023/8/13

import java.io.Serializable;
import java.util.List;

// 作者:ITAEM 陈金城
public  class DeviceInfoBean implements Serializable {
    /**
     * address_info : string
     * albs : string
     * app_name : string
     * audio : 0
     * audio_external : 0
     * audio_internal : 0
     * battery : 0
     * battery_status : {"battery_level":"string","battery_max":"string","battery_pct":0,"battery_state":0,"is_ac_charge":0,"is_charging":0,"is_usb_charge":0}
     * brand : string
     * build_id : string
     * build_name : string
     * bundleId : string
     * contact_group : 0
     * create_time : string
     * developmentRegion : string
     * device_id : string
     * device_info : string
     * download_files : 0
     * general_data : {"allowsVOIP":true,"and_id":"string","currentSystemTime":0,"elapsedRealtime":0,"gaid":"string","imei":"string","is_usb_debug":"string","is_using_proxy_port":"string","is_using_vpn":"string","language":"string","locale_display_language":"string","locale_iso_3_country":"string","locale_iso_3_language":"string","mac":"string","mobileCountryCode":"string","mobileNetworkCode":"string","network_operator_name":"string","network_type":"string","network_type_new":"string","phone_number":"string","phone_type":0,"sensor_list":[{"maxRange":"string","minDelay":"string","name":"string","power":"string","resolution":"string","type":"string","vendor":"string","version":"string"}],"serviceCurrentRadioAccessTechnology":"string","time_zone_id":"string","uptimeMillis":0,"uuid":"string","wifi_mac":"string"}
     * gps_address : string
     * gps_address_city : string
     * gps_address_province : string
     * gps_address_street : string
     * gps_adid : string
     * gps_latitude : string
     * gps_longitude : string
     * hardware : {"board":"string","brand":"string","cores":0,"device_height":0,"device_name":"string","device_width":0,"model":"string","physical_size":"string","production_date":0,"release":"string","sdk_version":"string","serial_number":"string"}
     * idfa : string
     * idfv : string
     * images_external : 0
     * images_internal : 0
     * imei : string
     * ip : string
     * is_root : 0
     * is_simulator : 0
     * last_login_time : string
     * mac : string
     * memory : string
     * network : {"configured_wifi":[{"bssid":"string","mac":"string","name":"string","ssid":"string"}],"current_wifi":{"bssid":"string","mac":"string","name":"string","ssid":"string"},"ip":"string","wifi_count":0}
     * new_storage : {"activeMemory":0,"app_free_memory":"string","app_max_memory":"string","app_total_memory":"string","contain_sd":"string","extra_sd":"string","freeMemory":0,"inActiveMemory":0,"internal_storage_total":0,"internal_storage_usable":0,"memory_card_free_size":0,"memory_card_size":0,"memory_card_size_use":0,"memory_card_usable_size":0,"purgableMemory":0,"ram_total_size":"string","ram_usable_size":"string","totalMemory":0,"usedMemory":0,"wiredMemory":0}
     * os_type : string
     * os_version : string
     * other_data : {"dbm":"string","dbmClass":0,"keyboard":0,"last_boot_time":0,"root_jailbreak":0,"simulator":0}
     * package_name : string
     * pic_count : 0
     * process_info : {"activeProcessorCount":0,"arguments":"string","environment":"string","globallyUniqueString":"string","hostName":"string","lowPowerModeEnabled":true,"operatingSystemVersionString":"string","physicalMemory":0,"processIdentifier":0,"processName":"string","processorCount":0,"systemUptime":"string","thermalState":0}
     * resolution : string
     * sdcard : string
     * shortVersionString : string
     * storage : string
     * unuse_sdcard : string
     * unuse_storage : string
     * version : string
     * video : 0
     * video_external : 0
     * video_internal : 0
     * wifi : 0
     * wifi_name : string
     */

    private String address_info;
    private String albs;
    //       private int audio_external;
    private int audio_internal;
    private int battery;
    private BatteryStatusBean battery_status;
    private String brand;
    private String build_id;
    private String build_name;
    //   private String bundleId;
    //      private int contact_group;
    private String create_time;
    //     private String developmentRegion;
    private String device_id;
    private String device_info;
    //          private int download_files;
    private GeneralDataBean general_data;
    private String gps_address;

    private String gps_adid;
    private String gps_latitude;
    private String gps_longitude;
    private HardwareBean hardware;
    private String idfa;
    private String idfv;
    //         private int images_external;
    private int images_internal;
    private String imei;
    private String ip;
    private int is_root;
    private int is_simulator;
    private String last_login_time;
    private String imsi;
    private String mac;
    private String memory;
    private NetworkBean network;
    private NewStorageBean new_storage;
    private String os_type;
    private String os_version;
    private OtherDataBean other_data;
    private String package_name;
    //          private int pic_count;
    //   private ProcessInfoBean process_info;
    private String resolution;
    //           private String sdcard;
    //    private String shortVersionString;
    private String storage;
    //       private String unuse_sdcard;
    private String unuse_storage;
    //     private String version;
    //      private int video;
    //          private int video_external;
    private int video_internal;
    private int wifi;
    //      private String wifi_name;

    public DeviceInfoBean(String address_info, String albs, int audio_internal, int battery,BatteryStatusBean battery_status, String brand, String build_id, String build_name,  String create_time, String device_id, String device_info,  GeneralDataBean general_data, String gps_address, String gps_adid, String gps_latitude, String gps_longitude,HardwareBean hardware,String idfa,String idfv, int images_internal, String imei, String ip, int is_root, int is_simulator, String last_login_time, String mac, String memory, NetworkBean network, NewStorageBean new_storage, String os_type, String os_version,OtherDataBean other_data, String package_name, String resolution,  String storage, String unuse_storage,  int video_internal, int wifi,String imsi) {
        this.address_info = address_info;
        this.albs = albs;
        this.audio_internal = audio_internal;
        this.battery = battery;
        this.battery_status = battery_status;
        this.brand = brand;
        this.build_id = build_id;
        this.build_name = build_name;
        //           this.contact_group = contact_group;
        this.create_time = create_time;
        this.device_id = device_id;
        this.device_info = device_info;
        this.general_data = general_data;
        this.gps_address = gps_address;
        this.gps_adid = gps_adid;
        this.gps_latitude = gps_latitude;
        this.gps_longitude = gps_longitude;
        this.hardware = hardware;
        this.idfa = idfa;
        this.idfv = idfv;
        //          this.images_external = images_external;
        this.images_internal = images_internal;
        this.imei = imei;
        this.ip = ip;
        this.is_root = is_root;
        this.is_simulator = is_simulator;
        this.last_login_time = last_login_time;
        this.mac = mac;
        this.memory = memory;
        this.network = network;
        this.new_storage = new_storage;
        this.os_type = os_type;
        this.os_version = os_version;
        this.other_data = other_data;
        this.package_name = package_name;
        //          this.pic_count = pic_count;
        //       this.process_info = process_info;
        this.resolution = resolution;
        //        this.sdcard = sdcard;
        //        this.shortVersionString = shortVersionString;
        this.storage = storage;
        //            this.unuse_sdcard = unuse_sdcard;
        this.unuse_storage = unuse_storage;
        //        this.version = version;
        //        this.video = video;
        //              this.video_external = video_external;
        this.video_internal = video_internal;
        this.wifi = wifi;
        this.imsi = imsi;
        //        this.wifi_name = wifi_name;
    }

    public static class BatteryStatusBean implements Serializable {
        /**
         * battery_level : string
         * battery_max : string
         * battery_pct : 0
         * battery_state : 0
         * is_ac_charge : 0
         * is_charging : 0
         * is_usb_charge : 0
         */

        private String battery_level; // 电池电量
        private String battery_max; // 电池容量
        private int battery_pct; //  电池百分比
        //  private int battery_state;// 电池状态 充电0 不充电1
        private int is_ac_charge; // 是否交流充电(1:yes,0:no)
        private int is_charging; // 是否正在充电
        private int is_usb_charge;// 是否USB充电(1:yes,0:no)

        public BatteryStatusBean(String battery_level, String battery_max, int battery_pct, int is_ac_charge, int is_charging, int is_usb_charge) {
            this.battery_level = battery_level!=null?battery_level:"";
            this.battery_max = battery_max!=null?battery_max:"";
            this.battery_pct = battery_pct;
            this.is_ac_charge = is_ac_charge;
            this.is_charging = is_charging;
            this.is_usb_charge = is_usb_charge;
        }

        public int getBattery_pct() {
            return battery_pct;
        }
    }

    public static class GeneralDataBean implements Serializable {
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
        private String locale_display_language; // 此用户显示的语言环境语⾔的名称
        private String locale_iso_3_country; // 此地区的国家/地区的缩写
        private String locale_iso_3_language; // 语言环境的三字母缩写
        private String mac; // mac 地址
        private String network_operator_name; // 网络运营商名称
        private String network_type; // 网络类型 2G、3G、4G、5G、wifi、other、none
        private String network_type_new; // 网络类型 2G、3G、4G、5G、wifi、other、none
        private String phone_number; // 手机号
        private int phone_type; // 指示设备电话类型的常量。 这表示用于传输语音呼叫的无线电的类型
        //           private String serviceCurrentRadioAccessTechnology; // 运营商无线接入技术
        private String time_zone_id; // 时区的 ID
        private String uptimeMillis; // 从开机到现在的毫秒数（不包括睡眠时间）
        private String uuid; // 唯一标识 UUID.randomUUID().toString().toUpperCase()
        private List<SensorListBean> sensor_list; // 传感器信息

        public GeneralDataBean( String and_id, String currentSystemTime, String elapsedRealtime, String gaid, String imei, boolean is_usb_debug, boolean is_using_proxy_port, boolean is_using_vpn, String language, String locale_display_language, String locale_iso_3_country, String locale_iso_3_language, String mac, String network_operator_name, String network_type, String network_type_new, String phone_number, int phone_type, String time_zone_id, String uptimeMillis, String uuid,  List<GeneralDataBean.SensorListBean> sensor_list) {
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
            this.locale_iso_3_language = locale_iso_3_language;
            this.mac = mac;
            this.network_operator_name = network_operator_name;
            this.network_type = network_type;
            this.network_type_new = network_type_new;
            this.phone_number = phone_number;
            this.phone_type = phone_type;
            //           this.serviceCurrentRadioAccessTechnology = serviceCurrentRadioAccessTechnology;
            this.time_zone_id = time_zone_id;
            this.uptimeMillis = uptimeMillis;
            this.uuid = uuid;
            this.sensor_list = sensor_list;
        }

        public static class SensorListBean implements Serializable {
            /**
             * maxRange : string //
             * minDelay : string
             * name : string
             * power : string
             * resolution : string
             * type : string
             * vendor : string
             * version : string
             */

            private String maxRange;
            private String minDelay;
            private String name;
            private String power;
            private String resolution;
            private String type;
            private String vendor;
            private String version;

            public SensorListBean(String maxRange, String minDelay, String name, String power, String resolution, String type, String vendor, String version) {
                this.maxRange = maxRange;
                this.minDelay = minDelay;
                this.name = name;
                this.power = power;
                this.resolution = resolution;
                this.type = type;
                this.vendor = vendor;
                this.version = version;
            }
        }
    }

    public static class HardwareBean implements Serializable {
        /**
         * board : string
         * brand : string
         * cores : 0
         * device_height : 0
         * device_name : string
         * device_width : 0
         * model : string
         * physical_size : string
         * production_date : 0
         * release : string
         * sdk_version : string
         * serial_number : string
         */

        private String board; // 主板
        private String brand; // 设备品牌
        private String cores; // 设备内核
        private int device_height; // 分辨率高
        private String device_name; // 设备名称
        private int device_width; // 分辨率宽
        private String model; // 设备型号
        private String physical_size; // 物理尺寸
        private String production_date; // 手机出厂时间戳
        private String release; // 系统版本
        private String sdk_version; // SDK版本
        private String serial_number; // 设备序列号

        public HardwareBean(String board, String brand, String cores, int device_height, String device_name, int device_width, String model, String physical_size, String production_date, String release, String sdk_version, String serial_number) {
            this.board = board==null?"":board;
            this.brand = brand==null?"":brand;
            this.cores = cores;
            this.device_height = device_height;
            this.device_name = device_name==null?"":device_name;
            this.device_width = device_width;
            this.model = model==null?"":model;
            this.physical_size = physical_size ==null?"":physical_size;
            this.production_date = production_date ==null?"":production_date;
            this.release = release ==null?"":release;
            this.sdk_version = sdk_version==null?"":sdk_version;
            this.serial_number = serial_number==null?"":serial_number;
        }

        public String getBrand() {
            return brand;
        }

        public int getDevice_height() {
            return device_height;
        }

        public int getDevice_width() {
            return device_width;
        }
    }

    public static class NetworkBean implements Serializable {
        /**
         * configured_wifi : [{"bssid":"string","mac":"string","name":"string","ssid":"string"}]
         * current_wifi : {"bssid":"string","mac":"string","name":"string","ssid":"string"}
         * ip : string
         * wifi_count : 0
         */

        private NetworkBean.CurrentWifiBean current_wifi; // 当前WIFI
        private String ip; // 网络IP（内网）//            private int wifi_count; // wifi 个数
        //             private List<NetworkBean.ConfiguredWifiBean> configured_wifi; // 配置WIFI

        public NetworkBean(NetworkBean.CurrentWifiBean current_wifi, String ip) {
            this.current_wifi = current_wifi;
            this.ip = ip;
            //                 this.wifi_count = wifi_count;
            //                 this.configured_wifi = configured_wifi;
        }

        public static class CurrentWifiBean implements Serializable {
            /**
             * bssid : string
             * mac : string
             * name : string
             * ssid : string
             */

            private String bssid;
            private String mac;
            private String name;
            private String ssid;

            public CurrentWifiBean(String bssid, String mac, String name, String ssid) {
                this.bssid = bssid.equals("02:00:00:00:00:00")?"":bssid;
                this.mac = mac.equals("02:00:00:00:00:00")?"":mac;
                this.name = name.equals("<unknown ssid>")?"":name;
                this.ssid = ssid.equals("<unknown ssid>")?"":ssid;
            }
        }

        public static class ConfiguredWifiBean implements Serializable {
            /**
             * bssid : string
             * mac : string
             * name : string
             * ssid : string
             */

            private String bssid;
            private String mac;
            private String name;
            private String ssid;

            public ConfiguredWifiBean(String bssid, String mac, String name, String ssid) {
                this.bssid = bssid;
                this.mac = mac;
                this.name = name;
                this.ssid = ssid;
            }
        }
    }

    public static class NewStorageBean implements Serializable {
        /**
         * activeMemory : 0
         * app_free_memory : string
         * app_max_memory : string
         * app_total_memory : string
         * contain_sd : string
         * extra_sd : string
         * freeMemory : 0
         * inActiveMemory : 0
         * internal_storage_total : 0
         * internal_storage_usable : 0
         * memory_card_free_size : 0
         * memory_card_size : 0
         * memory_card_size_use : 0
         * memory_card_usable_size : 0
         * purgableMemory : 0
         * ram_total_size : string
         * ram_usable_size : string
         * totalMemory : 0
         * usedMemory : 0
         * wiredMemory : 0
         */

        //        private String activeMemory; // 活动内存 单位Byte）
        private String app_free_memory; // app可用内存大小 单位Byte）
        private String app_max_memory; // app最大内存大小 单位Byte）
        private String app_total_memory;// app总内存大小 单位Byte）
        private String contain_sd; // 是否有内置的SD卡（0否，1是）
        private String extra_sd; // 是否有外置的SD卡（0否，1是）
        //         private String freeMemory; //内存空闲大小 单位Byte）
        //         private String inActiveMemory; // 不活动内存 单位Byte）
        private String internal_storage_total; // 总存储大小 单位Byte）
        private String internal_storage_usable; // 可用存储大小 单位Byte）
        private String memory_card_free_size; // 内存卡剩余使用量 单位Byte）
        private String memory_card_size; //  内存卡大小 单位Byte）
        private String memory_card_size_use; // 内存卡已使用量 单位Byte）
        private String memory_card_usable_size; // 内存卡可使用量 单位Byte）
        //        private String purgableMemory; // 可清理内存 单位Byte）
        private String ram_total_size; // 总内存大小（ 单位Byte）
        private String ram_usable_size; // 内存可用大小 单位Byte）
//                private String totalMemory; // 总内存大小（ 单位Byte）
//                private String usedMemory; // 已用内存 单位Byte）
//                private String wiredMemory; // 保留内存 单位Byte）



        public String getInternal_storage_total() {
            return internal_storage_total;
        }

        public String getInternal_storage_usable() {
            return internal_storage_usable;
        }


        public void setApp_free_memory(String app_free_memory) {
            this.app_free_memory = app_free_memory;
        }

        public void setApp_max_memory(String app_max_memory) {
            this.app_max_memory = app_max_memory;
        }

        public void setApp_total_memory(String app_total_memory) {
            this.app_total_memory = app_total_memory;
        }


        public void setInternal_storage_total(String internal_storage_total) {
            this.internal_storage_total = internal_storage_total;
        }

        public void setInternal_storage_usable(String internal_storage_usable) {
            this.internal_storage_usable = internal_storage_usable;
        }

        public void setExtra_sd(String extra_sd) {
            this.extra_sd = extra_sd;
        }

        public void setRam_total_size(String ram_total_size) {
            this.ram_total_size = ram_total_size;
        }

        public void setRam_usable_size(String ram_usable_size) {
            this.ram_usable_size = ram_usable_size;
        }

        public void setContain_sd(String contain_sd) {
            this.contain_sd = contain_sd;
        }

        public void setMemory_card_free_size(String memory_card_free_size) {
            this.memory_card_free_size = memory_card_free_size;
        }

        public void setMemory_card_size(String memory_card_size) {
            this.memory_card_size = memory_card_size;
        }

        public void setMemory_card_size_use(String memory_card_size_use) {
            this.memory_card_size_use = memory_card_size_use;
        }

        public void setMemory_card_usable_size(String memory_card_usable_size) {
            this.memory_card_usable_size = memory_card_usable_size;
        }
    }

    public static class OtherDataBean implements Serializable {
        /**
         * dbm : string
         * dbmClass : 0
         * keyboard : 0
         * last_boot_time : 0
         * root_jailbreak : 0
         * simulator : 0
         */

        private String dbm; // 手机的信号强度 默认值-1
        //    private int dbmClass;
//        private int keyboard; // 连接到设备的键盘种类
        private String last_boot_time; // 最后一次启动时间
        private int root_jailbreak; // 是否 root
        private int simulator; // 是否为模拟器

        public OtherDataBean(String dbm, int keyboard, String last_boot_time, int root_jailbreak, int simulator) {
            this.dbm = dbm;
            //           dbmClass = 0;
//            this.keyboard = keyboard;
            this.last_boot_time = last_boot_time;
            this.root_jailbreak = root_jailbreak;
            this.simulator = simulator;
        }
    }
}
