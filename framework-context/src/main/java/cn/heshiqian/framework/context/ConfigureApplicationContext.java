package cn.heshiqian.framework.context;

public class ConfigureApplicationContext extends ApplicationContext {



    private ConfigureApplicationContext() {
    }

    public ConfigureApplicationContext(Class configureClass){
        this.configurationClass=configureClass;
        syncConfigureClass();
    }

    @Override
    protected Object getBean0(String name) {
        return null;
    }

    @Override
    protected <T> T getBean0(Class<T> tClass) {
        return null;
    }

}
