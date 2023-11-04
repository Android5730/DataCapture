package com.itaem.datacapture.listShow;// 2023/11/2

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itaem.datacapture.R;
import com.itaem.datacapture.bean.AddressBookBean;
import com.itaem.datacapture.bean.AppListBean;

import java.util.ArrayList;
import java.util.List;

// 作者:ITAEM 陈金城
public class DataListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String dataType;
    private List<Object> list = new ArrayList<>();
    private final static String TYPE_APPLIST = "AppList";
    private final static String TYPE_addressBook = "addressBook";
    private final static String TYPE_CalendarList = "CalendarList";
    private final static String TYPE_BatteryStatusBean = "BatteryStatusBean";
    private final static String TYPE_NetworkBean = "NetworkBean";
    private final static String TYPE_SMSBean = "SMSBean";
    private final static String TYPE_PhotoBean = "PhotoBean";
    private final static String TYPE_SensorBean = "SensorBean";

    // 通讯录的viewHolder
    public class AddressBookViewHolder extends RecyclerView.ViewHolder {
        TextView item_address_name;
        TextView item_address_number;
        ImageView item_iv_dial;
        public AddressBookViewHolder(@NonNull View itemView) {
            super(itemView);
            item_address_name = itemView.findViewById(R.id.item_address_name);
            item_address_number = itemView.findViewById(R.id.item_address_number);
            item_iv_dial = itemView.findViewById(R.id.item_iv_dial);
            initClick();
        }

        private void initClick() {
            item_iv_dial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 夜神模拟器没有该功能
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    Uri data = Uri.parse("tel:" + item_address_number.getText().toString());
                    intent.setData(data);
                    itemView.getContext().startActivity(intent);
                }
            });

        }

        private void setViewHolderData(AddressBookBean addressBookBean){
            item_address_name.setText("联系人:"+addressBookBean.getContact_display_name());
            item_address_number.setText("联系电话:"+addressBookBean.getNumber());
        }
    }
    public class AppListViewHolder extends RecyclerView.ViewHolder {
        ImageView item_app_icon;
        TextView item_app_name;
        TextView item_app_pageName;
        TextView item_app_versionCode;
        public AppListViewHolder(@NonNull View itemView) {
            super(itemView);
            item_app_icon = itemView.findViewById(R.id.item_app_icon);
            item_app_name = itemView.findViewById(R.id.item_app_name);
            item_app_pageName = itemView.findViewById(R.id.item_app_pageName);
            item_app_versionCode = itemView.findViewById(R.id.item_app_versionCode);
        }
        private void setViewHolderData(AppListBean appListBean){
            item_app_name.setText(appListBean.getApp_name());
            item_app_pageName.setText("包名:"+appListBean.getPackage_name());
            item_app_versionCode.setText("版本号:"+appListBean.getVersion_code());
            Glide.with(itemView.getContext()).load(appListBean.getApp_icon())
                    .placeholder(R.drawable.placeholder_load)
                    .error(R.drawable.glide_error)
                    .into(item_app_icon);
        }
    }

    public void setList(List<Object> list, String dataType){
        this.list = list;
        this.dataType = dataType;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (dataType){
            case TYPE_APPLIST:
                holder =  new AppListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_app, parent, false));
                break;
            case TYPE_addressBook:
                holder =  new AddressBookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_addressbook, parent, false));
                break;
        }
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (dataType){
            case TYPE_APPLIST:
                AppListBean appListBean = (AppListBean) list.get(position);
                if (holder instanceof AppListViewHolder) {
                    ((AppListViewHolder) holder).setViewHolderData(appListBean);
                }
                break;
            case TYPE_addressBook:
                AddressBookBean addressBookBean = (AddressBookBean) list.get(position);
                if (holder instanceof AddressBookViewHolder) {
                    ((AddressBookViewHolder) holder).setViewHolderData(addressBookBean);
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
