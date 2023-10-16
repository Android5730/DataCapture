package com.itaem.datacapture.bean;// 2023/8/13

import java.io.Serializable;

// 作者:ITAEM 陈金城
public  class NewStorageBean implements Serializable {
    /**
     * activeMemory : 0
     * app_free_memory : string
     * app_max_memory : string
     * app_total_memory : string
     * contain_sd : string
     * extra_sd : string
     * freeMemory : 0
     * inActiveMemory : 0
     * internal_storage_total : 0
     * internal_storage_usable : 0
     * memory_card_free_size : 0
     * memory_card_size : 0
     * memory_card_size_use : 0
     * memory_card_usable_size : 0
     * purgableMemory : 0
     * ram_total_size : string
     * ram_usable_size : string
     * totalMemory : 0
     * usedMemory : 0
     * wiredMemory : 0
     */

    //        private String activeMemory; // 活动内存 单位Byte）
    private String app_free_memory; // app可用内存大小 单位Byte）

    private String app_max_memory; // app最大内存大小 单位Byte）
    private String app_total_memory;// app总内存大小 单位Byte）
    private String contain_sd; // 是否有内置的SD卡（0否，1是）
    private String extra_sd; // 是否有外置的SD卡（0否，1是）
    //         private String freeMemory; //内存空闲大小 单位Byte）
    //         private String inActiveMemory; // 不活动内存 单位Byte）
    private String internal_storage_total; // 总存储大小 单位Byte）
    private String internal_storage_usable; // 可用存储大小 单位Byte）
    private String memory_card_free_size; // 内存卡剩余使用量 单位Byte）
    private String memory_card_size; //  内存卡大小 单位Byte）
    private String memory_card_size_use; // 内存卡已使用量 单位Byte）
    private String memory_card_usable_size; // 内存卡可使用量 单位Byte）
    //        private String purgableMemory; // 可清理内存 单位Byte）
    private String ram_total_size; // 总内存大小（ 单位Byte）
    private String ram_usable_size; // 内存可用大小 单位Byte）
    private String ram_threshold;// 低内存阙值
//                private String totalMemory; // 总内存大小（ 单位Byte）
//                private String usedMemory; // 已用内存 单位Byte）
//                private String wiredMemory; // 保留内存 单位Byte）



    public String getInternal_storage_total() {
        return internal_storage_total;
    }

    public String getInternal_storage_usable() {
        return internal_storage_usable;
    }

    public String getApp_free_memory() {
        return app_free_memory;
    }

    public String getApp_max_memory() {
        return app_max_memory;
    }

    public String getApp_total_memory() {
        return app_total_memory;
    }

    public String getContain_sd() {
        return contain_sd;
    }

    public String getExtra_sd() {
        return extra_sd;
    }

    public String getMemory_card_free_size() {
        return memory_card_free_size;
    }

    public String getMemory_card_size() {
        return memory_card_size;
    }

    public String getMemory_card_size_use() {
        return memory_card_size_use;
    }

    public String getMemory_card_usable_size() {
        return memory_card_usable_size;
    }

    public String getRam_total_size() {
        return ram_total_size;
    }

    public String getRam_usable_size() {
        return ram_usable_size;
    }

    public String getRam_threshold() {
        return ram_threshold;
    }

    public void setApp_free_memory(String app_free_memory) {
        this.app_free_memory = app_free_memory;
    }

    public void setApp_max_memory(String app_max_memory) {
        this.app_max_memory = app_max_memory;
    }

    public void setApp_total_memory(String app_total_memory) {
        this.app_total_memory = app_total_memory;
    }


    public void setInternal_storage_total(String internal_storage_total) {
        this.internal_storage_total = internal_storage_total;
    }

    public void setInternal_storage_usable(String internal_storage_usable) {
        this.internal_storage_usable = internal_storage_usable;
    }

    public void setExtra_sd(String extra_sd) {
        this.extra_sd = extra_sd;
    }

    public void setRam_total_size(String ram_total_size) {
        this.ram_total_size = ram_total_size;
    }

    public void setRam_usable_size(String ram_usable_size) {
        this.ram_usable_size = ram_usable_size;
    }

    public void setContain_sd(String contain_sd) {
        this.contain_sd = contain_sd;
    }

    public void setMemory_card_free_size(String memory_card_free_size) {
        this.memory_card_free_size = memory_card_free_size;
    }

    public void setMemory_card_size(String memory_card_size) {
        this.memory_card_size = memory_card_size;
    }

    public void setMemory_card_size_use(String memory_card_size_use) {
        this.memory_card_size_use = memory_card_size_use;
    }

    public void setMemory_card_usable_size(String memory_card_usable_size) {
        this.memory_card_usable_size = memory_card_usable_size;
    }

    public void setRam_threshold(String ram_threshold) {
        this.ram_threshold = ram_threshold;
    }
}

