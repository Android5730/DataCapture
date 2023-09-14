package com.itaem.datacapture;// 2023/9/1

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 作者:ITAEM 陈金城
public class BeanAdapter extends RecyclerView.Adapter<BeanAdapter.ViewHolder> {
    private final String[] hardwareArrays = new String[12];
    private final String[] NetworkArrays = new String[4];
    private final String[] NetworkCurrentWifiBeanArrays = new String[4];
    private final String[] BatteryStatusArrays = new String[7];
    private final String[] AddressInfoArrays = new String[8];
    private final String[] OtherDataBeanArrays = new String[4];
    private final String type;
    private List<String> list;

    public BeanAdapter(String type) {
        this.type = type;
        initArray(type);
    }

    public void setData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private void initArray(String type) {
        switch (type) {
            case "hardwareBean":
                hardwareArrays[0] = "主板(board):";
                hardwareArrays[1] = "设备品牌(brand):";
                hardwareArrays[2] = "设备内核(cores):";
                hardwareArrays[3] = "分辨率高(device_height):";
                hardwareArrays[4] = "设备名称(device_name):";
                hardwareArrays[5] = "分辨率宽(device_width):";
                hardwareArrays[6] = "设备型号(model):";
                hardwareArrays[7] = "物理尺寸(physical_size):";
                hardwareArrays[8] = "手机出厂时间戳(production_date):";
                hardwareArrays[9] = "系统版本(release):";
                hardwareArrays[10] = "SDK版本(sdk_version):";
                hardwareArrays[11] = "设备序列号(serial_number):";
                break;
            case "NetworkBean":
                NetworkArrays[0] = "当前WIFI(current_wifi):该属性为对象，点击查看详情";
                NetworkArrays[1] = "网络IP（内网）(ip):";
                NetworkArrays[2] = "wifi个数(wifi_count):";
                NetworkArrays[3] = "配置WIFI,附近的wifi(configured_wifi):该属性为集合属性，点击查看表格";
                break;
            case "BatteryStatusBean":
                BatteryStatusArrays[0] = "电池电量(battery_level):";
                BatteryStatusArrays[1] = "电池容量(battery_max):";
                BatteryStatusArrays[2] = "电池百分比(battery_pct):";
                BatteryStatusArrays[3] = "电池状态 充电0 不充电1(battery_state):";
                BatteryStatusArrays[4] = "是否交流充电(1:yes,0:no)(is_ac_charge):";
                BatteryStatusArrays[5] = "是否正在充电(is_charging):";
                BatteryStatusArrays[6] = "是否USB充电(1:yes,0:no)(is_usb_charge):";
                break;
            case "CurrentWifiBean":
                NetworkCurrentWifiBeanArrays[0] = "bssid(bssid):";
                NetworkCurrentWifiBeanArrays[1] = "mac(mac):";
                NetworkCurrentWifiBeanArrays[2] = "名称(name):";
                NetworkCurrentWifiBeanArrays[3] = "ssid(ssid):";
                break;
            case "AddressInfo":
                AddressInfoArrays[0] = "经度(gps_longitude):";
                AddressInfoArrays[1] = "维度(gps_latitude):";
                AddressInfoArrays[2] = "街道(gps_address_street):";
                AddressInfoArrays[3] = "省份(gps_address_province):";
                AddressInfoArrays[4] = "城市(gps_address_city):";
                AddressInfoArrays[5] = "国家(gps_address_country):";
                AddressInfoArrays[6] = "国家代码(gps_address_countryCode):";
                AddressInfoArrays[7] = "总体:";
                break;
            case "OtherDataBean":
                OtherDataBeanArrays[0] = "手机的信号强度,默认-1(dbm):";
                OtherDataBeanArrays[1] = "最后一次启动时间(last_boot_time):";
                OtherDataBeanArrays[2] = "是否root,true:1,false:0(root_jailbreak):";
                OtherDataBeanArrays[3] = "是否为模拟器,true:1,false:0(simulator):";
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView item_dec;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_dec = itemView.findViewById(R.id.item_dec);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClick!=null){
                        onItemClick.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public BeanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bean, parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull BeanAdapter.ViewHolder holder, int position) {
        switch (type) {
            case "hardwareBean":
                holder.item_dec.setText(hardwareArrays[position] + list.get(position));
                break;
            case "NetworkBean":
                holder.item_dec.setText(NetworkArrays[position] + list.get(position));
                break;
            case "BatteryStatusBean":
                holder.item_dec.setText(BatteryStatusArrays[position] + list.get(position));
                break;
            case "CurrentWifiBean":
                holder.item_dec.setText(NetworkCurrentWifiBeanArrays[position] + list.get(position));
                break;
            case "AddressInfo":
                holder.item_dec.setText(AddressInfoArrays[position] + list.get(position));
                break;
            case "OtherDataBean":
                holder.item_dec.setText(OtherDataBeanArrays[position] + list.get(position));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface onItemClick{
        void onItemClick(int position);
    }

    private onItemClick onItemClick;

    public void setOnItemClick(BeanAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
