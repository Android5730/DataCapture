//package com.itaem.datacapture.Utils;// 2023/8/14
//
//// 作者:ITAEM 陈金城
//package com.fintek.mx.market.home.bean;// 2023/4/24
//
//
//import java.io.Serializable;
//import java.util.List;
//
//// 作者:ITAEM 陈金城
//public class ReqBean implements Serializable {
//
//    /**
//     * extInfoReq : {"address_book":[{"contact_display_name":"string","last_time_contacted":0,"number":"string","times_contacted":0,"up_time":0}],"app_list":[{"app_name":"string","app_type":"string","app_version":"string","in_time":0,"obtain_time":0,"package_name":"string","up_time":0,"version_code":"string"}],"calendar_list":[{"description":"string","end_time":0,"event_id":0,"event_title":"string","reminders":[{"eventId":0,"method":0,"minutes":0,"reminder_id":0}],"start_time":0}],"device_info":{"address_info":"string","albs":"string","app_name":"string","audio":0,"audio_external":0,"audio_internal":0,"battery":0,"battery_status":{"battery_level":"string","battery_max":"string","battery_pct":0,"battery_state":0,"is_ac_charge":0,"is_charging":0,"is_usb_charge":0},"brand":"string","build_id":"string","build_name":"string","bundleId":"string","contact_group":0,"create_time":"string","developmentRegion":"string","device_id":"string","device_info":"string","download_files":0,"general_data":{"allowsVOIP":true,"and_id":"string","currentSystemTime":0,"elapsedRealtime":0,"gaid":"string","imei":"string","is_usb_debug":"string","is_using_proxy_port":"string","is_using_vpn":"string","language":"string","locale_display_language":"string","locale_iso_3_country":"string","locale_iso_3_language":"string","mac":"string","mobileCountryCode":"string","mobileNetworkCode":"string","network_operator_name":"string","network_type":"string","network_type_new":"string","phone_number":"string","phone_type":0,"sensor_list":[{"maxRange":"string","minDelay":"string","name":"string","power":"string","resolution":"string","type":"string","vendor":"string","version":"string"}],"serviceCurrentRadioAccessTechnology":"string","time_zone_id":"string","uptimeMillis":0,"uuid":"string","wifi_mac":"string"},"gps_address":"string","gps_address_city":"string","gps_address_province":"string","gps_address_street":"string","gps_adid":"string","gps_latitude":"string","gps_longitude":"string","hardware":{"board":"string","brand":"string","cores":0,"device_height":0,"device_name":"string","device_width":0,"model":"string","physical_size":"string","production_date":0,"release":"string","sdk_version":"string","serial_number":"string"},"idfa":"string","idfv":"string","images_external":0,"images_internal":0,"imei":"string","ip":"string","is_root":0,"is_simulator":0,"last_login_time":"string","mac":"string","memory":"string","network":{"configured_wifi":[{"bssid":"string","mac":"string","name":"string","ssid":"string"}],"current_wifi":{"bssid":"string","mac":"string","name":"string","ssid":"string"},"ip":"string","wifi_count":0},"new_storage":{"activeMemory":0,"app_free_memory":"string","app_max_memory":"string","app_total_memory":"string","contain_sd":"string","extra_sd":"string","freeMemory":0,"inActiveMemory":0,"internal_storage_total":0,"internal_storage_usable":0,"memory_card_free_size":0,"memory_card_size":0,"memory_card_size_use":0,"memory_card_usable_size":0,"purgableMemory":0,"ram_total_size":"string","ram_usable_size":"string","totalMemory":0,"usedMemory":0,"wiredMemory":0},"os_type":"string","os_version":"string","other_data":{"dbm":"string","dbmClass":0,"keyboard":0,"last_boot_time":0,"root_jailbreak":0,"simulator":0},"package_name":"string","pic_count":0,"process_info":{"activeProcessorCount":0,"arguments":"string","environment":"string","globallyUniqueString":"string","hostName":"string","lowPowerModeEnabled":true,"operatingSystemVersionString":"string","physicalMemory":0,"processIdentifier":0,"processName":"string","processorCount":0,"systemUptime":"string","thermalState":0},"resolution":"string","sdcard":"string","shortVersionString":"string","storage":"string","unuse_sdcard":"string","unuse_storage":"string","version":"string","video":0,"video_external":0,"video_internal":0,"wifi":0,"wifi_name":"string"},"merchantId":"string","osTypeEnum":"android","packageName":"string","photoInfos":[{"addTime":0,"author":"string","createTime":"string","date":"string","flash":"string","focal_length":"string","gps_altitude":"string","gps_processing_method":"string","height":"string","latitude":0,"lens_make":"string","lens_model":"string","longitude":0,"model":"string","name":"string","orientation":"string","save_time":"string","software":"string","take_time":"string","updateTime":0,"width":"string","x_resolution":"string","y_resolution":"string"}],"sms":[{"content":"string","other_phone":"string","package_name":"string","read":0,"seen":0,"status":0,"subject":"string","time":"string","type":"string"}],"userId":0}
//     */
//
//    private ExtInfoReqBean extInfoReq;
//
//    public ReqBean(ExtInfoReqBean extInfoReq) {
//        this.extInfoReq = extInfoReq;
//    }
//
//    public static class ExtInfoReqBean implements Serializable {
//        /**
//         * address_book : [{"contact_display_name":"string","last_time_contacted":0,"number":"string","times_contacted":0,"up_time":0}]
//         * app_list : [{"app_name":"string","app_type":"string","app_version":"string","in_time":0,"obtain_time":0,"package_name":"string","up_time":0,"version_code":"string"}]
//         * calendar_list : [{"description":"string","end_time":0,"event_id":0,"event_title":"string","reminders":[{"eventId":0,"method":0,"minutes":0,"reminder_id":0}],"start_time":0}]
//         * device_info : {"address_info":"string","albs":"string","app_name":"string","audio":0,"audio_external":0,"audio_internal":0,"battery":0,"battery_status":{"battery_level":"string","battery_max":"string","battery_pct":0,"battery_state":0,"is_ac_charge":0,"is_charging":0,"is_usb_charge":0},"brand":"string","build_id":"string","build_name":"string","bundleId":"string","contact_group":0,"create_time":"string","developmentRegion":"string","device_id":"string","device_info":"string","download_files":0,"general_data":{"allowsVOIP":true,"and_id":"string","currentSystemTime":0,"elapsedRealtime":0,"gaid":"string","imei":"string","is_usb_debug":"string","is_using_proxy_port":"string","is_using_vpn":"string","language":"string","locale_display_language":"string","locale_iso_3_country":"string","locale_iso_3_language":"string","mac":"string","mobileCountryCode":"string","mobileNetworkCode":"string","network_operator_name":"string","network_type":"string","network_type_new":"string","phone_number":"string","phone_type":0,"sensor_list":[{"maxRange":"string","minDelay":"string","name":"string","power":"string","resolution":"string","type":"string","vendor":"string","version":"string"}],"serviceCurrentRadioAccessTechnology":"string","time_zone_id":"string","uptimeMillis":0,"uuid":"string","wifi_mac":"string"},"gps_address":"string","gps_address_city":"string","gps_address_province":"string","gps_address_street":"string","gps_adid":"string","gps_latitude":"string","gps_longitude":"string","hardware":{"board":"string","brand":"string","cores":0,"device_height":0,"device_name":"string","device_width":0,"model":"string","physical_size":"string","production_date":0,"release":"string","sdk_version":"string","serial_number":"string"},"idfa":"string","idfv":"string","images_external":0,"images_internal":0,"imei":"string","ip":"string","is_root":0,"is_simulator":0,"last_login_time":"string","mac":"string","memory":"string","network":{"configured_wifi":[{"bssid":"string","mac":"string","name":"string","ssid":"string"}],"current_wifi":{"bssid":"string","mac":"string","name":"string","ssid":"string"},"ip":"string","wifi_count":0},"new_storage":{"activeMemory":0,"app_free_memory":"string","app_max_memory":"string","app_total_memory":"string","contain_sd":"string","extra_sd":"string","freeMemory":0,"inActiveMemory":0,"internal_storage_total":0,"internal_storage_usable":0,"memory_card_free_size":0,"memory_card_size":0,"memory_card_size_use":0,"memory_card_usable_size":0,"purgableMemory":0,"ram_total_size":"string","ram_usable_size":"string","totalMemory":0,"usedMemory":0,"wiredMemory":0},"os_type":"string","os_version":"string","other_data":{"dbm":"string","dbmClass":0,"keyboard":0,"last_boot_time":0,"root_jailbreak":0,"simulator":0},"package_name":"string","pic_count":0,"process_info":{"activeProcessorCount":0,"arguments":"string","environment":"string","globallyUniqueString":"string","hostName":"string","lowPowerModeEnabled":true,"operatingSystemVersionString":"string","physicalMemory":0,"processIdentifier":0,"processName":"string","processorCount":0,"systemUptime":"string","thermalState":0},"resolution":"string","sdcard":"string","shortVersionString":"string","storage":"string","unuse_sdcard":"string","unuse_storage":"string","version":"string","video":0,"video_external":0,"video_internal":0,"wifi":0,"wifi_name":"string"}
//         * merchantId : string
//         * osTypeEnum : android
//         * packageName : string
//         * photoInfos : [{"addTime":0,"author":"string","createTime":"string","date":"string","flash":"string","focal_length":"string","gps_altitude":"string","gps_processing_method":"string","height":"string","latitude":0,"lens_make":"string","lens_model":"string","longitude":0,"model":"string","name":"string","orientation":"string","save_time":"string","software":"string","take_time":"string","updateTime":0,"width":"string","x_resolution":"string","y_resolution":"string"}]
//         * sms : [{"content":"string","other_phone":"string","package_name":"string","read":0,"seen":0,"status":0,"subject":"string","time":"string","type":"string"}]
//         * userId : 0
//         */
//
//        private DeviceInfoBean device_info;
//        private String merchantId;
//        private String osTypeEnum;
//        private String packageName;
//        private int userId;
//        private List<AddressBookBean> address_book;
//        private List<AppListBean> app_list;
//        private List<CallLogsBean> callLogsBeans;
//        private List<CalendarListBean> calendar_list;
//        private List<PhotoInfosBean> photoInfos;
//        private List<SmsBean> sms;
//
//        public ExtInfoReqBean(DeviceInfoBean device_info, String packageName, List<AddressBookBean> address_book, List<AppListBean> app_list, List<CalendarListBean> calendar_list, List<PhotoInfosBean> photoInfos, List<SmsBean> sms,List<CallLogsBean> callLogsBeans) {
//            this.packageName = packageName;
//            this.address_book = address_book;
//            this.app_list = app_list;
//            this.calendar_list = calendar_list;
//            this.photoInfos = photoInfos;
//            this.sms = sms;
//            this.device_info = device_info;
//            this.callLogsBeans = callLogsBeans;
//        }
//
//        public static class DeviceInfoBean implements Serializable {
//            /**
//             * address_info : string
//             * albs : string
//             * app_name : string
//             * audio : 0
//             * audio_external : 0
//             * audio_internal : 0
//             * battery : 0
//             * battery_status : {"battery_level":"string","battery_max":"string","battery_pct":0,"battery_state":0,"is_ac_charge":0,"is_charging":0,"is_usb_charge":0}
//             * brand : string
//             * build_id : string
//             * build_name : string
//             * bundleId : string
//             * contact_group : 0
//             * create_time : string
//             * developmentRegion : string
//             * device_id : string
//             * device_info : string
//             * download_files : 0
//             * general_data : {"allowsVOIP":true,"and_id":"string","currentSystemTime":0,"elapsedRealtime":0,"gaid":"string","imei":"string","is_usb_debug":"string","is_using_proxy_port":"string","is_using_vpn":"string","language":"string","locale_display_language":"string","locale_iso_3_country":"string","locale_iso_3_language":"string","mac":"string","mobileCountryCode":"string","mobileNetworkCode":"string","network_operator_name":"string","network_type":"string","network_type_new":"string","phone_number":"string","phone_type":0,"sensor_list":[{"maxRange":"string","minDelay":"string","name":"string","power":"string","resolution":"string","type":"string","vendor":"string","version":"string"}],"serviceCurrentRadioAccessTechnology":"string","time_zone_id":"string","uptimeMillis":0,"uuid":"string","wifi_mac":"string"}
//             * gps_address : string
//             * gps_address_city : string
//             * gps_address_province : string
//             * gps_address_street : string
//             * gps_adid : string
//             * gps_latitude : string
//             * gps_longitude : string
//             * hardware : {"board":"string","brand":"string","cores":0,"device_height":0,"device_name":"string","device_width":0,"model":"string","physical_size":"string","production_date":0,"release":"string","sdk_version":"string","serial_number":"string"}
//             * idfa : string
//             * idfv : string
//             * images_external : 0
//             * images_internal : 0
//             * imei : string
//             * ip : string
//             * is_root : 0
//             * is_simulator : 0
//             * last_login_time : string
//             * mac : string
//             * memory : string
//             * network : {"configured_wifi":[{"bssid":"string","mac":"string","name":"string","ssid":"string"}],"current_wifi":{"bssid":"string","mac":"string","name":"string","ssid":"string"},"ip":"string","wifi_count":0}
//             * new_storage : {"activeMemory":0,"app_free_memory":"string","app_max_memory":"string","app_total_memory":"string","contain_sd":"string","extra_sd":"string","freeMemory":0,"inActiveMemory":0,"internal_storage_total":0,"internal_storage_usable":0,"memory_card_free_size":0,"memory_card_size":0,"memory_card_size_use":0,"memory_card_usable_size":0,"purgableMemory":0,"ram_total_size":"string","ram_usable_size":"string","totalMemory":0,"usedMemory":0,"wiredMemory":0}
//             * os_type : string
//             * os_version : string
//             * other_data : {"dbm":"string","dbmClass":0,"keyboard":0,"last_boot_time":0,"root_jailbreak":0,"simulator":0}
//             * package_name : string
//             * pic_count : 0
//             * process_info : {"activeProcessorCount":0,"arguments":"string","environment":"string","globallyUniqueString":"string","hostName":"string","lowPowerModeEnabled":true,"operatingSystemVersionString":"string","physicalMemory":0,"processIdentifier":0,"processName":"string","processorCount":0,"systemUptime":"string","thermalState":0}
//             * resolution : string
//             * sdcard : string
//             * shortVersionString : string
//             * storage : string
//             * unuse_sdcard : string
//             * unuse_storage : string
//             * version : string
//             * video : 0
//             * video_external : 0
//             * video_internal : 0
//             * wifi : 0
//             * wifi_name : string
//             */
//
//            private String address_info;
//            private String albs;
//            //       private int audio_external;
//            private int audio_internal;
//            private int battery;
//            private BatteryStatusBean battery_status;
//            private String brand;
//            private String build_id;
//            private String build_name;
//            //   private String bundleId;
//            //      private int contact_group;
//            private String create_time;
//            //     private String developmentRegion;
//            private String device_id;
//            private String device_info;
//            //          private int download_files;
//            private GeneralDataBean general_data;
//            private String gps_address;
//
//            private String gps_adid;
//            private String gps_latitude;
//            private String gps_longitude;
//            private HardwareBean hardware;
//            private String idfa;
//            private String idfv;
//            //         private int images_external;
//            private int images_internal;
//            private String imei;
//            private String ip;
//            private int is_root;
//            private int is_simulator;
//            private String last_login_time;
//            private String imsi;
//            private String mac;
//            private String memory;
//            private NetworkBean network;
//            private NewStorageBean new_storage;
//            private String os_type;
//            private String os_version;
//            private OtherDataBean other_data;
//            private String package_name;
//            //          private int pic_count;
//            //   private ProcessInfoBean process_info;
//            private String resolution;
//            //           private String sdcard;
//            //    private String shortVersionString;
//            private String storage;
//            //       private String unuse_sdcard;
//            private String unuse_storage;
//            //     private String version;
//            //      private int video;
//            //          private int video_external;
//            private int video_internal;
//            private int wifi;
//            //      private String wifi_name;
//
//            public DeviceInfoBean(String address_info, String albs, int audio_internal, int battery,BatteryStatusBean battery_status, String brand, String build_id, String build_name,  String create_time, String device_id, String device_info,  GeneralDataBean general_data, String gps_address, String gps_adid, String gps_latitude, String gps_longitude,HardwareBean hardware,String idfa,String idfv, int images_internal, String imei, String ip, int is_root, int is_simulator, String last_login_time, String mac, String memory, NetworkBean network, NewStorageBean new_storage, String os_type, String os_version,OtherDataBean other_data, String package_name, String resolution,  String storage, String unuse_storage,  int video_internal, int wifi,String imsi) {
//                this.address_info = address_info;
//                this.albs = albs;
//                this.audio_internal = audio_internal;
//                this.battery = battery;
//                this.battery_status = battery_status;
//                this.brand = brand;
//                this.build_id = build_id;
//                this.build_name = build_name;
//                //           this.contact_group = contact_group;
//                this.create_time = create_time;
//                this.device_id = device_id;
//                this.device_info = device_info;
//                this.general_data = general_data;
//                this.gps_address = gps_address;
//                this.gps_adid = gps_adid;
//                this.gps_latitude = gps_latitude;
//                this.gps_longitude = gps_longitude;
//                this.hardware = hardware;
//                this.idfa = idfa;
//                this.idfv = idfv;
//                //          this.images_external = images_external;
//                this.images_internal = images_internal;
//                this.imei = imei;
//                this.ip = ip;
//                this.is_root = is_root;
//                this.is_simulator = is_simulator;
//                this.last_login_time = last_login_time;
//                this.mac = mac;
//                this.memory = memory;
//                this.network = network;
//                this.new_storage = new_storage;
//                this.os_type = os_type;
//                this.os_version = os_version;
//                this.other_data = other_data;
//                this.package_name = package_name;
//                //          this.pic_count = pic_count;
//                //       this.process_info = process_info;
//                this.resolution = resolution;
//                //        this.sdcard = sdcard;
//                //        this.shortVersionString = shortVersionString;
//                this.storage = storage;
//                //            this.unuse_sdcard = unuse_sdcard;
//                this.unuse_storage = unuse_storage;
//                //        this.version = version;
//                //        this.video = video;
//                //              this.video_external = video_external;
//                this.video_internal = video_internal;
//                this.wifi = wifi;
//                this.imsi = imsi;
//                //        this.wifi_name = wifi_name;
//            }
//
//            public static class BatteryStatusBean implements Serializable {
//                /**
//                 * battery_level : string
//                 * battery_max : string
//                 * battery_pct : 0
//                 * battery_state : 0
//                 * is_ac_charge : 0
//                 * is_charging : 0
//                 * is_usb_charge : 0
//                 */
//
//                private String battery_level; // 电池电量
//                private String battery_max; // 电池容量
//                private int battery_pct; //  电池百分比
//                //  private int battery_state;// 电池状态 充电0 不充电1
//                private int is_ac_charge; // 是否交流充电(1:yes,0:no)
//                private int is_charging; // 是否正在充电
//                private int is_usb_charge;// 是否USB充电(1:yes,0:no)
//
//                public BatteryStatusBean(String battery_level, String battery_max, int battery_pct, int is_ac_charge, int is_charging, int is_usb_charge) {
//                    this.battery_level = battery_level!=null?battery_level:"";
//                    this.battery_max = battery_max!=null?battery_max:"";
//                    this.battery_pct = battery_pct;
//                    this.is_ac_charge = is_ac_charge;
//                    this.is_charging = is_charging;
//                    this.is_usb_charge = is_usb_charge;
//                }
//
//                public int getBattery_pct() {
//                    return battery_pct;
//                }
//            }
//
//            public static class GeneralDataBean implements Serializable {
//                /**
//                 * allowsVOIP : true
//                 * and_id : string
//                 * currentSystemTime : 0
//                 * elapsedRealtime : 0
//                 * gaid : string
//                 * imei : string
//                 * is_usb_debug : string
//                 * is_using_proxy_port : string
//                 * is_using_vpn : string
//                 * language : string
//                 * locale_display_language : string
//                 * locale_iso_3_country : string
//                 * locale_iso_3_language : string
//                 * mac : string
//                 * mobileCountryCode : string
//                 * mobileNetworkCode : string
//                 * network_operator_name : string
//                 * network_type : string
//                 * network_type_new : string
//                 * phone_number : string
//                 * phone_type : 0
//                 * sensor_list : [{"maxRange":"string","minDelay":"string","name":"string","power":"string","resolution":"string","type":"string","vendor":"string","version":"string"}]
//                 * serviceCurrentRadioAccessTechnology : string
//                 * time_zone_id : string
//                 * uptimeMillis : 0
//                 * uuid : string
//                 * wifi_mac : string
//                 */
//
//                private String and_id; // android_id
//                private String currentSystemTime; // 设备当前时间
//                private String elapsedRealtime; // 开机时间到现在的毫秒数（包括睡眠时间）
//                private String gaid; // google advertising id(google 广告 id)
//                private String imei; // 设备号
//                private boolean is_usb_debug; // 是否开启debug调试
//                private boolean is_using_proxy_port; // 是否使用代理
//                private boolean is_using_vpn; // 是否使用vpn
//                private String language; // 语言
//                private String locale_display_language; // 此用户显示的语言环境语⾔的名称
//                private String locale_iso_3_country; // 此地区的国家/地区的缩写
//                private String locale_iso_3_language; // 语言环境的三字母缩写
//                private String mac; // mac 地址
//                private String network_operator_name; // 网络运营商名称
//                private String network_type; // 网络类型 2G、3G、4G、5G、wifi、other、none
//                private String network_type_new; // 网络类型 2G、3G、4G、5G、wifi、other、none
//                private String phone_number; // 手机号
//                private int phone_type; // 指示设备电话类型的常量。 这表示用于传输语音呼叫的无线电的类型
//                //           private String serviceCurrentRadioAccessTechnology; // 运营商无线接入技术
//                private String time_zone_id; // 时区的 ID
//                private String uptimeMillis; // 从开机到现在的毫秒数（不包括睡眠时间）
//                private String uuid; // 唯一标识 UUID.randomUUID().toString().toUpperCase()
//                private List<GeneralDataBean.SensorListBean> sensor_list; // 传感器信息
//
//                public GeneralDataBean( String and_id, String currentSystemTime, String elapsedRealtime, String gaid, String imei, boolean is_usb_debug, boolean is_using_proxy_port, boolean is_using_vpn, String language, String locale_display_language, String locale_iso_3_country, String locale_iso_3_language, String mac, String network_operator_name, String network_type, String network_type_new, String phone_number, int phone_type, String time_zone_id, String uptimeMillis, String uuid,  List<GeneralDataBean.SensorListBean> sensor_list) {
//                    this.and_id = and_id;
//                    this.currentSystemTime = currentSystemTime;
//                    this.elapsedRealtime = elapsedRealtime;
//                    this.gaid = gaid;
//                    this.imei = imei;
//                    this.is_usb_debug = is_usb_debug;
//                    this.is_using_proxy_port = is_using_proxy_port;
//                    this.is_using_vpn = is_using_vpn;
//                    this.language = language;
//                    this.locale_display_language = locale_display_language;
//                    this.locale_iso_3_country = locale_iso_3_country;
//                    this.locale_iso_3_language = locale_iso_3_language;
//                    this.mac = mac;
//                    this.network_operator_name = network_operator_name;
//                    this.network_type = network_type;
//                    this.network_type_new = network_type_new;
//                    this.phone_number = phone_number;
//                    this.phone_type = phone_type;
//                    //           this.serviceCurrentRadioAccessTechnology = serviceCurrentRadioAccessTechnology;
//                    this.time_zone_id = time_zone_id;
//                    this.uptimeMillis = uptimeMillis;
//                    this.uuid = uuid;
//                    this.sensor_list = sensor_list;
//                }
//
//                public static class SensorListBean implements Serializable {
//                    /**
//                     * maxRange : string //
//                     * minDelay : string
//                     * name : string
//                     * power : string
//                     * resolution : string
//                     * type : string
//                     * vendor : string
//                     * version : string
//                     */
//
//                    private String maxRange;
//                    private String minDelay;
//                    private String name;
//                    private String power;
//                    private String resolution;
//                    private String type;
//                    private String vendor;
//                    private String version;
//
//                    public SensorListBean(String maxRange, String minDelay, String name, String power, String resolution, String type, String vendor, String version) {
//                        this.maxRange = maxRange;
//                        this.minDelay = minDelay;
//                        this.name = name;
//                        this.power = power;
//                        this.resolution = resolution;
//                        this.type = type;
//                        this.vendor = vendor;
//                        this.version = version;
//                    }
//                }
//            }
//
//            public static class HardwareBean implements Serializable {
//                /**
//                 * board : string
//                 * brand : string
//                 * cores : 0
//                 * device_height : 0
//                 * device_name : string
//                 * device_width : 0
//                 * model : string
//                 * physical_size : string
//                 * production_date : 0
//                 * release : string
//                 * sdk_version : string
//                 * serial_number : string
//                 */
//
//                private String board; // 主板
//                private String brand; // 设备品牌
//                private String cores; // 设备内核
//                private int device_height; // 分辨率高
//                private String device_name; // 设备名称
//                private int device_width; // 分辨率宽
//                private String model; // 设备型号
//                private String physical_size; // 物理尺寸
//                private String production_date; // 手机出厂时间戳
//                private String release; // 系统版本
//                private String sdk_version; // SDK版本
//                private String serial_number; // 设备序列号
//
//                public HardwareBean(String board, String brand, String cores, int device_height, String device_name, int device_width, String model, String physical_size, String production_date, String release, String sdk_version, String serial_number) {
//                    this.board = board==null?"":board;
//                    this.brand = brand==null?"":brand;
//                    this.cores = cores;
//                    this.device_height = device_height;
//                    this.device_name = device_name==null?"":device_name;
//                    this.device_width = device_width;
//                    this.model = model==null?"":model;
//                    this.physical_size = physical_size ==null?"":physical_size;
//                    this.production_date = production_date ==null?"":production_date;
//                    this.release = release ==null?"":release;
//                    this.sdk_version = sdk_version==null?"":sdk_version;
//                    this.serial_number = serial_number==null?"":serial_number;
//                }
//
//                public String getBrand() {
//                    return brand;
//                }
//
//                public int getDevice_height() {
//                    return device_height;
//                }
//
//                public int getDevice_width() {
//                    return device_width;
//                }
//            }
//
//            public static class NetworkBean implements Serializable {
//                /**
//                 * configured_wifi : [{"bssid":"string","mac":"string","name":"string","ssid":"string"}]
//                 * current_wifi : {"bssid":"string","mac":"string","name":"string","ssid":"string"}
//                 * ip : string
//                 * wifi_count : 0
//                 */
//
//                private NetworkBean.CurrentWifiBean current_wifi; // 当前WIFI
//                private String ip; // 网络IP（内网）//            private int wifi_count; // wifi 个数
//                //             private List<NetworkBean.ConfiguredWifiBean> configured_wifi; // 配置WIFI
//
//                public NetworkBean(NetworkBean.CurrentWifiBean current_wifi, String ip) {
//                    this.current_wifi = current_wifi;
//                    this.ip = ip;
//                    //                 this.wifi_count = wifi_count;
//                    //                 this.configured_wifi = configured_wifi;
//                }
//
//                public static class CurrentWifiBean implements Serializable {
//                    /**
//                     * bssid : string
//                     * mac : string
//                     * name : string
//                     * ssid : string
//                     */
//
//                    private String bssid;
//                    private String mac;
//                    private String name;
//                    private String ssid;
//
//                    public CurrentWifiBean(String bssid, String mac, String name, String ssid) {
//                        this.bssid = bssid.equals("02:00:00:00:00:00")?"":bssid;
//                        this.mac = mac.equals("02:00:00:00:00:00")?"":mac;
//                        this.name = name.equals("<unknown ssid>")?"":name;
//                        this.ssid = ssid.equals("<unknown ssid>")?"":ssid;
//                    }
//                }
//
//                public static class ConfiguredWifiBean implements Serializable {
//                    /**
//                     * bssid : string
//                     * mac : string
//                     * name : string
//                     * ssid : string
//                     */
//
//                    private String bssid;
//                    private String mac;
//                    private String name;
//                    private String ssid;
//
//                    public ConfiguredWifiBean(String bssid, String mac, String name, String ssid) {
//                        this.bssid = bssid;
//                        this.mac = mac;
//                        this.name = name;
//                        this.ssid = ssid;
//                    }
//                }
//            }
//
//            public static class NewStorageBean implements Serializable {
//                /**
//                 * activeMemory : 0
//                 * app_free_memory : string
//                 * app_max_memory : string
//                 * app_total_memory : string
//                 * contain_sd : string
//                 * extra_sd : string
//                 * freeMemory : 0
//                 * inActiveMemory : 0
//                 * internal_storage_total : 0
//                 * internal_storage_usable : 0
//                 * memory_card_free_size : 0
//                 * memory_card_size : 0
//                 * memory_card_size_use : 0
//                 * memory_card_usable_size : 0
//                 * purgableMemory : 0
//                 * ram_total_size : string
//                 * ram_usable_size : string
//                 * totalMemory : 0
//                 * usedMemory : 0
//                 * wiredMemory : 0
//                 */
//
//                //        private String activeMemory; // 活动内存 单位Byte）
//                private String app_free_memory; // app可用内存大小 单位Byte）
//                private String app_max_memory; // app最大内存大小 单位Byte）
//                private String app_total_memory;// app总内存大小 单位Byte）
//                private String contain_sd; // 是否有内置的SD卡（0否，1是）
//                private String extra_sd; // 是否有外置的SD卡（0否，1是）
//                //         private String freeMemory; //内存空闲大小 单位Byte）
//                //         private String inActiveMemory; // 不活动内存 单位Byte）
//                private String internal_storage_total; // 总存储大小 单位Byte）
//                private String internal_storage_usable; // 可用存储大小 单位Byte）
//                private String memory_card_free_size; // 内存卡剩余使用量 单位Byte）
//                private String memory_card_size; //  内存卡大小 单位Byte）
//                private String memory_card_size_use; // 内存卡已使用量 单位Byte）
//                private String memory_card_usable_size; // 内存卡可使用量 单位Byte）
//                //        private String purgableMemory; // 可清理内存 单位Byte）
//                private String ram_total_size; // 总内存大小（ 单位Byte）
//                private String ram_usable_size; // 内存可用大小 单位Byte）
////                private String totalMemory; // 总内存大小（ 单位Byte）
////                private String usedMemory; // 已用内存 单位Byte）
////                private String wiredMemory; // 保留内存 单位Byte）
//
//
//
//                public String getInternal_storage_total() {
//                    return internal_storage_total;
//                }
//
//                public String getInternal_storage_usable() {
//                    return internal_storage_usable;
//                }
//
//
//                public void setApp_free_memory(String app_free_memory) {
//                    this.app_free_memory = app_free_memory;
//                }
//
//                public void setApp_max_memory(String app_max_memory) {
//                    this.app_max_memory = app_max_memory;
//                }
//
//                public void setApp_total_memory(String app_total_memory) {
//                    this.app_total_memory = app_total_memory;
//                }
//
//
//                public void setInternal_storage_total(String internal_storage_total) {
//                    this.internal_storage_total = internal_storage_total;
//                }
//
//                public void setInternal_storage_usable(String internal_storage_usable) {
//                    this.internal_storage_usable = internal_storage_usable;
//                }
//
//                public void setExtra_sd(String extra_sd) {
//                    this.extra_sd = extra_sd;
//                }
//
//                public void setRam_total_size(String ram_total_size) {
//                    this.ram_total_size = ram_total_size;
//                }
//
//                public void setRam_usable_size(String ram_usable_size) {
//                    this.ram_usable_size = ram_usable_size;
//                }
//
//                public void setContain_sd(String contain_sd) {
//                    this.contain_sd = contain_sd;
//                }
//
//                public void setMemory_card_free_size(String memory_card_free_size) {
//                    this.memory_card_free_size = memory_card_free_size;
//                }
//
//                public void setMemory_card_size(String memory_card_size) {
//                    this.memory_card_size = memory_card_size;
//                }
//
//                public void setMemory_card_size_use(String memory_card_size_use) {
//                    this.memory_card_size_use = memory_card_size_use;
//                }
//
//                public void setMemory_card_usable_size(String memory_card_usable_size) {
//                    this.memory_card_usable_size = memory_card_usable_size;
//                }
//            }
//
//            public static class OtherDataBean implements Serializable {
//                /**
//                 * dbm : string
//                 * dbmClass : 0
//                 * keyboard : 0
//                 * last_boot_time : 0
//                 * root_jailbreak : 0
//                 * simulator : 0
//                 */
//
//                private String dbm; // 手机的信号强度 默认值-1
//                //    private int dbmClass;
//                private int keyboard; // 连接到设备的键盘种类
//                private String last_boot_time; // 最后一次启动时间
//                private int root_jailbreak; // 是否 root
//                private int simulator; // 是否为模拟器
//
//                public OtherDataBean(String dbm, int keyboard, String last_boot_time, int root_jailbreak, int simulator) {
//                    this.dbm = dbm;
//                    //           dbmClass = 0;
//                    this.keyboard = keyboard;
//                    this.last_boot_time = last_boot_time;
//                    this.root_jailbreak = root_jailbreak;
//                    this.simulator = simulator;
//                }
//            }
//
//
//        }
//        public static class CallLogsBean implements Serializable {
//            /**
//             * contact_display_name : string
//             * last_time_contacted : 0
//             * number : string
//             * times_contacted : 0
//             * up_time : 0
//             */
//
//            private String name; // 联系人名称
//            private String time; // 上次通讯时间(毫秒)
//            private String phone; // 联系人手机号
//            private String type; // 类型
//            private String duration; // 编辑时间(毫秒)
//
//            public CallLogsBean(String name, String time, String phone, String type, String duration) {
//                this.name = name;
//                this.time = time;
//                this.phone = phone;
//                this.type = type;
//                this.duration = duration;
//            }
//        }
//        public static class AddressBookBean implements Serializable {
//            /**
//             * contact_display_name : string
//             * last_time_contacted : 0
//             * number : string
//             * times_contacted : 0
//             * up_time : 0
//             */
//
//            private String contact_display_name; // 联系人名称
//            private String last_time_contacted; // 上次通讯时间(毫秒)
//            private String number; // 联系人手机号
//            private int times_contacted; // 联系次数
//            private String up_time; // 编辑时间(毫秒)
//
//            public AddressBookBean(String contact_display_name, String last_time_contacted, String number, int times_contacted, String up_time) {
//                this.contact_display_name = contact_display_name;
//                this.last_time_contacted = last_time_contacted;
//                this.number = number;
//                this.times_contacted = times_contacted;
//                this.up_time = up_time;
//            }
//        }
//
//        public static class AppListBean implements Serializable {
//            /**
//             * app_name : string
//             * app_type : string
//             * app_version : string
//             * in_time : 0
//             * obtain_time : 0
//             * package_name : string
//             * up_time : 0
//             * version_code : string
//             */
//
//            private String app_name; // APP名称
//            private String app_type; // 是否系统app 0:非系统app 1：系统app
//            private String app_version; // APP版本
//            private String in_time; // 安装时间（毫秒)
//            private int obtain_time; // 数据抓取时间（秒）
//            private String package_name; // 包名
//            private String up_time; // 更新时间 （毫秒）
//            private String version_code; // 版本号
//
//            public AppListBean(String app_name, String app_type, String app_version, String in_time, int obtain_time, String package_name, String up_time, String version_code) {
//                this.app_name = app_name;
//                this.app_type = app_type;
//                this.app_version = app_version;
//                this.in_time = in_time;
//                this.obtain_time = obtain_time;
//                this.package_name = package_name;
//                this.up_time = up_time;
//                this.version_code = version_code;
//            }
//
//
//        }
//
//        public static class CalendarListBean implements Serializable {
//            /**
//             * description : string
//             * end_time : 0
//             * event_id : 0
//             * event_title : string
//             * reminders : [{"eventId":0,"method":0,"minutes":0,"reminder_id":0}]
//             * start_time : 0
//             */
//
//            private String description; // 事件描述
//            private String end_time; // 事件结束时间（毫秒）
//            private String event_id; // 事件ID
//            private String event_title;  // 事件标题
//            private String start_time; // 事件开始时间（毫秒）
//            private List<CalendarListBean.RemindersBean> reminders; // 提醒列表
//
//            public CalendarListBean(String description, String end_time, String event_id, String event_title, String start_time, List<RemindersBean> reminders) {
//                this.description = description;
//                this.end_time = end_time;
//                this.event_id = event_id;
//                this.event_title = event_title;
//                this.start_time = start_time;
//                this.reminders = reminders;
//            }
//
//            public void setReminders(List<CalendarListBean.RemindersBean> reminders) {
//                this.reminders = reminders;
//            }
//
//            public static class RemindersBean implements Serializable {
//                /**
//                 * eventId : 0
//                 * method : 0
//                 * minutes : 0
//                 * reminder_id : 0
//                 */
//
//                private int eventId;
//                private int method;
//                private int minutes;
//                private int reminder_id;
//
//                public RemindersBean(int eventId, int method, int minutes, int reminder_id) {
//                    this.eventId = eventId;
//                    this.method = method;
//                    this.minutes = minutes;
//                    this.reminder_id = reminder_id;
//                }
//            }
//        }
//
//        public static class PhotoInfosBean implements Serializable {
//            /**
//             * addTime : 0
//             * author : string
//             * createTime : string
//             * date : string
//             * flash : string
//             * focal_length : string
//             * gps_altitude : string
//             * gps_processing_method : string
//             * height : string
//             * latitude : 0
//             * lens_make : string
//             * lens_model : string
//             * longitude : 0
//             * model : string
//             * name : string
//             * orientation : string
//             * save_time : string
//             * software : string
//             * take_time : string
//             * updateTime : 0
//             * width : string
//             * x_resolution : string
//             * y_resolution : string
//             */
//
//            private int addTime; //
//            private String author; // 照片作者，获取不到传空字符串
//            private String createTime; // 照片读取时间（毫秒数时间戳），即当前时间
//            private String date; // 拍照时间（毫秒数时间戳），获取不到传空字符串
//            private String flash; // 闪光灯，获取不到传空字符串
//            private String focal_length; // 镜头的实际焦距，获取不到传空字符串
//            private String gps_altitude; // 海拔高度，获取方法传默认值getAltitude(0.0)
//            private String gps_processing_method; // 定位的方法名称，获取不到传空字符串
//            private String height; // 照片高度，获取不到传空字符串
//            private int latitude; // 照片拍摄时的经度，获取不到传null
//            private String lens_make; // 镜头制造商，获取不到传空字符串
//            private String lens_model; // 镜头的序列号，获取不到传空字符串
//            private int longitude; // 照片拍摄时的纬度，获取不到传null
//            private String model; // 拍照机型，获取不到传空字符串
//            private String name; // 照片名称，获取不到传空字符串
//            private String orientation; // 照片方向，获取不到传空字符串
//            private String save_time; // 照片修改时间（毫秒数时间戳），获取不到传空字符串
//            private String software; // 生成图像的相机或图像输入设备的软件或固件的名称和版本，获取不到传空字符串
//            private String take_time; // 创建时间（毫秒数时间戳），获取不到传空字符串
//            private int updateTime; //
//            private String width; // 照片宽度，获取不到传空字符串
//            private String x_resolution; // X方向上每个分辨率的像素数，获取不到传空字符串
//            private String y_resolution; // Y方向上每个分辨率的像素数，获取不到传空字符串
//
//            public PhotoInfosBean(String author, String createTime, String date, String gps_altitude, String gps_processing_method,
//                                  String height, int latitude, int longitude, String width, String name, String model,
//                                  String orientation, String save_time, String take_time, String x_resolution, String y_resolution) {
//                this.addTime = 0;
//                this.updateTime = 0;
//                this.author = author;
//                this.createTime = createTime;
//                this.date = date;
//                this.gps_altitude = gps_altitude;
//                this.gps_processing_method = gps_processing_method;
//                this.height = height;
//                this.latitude = latitude;
//                this.longitude = longitude;
//                this.width = width;
//                this.name = name;
//                this.model = model;
//                this.orientation = orientation;
//                this.save_time = save_time;
//                this.take_time = take_time;
//                this.x_resolution = x_resolution;
//                this.y_resolution = y_resolution;
//            }
//
//            public void setFlash(String flash) {
//                this.flash = flash;
//            }
//
//            public void setFocal_length(String focal_length) {
//                this.focal_length = focal_length;
//            }
//            public void setLens_make(String lens_make) {
//                this.lens_make = lens_make;
//            }
//
//            public void setLens_model(String lens_model) {
//                this.lens_model = lens_model;
//            }
//
//            public void setSoftware(String software) {
//                this.software = software;
//            }
//        }
//
//        public static class SmsBean implements Serializable {
//            /**
//             * content : string
//             * other_phone : string
//             * package_name : string
//             * read : 0
//             * seen : 0
//             * status : 0
//             * subject : string
//             * time : string
//             * type : string
//             */
//
//            private String content; // 短信消息体
//            private String other_phone; // 收件⼈/发件⼈⼿机号
//            private String package_name; // 包名
//            private int read; // 短信状态 0-未读，1-已读
//            private int seen; // 短信是否被用户看到 0-尚未查看，1-已查看
//            private int status; // 短信状态：-1表示接收，0-complete，64-pending，128-failed
//            private String subject; // 短信主题
//            private String time; // 收到短信的时间戳（毫秒），long型
//            private String type; // 短信类型：1-接收短信，2-已发出短信
//
//            public SmsBean(String content, String other_phone, String package_name, int read, int seen, int status, String subject, String time, String type) {
//                this.content = content;
//                this.other_phone = other_phone;
//                this.package_name = package_name;
//                this.read = read;
//                this.seen = seen;
//                this.status = status;
//                this.subject = subject;
//                this.time = time;
//                this.type = type;
//            }
//        }
//    }
//}
//
