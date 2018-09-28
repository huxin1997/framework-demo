package cn.heshiqian.framework.util;

import java.lang.reflect.Field;

public abstract class Util {


    public static void assertNull(Object o) {
        assertNull(o, "传入对象可能为空！");
    }

    public static void assertNull(Object... o) {
        for (Object obj : o)
            assertNull(obj, "传入对象可能为空！目标：" + obj.toString());
    }

    public static void assertNull(Object o, String message) {
        if (o == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void guessTypeInject(Object target, Field field, String val) {

        String type = field.getType().getTypeName();
        field.setAccessible(true);
        try {

            if(type.equals("int")){
                field.set(target, Integer.valueOf(val));
            }else if(type.equals("double")){
                field.set(target, Double.valueOf(val));
            }else if(type.equals("float")){
                field.set(target, Float.valueOf(val));
            }else if(type.equals("boolean")){
                field.set(target, Boolean.valueOf(val));
            }

            if (type.equals(String.class.getTypeName())) {
                field.set(target, String.valueOf(val));
            } else if (type.equals(Integer.class.getTypeName())) {
                field.set(target, Integer.valueOf(val));
            } else if (type.equals(Boolean.class.getTypeName())) {
                field.set(target, Boolean.valueOf(val));
            } else if (type.equals(Float.class.getTypeName())) {
                field.set(target, Float.valueOf(val));
            } else if (type.equals(Double.class.getTypeName())) {
                field.set(target, Double.valueOf(val));
            }

        } catch (IllegalArgumentException e) {
            throw new TypeNotCastException("参数有误，可能转换类型错误！请检查参数类型是否与字段相同或是子类",e);
        } catch (IllegalAccessException e) {
            throw new TypeNotCastException("参数不可访问",e);
        }

    }

}
