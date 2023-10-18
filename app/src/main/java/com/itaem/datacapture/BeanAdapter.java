package com.itaem.datacapture;// 2023/9/1

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skydoves.colorpickerview.ColorEnvelope;

import java.util.List;

// 作者:ITAEM 陈金城
public class BeanAdapter extends RecyclerView.Adapter<BeanAdapter.ViewHolder> {
    private final String[] hardwareArrays = new String[12];
    private final String[] NetworkArrays = new String[4];
    private final String[] NetworkCurrentWifiBeanArrays = new String[4];
    private final String[] BatteryStatusArrays = new String[7];
    private final String[] AddressInfoArrays = new String[8];
    private final String[] OtherDataBeanArrays = new String[4];
    private final String[] NewStorageBeanArrays = new String[14];
    private final String[] GeneralDataBeanArrays = new String[22];
    private final String type;
    private ForegroundColorSpan span;
    private List<String> list;
    private int viewType;
    public BeanAdapter(String type) {
        this.type = type;
        initArray(type);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void setData(List<String> list) {
        this.list = list;
        span = new ForegroundColorSpan(Color.parseColor("#000000"));
        notifyDataSetChanged();
    }
    public void setColor(ColorEnvelope colorEnvelope){
        span = new ForegroundColorSpan(colorEnvelope.getColor());
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
            case "NewStorageBean":
                NewStorageBeanArrays[0] = "app最大内存大小 app_max_memory）:";
                NewStorageBeanArrays[1] = "app总内存大小 app_total_memory）:";
                NewStorageBeanArrays[2] = "app可用内存大小 app_free_memory）:";
                NewStorageBeanArrays[3] = "是否有内置的SD卡（0否，1是）contain_sd:";
                NewStorageBeanArrays[4] = "是否有外置的SD卡（0否，1是）extra_sd:";
                NewStorageBeanArrays[5] = "总存储大小 internal_storage_total）:";
                NewStorageBeanArrays[6] = "可用存储大小 internal_storage_usable）:";
                NewStorageBeanArrays[7] = "内存卡大小 memory_card_size）:";
                NewStorageBeanArrays[8] = "内存卡已使用量 memory_card_size_use）:";
                NewStorageBeanArrays[9] = "内存卡可使用量 memory_card_usable_size）:";
                NewStorageBeanArrays[10] = "内存卡剩余使用量 memory_card_free_size）:";
                NewStorageBeanArrays[11] = "总内存大小（ram_total_size）:";
                NewStorageBeanArrays[12] = "内存可用大小 ram_usable_size）:";
                NewStorageBeanArrays[13] = "低内存阙值 ram_threshold):";
                break;
            case "GeneralDataBean":
                GeneralDataBeanArrays[0] = "android_id:";
                GeneralDataBeanArrays[1] = "设备当前时间 currentSystemTime:";
                GeneralDataBeanArrays[2] = "开机时间到现在的毫秒数（包括睡眠时间） elapsedRealtime:";
                GeneralDataBeanArrays[3] = "google advertising id(google 广告 id)  gaid:";
                GeneralDataBeanArrays[4] = "设备号  imei:";
                GeneralDataBeanArrays[5] = "是否开启debug调试  is_usb_debug:";
                GeneralDataBeanArrays[6] = "是否使用代理  is_using_proxy_port:";
                GeneralDataBeanArrays[7] = "是否使用vpn  is_using_vpn:";
                GeneralDataBeanArrays[8] = "语言  language:";
                GeneralDataBeanArrays[9] = "此用户显示的语言环境语言的名称  locale_display_language:";
                GeneralDataBeanArrays[10] = "此地区的国家/地区的缩写  locale_iso_3_country:";
                GeneralDataBeanArrays[11] = "适合显示给用户的区域设置国家的名称  locale_country:";
                GeneralDataBeanArrays[12] = "语言环境的三字母缩写  locale_iso_3_language:";
                GeneralDataBeanArrays[13] = "mac地址   mac:";
                GeneralDataBeanArrays[14] = "网络运营商名称   network_operator_name:";
                GeneralDataBeanArrays[15] = "网络类型 2G、3G、4G、5G、wifi、other、none   network_type:";
                GeneralDataBeanArrays[16] = "手机号  phone_number:";
                GeneralDataBeanArrays[17] = "指示设备电话类型的常量。 这表示用于传输语音呼叫的无线电的类型  phone_type:";
                GeneralDataBeanArrays[18] = "时区的ID  time_zone_id:";
                GeneralDataBeanArrays[19] = "从开机到现在的毫秒数（不包括睡眠时间）  uptimeMillis:";
                GeneralDataBeanArrays[20] = "当前线程中运行的毫秒数，在主线程可以说是当前应用程序运行时间  threadTimeMillis:";
                GeneralDataBeanArrays[21] = "唯一标识  uuid:";
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
                SpannableString spannableStringHard = new SpannableString(hardwareArrays[position] + list.get(position));
                spannableStringHard.setSpan(span,hardwareArrays[position].length(),spannableStringHard.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.item_dec.setText(spannableStringHard);
                break;
            case "NetworkBean":
                SpannableString spannableStringNet = new SpannableString(NetworkArrays[position] + list.get(position));
                spannableStringNet.setSpan(span,NetworkArrays[position].length(),spannableStringNet.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.item_dec.setText(spannableStringNet);
                break;
            case "BatteryStatusBean":
                SpannableString spannableStringNetBattery = new SpannableString(BatteryStatusArrays[position] + list.get(position));
                spannableStringNetBattery.setSpan(span,BatteryStatusArrays[position].length(),spannableStringNetBattery.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.item_dec.setText(spannableStringNetBattery);
                break;
            case "CurrentWifiBean":
                SpannableString spanCurrentWifi = new SpannableString(NetworkCurrentWifiBeanArrays[position] + list.get(position));
                spanCurrentWifi.setSpan(span,NetworkCurrentWifiBeanArrays[position].length(),spanCurrentWifi.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.item_dec.setText(spanCurrentWifi);
                break;
            case "AddressInfo":
                SpannableString spanAddressInfo = new SpannableString(AddressInfoArrays[position] + list.get(position));
                spanAddressInfo.setSpan(span,AddressInfoArrays[position].length(),spanAddressInfo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.item_dec.setText(spanAddressInfo);
                break;
            case "OtherDataBean":
                SpannableString spanOtherDataBean = new SpannableString(OtherDataBeanArrays[position] + list.get(position));
                spanOtherDataBean.setSpan(span,OtherDataBeanArrays[position].length(),spanOtherDataBean.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.item_dec.setText(spanOtherDataBean);
                break;
            case "NewStorageBean":
                SpannableString spanNewStorageBean = new SpannableString(NewStorageBeanArrays[position] + list.get(position));
                spanNewStorageBean.setSpan(span,NewStorageBeanArrays[position].length(),spanNewStorageBean.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.item_dec.setText(spanNewStorageBean);
                break;
            case "GeneralDataBean":
                SpannableString spanGeneralDataBean = new SpannableString(GeneralDataBeanArrays[position] + list.get(position));
                spanGeneralDataBean.setSpan(span,GeneralDataBeanArrays[position].length(),spanGeneralDataBean.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.item_dec.setText(spanGeneralDataBean);
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
