package com.itaem.datacapture.bean;// 2023/8/13

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.io.Serializable;

// 作者:ITAEM 陈金城
@SmartTable(name="照片数据")
public  class PhotoInfosBean implements Serializable {
    /**
     * addTime : 0
     * author : string
     * createTime : string
     * date : string
     * flash : string
     * focal_length : string
     * gps_altitude : string
     * gps_processing_method : string
     * height : string
     * latitude : 0
     * lens_make : string
     * lens_model : string
     * longitude : 0
     * model : string
     * name : string
     * orientation : string
     * save_time : string
     * software : string
     * take_time : string
     * updateTime : 0
     * width : string
     * x_resolution : string
     * y_resolution : string
     */
    @SmartColumn(id =1,name = "addTime_添加数据库时间（保存）")
    private String addTime; //
    @SmartColumn(id =2,name = "author_照片作者")
    private String author; // 照片作者，获取不到传空字符串
    @SmartColumn(id =3,name = "createTime_照片读取时间（毫秒数时间戳），即当前时间")
    private String createTime; // 照片读取时间（毫秒数时间戳），即当前时间
    @SmartColumn(id =4,name = "date_拍照时间（毫秒数时间戳）")
    private String date; // 拍照时间（毫秒数时间戳），获取不到传空字符串
    @SmartColumn(id =5,name = "flash_闪光灯")
    private String flash; // 闪光灯，获取不到传空字符串
    @SmartColumn(id =6,name = "focal_length_镜头的实际焦距")
    private String focal_length; // 镜头的实际焦距，获取不到传空字符串
    @SmartColumn(id =7,name = "gps_altitude_海拔高度，获取方法传默认值getAltitude(0.0)")
    private String gps_altitude; // 海拔高度，获取方法传默认值getAltitude(0.0)
    @SmartColumn(id =8,name = "gps_processing_method_定位的方法名称")
    private String gps_processing_method; // 定位的方法名称，获取不到传空字符串
    @SmartColumn(id =8,name = "height_照片高度")
    private String height; // 照片高度，获取不到传空字符串
    @SmartColumn(id =9,name = "latitude_照片拍摄时的经度")
    private int latitude; // 照片拍摄时的经度，获取不到传null
    @SmartColumn(id =10,name = "lens_make_ 镜头制造商")
    private String lens_make; // 镜头制造商，获取不到传空字符串
    @SmartColumn(id =11,name = "lens_model_ 镜头的序列号")
    private String lens_model; // 镜头的序列号，获取不到传空字符串
    @SmartColumn(id =12,name = "longitude_照片拍摄时的纬度")
    private int longitude; // 照片拍摄时的纬度，获取不到传null
    @SmartColumn(id =13,name = "model_拍照机型")
    private String model; // 拍照机型，获取不到传空字符串
    @SmartColumn(id =14,name = "name_照片名称")
    private String name; // 照片名称，获取不到传空字符串
    @SmartColumn(id =15,name = "orientation_照片方向")
    private String orientation; // 照片方向，获取不到传空字符串
    @SmartColumn(id =16,name = "save_time_照片修改时间（毫秒数时间戳）")
    private String save_time; // 照片修改时间（毫秒数时间戳），获取不到传空字符串
    @SmartColumn(id =17,name = "software_生成图像的相机或图像输入设备的软件或固件的名称和版本")
    private String software; // 生成图像的相机或图像输入设备的软件或固件的名称和版本，获取不到传空字符串
    @SmartColumn(id =18,name = "take_time_创建时间（毫秒数时间戳）")
    private String take_time; // 创建时间（毫秒数时间戳），获取不到传空字符串
    @SmartColumn(id =19,name = "updateTime_编辑时间")
    private String updateTime; //
    @SmartColumn(id =20,name = "width_照片宽度")
    private String width; // 照片宽度，获取不到传空字符串
    @SmartColumn(id =21,name = "x_resolution_X方向上每个分辨率的像素数")
    private String x_resolution; // X方向上每个分辨率的像素数，获取不到传空字符串
    @SmartColumn(id =22,name = "y_resolution_Y方向上每个分辨率的像素数")
    private String y_resolution; // Y方向上每个分辨率的像素数，获取不到传空字符串

    public PhotoInfosBean(String addTime,String updateTime,String author, String createTime, String date, String gps_processing_method,
                          String height, int latitude, int longitude, String width, String name, String model,
                          String orientation, String save_time, String take_time) {
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.author = author;
        this.createTime = createTime;
        this.date = date;
        this.gps_processing_method = gps_processing_method;
        this.height = height;
        this.latitude = latitude;
        this.longitude = longitude;
        this.width = width;
        this.name = name;
        this.model = model;
        this.orientation = orientation;
        this.save_time = save_time;
        this.take_time = take_time;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public void setFocal_length(String focal_length) {
        this.focal_length = focal_length;
    }
    public void setLens_make(String lens_make) {
        this.lens_make = lens_make;
    }

    public void setLens_model(String lens_model) {
        this.lens_model = lens_model;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public void setX_resolution(String x_resolution) {
        this.x_resolution = x_resolution;
    }

    public void setY_resolution(String y_resolution) {
        this.y_resolution = y_resolution;
    }

    public void setGps_altitude(String gps_altitude) {
        this.gps_altitude = gps_altitude;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

