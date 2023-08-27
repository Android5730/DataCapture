package com.itaem.datacapture.Utils;// 2023/8/13

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.itaem.datacapture.bean.AddressBookBean;

import java.util.ArrayList;
import java.util.List;

// 作者:ITAEM 陈金城
public class AddressBookUtil {
    @SuppressLint("Range")
    public static List<AddressBookBean> getAddressBookBean(Context context) {
        List<AddressBookBean> addressBook = new ArrayList<>();
        ContentResolver cr = context.getContentResolver();
        Cursor crs = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (crs.moveToNext()) {
            // 获得联系人姓名
            int nameColumnIndex = crs.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
            String name = crs.getString(nameColumnIndex);
            // 获取联系人手机号码
            int numberColumnIndex = crs.getColumnIndex(ContactsContract.Contacts._ID);
            // 获得当前联系人的ID索引用于查询号码
            String contact_Id = crs.getString(numberColumnIndex);
            // 注意第一个参数和上一个游标crs的参数是不同的。上一个是ContactsContract.Contacts.CONTENT_URI，并且第三个参数是为了得到和前面匹配的电话号码
            Cursor crs_Num = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = "
                    + contact_Id, null, null);
            String number = "";
            while (crs_Num.moveToNext()) {
                int index = crs_Num.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                number = crs_Num.getString(index);
                if (!number.isEmpty()) break;
            }
            // 编辑时间
            int updateTimeColumnIndex = crs.getColumnIndex(ContactsContract.Contacts.CONTACT_LAST_UPDATED_TIMESTAMP);
            long updateTime = crs.getLong(updateTimeColumnIndex);
            // 上次通讯时间(毫秒)
            int lastTimeColumnIndex = crs.getColumnIndex(ContactsContract.PhoneLookup.LAST_TIME_CONTACTED);
            long lastTime = crs.getLong(lastTimeColumnIndex);
            // 获得联系次数
            int timeColumnIndex = crs.getColumnIndex(ContactsContract.PhoneLookup.TIMES_CONTACTED);
            String type = "";
            switch (crs.getColumnIndex(ContactsContract.PhoneLookup.TYPE)){
                case 1:
                    type = "家庭电话";
                    break;
                case 2:
                    type = "移动电话";
                    break;
                case 3:
                    type = "工作电话";
                    break;
                default:
                    type = "其他";
                    break;
            }
            int times = crs.getInt(timeColumnIndex);
            addressBook.add(new AddressBookBean(name, String.valueOf(lastTime), number, times, String.valueOf(updateTime),type));
        }
        crs.close();
        return addressBook;
    }
}
