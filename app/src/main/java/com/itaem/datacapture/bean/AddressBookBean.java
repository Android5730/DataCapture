package com.itaem.datacapture.bean;// 2023/8/13

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.io.Serializable;

// 作者:ITAEM 陈金城
@SmartTable(name="通讯录")
public  class AddressBookBean implements Serializable {
    /**
     * contact_display_name : string
     * last_time_contacted : 0
     * number : string
     * times_contacted : 0
     * up_time : 0
     */
    @SmartColumn(id =1,name = "contact_display_name_联系人名称")
    private String contact_display_name; // 联系人名称
    @SmartColumn(id =2,name = "last_time_contacted_上次通讯时间(毫秒)")
    private String last_time_contacted; // 上次通讯时间(毫秒)
    @SmartColumn(id =3,name = "number_联系人手机号")
    private String number; // 联系人手机号
    @SmartColumn(id =4,name = "times_contacted_联系次数")
    private int times_contacted; // 联系次数
    @SmartColumn(id =5,name = "up_time_编辑时间(毫秒)")
    private String up_time; // 编辑时间(毫秒)
    @SmartColumn(id =6,name = "type_通话类型")
    private String type; // 通话类型

    public AddressBookBean(String contact_display_name, String last_time_contacted, String number, int times_contacted, String up_time,String type) {
        this.contact_display_name = contact_display_name;
        this.last_time_contacted = last_time_contacted;
        this.number = number;
        this.times_contacted = times_contacted;
        this.up_time = up_time;
        this.type = type;
    }
}
