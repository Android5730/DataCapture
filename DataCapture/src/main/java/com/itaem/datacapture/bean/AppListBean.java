package com.itaem.datacapture.bean;// 2023/8/13

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.io.Serializable;

// 作者:ITAEM 陈金城
@SmartTable(name="应用列表")
public  class AppListBean implements Serializable {
    /**
     * app_name : string
     * app_type : string
     * app_version : string
     * in_time : 0
     * obtain_time : 0
     * package_name : string
     * up_time : 0
     * version_code : string
     */
    @SmartColumn(id =1,name = "app_name_APP名称")
    private String app_name; // APP名称
    @SmartColumn(id =2,name = "app_type_是否系统app(0:非，1：是)")
    private String app_type; // 是否系统app 0:非系统app 1：系统app
    @SmartColumn(id =3,name = "app_version_APP版本")
    private String app_version; // APP版本
    @SmartColumn(id =4,name = "in_time_安装时间（毫秒)")
    private String in_time; // 安装时间（毫秒)
    @SmartColumn(id =5,name = "obtain_time_数据抓取时间（秒）")
    private int obtain_time; // 数据抓取时间（秒）
    @SmartColumn(id =6,name = "package_name_包名")
    private String package_name; // 包名
    @SmartColumn(id =7,name = "up_time_更新时间 （毫秒）")
    private String up_time; // 更新时间 （毫秒）
    @SmartColumn(id =8,name = "version_code_版本号")
    private String version_code; // 版本号
    public AppListBean(String app_name, String app_type, String app_version, String in_time, int obtain_time, String package_name, String up_time, String version_code) {
        this.app_name = app_name;
        this.app_type = app_type;
        this.app_version = app_version;
        this.in_time = in_time;
        this.obtain_time = obtain_time;
        this.package_name = package_name;
        this.up_time = up_time;
        this.version_code = version_code;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = app_type;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public int getObtain_time() {
        return obtain_time;
    }

    public void setObtain_time(int obtain_time) {
        this.obtain_time = obtain_time;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getUp_time() {
        return up_time;
    }

    public void setUp_time(String up_time) {
        this.up_time = up_time;
    }

    public String getVersion_code() {
        return version_code;
    }

    public void setVersion_code(String version_code) {
        this.version_code = version_code;
    }

}
