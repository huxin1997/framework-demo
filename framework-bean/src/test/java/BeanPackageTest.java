import a.b.c.d.e;
import cn.heshiqian.framework.bean.AbstractBeanFactory;
import cn.heshiqian.framework.bean.AnnotationBean;
import cn.heshiqian.framework.bean.AnnotationBeanFactory;
import cn.heshiqian.framework.bean.XmlBeanReaderImpl;
import org.junit.Test;

public class BeanPackageTest {

    @Test
    public void t1(){

//        AbstractBeanFactory abstractBeanFactory = new AbstractBeanFactory();
//        Object a = abstractBeanFactory.newBean("a");
//        System.out.println(a.toString());
//        XmlBeanReaderImpl xmlBeanReader = new XmlBeanReaderImpl();
//        xmlBeanReader.read();
//        xmlBeanReader.showBeanList();
//
//        Object a = xmlBeanReader.getBean("a");
//        System.out.println(a.toString());

        AnnotationBean annotationBean = new AnnotationBeanFactory();

        Object o = annotationBean.injectBean(e.class);
        System.out.println(o.toString());

    }




}
