package com.itaem.datacapture.Utils;// 2023/8/13

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;

import com.itaem.datacapture.bean.DeviceInfoBean;
import com.itaem.datacapture.bean.GeneralDataBean;
import com.itaem.datacapture.bean.SensorListBean;

import java.util.ArrayList;
import java.util.List;

// 作者:ITAEM 陈金城
public class SensorListUtil {
    public static List<SensorListBean> getSensorListBean(Context context) {
        List<SensorListBean> sensorListBeans = new ArrayList<>();
        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                sensorListBeans.add(new SensorListBean(
                        String.valueOf(sensor.getId()),String.valueOf(sensor.getMaximumRange()),
                        String.valueOf(sensor.getMinDelay()), sensor.getName(), String.valueOf(sensor.getPower()),
                        String.valueOf(sensor.getResolution()), String.valueOf(sensor.getType()),
                        String.valueOf(sensor.getVendor()), String.valueOf(sensor.getVersion())
                        ));
            }else {
                sensorListBeans.add(new SensorListBean(
                        String.valueOf(-2),String.valueOf(sensor.getMaximumRange()),
                        String.valueOf(sensor.getMinDelay()), sensor.getName(), String.valueOf(sensor.getPower()),
                        String.valueOf(sensor.getResolution()), String.valueOf(sensor.getType()),
                        String.valueOf(sensor.getVendor()), String.valueOf(sensor.getVersion())
                        ));
            }
        }
        return sensorListBeans;
    }
}
