package com.itaem.datacapture.Utils;// 2023/8/13

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.util.DisplayMetrics;

import com.itaem.datacapture.bean.PhotoInfosBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 作者:ITAEM 陈金城
public class PhotoInfosUtil {
    /**
     * 获取image
     */
    @SuppressLint("Range")
    public static List<PhotoInfosBean> getPhotoInfosBean(Context context, Location location) {
        List<PhotoInfosBean> photoInfosBeans = new ArrayList<>();
        long start = System.currentTimeMillis();
        // 定义要查询的图片的URI
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Uri uriInternal = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        // 定义要查询的列
        String[] projection = {
                MediaStore.Images.ImageColumns.AUTHOR,
                MediaStore.Images.ImageColumns.ARTIST,
                MediaStore.Images.ImageColumns.DATE_ADDED,
                MediaStore.Images.ImageColumns.DATA,
                MediaStore.Images.ImageColumns.WIDTH,
                MediaStore.Images.ImageColumns.HEIGHT,
                MediaStore.Images.ImageColumns.DATE_TAKEN,
                MediaStore.Images.ImageColumns.LATITUDE,
                MediaStore.Images.ImageColumns.LONGITUDE,
                MediaStore.Images.ImageColumns.BUCKET_ID,
                MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.ORIENTATION,
                MediaStore.Images.Media.DATE_MODIFIED
        };
        // 查询图片，并获取游标
        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        // 遍历游标，获取图片信息并显示
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                String addTime = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_ADDED));
                String updateTime = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_MODIFIED));
                String author = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.ARTIST));
                String createTime = String.valueOf(SystemClock.currentThreadTimeMillis());
       //         String createTime = String.valueOf(SystemClock.currentThreadTimeMillis() - start);
                String date = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_TAKEN));
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)); // 路径
                String gps_processing_method = "";// 定位的方法名称，获取不到传空字符串
                String height = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.HEIGHT)) == null ? "0" : cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.HEIGHT));
                int latitude = cursor.getInt(cursor.getColumnIndex(MediaStore.Images.ImageColumns.LATITUDE));
                int longitude = cursor.getInt(cursor.getColumnIndex(MediaStore.Images.ImageColumns.LONGITUDE));
                String width = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.WIDTH)) == null ? "0" : cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.WIDTH));
                String name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));// 文件名
                // 从文件名中提取设备的制造商和型号
                String model = "";
                String[] parts = name.split("_");
                if (parts.length >= 3) {
                    model = parts[1];// 拍照机型
                }
                String orientation = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.ORIENTATION));
                String save_time = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED));
                String take_time = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATE_TAKEN));

                PhotoInfosBean photoInfosBean = new PhotoInfosBean(addTime,updateTime,author, createTime, date,
                        gps_processing_method, height, latitude, longitude, width, name, model, orientation, save_time, take_time);
                photoInfosBeans.add(getImageFocalLength(path, photoInfosBean));
            }
            cursor.close();
        }
        // 查询图片，并获取游标
        Cursor cursorInternal = context.getContentResolver().query(uriInternal, projection, null, null, null);
        // 遍历游标，获取图片信息并显示
        if (cursorInternal != null) {
            while (cursorInternal.moveToNext()) {
                String addTime = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.DATE_ADDED));
                String updateTime = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.DATE_MODIFIED));
                String author = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.ARTIST));
                String createTime = String.valueOf(System.currentTimeMillis() - start);
                String date = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.DATE_TAKEN));
                String path = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.DATA)); // 路径
                String gps_processing_method = "";// 定位的方法名称，获取不到传空字符串
                String height = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.HEIGHT)) == null ? "0" : cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.HEIGHT));
                int latitude = cursorInternal.getInt(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.LATITUDE));
                int longitude = cursorInternal.getInt(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.LONGITUDE));
                String width = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.ImageColumns.WIDTH));
                String name = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));// 文件名
                // 从文件名中提取设备的制造商和型号
                String model = "";
                String[] parts = name.split("_");
                if (parts.length >= 3) {
                    model = parts[1];// 拍照机型
                }
                String orientation = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.Media.ORIENTATION));
                String save_time = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED));
                String take_time = cursorInternal.getString(cursorInternal.getColumnIndex(MediaStore.Images.Media.DATE_TAKEN));
                PhotoInfosBean photoInfosBean = new PhotoInfosBean(addTime,updateTime,author, createTime, date,
                        gps_processing_method, height, latitude, longitude, width, name, model, orientation, save_time, take_time);
                photoInfosBeans.add(getImageFocalLength(path, photoInfosBean));
            }
            cursorInternal.close();
        }
        return photoInfosBeans;
    }

    /**
     *  获取照片的其他数据
     */
    private static PhotoInfosBean getImageFocalLength(String imagePath, PhotoInfosBean photoInfosBean) {
        String flash = ""; // 闪光灯，获取不到传空字符串
        String focal_length = ""; //  镜头的实际焦距，获取不到传空字符串
        String lens_make = ""; // 镜头制造商
        String lens_model = ""; // 镜头的序列号
        String software = "";// 软件
        String x_resolution = "";//
        String y_resolution = "";//
        String gps_altitude = "";
        try {
            ExifInterface exifInterface = new ExifInterface(imagePath);
            focal_length = exifInterface.getAttribute(ExifInterface.TAG_FOCAL_LENGTH) != null ? exifInterface.getAttribute(ExifInterface.TAG_FOCAL_LENGTH) : "";
            flash = exifInterface.getAttribute(ExifInterface.TAG_FLASH) != null ? exifInterface.getAttribute(ExifInterface.TAG_FLASH) : "";
            lens_make = exifInterface.getAttribute(ExifInterface.TAG_MAKE);
            lens_model = exifInterface.getAttribute(ExifInterface.TAG_MODEL);
            x_resolution = exifInterface.getAttribute(ExifInterface.TAG_X_RESOLUTION);
            y_resolution = exifInterface.getAttribute(ExifInterface.TAG_Y_RESOLUTION);
            software = exifInterface.getAttribute(ExifInterface.TAG_SOFTWARE);
            gps_altitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_ALTITUDE);
            photoInfosBean.setFlash(flash);
            photoInfosBean.setFocal_length(focal_length);
            photoInfosBean.setLens_make(lens_make);
            photoInfosBean.setLens_model(lens_model);
            photoInfosBean.setSoftware(software);
            photoInfosBean.setX_resolution(x_resolution);
            photoInfosBean.setY_resolution(y_resolution);
            photoInfosBean.setAuthor(exifInterface.getAttribute(ExifInterface.TAG_ARTIST));
            photoInfosBean.setGps_altitude(gps_altitude);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photoInfosBean;
    }

    /**
     * 获取x或y上的像素
     */
    private static String getXPixels(String width, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity activity = (Activity) context;
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        return String.valueOf(Integer.parseInt(width) / screenWidth);
    }

    private static String getYPixels(String height, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity activity = (Activity) context;
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        return String.valueOf(Integer.parseInt(height) / screenHeight);
    }

}
