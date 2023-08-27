package com.itaem.datacapture.bean;// 2023/8/13

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.io.Serializable;
import java.util.List;

// 作者:ITAEM 陈金城
@SmartTable(name="日历事件")
public  class CalendarListBean implements Serializable {
    /**
     * description : string
     * end_time : 0
     * event_id : 0
     * event_title : string
     * reminders : [{"eventId":0,"method":0,"minutes":0,"reminder_id":0}]
     * start_time : 0
     */
    @SmartColumn(id =1,name = "description_事件描述")
    private String description; // 事件描述
    @SmartColumn(id =2,name = "end_time_事件结束时间（毫秒）")
    private String end_time; // 事件结束时间（毫秒）
    @SmartColumn(id =3,name = "event_id_事件ID")
    private String event_id; // 事件ID
    @SmartColumn(id =4,name = "event_title_事件标题")
    private String event_title;  // 事件标题
    @SmartColumn(id =5,name = "start_time_事件开始时间（毫秒）")
    private String start_time; // 事件开始时间（毫秒）
    @SmartColumn(id =6,name = "reminders_提醒列表")
    private List<RemindersBean> reminders; // 提醒列表

    public CalendarListBean(String description, String end_time, String event_id, String event_title, String start_time, List<RemindersBean> reminders) {
        this.description = description;
        this.end_time = end_time;
        this.event_id = event_id;
        this.event_title = event_title;
        this.start_time = start_time;
        this.reminders = reminders;
    }

    public void setReminders(List<CalendarListBean.RemindersBean> reminders) {
        this.reminders = reminders;
    }

    public static class RemindersBean implements Serializable {
        /**
         * eventId : 0
         * method : 0
         * minutes : 0
         * reminder_id : 0
         */

        private int eventId;
        private int method;
        private int minutes;
        private int reminder_id;

        public RemindersBean(int eventId, int method, int minutes, int reminder_id) {
            this.eventId = eventId;
            this.method = method;
            this.minutes = minutes;
            this.reminder_id = reminder_id;
        }

        public int getEventId() {
            return eventId;
        }

        public void setEventId(int eventId) {
            this.eventId = eventId;
        }

        public int getMethod() {
            return method;
        }

        public void setMethod(int method) {
            this.method = method;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getReminder_id() {
            return reminder_id;
        }

        public void setReminder_id(int reminder_id) {
            this.reminder_id = reminder_id;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public List<RemindersBean> getReminders() {
        return reminders;
    }
}

