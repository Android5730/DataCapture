package com.itaem.datacapture.Factory;// 2023/11/9

import com.itaem.datacapture.Utils.DataUtil;

// 作者:ITAEM 陈金城
public class Factory extends DataListFactory{
    @SuppressWarnings("unchecked")
    @Override
    public <T extends DataUtil> T getDataUtil(Class<T> clz) {
        DataUtil dataUtil = null;
        String className = clz.getName();
        try {
            // 通过反射生产不同厂家的计算机
            dataUtil = (DataUtil) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (T) dataUtil;
    }
}
