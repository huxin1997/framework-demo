import cn.heshiqian.framework.bean.AbstractBeanFactory;
import org.junit.Test;

public class BeanPackageTest {

    @Test
    public void t1(){

        AbstractBeanFactory abstractBeanFactory = new AbstractBeanFactory();
        Stu stu = abstractBeanFactory.newBean(Stu.class);
        System.out.println(stu.toString());
    }


    public abstract class Stu{
        public Stu() {
        }
    }

}
