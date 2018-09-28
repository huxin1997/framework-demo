package cn.heshiqian.framework.bean;

import cn.heshiqian.framework.util.Util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

public abstract class BeanFactory {

    /**
     * 生成类
     *
     * @param tClass 需要生成的类对象
     * @return 实例化的类
     */
    protected abstract <T> T generatorClass(Class<T> tClass);

    /**
     * 根据类对象，生成一个Bean
     *
     * @param tClass 类对象
     * @return 实例化的类
     * @throws BeanInitException 类实例化失败抛出
     */
    public abstract <T> T newBean(Class<T> tClass) throws BeanInitException;

    /**
     * 通过构造器创建Bean
     *
     * @param constructor 类的构造器
     * @param args        需要执行的参数
     * @return 实例化类
     * 使用构造器时，建议在类中添加公共的无参构造函数。
     * @throws BeanInitException 类实例化失败抛出
     */
    protected abstract <T> T invokeConstructor(Constructor<T> constructor, Object... args) throws BeanInitException;


    public abstract Object newBean(String className) throws BeanInitException;

    public abstract <T> T newBean(String className, Class<T> type) throws BeanInitException, ClassCastException;


    protected abstract <T> T findClassNameInitToObj() throws BeanInitException;

    protected static Object injectBean(String className, HashMap<String, Object> param) {
        Util.assertNull(className);
        return injectBean0(className, param);
    }

    @SuppressWarnings("all")
    private static Object injectBean0(String className, HashMap<String, Object> param) {
        try {
            Class<?> aClass = Class.forName(className);
            Object obj = aClass.newInstance();
            if (param != null) {
                Iterator<String> iterator = param.keySet().iterator();
                while (iterator.hasNext()) {
                    String field = iterator.next();
                    Field declaredField = aClass.getDeclaredField(field);
                    declaredField.set(obj, param.get(field));
                }
            }
            return obj;
        } catch (ClassNotFoundException e) {
            throw new BeanInjectFailException("没有找到此类！" + className, e);
        } catch (IllegalAccessException e) {
            throw new BeanInjectFailException("实例化失败，构造函数是私有的吗?", e);
        } catch (InstantiationException e) {
            throw new BeanInjectFailException("实例化失败，此类是接口或是抽象类", e);
        } catch (NoSuchFieldException e) {
            throw new BeanInjectFailException("注入失败，类中不包含传入字段集的相关字段", e);
        }
    }


}
