package com.itaem.datacapture.beanShow;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.itaem.datacapture.listShow.DataListShowActivity;
import com.itaem.datacapture.R;
import com.itaem.datacapture.Utils.BatteryStatusUtil;
import com.itaem.datacapture.Utils.GeneralDataUtil;
import com.itaem.datacapture.Utils.HardwareUtil;
import com.itaem.datacapture.Utils.LocationUtils;
import com.itaem.datacapture.Utils.NetworkBeanUtils;
import com.itaem.datacapture.Utils.OtherDataUtil;
import com.itaem.datacapture.Utils.SDCardUtils;
import com.itaem.datacapture.bean.BatteryStatusBean;
import com.itaem.datacapture.bean.GeneralDataBean;
import com.itaem.datacapture.bean.HardwareBean;
import com.itaem.datacapture.bean.NetworkBean;
import com.itaem.datacapture.bean.NewStorageBean;
import com.itaem.datacapture.bean.OtherDataBean;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

import java.util.ArrayList;
import java.util.List;

public class DataBeanActivity extends AppCompatActivity {
    private String type;
    private BeanAdapter beanAdapter;
    private MaterialToolbar toolbar;
    private List<Integer> canClickPosition;
    private RecyclerView recyclerView;
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
                break;
            case "OtherDataBean":
                OtherDataBean otherDataBean = OtherDataUtil.getOtherDataBean(this);
                list.add(otherDataBean.getDbm());
                list.add(otherDataBean.getLast_boot_time());
                list.add(String.valueOf(otherDataBean.getRoot_jailbreak()));
                list.add(String.valueOf(otherDataBean.getSimulator()));
                break;
            case "NewStorageBean":
                NewStorageBean newStorageBean = SDCardUtils.getNewStorageBean(this);
                list.add(newStorageBean.getApp_max_memory());
                list.add(newStorageBean.getApp_total_memory());
                list.add(newStorageBean.getApp_free_memory());
                list.add(newStorageBean.getContain_sd());
                list.add(newStorageBean.getExtra_sd());
                list.add(newStorageBean.getInternal_storage_total());
                list.add(newStorageBean.getInternal_storage_usable());
                list.add(newStorageBean.getMemory_card_size());
                list.add(newStorageBean.getMemory_card_size_use());
                list.add(newStorageBean.getMemory_card_usable_size());
                list.add(newStorageBean.getMemory_card_free_size());
                list.add(newStorageBean.getRam_total_size());
                list.add(newStorageBean.getRam_usable_size());
                list.add(newStorageBean.getRam_threshold());
                break;
            case "GeneralDataBean":
                GeneralDataBean generalData = GeneralDataUtil.getGeneralData(this);
                list.add(generalData.getAnd_id());
                list.add(generalData.getCurrentSystemTime());
                list.add(generalData.getElapsedRealtime());
                list.add(generalData.getGaid());
                list.add(generalData.getImei());
                list.add(String.valueOf(generalData.isIs_usb_debug()));
                list.add(String.valueOf(generalData.isIs_using_proxy_port()));
                list.add(String.valueOf(generalData.isIs_using_vpn()));
                list.add(generalData.getLanguage());
                list.add(generalData.getLocale_display_language());
                list.add(generalData.getLocale_iso_3_country());
                list.add(generalData.getLocale_country());
                list.add(generalData.getLocale_iso_3_language());
                list.add(generalData.getMac());
                list.add(generalData.getNetwork_operator_name());
                list.add(generalData.getNetwork_type());
                list.add(generalData.getPhone_number());
                list.add(String.valueOf(generalData.getPhone_type()));
                list.add(generalData.getTime_zone_id());
                list.add(generalData.getUptimeMillis());
                list.add(generalData.getThreadTimeMillis());
                list.add(generalData.getUuid());
                break;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_data,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_color:
                Toast.makeText(this, "颜色选择器", Toast.LENGTH_SHORT).show();
                new ColorPickerDialog.Builder(this)
                        .setTitle("ColorPicker Dialog")
                        .setPreferenceName("MyColorPickerDialog")
                        .setPositiveButton(getString(R.string.confirm),
                                new ColorEnvelopeListener() {
                                    @Override
                                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                        beanAdapter.setColor(envelope);
                                        beanAdapter.notifyDataSetChanged();
                                    }
                                })
                        .setNegativeButton(getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                        .attachAlphaSlideBar(true) // the default value is true.
                        .attachBrightnessSlideBar(true)  // the default value is true.
                        .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                        .show();
                break;
            case R.id.menu_changeLayout:
                DefaultItemAnimator itemAnimator = new DefaultItemAnimator();
                itemAnimator.setChangeDuration(1000); // 设置布局切换时的动画持续时间，单位为毫秒
                recyclerView.setItemAnimator(itemAnimator);
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager){
                    recyclerView.addItemDecoration(new DividerItemDecoration(this,1));
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                }else {
                    Toast.makeText(this, "切换布局", Toast.LENGTH_SHORT).show();
                    recyclerView.setLayoutManager(new GridLayoutManager(DataBeanActivity.this,2));
                    recyclerView.addItemDecoration(new DividerItemDecoration(this,1));
                    recyclerView.addItemDecoration(new DividerItemDecoration(this,0));
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_bean);
        setSupportActionBar(toolbar);
        recyclerView= findViewById(R.id.rv_bean);
        toolbar.setTitle(initToolbarTitle(type));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,1));
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
            case "NewStorageBean(单位Byte)":
                return "内存数据信息";
            case "GeneralDataBean":
                return "通用数据信息";

        }
        return "错误数据跳转";
    }
}