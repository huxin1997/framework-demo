package cn.heshiqian.framework.bean;

import java.lang.reflect.Constructor;

public abstract class BeanFactory {

    /**
     * 生成类
     * @param tClass 余姚生成的类对象
     * @return 实例化的类
     */
    protected abstract <T> T generatorClass(Class<T> tClass);

    /**
     * 根据类对象，生成一个Bean
     * @param tClass 类对象
     * @return 实例化的类
     * @throws BeanInitException 类实例化失败抛出
     */
    public abstract <T>T newBean(Class<T> tClass) throws BeanInitException;

    /**
     * 通过构造器创建Bean
     * @param constructor 类的构造器
     * @param args 需要执行的参数
     * @return 实例化类
     * 使用构造器时，建议在类中添加公共的无参构造函数。
     * @throws BeanInitException 类实例化失败抛出
     */
    protected abstract <T>T invokeConstructor(Constructor<T> constructor,Object... args) throws BeanInitException;




}
