package cn.heshiqian.framework.bean;

import cn.heshiqian.framework.util.Util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AbstractBeanFactory extends BeanFactory {




    @Override
    public <T> T newBean(Class<T> tClass) throws BeanInitException{
        Util.assertNull(tClass,"传入类不能为空！");
        if(tClass.isInterface())
            throw new BeanInitException("实例化失败，传入的类是一个接口！");
        try {
            return invokeConstructor(tClass.getDeclaredConstructor());
        } catch (NoSuchMethodException e) {
            throw new BeanInitException("你还没有对此类设计构造函数！或此类是抽象类?");
        }
    }

    @Override
    protected <T> T invokeConstructor(Constructor<T> constructor, Object... args) throws BeanInitException {
        Util.assertNull(constructor,"构造器为空！");
        try {
            return constructor.newInstance();
        } catch (InstantiationException e) {
            throw new BeanInitException("实例化失败，此类是接口或者抽象类?",e);
        } catch (IllegalAccessException e) {
            throw new BeanInitException("实例化失败，构造函数是私有的?",e);
        } catch (InvocationTargetException e) {
            throw new BeanInitException("实例化失败，构造函数执行过程有异常抛出",e);
        }
    }

    @Override
    public Object newBean(String className) throws BeanInitException {
        Util.assertNull(className);
        try {
            return invokeConstructor(Class.forName(className).getDeclaredConstructor());
        } catch (NoSuchMethodException e) {
            throw new BeanInitException("你还没有对此类设计构造函数！或此类是抽象类?");
        } catch (ClassNotFoundException e) {
            throw new BeanInitException("没有找到此类！请检查类名和包名",e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T newBean(String className, Class<T> type) throws BeanInitException,ClassCastException {
        Util.assertNull(className,type);
        try {
            Class<?> aClass = Class.forName(className);
            return (T) invokeConstructor(aClass.getDeclaredConstructor());
        } catch (ClassNotFoundException e) {
            throw new BeanInitException("没有找到此类！请检查类名和包名",e);
        } catch (NoSuchMethodException e) {
            throw new BeanInitException("你还没有对此类设计构造函数！或此类是抽象类?");
//        } catch (ClassCastException e){
//            throw new BeanInitException("无法将"+className+"转换为"+type.getTypeName()+"类型，请检查是否为其子类",e);
        }
    }

    @Override
    protected <T> T findClassNameInitToObj() throws BeanInitException {
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
