package com.itaem.datacapture.Utils;// 2023/4/24



import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;


import com.itaem.datacapture.bean.NewStorageBean;

import java.io.File;


// 获取存储bean类
public class SDCardUtils {
    private static NewStorageBean newStorageBean = new NewStorageBean();
    private static StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());

    public static NewStorageBean getNewStorageBean(Context context){
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(info);
  //      newStorageBean.setActiveMemory(String.valueOf(storageData.ram_total_size));
  //      newStorageBean.setInActiveMemory(String.valueOf(storageData.ram_total_size-storageData.ram_usable_size));
 //       newStorageBean.setTotalMemory(String.valueOf(storageData.internal_storage_total+storageData.memory_card_size));// 总内存
 //       newStorageBean.setUsedMemory(String.valueOf(storageData.memory_card_size_use+storageData.internal_storage_total-storageData.internal_storage_usable));
 //       newStorageBean.setFreeMemory(String.valueOf(storageData.internal_storage_usable+storageData.memory_card_size-storageData.memory_card_size_use));// 可用
 //       newStorageBean.setPurgableMemory(String.valueOf(storageData.memory_card_size_use));
 //       newStorageBean.setWiredMemory(String.valueOf(getReservedMemory()));
        newStorageBean.setApp_max_memory(String.valueOf(Runtime.getRuntime().maxMemory()));
        newStorageBean.setApp_total_memory(String.valueOf(Runtime.getRuntime().totalMemory()));
        newStorageBean.setApp_free_memory(String.valueOf(Runtime.getRuntime().freeMemory()));
        newStorageBean.setContain_sd(isSDInner()?"1":"0");// 是否内置内存卡
        newStorageBean.setExtra_sd(isSDCardMount()?"0":"1");// 是否外置内存卡
        newStorageBean.setInternal_storage_total(String.valueOf(getFsTotalsize())); // 总存储大小 单位Byte）
        newStorageBean.setInternal_storage_usable(String.valueOf(getFsAvailableSize()));// 可用存储大小
        newStorageBean.setMemory_card_size(String.valueOf(getSDCardSize()));
        newStorageBean.setMemory_card_size_use(String.valueOf(getFsUseSize()));
        newStorageBean.setMemory_card_free_size(String.valueOf(getFsTotalsize()-getFsUseSize()));
        newStorageBean.setMemory_card_usable_size(String.valueOf(getFsTotalsize()-getFsUseSize()));
        newStorageBean.setRam_total_size(String.valueOf(info.totalMem));
        newStorageBean.setRam_usable_size(String.valueOf(info.availMem));
        newStorageBean.setRam_threshold(String.valueOf(info.threshold));

        return newStorageBean;
    }
    // 获取可用大小
    private static long getFsAvailableSize() {
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }
    // 获取总大小
    private static long getFsTotalsize() {
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }
    private static long getFsUseSize() {
        return statFs.getBlockSizeLong() * (statFs.getBlockCountLong() - statFs.getAvailableBlocksLong());
    }
    public static long getSDCardSize() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            String sdCardPath = Environment.getDataDirectory().getPath();
            StatFs statFs = new StatFs(sdCardPath);
            long blockSize = statFs.getBlockSizeLong();
            long totalBlocks = statFs.getBlockCountLong();
            long totalSize = blockSize * totalBlocks;
            return totalSize;
        } else {
            return 0; // 存储卡未挂载或不可用
        }
    }

    /**
     * 获取保留内存
     */
    public static long getReservedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory() + Debug.getNativeHeapAllocatedSize();
    }

    /**
     * 判断SD是否挂载
     */
    public static boolean isSDCardMount() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 设备是否有内置sd卡
     * @return
     */
    public static boolean isSDInner(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File internalStorage = Environment.getExternalStorageDirectory();
            // 检查内置存储是否可用
            if (internalStorage != null && internalStorage.exists()) {
                // 设备有内置SD卡
                return true;
            }
        } else {
            // 设备没有内置SD卡
            return false;
        }
        return false;
    }
}
