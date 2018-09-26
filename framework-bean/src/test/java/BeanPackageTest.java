import cn.heshiqian.framework.bean.AbstractBeanFactory;
import cn.heshiqian.framework.bean.XmlBeanReaderImpl;
import org.junit.Test;

public class BeanPackageTest {

    @Test
    public void t1(){

//        AbstractBeanFactory abstractBeanFactory = new AbstractBeanFactory();
//        a stu = abstractBeanFactory.newBean(a.class);
//        System.out.println(stu.toString());


        XmlBeanReaderImpl xmlBeanReader = new XmlBeanReaderImpl();
        xmlBeanReader.read();

    }




}
