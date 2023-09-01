package com.itaem.datacapture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.column.ColumnInfo;
import com.bin.david.form.listener.OnColumnClickListener;
import com.itaem.datacapture.Utils.AddressBookUtil;
import com.itaem.datacapture.Utils.AppListUtil;
import com.itaem.datacapture.Utils.BatteryStatusUtil;
import com.itaem.datacapture.Utils.CalendarListUtil;
import com.itaem.datacapture.Utils.LocationUtils;
import com.itaem.datacapture.Utils.NetworkBeanUtils;
import com.itaem.datacapture.Utils.PhotoInfosUtil;
import com.itaem.datacapture.Utils.SensorListUtil;
import com.itaem.datacapture.Utils.SmsUtil;
import com.itaem.datacapture.bean.AddressBookBean;
import com.itaem.datacapture.bean.AppListBean;
import com.itaem.datacapture.bean.BatteryStatusBean;
import com.itaem.datacapture.bean.CalendarListBean;
import com.itaem.datacapture.bean.NetworkBean;
import com.itaem.datacapture.bean.PhotoInfosBean;
import com.itaem.datacapture.bean.SensorListBean;
import com.itaem.datacapture.bean.SmsBean;

import java.util.Collections;
import java.util.List;

public class DataListShowActivity extends AppCompatActivity {
    SmartTable table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);
        table = findViewById(R.id.table);
        String data_type = getIntent().getStringExtra("Data_Type");
        switch (data_type){
            case "addressBook":
                List<AddressBookBean> addressBookBean = AddressBookUtil.getAddressBookBean(getBaseContext());
                table.setData(addressBookBean);
                break;
            case "AppList":
                List<AppListBean> appListBean = AppListUtil.getAppListBean(this);
                table.setData(appListBean);
                break;
            case "CalendarList":
                List<CalendarListBean> calendarListBean = CalendarListUtil.getCalendarListBean(this);
                table.setData(calendarListBean);
                break;
            case "BatteryStatusBean":
                BatteryStatusBean batteryState = BatteryStatusUtil.getBatteryState(this);
                table.setData(Collections.singletonList(batteryState));
                break;
            case "NetworkBean":
                NetworkBean networkBean = NetworkBeanUtils.getNetworkBean(this);
                table.setData(Collections.singletonList(networkBean));
                networkClick(networkBean);
                break;
            case "SMSBean":
                List<SmsBean> smsList = SmsUtil.getSmsList(this);
                table.setData(smsList);
                break;
            case "PhotoBean":
                List<PhotoInfosBean> photoInfosBean = PhotoInfosUtil.getPhotoInfosBean(this, LocationUtils.getInstance(this).showLocation());
                table.setData(photoInfosBean);
                break;
            case "SensorBean":
                List<SensorListBean> sensorListBean = SensorListUtil.getSensorListBean(this);
                table.setData(sensorListBean);
                break;
        }

    }

    private void networkClick(NetworkBean networkBean){
        table.setOnColumnClickListener(new OnColumnClickListener() {
            @Override
            public void onClick(ColumnInfo columnInfo) {
                Column column = columnInfo.column;
                if (column.getColumnName().equals("current_wifi_当前WIFI")){
                    // 识别当前是否为wifi状态
                    table.setData(Collections.singletonList(networkBean.getCurrent_wifi()));
                    table.notifyDataChanged();
                }else if (column.getColumnName().equals("configured_wifi_配置WIFI")){
                    table.setData(networkBean.getConfigured_wifi());
                    table.notifyDataChanged();
                }
            }
        });
    }
}