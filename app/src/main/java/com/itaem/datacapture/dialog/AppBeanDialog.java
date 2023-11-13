package com.itaem.datacapture.dialog;// 2023/11/4

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.itaem.datacapture.R;
import com.itaem.datacapture.bean.AppListBean;
import com.itaem.datacapture.databinding.DialogAppbeanBinding;
import com.itaem.datacapture.utils.MarketUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

// 作者:ITAEM 陈金城
public class AppBeanDialog extends Dialog {
    private boolean isMiss = true;
    private String AppInTime;
    private String AppUpTime;
    private String showInTime;
    private String showUpTime;
    DialogAppbeanBinding binding;
    public AppBeanDialog(@NonNull Context context,AppListBean bean) {
        super(context, R.style.DialogBaseStyle);
        binding = DialogAppbeanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView(bean);
    }

    private void initClick(AppListBean appListBean) {
        binding.dialogToDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", appListBean.getPackage_name(), null);
                intent.setData(uri);
                getContext().startActivity(intent);
            }
        });
        binding.dialogToPlayShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarketUtils.getTools().startMarket(getContext(),appListBean.getPackage_name());
            }
        });
        binding.dialogIvTimeStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMiss){
                    binding.dialogTvTimeStyle.setText("时间类型为:年月日");
                    AppInTime = "APP安装时间（in_time）:" + SimpleDateFormat.getInstance()
                            .format(new Date(Long.parseLong(appListBean.getIn_time())));
                    AppUpTime = "APP更新时间（up_time）:" + SimpleDateFormat.getInstance()
                            .format(new Date(Long.parseLong(appListBean.getUp_time())));
                    StartThread(AppInTime,0);
                    StartThread(AppUpTime,1);
//                    binding.dialogAppInTime.setText(new StringBuilder("APP安装时间（in_time）:").append(SimpleDateFormat.getInstance()
//                            .format(new Date(Long.parseLong(appListBean.getIn_time())))));
//                    binding.dialogAppUptime.setText(new StringBuilder("更新时间（up_time）:").append(SimpleDateFormat.getInstance()
//                            .format(new Date(Long.parseLong(appListBean.getUp_time())))));
                }else {
                    binding.dialogTvTimeStyle.setText("时间类型为:毫秒");
                    AppUpTime = "APP安装时间（in_time）:" + appListBean.getIn_time();
                    AppUpTime = "APP更新时间（up_time）:" + appListBean.getUp_time();
                    StartThread(AppInTime,0);
                    StartThread(AppUpTime,1);
//                    binding.dialogAppInTime.setText(new StringBuilder("APP安装时间（in_time）:").append(appListBean.getIn_time()));
//                    binding.dialogAppUptime.setText(new StringBuilder("更新时间（up_time）:").append(appListBean.getUp_time()));
                }
                isMiss = !isMiss;
            }
        });
    }

    private void initView(AppListBean appListBean) {
        binding.dialogName.setText(new StringBuilder("APP名称（app_name）:").append(appListBean.getApp_name()));
        binding.dialogAppType.setText(new StringBuilder("是否系统app（app_type）:").append(appListBean.getApp_type().equals("1")?"是":"否"));
        binding.dialogAppVersion.setText(new StringBuilder("APP版本（app_version）:").append(appListBean.getApp_version()));
        binding.dialogAppInTime.setText(new StringBuilder("APP安装时间（in_time）:").append(appListBean.getIn_time()));
        binding.dialogAppUptime.setText(new StringBuilder("更新时间（up_time）:").append(appListBean.getUp_time()));
        binding.dialogAppPackageName.setText(new StringBuilder("包名（package_name）:").append(appListBean.getPackage_name()));
        binding.dialogAppVersionCode.setText(new StringBuilder("版本号（version_code）:").append(appListBean.getVersion_code()));
        Glide.with(getContext()).load(appListBean.getApp_icon())
                .placeholder(R.drawable.placeholder_load)
                .error(R.drawable.glide_error)
                .into(binding.dialogIcon);
        initClick(appListBean);

    }
    private void StartThread(String string,int type){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<string.length(); i++){
                    try {
                        Thread.sleep(90);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Message message = new Message();
                    message.what = type;
                    message.obj = string.substring(0, i+1);;
                    handler.sendMessage(message);
                }
            }
        }).start();
    }
    private Handler handler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0:
                    binding.dialogAppInTime.setText((String)msg.obj);
                    break;
                case 1:
                    binding.dialogAppUptime.setText((String)msg.obj);
                    break;

            }
        }
    };

}
