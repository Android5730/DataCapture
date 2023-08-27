package com.itaem.datacapture.Utils;// 2023/8/13

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;

import com.itaem.datacapture.bean.CalendarListBean;

import java.util.ArrayList;
import java.util.List;

// 作者:ITAEM 陈金城
public class CalendarListUtil {
    /**
     * 获取日历信息
     */
    @SuppressLint("Range")
    public static List<CalendarListBean> getCalendarListBean(Context context) {
        List<CalendarListBean> listBeans = new ArrayList<>();
        Cursor eventCursor = context.getContentResolver().query(CalendarContract.Events.CONTENT_URI, null, null, null, null);
        ContentResolver cr = context.getContentResolver();
        Uri uri = CalendarContract.Reminders.CONTENT_URI;
        String[] projection = {CalendarContract.Reminders._ID, CalendarContract.Reminders.MINUTES, CalendarContract.Reminders.METHOD};
        String selection = CalendarContract.Reminders.EVENT_ID + " = ?";
        if (eventCursor != null) {
            while (eventCursor.moveToNext()) {
                int descriptionIndex = eventCursor.getColumnIndex("description");
                String description = descriptionIndex >= 0 ? eventCursor.getString(descriptionIndex) : null;
                int titleIndex = eventCursor.getColumnIndex("title");
                String title = titleIndex >= 0 ? eventCursor.getString(titleIndex) : null;
                int startTimeIndex = eventCursor.getColumnIndex("dtstart");
                String start_time = startTimeIndex >= 0 ? eventCursor.getString(startTimeIndex) : null;
                int endTimeIndex = eventCursor.getColumnIndex("dtend");
                String end_time = endTimeIndex >= 0 ? eventCursor.getString(endTimeIndex) : null;
                int eventIdIndex = eventCursor.getColumnIndex("_id");
                String event_id = eventIdIndex >= 0 ? eventCursor.getString(eventIdIndex) : null;
                if (event_id != null) {
                    String[] selectionArgs = {Long.toString(Long.parseLong(event_id))};
                    Cursor query = cr.query(uri, projection, selection, selectionArgs, null);
                    List<CalendarListBean.RemindersBean> remindersBeans = new ArrayList<>();
                    while (query.moveToNext()) {
                        int reminder_id = Integer.parseInt(query.getString(query.getColumnIndex("_id")));
                        int minutes = Integer.parseInt(query.getString(query.getColumnIndex("minutes")));
                        int method = Integer.parseInt(query.getString(query.getColumnIndex("method")));
                        remindersBeans.add(new CalendarListBean.RemindersBean(Integer.parseInt(event_id), method, minutes, reminder_id));
                    }
                    query.close();
                    listBeans.add(new CalendarListBean(description == null ? "" : description, end_time, event_id, title, start_time, remindersBeans));
                }

            }
        }

        if (eventCursor != null) {
            eventCursor.close();
        }
        return listBeans;
    }
}
