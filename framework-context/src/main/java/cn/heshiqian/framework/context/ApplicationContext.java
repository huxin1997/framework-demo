package cn.heshiqian.framework.context;

import cn.heshiqian.framework.util.Util;

public abstract class ApplicationContext {

    Class configurationClass;

    public <T>T getBean(Class<T> tClass){
        Util.assertNull(tClass);
        return getBean0(tClass);
    }

    public Object getBean(String name){
        Util.assertNull(name);
        return getBean0(name);
    }

    protected abstract Object getBean0(String name);

    protected abstract <T>T getBean0(Class<T> tClass);


    void syncConfigureClass(){

    }

}
