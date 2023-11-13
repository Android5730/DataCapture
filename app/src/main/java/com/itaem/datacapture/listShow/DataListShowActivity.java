package com.itaem.datacapture.listShow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.column.ColumnInfo;
import com.bin.david.form.listener.OnColumnClickListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.itaem.datacapture.Factory.Factory;
import com.itaem.datacapture.R;
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
    RecyclerView recyclerView_list;
    DataListAdapter listAdapter;
    MaterialToolbar toolbar;
    ProgressBar progressBar;
    private boolean isTable = true;// 是否为表格布局状态
    private String data_type;// 当前布局的列表数据类型，需要调整适配器布局
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);
        initView();
        initData();


    }

    private void initView() {
        recyclerView_list = findViewById(R.id.rv_list);
        toolbar = findViewById(R.id.toolbar_list);
        table = findViewById(R.id.table);
        progressBar = findViewById(R.id.progress);
        setSupportActionBar(toolbar);
        recyclerView_list.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new DataListAdapter();
        recyclerView_list.addItemDecoration(new DividerItemDecoration(this,1));
        recyclerView_list.setAdapter(listAdapter);

    }

    private void initData() {
        data_type = getIntent().getStringExtra("Data_Type");
        switch (data_type){
            case "addressBook":
                List<AddressBookBean> addressBookBean = AddressBookUtil.getAddressBookBean(getBaseContext());
                table.setData(addressBookBean);
                break;
            case "AppList":
                progressBar.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        List<AppListBean> appListBean = AppListUtil.getAppListBean(DataListShowActivity.this);
                        List<AppListBean> appListBean = new Factory().getDataUtil(AppListUtil.class).getData(DataListShowActivity.this);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);
                                table.setData(appListBean);
                            }
                        });
                    }
                }).start();
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
                table.setData(networkBean.getConfigured_wifi());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_data,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_change_layout:
                if (isTable){
                    table.setVisibility(View.GONE);
                    recyclerView_list.setVisibility(View.VISIBLE);
                    listAdapter.setList(table.getTableData().getT(),data_type);
                    isTable = false;
                    item.setTitle("切换表格布局");
                }else {
                    table.setVisibility(View.VISIBLE);
                    recyclerView_list.setVisibility(View.GONE);
                    isTable = true;
                    item.setTitle("切换列表布局");
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}