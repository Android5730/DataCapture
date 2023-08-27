//package com.itaem.datacapture.Utils;// 2023/4/24
//
//
//
//import android.os.Debug;
//import android.os.Environment;
//
//import com.itaem.datacapture.bean.DeviceInfoBean;
//
//import java.io.File;
//
//
//// 获取存储bean类
//public class SDCardUtils {
//    private static DeviceInfoBean.NewStorageBean newStorageBean = new DeviceInfoBean.NewStorageBean();
//
//    public static DeviceInfoBean.NewStorageBean getNewStorageBean(){
//        StorageData storageData = StorageQueryUtil.queryWithStorageManager(new StorageData());
//  //      newStorageBean.setActiveMemory(String.valueOf(storageData.ram_total_size));
//  //      newStorageBean.setInActiveMemory(String.valueOf(storageData.ram_total_size-storageData.ram_usable_size));
// //       newStorageBean.setTotalMemory(String.valueOf(storageData.internal_storage_total+storageData.memory_card_size));// 总内存
// //       newStorageBean.setUsedMemory(String.valueOf(storageData.memory_card_size_use+storageData.internal_storage_total-storageData.internal_storage_usable));
// //       newStorageBean.setFreeMemory(String.valueOf(storageData.internal_storage_usable+storageData.memory_card_size-storageData.memory_card_size_use));// 可用
// //       newStorageBean.setPurgableMemory(String.valueOf(storageData.memory_card_size_use));
// //       newStorageBean.setWiredMemory(String.valueOf(getReservedMemory()));
//        newStorageBean.setApp_max_memory(String.valueOf(Runtime.getRuntime().maxMemory()));
//        newStorageBean.setApp_total_memory(String.valueOf(Runtime.getRuntime().totalMemory()));
//        newStorageBean.setApp_free_memory(String.valueOf(Runtime.getRuntime().freeMemory()));
//        newStorageBean.setContain_sd(isSDInner()?"1":"0");// 是否内置内存卡
//        newStorageBean.setExtra_sd(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)?"0":"1");// 是否外置内存卡
//        newStorageBean.setInternal_storage_total(String.valueOf(storageData.internal_storage_total)); // 总存储大小 单位Byte）
//        newStorageBean.setInternal_storage_usable(String.valueOf(storageData.internal_storage_usable));// 可用存储大小
//        newStorageBean.setMemory_card_size(String.valueOf(storageData.memory_card_size));
//        newStorageBean.setMemory_card_size_use(String.valueOf(storageData.memory_card_size_use));
//        newStorageBean.setMemory_card_free_size(String.valueOf(storageData.memory_card_size-storageData.memory_card_size_use));
//        newStorageBean.setMemory_card_usable_size(String.valueOf(storageData.memory_card_size-storageData.memory_card_size_use));
//        newStorageBean.setRam_total_size(String.valueOf(storageData.ram_total_size));
//        newStorageBean.setRam_usable_size(String.valueOf(storageData.ram_usable_size));
//        return newStorageBean;
//    }
//
//    /**
//     * 获取保留内存
//     */
//    public static long getReservedMemory() {
//        Runtime runtime = Runtime.getRuntime();
//        return runtime.totalMemory() - runtime.freeMemory() + Debug.getNativeHeapAllocatedSize();
//    }
//
//    /**
//     * 判断SD是否挂载
//     */
//    public static boolean isSDCardMount() {
//        return Environment.getExternalStorageState().equals(
//                Environment.MEDIA_MOUNTED);
//    }
//
//    /**
//     * 设备是否有内置sd卡
//     * @return
//     */
//    public static boolean isSDInner(){
//        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//            File internalStorage = Environment.getExternalStorageDirectory();
//            // 检查内置存储是否可用
//            if (internalStorage != null && internalStorage.exists()) {
//                // 设备有内置SD卡
//                return true;
//            }
//        } else {
//            // 设备没有内置SD卡
//            return false;
//        }
//        return false;
//    }
//}