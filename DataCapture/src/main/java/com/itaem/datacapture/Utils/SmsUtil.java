package com.itaem.datacapture.Utils;// 2023/8/13

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Telephony;

import com.itaem.datacapture.bean.SmsBean;

import java.util.ArrayList;
import java.util.List;

// 作者:ITAEM 陈金城
public class SmsUtil {
    /**
     * 获取sms列表
     */
    @SuppressLint("Range")
    public static List<SmsBean> getSmsList(Context context) {
        List<SmsBean> smsBeans = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(Telephony.Sms.CONTENT_URI, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int typeSms = cursor.getInt(cursor.getColumnIndex(Telephony.Sms.TYPE));
                String date_receive = cursor.getString(cursor.getColumnIndex(Telephony.Sms.DATE));
                String date_sent = cursor.getString(cursor.getColumnIndex(Telephony.Sms.DATE_SENT));
                String other_phone = cursor.getString(cursor.getColumnIndex(Telephony.Sms.ADDRESS));
                String time = "";
                String type = "";
                if (typeSms==Telephony.Sms.MESSAGE_TYPE_SENT) {
                    time = date_sent;
                    type = "2";
                } else {
                    time = date_receive;
                    type = "1";
                }
                int read = cursor.getInt(cursor.getColumnIndex(Telephony.Sms.READ));
                int seen = cursor.getInt(cursor.getColumnIndex(Telephony.Sms.SEEN));
                int status = cursor.getInt(cursor.getColumnIndex(Telephony.Sms.STATUS));
                if (status == 32) status = 64;
                else if (status == 64) status = 128;
                String subject = cursor.getString(cursor.getColumnIndex(Telephony.Sms.SUBJECT));
                if (subject == null) {
                    subject = "";
                }
                String content = cursor.getString(cursor.getColumnIndex(Telephony.Sms.BODY));
                String package_name = "包名";
                smsBeans.add(new SmsBean(content, other_phone, package_name, read, seen,
                        status, subject, time, type));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return smsBeans;
    }
}
