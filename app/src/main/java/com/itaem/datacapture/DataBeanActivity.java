package com.itaem.datacapture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.itaem.datacapture.Utils.BatteryStatusUtil;
import com.itaem.datacapture.Utils.HardwareUtil;
import com.itaem.datacapture.Utils.LocationUtils;
import com.itaem.datacapture.Utils.NetworkBeanUtils;
import com.itaem.datacapture.Utils.OtherDataUtil;
import com.itaem.datacapture.bean.BatteryStatusBean;
import com.itaem.datacapture.bean.HardwareBean;
import com.itaem.datacapture.bean.NetworkBean;
import com.itaem.datacapture.bean.OtherDataBean;

import java.util.ArrayList;
import java.util.List;

public class DataBeanActivity extends AppCompatActivity {
    private String type;
    private BeanAdapter beanAdapter;
    private List<Integer> canClickPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bean);
        if (getIntent().getStringExtra("Data_Type")!=null){
            type = getIntent().getStringExtra("Data_Type");
        }
        initView();
        initData();
        initClick();
    }

    private void initData() {
        initList(type);

    }

    private void initList(String type) {
        List<String> list = new ArrayList<>();
        canClickPosition = new ArrayList<>();
        switch (type){
            case "BatteryStatusBean":
                BatteryStatusBean batteryState = BatteryStatusUtil.getBatteryState(this);
                list.add(batteryState.getBattery_level());
                list.add(batteryState.getBattery_max());
                list.add(String.valueOf(batteryState.getBattery_pct()));
                list.add(String.valueOf(batteryState.getBattery_state()));
                list.add(String.valueOf(batteryState.getIs_ac_charge()));
                list.add(String.valueOf(batteryState.getIs_charging()));
                list.add(String.valueOf(batteryState.getIs_usb_charge()));
                break;
            case "hardwareBean":
                HardwareBean hardwareBean = HardwareUtil.getHardwareBean(this);
                list.add(hardwareBean.getBoard());
                list.add(hardwareBean.getBrand());
                list.add(String.valueOf(hardwareBean.getCores()));
                list.add(String.valueOf(hardwareBean.getDevice_height()));
                list.add(String.valueOf(hardwareBean.getDevice_name()));
                list.add(String.valueOf(hardwareBean.getDevice_width()));
                list.add(String.valueOf(hardwareBean.getModel()));
                list.add(String.valueOf(hardwareBean.getPhysical_size()));
                list.add(String.valueOf(hardwareBean.getProduction_date()));
                list.add(String.valueOf(hardwareBean.getRelease()));
                list.add(String.valueOf(hardwareBean.getSdk_version()));
                list.add(String.valueOf(hardwareBean.getSerial_number()));
                break;
            case "NetworkBean":
                NetworkBean networkBean = NetworkBeanUtils.getNetworkBean(this);
                list.add(" ");
                list.add(networkBean.getIp());
                list.add(String.valueOf(networkBean.getWifi_count()));
                list.add(" ");
                canClickPosition.add(0);
                canClickPosition.add(3);
                break;
            case "CurrentWifiBean":
                NetworkBean.CurrentWifiBean current_wifi = NetworkBeanUtils.getNetworkBean(this).getCurrent_wifi();
                list.add(current_wifi.getBssid());
                list.add(current_wifi.getMac());
                list.add(current_wifi.getName());
                list.add(current_wifi.getSsid());
                break;
            case "AddressInfo":
                LocationUtils instance = LocationUtils.getInstance(this);
                LocationUtils.AddressInfo addressInfo = instance.getAddressInfo();
                String address = instance.getAddress();
                list.add(addressInfo.getGps_latitude()==null?instance.getLatitude():addressInfo.getGps_latitude()); // list.add(instance.getLatitude());
                list.add(addressInfo.getGps_longitude()==null?instance.getLongitude():addressInfo.getGps_longitude());// list.add(instance.getLongitude());
                list.add(addressInfo.getGps_address_street());
                list.add(addressInfo.getGps_address_province());
                list.add(addressInfo.getGps_address_city());
                list.add(addressInfo.getGps_address_country());
                list.add(addressInfo.getGps_address_countryCode());
                list.add(address);
            case "OtherDataBean":
                OtherDataBean otherDataBean = OtherDataUtil.getOtherDataBean(this);
                list.add(otherDataBean.getDbm());
                list.add(otherDataBean.getLast_boot_time());
                list.add(String.valueOf(otherDataBean.getRoot_jailbreak()));
                list.add(String.valueOf(otherDataBean.getSimulator()));
        }
        beanAdapter.setData(list);
    }

    private void initClick() {
        beanAdapter.setOnItemClick(new BeanAdapter.onItemClick() {
            @Override
            public void onItemClick(int position) {
                if (canClickPosition.contains(position)) {
                    if (position == 3) {
                        Intent intent = new Intent(DataBeanActivity.this, DataListShowActivity.class);
                        intent.putExtra("Data_Type", "NetworkBean");
                        startActivity(intent);
                    } else if (position == 0) {
                        Intent intent = new Intent(DataBeanActivity.this, DataBeanActivity.class);
                        intent.putExtra("Data_Type", "CurrentWifiBean");
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void initView() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar_bean);
        RecyclerView recyclerView = findViewById(R.id.rv_bean);
        toolbar.setTitle(initToolbarTitle(type));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        beanAdapter = new BeanAdapter(type);
        recyclerView.setAdapter(beanAdapter);
    }

    private String initToolbarTitle(String type){
        switch (type){
            case "BatteryStatusBean":
                return "电量数据信息";
            case "hardwareBean":
                return "硬件数据信息";
            case "NetworkBean":
                return "网络数据信息";
            case "CurrentWifiBean":
                return "当前wifi信息";
            case "AddressInfo":
                return "地址数据信息";
            case "OtherDataBean":
                return "其他数据信息";

        }
        return "错误数据跳转";
    }
}