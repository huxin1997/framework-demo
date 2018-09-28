package cn.heshiqian.framework.bean;

import cn.heshiqian.framework.util.Util;

public abstract class AnnotationBean {

    public Object injectBean(Class beanClass){
        Util.assertNull(beanClass);
        return injectBean0(beanClass);
    }

    protected abstract Object injectBean0(Class beanClass);

}
