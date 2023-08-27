package com.itaem.datacapture;// 2023/8/13

import android.content.Context;

import com.itaem.datacapture.Utils.AddressBookUtil;
import com.itaem.datacapture.bean.AddressBookBean;

import java.util.List;


// 作者:ITAEM 陈金城
public class DataCaptureUtil {
    public static void init(Context context){
        List<AddressBookBean> addressBookBean = AddressBookUtil.getAddressBookBean(context);
    }
}
