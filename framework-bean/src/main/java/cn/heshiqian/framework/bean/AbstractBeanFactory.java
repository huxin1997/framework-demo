package cn.heshiqian.framework.bean;

import cn.heshiqian.framework.util.Util;
import com.sun.org.glassfish.gmbal.Description;

import java.lang.reflect.Constructor;

public class AbstractBeanFactory extends BeanFactory {




    @Override
    public <T> T newBean(Class<T> tClass) throws BeanInitException{
        Util.assertNull(tClass,"传入类不能为空！");
        if(tClass.isInterface())
            throw new BeanInitException("实例化失败，传入的类是一个接口！");
        try {
            return invokeConstructor(tClass.getDeclaredConstructor());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected <T> T invokeConstructor(Constructor<T> constructor, Object... args) throws BeanInitException {
        return null;
    }

    @Deprecated
    @Override
    protected <T> T generatorClass(Class<T> tClass) {
        Util.assertNull(tClass,"传入类不能为空！");
        if(tClass.isInterface())
            throw new BeanInitException("实例化失败，传入类是一个接口！");
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            throw new BeanInitException("实例化失败，此类是抽象类吗？");
        } catch (IllegalAccessException e) {
            throw new BeanInitException("实例化失败，此类是私有的吗？");
        }
    }

}
