package com.itaem.datacapture.bean;// 2023/8/27

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.io.Serializable;

// 作者:ITAEM 陈金城
@SmartTable(name="传感器信息")
public  class SensorListBean implements Serializable {
    /**
     * maxRange : string //传感器单元中传感器的最大量程
     * minDelay : string //
     * name : string
     * power : string
     * resolution : string
     * type : string
     * vendor : string
     * version : string
     */
    @SmartColumn(id =1,name = "id_传感器id,0不支持功能，-1即其类型和名称的组合在系统中唯一标识。-2获取活到")
    private String id;
    @SmartColumn(id =2,name = "maxRange_最大量程")
    private String maxRange;
    @SmartColumn(id =3,name = "minDelay_最小延迟")
    private String minDelay;
    @SmartColumn(id =4,name = "name_传感器名称")
    private String name;
    @SmartColumn(id =5,name = "power_使用时功率")
    private String power;
    @SmartColumn(id =6,name = "resolution_分辨率")
    private String resolution;
    @SmartColumn(id =7,name = "type_通用类型")
    private String type;
    @SmartColumn(id =8,name = "vendor_厂商字符串")
    private String vendor;
    @SmartColumn(id =9,name = "version_版本")
    private String version;
    @SmartColumn(id =10,name = "RequiredPermission_访问所需权限")
    private String RequiredPermission;

    public SensorListBean(String id,String maxRange, String minDelay, String name, String power, String resolution, String type, String vendor, String version) {
        this.id = id;
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
