package com.itaem.datacapture.Utils;// 2023/8/13


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.itaem.datacapture.bean.AppListBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 作者:ITAEM 陈金城
public class AppListUtil {
    /**
     * 获取列表
     */
    public static List<AppListBean> getAppListBean(Context context) {
        List<AppListBean> appListBeans = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (ApplicationInfo applicationInfo : installedApplications) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(applicationInfo.packageName, PackageManager.GET_ACTIVITIES);
                // 获取app名称
                String name = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    appListBeans.add(new AppListBean(name,
                            // 判断是否系统应用
                            String.valueOf((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0 ? 1 : 0), packageInfo.versionName,
                            String.valueOf(packageInfo.firstInstallTime),
                            (int) (new Date().getTime() / 1000), packageInfo.packageName,
                            String.valueOf(packageInfo.lastUpdateTime), String.valueOf(packageInfo.getLongVersionCode())));
                }else {
                    appListBeans.add(new AppListBean(name,
                            // 判断是否系统应用
                            String.valueOf((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0 ? 1 : 0), packageInfo.versionName,
                            String.valueOf(packageInfo.firstInstallTime),
                            (int) (new Date().getTime() / 1000), packageInfo.packageName,
                            String.valueOf(packageInfo.lastUpdateTime), String.valueOf(packageInfo.versionCode)));
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return appListBeans;
    }
}