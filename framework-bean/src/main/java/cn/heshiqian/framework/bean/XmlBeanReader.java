package cn.heshiqian.framework.bean;

public interface XmlBeanReader {


    void read(String xmlPath);

    void read();

    void getBean(String id);

    void parseXml();

}
