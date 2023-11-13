package com.itaem.datacapture.Utils;// 2023/11/9

import android.content.Context;

import com.itaem.datacapture.bean.AppListBean;
import com.itaem.datacapture.bean.ShowListBean;

import java.util.List;

// 作者:ITAEM 陈金城
public abstract class DataUtil {
    public abstract <T extends ShowListBean> List<T> getData(Context context);
}
