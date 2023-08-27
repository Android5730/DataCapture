package com.itaem.datacapture.bean;// 2023/8/13

import java.io.Serializable;

// 作者:ITAEM 陈金城
public  class HardwareBean implements Serializable {
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

