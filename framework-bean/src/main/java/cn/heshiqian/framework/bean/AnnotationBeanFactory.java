package cn.heshiqian.framework.bean;

import cn.heshiqian.framework.bean.annotation.Bean;
import cn.heshiqian.framework.util.Util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationBeanFactory extends AnnotationBean {


    @Override
    protected Object injectBean0(Class beanClass) {
        Object obj = BeanFactory.injectBean(beanClass.getTypeName(), null);

        String classId;
        Bean head = obj.getClass().getAnnotation(Bean.class);
        if(head==null||head.value().trim().equals(""))
            classId=obj.getClass().getSimpleName();
        else
            classId=head.value();

        System.out.println(obj.getClass().getTypeName()+" ID:"+classId+" initialization");

        Field[] declaredFields = obj.getClass().getDeclaredFields();

        for(Field field:declaredFields){
            Bean annotation = field.getAnnotation(Bean.class);
            if(annotation==null)
                continue;
            Util.guessTypeInject(obj,field,annotation.value());
        }
        return obj;
    }
}
