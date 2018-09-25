package cn.heshiqian.framework.util;

public abstract class Util {



    public static void assertNull(Object o){
        assertNull(o,"传入对象可能为空！");
    }

    public static void assertNull(Object o ,String message){
        if(o==null) {
            throw new IllegalArgumentException(message);
        }
    }

}
