package com.itaem.datacapture;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.itaem.datacapture.Utils.LocationUtils;
import com.itaem.datacapture.beanShow.DataBeanActivity;
import com.itaem.datacapture.listShow.DataListShowActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAddressBook();
        initAppList();
        initCalendarList();
        initBatteryStatusBean();
        initNetworkBean();
        initSMSList();
        initPhotoList();
        initSensorList();
        initHardWateBean();
        initAddressInfo();
        initOtherDataBean();
        initNewStorageBean();
        initGeneralDataBean();
    }

    private void initGeneralDataBean() {
        findViewById(R.id.btn_GeneralDataBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataBeanActivity.class);
                intent.putExtra("Data_Type","GeneralDataBean");
                startActivity(intent);
            }
        });
        findViewById(R.id.GeneralDataBean_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Permission.ACCESS_FINE_LOCATION,Permission.READ_PHONE_STATE);
            }
        });
    }

    private void initNewStorageBean() {
        findViewById(R.id.btn_NewStorageBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataBeanActivity.class);
                intent.putExtra("Data_Type","NewStorageBean");
                startActivity(intent);
            }
        });
        findViewById(R.id.NewStorageBean_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Permission.READ_EXTERNAL_STORAGE);
            }
        });
    }

    private void initOtherDataBean() {
        findViewById(R.id.btn_OtherDataBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataBeanActivity.class);
                intent.putExtra("Data_Type","OtherDataBean");
                startActivity(intent);
            }
        });
        findViewById(R.id.OtherDataBean_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGPS();
            }
        });
    }

    private void initAddressInfo() {
        findViewById(R.id.btn_AddressInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataBeanActivity.class);
                intent.putExtra("Data_Type","AddressInfo");
                startActivity(intent);
            }
        });
        findViewById(R.id.AddressInfo_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Permission.ACCESS_COARSE_LOCATION);
            }
        });
    }

    private void initHardWateBean() {
        findViewById(R.id.btn_Hardware).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataBeanActivity.class);
                intent.putExtra("Data_Type","hardwareBean");
                startActivity(intent);
            }
        });
    }

    private void initSensorList() {
        findViewById(R.id.btn_Sensor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataListShowActivity.class);
                intent.putExtra("Data_Type","SensorBean");
                startActivity(intent);
            }
        });

    }

    private void initPhotoList() {
        findViewById(R.id.btn_Photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataListShowActivity.class);
                intent.putExtra("Data_Type","PhotoBean");
                startActivity(intent);
            }
        });
        findViewById(R.id.Photo_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Permission.READ_EXTERNAL_STORAGE);
            }
        });
    }

    private void initSMSList() {
        findViewById(R.id.btn_SMS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataListShowActivity.class);
                intent.putExtra("Data_Type","SMSBean");
                startActivity(intent);
            }
        });
        findViewById(R.id.SMS_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Permission.READ_SMS);
            }
        });
    }

    private void initNetworkBean() {
        findViewById(R.id.btn_NetworkBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataBeanActivity.class);
                intent.putExtra("Data_Type","NetworkBean");
                startActivity(intent);
            }
        });
        findViewById(R.id.NetworkBean_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Permission.ACCESS_FINE_LOCATION,Permission.ACCESS_COARSE_LOCATION);
            }
        });
    }

    private void initBatteryStatusBean() {
        findViewById(R.id.btn_BatteryStatusBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataBeanActivity.class);
                intent.putExtra("Data_Type","BatteryStatusBean");
                startActivity(intent);
            }
        });
    }

    private void initCalendarList() {
        findViewById(R.id.CalendarList_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Permission.READ_CALENDAR);
            }
        });
        findViewById(R.id.btn_CalendarList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataListShowActivity.class);
                intent.putExtra("Data_Type","CalendarList");
                startActivity(intent);
            }
        });

    }

    private void initAppList() {
        findViewById(R.id.btn_AppList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataListShowActivity.class);
                intent.putExtra("Data_Type","AppList");
                startActivity(intent);
            }
        });
    }

    private void initAddressBook() {
        findViewById(R.id.addressBook_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Permission.READ_CONTACTS);
            }
        });
        findViewById(R.id.btn_addressBook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataListShowActivity.class);
                intent.putExtra("Data_Type","addressBook");
                startActivity(intent);

            }
        });
    }

    private void requestPermission(String...permission){
        XXPermissions.with(this).permission(permission).request(new OnPermissionCallback() {
            @Override
            public void onGranted(@NonNull List<String> permissions, boolean allGranted) {
                if (!allGranted) {
                    Toast.makeText(MainActivity.this,"获取权限成功", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onDenied(@NonNull List<String> permissions, boolean doNotAskAgain) {
                if (doNotAskAgain) {
                    Toast.makeText(MainActivity.this,"获取权限被禁止且不再询问",Toast.LENGTH_LONG).show();
                    // 如果是被永久拒绝就跳转到应用权限系统设置页面
                    XXPermissions.startPermissionActivity(MainActivity.this, permissions);
                } else {
                    Toast.makeText(MainActivity.this,"获取权限失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // 判断是否开启定位服务
    public  boolean isLocationServiceEnabled(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        return !isGPSEnabled&&!isNetworkEnabled;
    }
    // 检查是否开启GPS
    private void checkGPS(){
        if (!isLocationServiceEnabled(this)) {
            if (checkPermission(this)){
                LocationUtils.getInstance(this);
            }else {
                requestPermission(Permission.ACCESS_COARSE_LOCATION);
            }
        }else {
            LocationUtils.getInstance(this);
        }
    }
    // 检查是否申请权限
    private boolean checkPermission(Context context){
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d("数据抓取:LocationUtils", "并未申请相关权限");
            return false;
        }
        return true;
    }
}