# DataCapture
对手机设备的信息数据抓取，目前支持在子线程抓取数据，因为有些数据量过于庞大会阻塞线程,可抓取数据有:

习惯性上图展示：

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/b26f4f38bf0e431e93025be1f3b2888e~tplv-k3u1fbpfcp-zoom-1.image)

体验demo:（密码：aoc8）

![image.png](https://p9-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/89e0ab9d7c3147cd89d4d163664ab626~tplv-k3u1fbpfcp-jj-mark:0:0:0:0:q75.image#?w=190&h=190&s=1383&e=png&b=ffffff)

1.通讯录集合数据
| 字段名 | 详情 |
|--|--|
| contact_display_name |联系人名称|
| last_time_contacted | 上次通讯时间(毫秒) |
| number |联系人手机号 |
| times_contacted |联系次数|
| up_time | 编辑时间(毫秒)) |
| type |通话类型|

2.应用列表集合数据
| 字段名 | 详情 |
|--|--|
| app_name |APP名称|
| app_type | 是否系统app 0:非系统app 1：系统app |
| app_version |APP版本 |
| in_time |安装时间（毫秒)|
| obtain_time | 数据抓取时间（秒）) |
| package_name |包名|
| up_time |更新时间 （毫秒）|
| version_code |  版本号 |

3.日历事件信息数据
| 字段名 | 详情 |
|--|--|
| description |事件描述|
| end_time | 事件结束时间（毫秒） |
| event_id |事件ID |
| event_title |事件标题|
| start_time | 事件开始时间（毫秒）) |
| reminders |提醒列表|

4.电量信息数据
| 字段名 | 详情 |
|--|--|
| battery_level |电池电量|
| battery_max |电池容量 |
| battery_pct |电池百分比 |
| battery_state |电池状态 充电0 不充电1|
| is_ac_charge | 是否交流充电(1:yes,0:no) |
| is_charging |是否正在充电|
| is_usb_charge |是否USB充电(1:yes,0:no)|

5.sms短信信息数据
| 字段名 | 详情 |
|--|--|
| content |短信消息体|
| other_phone |收件⼈/发件⼈⼿机号 |
| package_name |包名 |
| read | 短信状态 0-未读，1-已读|
| seen | 短信是否被用户看到 0-尚未查看，1-已查看 |
| status |短信状态：-1表示接收，0-complete，64-pending，128-failed|
| subject |短信主题|
| time |收到短信的时间戳（毫秒），long型|
| type |短信类型：1-接收短信，2-已发出短信|

6.照片集合信息数据
| 字段名 | 详情 |
|--|--|
| addTime |添加数据库时间（保存）|
| author |照片作者 |
| createTime |照片读取时间（毫秒数时间戳），即当前时间 |
| date | 拍照时间（毫秒数时间戳）|
| flash | 闪光灯 |
| focal_length |镜头的实际焦距|
| gps_altitude |海拔高度|
| gps_processing_method | 定位的方法名称|
| height | 照片高度|
| latitude | 照片拍摄时的经度 |
| lens_make |镜头制造商|
| lens_model |镜头的序列号|
| longitude | 照片拍摄时的纬度|
| model | 拍照机型|
| name | 照片名称|
| orientation |  照片方向|
| save_time | 照片修改时间|
| software | 生成图像的相机或图像输入设备的软件或固件的名称和版本|
| take_time |  创建时间（毫秒数时间戳）|
| updateTime | 编辑时间|
| width | 照片宽度|
| x_resolution |  X方向上每个分辨率的像素数|
| y_resolution |  Y方向上每个分辨率的像素数|

7.传感器信息数据
| 字段名 | 详情 |
|--|--|
| id |传感器id,0不支持功能，-1即其类型和名称的组合在系统中唯一标识。-2获取不到|
| maxRange |传感器单元中传感器的最大量程|
| minDelay |两个事件之间允许的最小延迟(以微秒为单位)，如果此传感器仅在其测量的数据发生变化时返回值，则为零|
| name | 传感器名称|
| power | 使用时功率 |
| resolution |传感器单元中传感器的分辨率|
| type |该传感器的通用类型|
| name | 传感器名称|
| vendor | 厂商字符串 |
| version |版本|

8.wifi信息数据
| 字段名 | 详情 |
|--|--|
| current_wifi |当前WIFI详情|
| ip |网络IP（内网）|
| wifi_count | wifi 个数|
| configured_wifi | 配置WIFI,附近的wifi|

8.1 wifi详情
| 字段名 | 详情 |
|--|--|
| bssid |bssid|
| mac |mac|
| name | name|
| ssid | ssid|

9.硬件信息数据
| 字段名 | 详情 |
|--|--|
| board |主板|
| brand |设备品牌|
| cores |设备内核|
| device_height |分辨率高|
| device_name | 设备名称 |
| device_width |分辨率宽|
| model |设备型号|
| physical_size | 物理尺寸|
| production_date | 手机出厂时间戳 |
| release |系统版本|
| sdk_version | SDK版本|
| serial_number | 设备序列号 |
10.定位信息数据
| 字段名 | 详情 |
|--|--|
| gps_longitude |经度|
| gps_latitude |维度|
| gps_address_street |街道|
| gps_address_province |省份|
| gps_address_city | 城市 |
| gps_address_country |国家|
| gps_address_countryCode |国家代码|
11.其他信息数据
| 字段名 | 详情 |
|--|--|
| dbm |手机的信号强度 默认值-1|
| last_boot_time |最后一次启动时间，毫秒|
| root_jailbreak |是否root，true：1,false:0|
| simulator |是否为模拟器，true：1，false：0|
12.内存信息数据
| 字段名 | 详情 |
|--|--|
| app_free_memory | app可用内存大小 单位Byte）|
| app_max_memory |app最大内存大小 单位Byte）|
| app_total_memory |app总内存大小 单位Byte）|
| contain_sd |是否有内置的SD卡（0否，1是）|
| extra_sd | 是否有外置的SD卡（0否，1是）|
| internal_storage_total | 总存储大小 单位Byte）|
| internal_storage_usable |可用存储大小 单位Byte）|
| memory_card_free_size |内存卡剩余使用量 单位Byte）|
| memory_card_size |内存卡大小 单位Byte）|
| memory_card_size_use | 内存卡已使用量 单位Byte）|
| memory_card_usable_size | 内存卡可使用量 单位Byte）|
| ram_total_size |总内存大小（ 单位Byte）|
| ram_usable_size |内存可用大小 单位Byte）|
| ram_threshold |低内存阙值|
13.通用信息数据
| 字段名 | 详情 |
|--|--|
| and_id | android_id|
| currentSystemTime |设备当前时间|
| elapsedRealtime |开机时间到现在的毫秒数（包括睡眠时间）|
| gaid | google advertising id(google 广告 id)|
| imei | 设备号|
| is_usb_debug | 是否开启debug调试|
| is_using_proxy_port |是否使用代理|
| is_using_vpn |是否使用vpn|
| language |语言|
| locale_display_language | 此用户显示的语言环境语言的名称|
| locale_iso_3_country | 此地区的国家/地区的缩写|
| locale_country |此地区的国家|
| locale_iso_3_language |语言环境的三字母缩写|
| mac |mac 地址|
| network_operator_name |网络运营商名称|
| network_type |网络类型 2G、3G、4G、5G、wifi、other、none|
| phone_number |手机号|
| phone_type |  指示设备电话类型的常量。 这表示用于传输语音呼叫的无线电的类型|
| time_zone_id | 时区的 ID|
| uptimeMillis | 从开机到现在的毫秒数（不包括睡眠时间）|
| uuid |唯一标识|

导入依赖方式：

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    dependencies {
	        implementation 'com.github.Android5730:DataCapture:v0.32'
	}

获取信息方法
```java
// 获取通讯录
List<AddressBookBean> addressBookBean = AddressBookUtil.getAddressBookBean(getBaseContext());
// 获取应用列表
List<AppListBean> appListBean = AppListUtil.getAppListBean(this);
// 获取日历事件
List<CalendarListBean> calendarListBean = CalendarListUtil.getCalendarListBean(this);
// 获取电量信息
BatteryStatusBean batteryState = BatteryStatusUtil.getBatteryState(this);
// 获取wifi信息
NetworkBean networkBean = NetworkBeanUtils.getNetworkBean(this);
// 获取wifi信息详情
NetworkBean.CurrentWifiBean current_wifi = NetworkBeanUtils.getNetworkBean(this).getCurrent_wifi();
// 获取附近wifi集合
List<NetworkBean.ConfiguredWifiBean> configured_wifi = networkBean.getConfigured_wifi();
// 获取sms短信信息
List<SmsBean> smsList = SmsUtil.getSmsList(this);
// 获取照片集合信息
List<PhotoInfosBean> photoInfosBean = PhotoInfosUtil.getPhotoInfosBean(this, 
LocationUtils.getInstance(this).showLocation());
// 获取传感器集合信息
List<SensorListBean> sensorListBean = SensorListUtil.getSensorListBean(this);
// 获取硬件信息
HardwareBean hardwareBean = HardwareUtil.getHardwareBean(this);
// 获取定位信息
LocationUtils instance = LocationUtils.getInstance(this); // 定位工具类单例对象
LocationUtils.AddressInfo addressInfo = instance.getAddressInfo(); // bean信息
String address = instance.getAddress();// bean类整合信息
// 获取其他信息
OtherDataBean otherDataBean = OtherDataUtil.getOtherDataBean(this);
// 获取内存信息
NewStorageBean newStorageBean = SDCardUtils.getNewStorageBean(this);
// 获取通用信息
GeneralDataBean generalData = GeneralDataUtil.getGeneralData(this);




```
    若是大家感兴趣，我后续会更新此库，方便大家获取更多的数据
    这个是本人的博客：https://blog.csdn.net/weixin_63088467?spm=1011.2415.3001.5343 
    https://juejin.cn/user/4156615587280125 欢迎持续关注
