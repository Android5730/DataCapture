package com.itaem.datacapture.utils;// 2023/11/13


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 /* @anthor:njb
 /* @date: 2020-04-29 00:15
 /* @desc:
 **/
public class MarketUtils {
    private static MarketUtils tools;
    private static final String schemaUrl = "market://details?id=";
    public static MarketUtils getTools() {
        if (null == tools) {
            tools = new MarketUtils();
        }
        return tools;
    }
        /***
         /* 不指定包名
         /* @param mContext
         */
    public void startMarket(Context mContext) {
        String packageName = mContext.getPackageName();//得到包名
        startMarket(mContext, packageName);
    }
        /**
         /* 指定包名
         /*
         /* @param mContext
         /* @param packageName
         */
    public boolean startMarket(Context mContext, String packageName) {
        try {
            String deviceBrand = getDeviceBrand();//获得手机厂商
//根据厂商获取对应市场的包名
            String brandName = deviceBrand.toUpperCase();//大写
            if (TextUtils.isEmpty(brandName)) {
                Log.e("MarketUtils", "没有读取到手机厂商~~");
                return false;
            }
            String marketPackageName = getBrandName(brandName);
            if (null == marketPackageName || "".equals(marketPackageName)) {
//手机不再列表里面,去尝试寻找
//检测百度和应用宝是否在手机上安装,如果安装，则跳转到这两个市场的其中一个
                boolean isExit1 = isCheckBaiduOrYYB(mContext, PACKAGE_NAME.BAIDU_PACKAGE_NAME);
                if (isExit1) {
                    startMarket(mContext, packageName, PACKAGE_NAME.BAIDU_PACKAGE_NAME);
                    return true;
                }
                boolean isExit2 = isCheckBaiduOrYYB(mContext, PACKAGE_NAME.TENCENT_PACKAGE_NAME);
                if (isExit2) {
                    startMarket(mContext, packageName, PACKAGE_NAME.TENCENT_PACKAGE_NAME);
                    return true;
                }
            }
            startMarket(mContext, packageName, marketPackageName);
            return true;
        } catch (ActivityNotFoundException anf) {
            Log.e("MarketUtils", "要跳转的应用市场不存在!");
        } catch (Exception e) {
            Log.e("MarketUtils", "其他错误：" + e.getMessage());
        }
        return false;
    }
        /***
         /* 指定包名，指定市场
         /* @param mContext
         /* @param packageName
         /* @param marketPackageName
         */
    public void startMarket(Context mContext, String packageName, String marketPackageName) {
        try {
            openMarket(mContext, packageName, marketPackageName);
        } catch (ActivityNotFoundException anf) {
            Log.e("MarketUtils", "要跳转的应用市场不存在!");
        } catch (Exception e) {
            Log.e("MarketUtils", "其他错误：" + e.getMessage());
        }
    }
        /***
         /* 打开应用市场
         /* @param mContext
         /* @param packageName
         /* @param marketPackageName
         */
    private void openMarket(Context mContext, String packageName, String marketPackageName) {
        try {
            Uri uri = Uri.parse(schemaUrl + packageName);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage(marketPackageName);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        } catch (ActivityNotFoundException anf) {
            Log.e("MarketUtils", "要跳转的应用市场不存在!");
        } catch (Exception e) {
            Log.e("MarketUtils", "其他错误：" + e.getMessage());
        }
    }
        /***
         /* 检测是否是应用宝或者是百度市场
         /* @param mContext
         /* @param packageName
         /* @return
         */
    private boolean isCheckBaiduOrYYB(Context mContext, String packageName) {
        boolean installed = isInstalled(packageName, mContext);
        return installed;
    }
        /****
         /* 检查APP是否安装成功
         /* @param packageName
         /* @param context
         /* @return
         */
    private boolean isInstalled(@NonNull String packageName, Context context) {
        if ("".equals(packageName) || packageName.length() <= 0) {
            return false;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }
    private String getBrandName(String brandName) {
        if (BRAND.HUAWEI_BRAND.equals(brandName)) {
//华为
            return PACKAGE_NAME.HUAWEI_PACKAGE_NAME;
        } else if (BRAND.OPPO_BRAND.equals(brandName)) {
//oppo
            return PACKAGE_NAME.OPPO_PACKAGE_NAME;
        } else if (BRAND.VIVO_BRAND.equals(brandName)) {
//vivo
            return PACKAGE_NAME.VIVO_PACKAGE_NAME;
        } else if (BRAND.XIAOMI_BRAND.equals(brandName)) {
//小米
            return PACKAGE_NAME.XIAOMI_PACKAGE_NAME;
        } else if (BRAND.LENOVO_BRAND.equals(brandName)) {
//联想
            return PACKAGE_NAME.LIANXIANG_PACKAGE_NAME;
        } else if (BRAND.QH360_BRAND.equals(brandName)) {
//360
            return PACKAGE_NAME.QH360_PACKAGE_NAME;
        } else if (BRAND.MEIZU_BRAND.equals(brandName)) {
//魅族
            return PACKAGE_NAME.MEIZU_PACKAGE_NAME;
        } else if (BRAND.HONOR_BRAND.equals(brandName)) {
//华为
            return PACKAGE_NAME.HUAWEI_PACKAGE_NAME;
        } else if (BRAND.XIAOLAJIAO_BRAND.equals(brandName)) {
//小辣椒
            return PACKAGE_NAME.ZHUOYI_PACKAGE_NAME;
        } else if (BRAND.ZTE_BRAND.equals(brandName)) {
//zte
            return PACKAGE_NAME.ZTE_PACKAGE_NAME;
        } else if (BRAND.NIUBIA_BRAND.equals(brandName)) {
//努比亚
            return PACKAGE_NAME.NIUBIA_PACKAGE_NAME;
        } else if (BRAND.ONE_PLUS_BRAND.equals(brandName)) {
//OnePlus
            return PACKAGE_NAME.OPPO_PACKAGE_NAME;
        } else if (BRAND.MEITU_BRAND.equals(brandName)) {
//美图
            return PACKAGE_NAME.MEITU_PACKAGE_NAME;
        } else if (BRAND.SONY_BRAND.equals(brandName)) {
//索尼
            return PACKAGE_NAME.GOOGLE_PACKAGE_NAME;
        } else if (BRAND.GOOGLE_BRAND.equals(brandName)) {
//google
            return PACKAGE_NAME.GOOGLE_PACKAGE_NAME;
        }
        return "";
    }
        /**
         /* 获取手机厂商
         */
    private String getDeviceBrand() {
        return android.os.Build.BRAND;
    }
    public static class BRAND {
        public static final String HUAWEI_BRAND = "HUAWEI";//HUAWEI_PACKAGE_NAME
        public static final String HONOR_BRAND = "HONOR";//HUAWEI_PACKAGE_NAME
        public static final String OPPO_BRAND = "OPPO";//OPPO_PACKAGE_NAME
        public static final String MEIZU_BRAND = "MEIZU";//MEIZU_PACKAGE_NAME
        public static final String VIVO_BRAND = "VIVO";//VIVO_PACKAGE_NAME
        public static final String XIAOMI_BRAND = "XIAOMI";//XIAOMI_PACKAGE_NAME
        public static final String LENOVO_BRAND = "LENOVO";//LIANXIANG_PACKAGE_NAME //Lenovo
        public static final String ZTE_BRAND = "ZTE";//ZTE_PACKAGE_NAME
        public static final String XIAOLAJIAO_BRAND = "XIAOLAJIAO";//ZHUOYI_PACKAGE_NAME
        public static final String QH360_BRAND = "360";//QH360_PACKAGE_NAME
        public static final String NIUBIA_BRAND = "NUBIA";//NIUBIA_PACKAGE_NAME
        public static final String ONE_PLUS_BRAND = "ONEPLUS";//OPPO_PACKAGE_NAME
        public static final String MEITU_BRAND = "MEITU";//MEITU_PACKAGE_NAME
        public static final String SONY_BRAND = "SONY";//GOOGLE_PACKAGE_NAME
        public static final String GOOGLE_BRAND = "GOOGLE";//GOOGLE_PACKAGE_NAME
        public static final String HTC_BRAND = "HTC";//未知应用商店包名
        public static final String ZUK_BRAND = "ZUK";//未知应用商店包名
    }
        /** Redmi*/
        /**
         /* 华为，oppo,vivo,小米，360，联想，魅族，安智，百度，阿里，应用宝，goog，豌豆荚，pp助手
         **/
    public static class PACKAGE_NAME {
        public static final String OPPO_PACKAGE_NAME = "com.oppo.market";//oppo
        public static final String VIVO_PACKAGE_NAME = "com.bbk.appstore";//vivo
        public static final String HUAWEI_PACKAGE_NAME = "com.huawei.appmarket";//华为
        public static final String QH360_PACKAGE_NAME = "com.qihoo.appstore";//360
        public static final String XIAOMI_PACKAGE_NAME = "com.xiaomi.market";//小米
        public static final String MEIZU_PACKAGE_NAME = "com.meizu.mstore";//，魅族
        public static final String LIANXIANG_PACKAGE_NAME = "com.lenovo.leos.appstore";//联想
        public static final String ZTE_PACKAGE_NAME = "zte.com.market";//zte
        public static final String ZHUOYI_PACKAGE_NAME = "com.zhuoyi.market";//卓易
        public static final String GOOGLE_PACKAGE_NAME = "com.android.vending";//google
        public static final String NIUBIA_PACKAGE_NAME = "com.nubia.neostore";//努比亚
        public static final String MEITU_PACKAGE_NAME = "com.android.mobile.appstore";//美图
        public static final String BAIDU_PACKAGE_NAME = "com.baidu.appsearch";//baidu
        public static final String TENCENT_PACKAGE_NAME = "com.tencent.android.qqdownloader";//应用宝
        public static final String PPZHUSHOU_PACKAGE_NAME = "com.pp.assistant";//pp助手
        public static final String ANZHI_PACKAGE_NAME = "com.goapk.market";//安智市场
        public static final String WANDOUJIA_PACKAGE_NAME = "com.wandoujia.phonenix2";//豌豆荚
        // public static final String SUONI_PACKAGE_NAME = "com.android.vending";//索尼
    }
        /**
         /* 启动到应用商店app详情界面
         /* @param appPkg 目标App的包名
         /* @param marketPkg 应用商店包名 ,如果为"" 则由系统弹出应用商店
         /* 列表供用户选择,否则调转到目标市场的应用详情界面，某些应用商店可能会失败
         */
    public static void launchAppDetail(Context context, String appPkg, String marketPkg) {
        try {
            if (TextUtils.isEmpty(appPkg)) return;
            Uri uri = Uri.parse("market://details?id=" + appPkg);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(marketPkg)) {
                intent.setPackage(marketPkg);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
