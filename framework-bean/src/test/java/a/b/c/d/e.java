package a.b.c.d;

import cn.heshiqian.framework.bean.annotation.Bean;

@Bean
public class e {

    @Bean(value = "BKL")
    private String name;
    @Bean(value = "20")
    private int age;
    @Bean(value = "true")
    private boolean sex;

    public e(){
    }

    @Override
    public String toString() {
        return "e{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
