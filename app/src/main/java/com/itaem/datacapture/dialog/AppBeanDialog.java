package com.itaem.datacapture.dialog;// 2023/11/4

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.itaem.datacapture.R;
import com.itaem.datacapture.bean.AppListBean;
import com.itaem.datacapture.databinding.DialogAppbeanBinding;

// 作者:ITAEM 陈金城
public class AppBeanDialog extends Dialog {

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


}
