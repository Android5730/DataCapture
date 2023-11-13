package com.itaem.datacapture.Factory;// 2023/11/9

import android.content.Context;

import com.itaem.datacapture.Utils.DataUtil;
import com.itaem.datacapture.bean.ShowListBean;

import java.util.List;

// 作者:ITAEM 陈金城
public abstract class DataListFactory {
    public abstract <T extends DataUtil> T getDataUtil(Class<T> className);
}
