package cn.heshiqian.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface BeanField {
    String key();
    String val();
}
