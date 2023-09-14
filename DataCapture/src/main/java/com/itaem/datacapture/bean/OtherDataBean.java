package com.itaem.datacapture.bean;// 2023/8/13

import java.io.Serializable;

// 作者:ITAEM 陈金城
public  class OtherDataBean implements Serializable {
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
//    private int keyboard; // 连接到设备的键盘种类
    private String last_boot_time; // 最后一次启动时间
    private int root_jailbreak; // 是否 root
    private int simulator; // 是否为模拟器

    public OtherDataBean(String dbm, String last_boot_time, int root_jailbreak, int simulator) {
        this.dbm = dbm;
        //           dbmClass = 0;
//        this.keyboard = keyboard;
        this.last_boot_time = last_boot_time;
        this.root_jailbreak = root_jailbreak;
        this.simulator = simulator;
    }

    public String getDbm() {
        return dbm;
    }

    public String getLast_boot_time() {
        return last_boot_time;
    }

    public int getRoot_jailbreak() {
        return root_jailbreak;
    }

    public int getSimulator() {
        return simulator;
    }
}

