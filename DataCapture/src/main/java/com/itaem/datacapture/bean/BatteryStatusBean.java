package com.itaem.datacapture.bean;// 2023/8/13

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.io.Serializable;

// 作者:ITAEM 陈金城
@SmartTable(name="电量信息")
public  class BatteryStatusBean implements Serializable {
    /**
     * battery_level : string
     * battery_max : string
     * battery_pct : 0
     * battery_state : 0
     * is_ac_charge : 0
     * is_charging : 0
     * is_usb_charge : 0
     */
    @SmartColumn(id =1,name = "battery_level_电池电量")
    private String battery_level; // 电池电量
    @SmartColumn(id =2,name = "battery_max_电池容量")
    private String battery_max; // 电池容量
    @SmartColumn(id =3,name = "battery_pct_电池百分比")
    private int battery_pct; //  电池百分比
    @SmartColumn(id =4,name = "battery_state_电池状态 充电0 不充电1")
    private int battery_state;// 电池状态 充电0 不充电1
    @SmartColumn(id =5,name = "is_ac_charge_是否交流充电(1:yes,0:no)")
    private int is_ac_charge; // 是否交流充电(1:yes,0:no)
    @SmartColumn(id =6,name = "is_charging_是否正在充电")
    private int is_charging; // 是否正在充电
    @SmartColumn(id =6,name = "is_usb_charge_是否USB充电(1:yes,0:no)")
    private int is_usb_charge;// 是否USB充电(1:yes,0:no)

    public BatteryStatusBean(String battery_level, String battery_max, int battery_pct,int battery_state, int is_ac_charge, int is_charging, int is_usb_charge) {
        this.battery_level = battery_level!=null?battery_level:"";
        this.battery_max = battery_max!=null?battery_max:"";
        this.battery_pct = battery_pct;
        this.battery_state = battery_state;
        this.is_ac_charge = is_ac_charge;
        this.is_charging = is_charging;
        this.is_usb_charge = is_usb_charge;
    }

    public String getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(String battery_level) {
        this.battery_level = battery_level;
    }

    public String getBattery_max() {
        return battery_max;
    }

    public void setBattery_max(String battery_max) {
        this.battery_max = battery_max;
    }

    public int getBattery_pct() {
        return battery_pct;
    }

    public void setBattery_pct(int battery_pct) {
        this.battery_pct = battery_pct;
    }

    public int getBattery_state() {
        return battery_state;
    }

    public void setBattery_state(int battery_state) {
        this.battery_state = battery_state;
    }

    public int getIs_ac_charge() {
        return is_ac_charge;
    }

    public void setIs_ac_charge(int is_ac_charge) {
        this.is_ac_charge = is_ac_charge;
    }

    public int getIs_charging() {
        return is_charging;
    }

    public void setIs_charging(int is_charging) {
        this.is_charging = is_charging;
    }

    public int getIs_usb_charge() {
        return is_usb_charge;
    }

    public void setIs_usb_charge(int is_usb_charge) {
        this.is_usb_charge = is_usb_charge;
    }
}

