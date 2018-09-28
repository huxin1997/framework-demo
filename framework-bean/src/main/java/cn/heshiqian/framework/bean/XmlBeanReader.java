package cn.heshiqian.framework.bean;

public interface XmlBeanReader {


    void read(String xmlPath);

    void read();

    Object getBean(String id);

    void parseXml();

    void showBeanList();

}
