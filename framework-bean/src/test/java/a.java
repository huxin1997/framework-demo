import cn.heshiqian.framework.bean.annotation.Bean;

@Bean(value = "$a")
public class a {

    @Bean(value = "12")
    int name;

    public a(){
//        int a=1/0;
    }

    @Override
    public String toString() {
        return "a{" +
                "name=" + name +
                '}';
    }
}
