package com.itaem.datacapture.bean;// 2023/8/13

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.io.Serializable;

// 作者:ITAEM 陈金城
@SmartTable(name="短信")
public  class SmsBean implements Serializable {
    /**
     * content : string
     * other_phone : string
     * package_name : string
     * read : 0
     * seen : 0
     * status : 0
     * subject : string
     * time : string
     * type : string
     */
    @SmartColumn(id =1,name = "content_短信消息体")
    private String content; // 短信消息体
    @SmartColumn(id =2,name = "other_phone_收件⼈/发件⼈⼿机号")
    private String other_phone; // 收件⼈/发件⼈⼿机号
    @SmartColumn(id =3,name = "package_name_包名")
    private String package_name; // 包名
    @SmartColumn(id =4,name = "read_短信状态 0-未读，1-已读")
    private int read; // 短信状态 0-未读，1-已读
    @SmartColumn(id =5,name = "seen_短信是否被用户看到 0-尚未查看，1-已查看")
    private int seen; // 短信是否被用户看到 0-尚未查看，1-已查看
    @SmartColumn(id =6,name = "status_短信状态：-1表示接收，0-complete，64-pending，128-failed")
    private int status; // 短信状态：-1表示接收，0-complete，64-pending，128-failed
    @SmartColumn(id =7,name = "subject_短信主题")
    private String subject; // 短信主题
    @SmartColumn(id =8,name = "time_收到短信的时间戳（毫秒），long型")
    private String time; // 收到短信的时间戳（毫秒），long型
    @SmartColumn(id =9,name = "type_短信类型：1-接收短信，2-已发出短信")
    private String type; // 短信类型：1-接收短信，2-已发出短信

    public SmsBean(String content, String other_phone, String package_name, int read, int seen, int status, String subject, String time, String type) {
        this.content = content;
        this.other_phone = other_phone;
        this.package_name = package_name;
        this.read = read;
        this.seen = seen;
        this.status = status;
        this.subject = subject;
        this.time = time;
        this.type = type;
    }
}
