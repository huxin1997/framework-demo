package cn.heshiqian.framework.bean;

import cn.heshiqian.framework.util.Util;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class XmlBeanReaderImpl implements XmlBeanReader {

    private static String xmlPath;
    private static SAXReader reader=new SAXReader();
    private Document xml;

    @SuppressWarnings("all")
    @Override
    public void read(String xmlPath) {
        this.xmlPath=xmlPath;
        parseXml();
    }

    @Override
    public void read() {
        parseXml();
    }

    @Override
    public void getBean(String id) {

    }

    @Override
    public void parseXml() {
        URL resource;
        if(xmlPath!=null)
            resource = Thread.currentThread().getContextClassLoader().getResource(xmlPath);
        else
            resource = Thread.currentThread().getContextClassLoader().getResource("beans.xml");

        Util.assertNull(resource,"找不到beans.xml，请检查文件位置！");

        try {
            xml = reader.read(resource);
        } catch (DocumentException e) {
            throw new XmlBeanParseException("读取XML时发生错误！",e);
        }

        Iterator<Element> bean = xml.getRootElement().elements("bean").iterator();

        while (bean.hasNext()){
            Element element = bean.next();
            System.out.println(element.getName()+"{");
            Iterator<Attribute> iterator = element.attributeIterator();
            while (iterator.hasNext()){
                Attribute attribute = iterator.next();
                System.out.println("    "+attribute.getName()+"=="+attribute.getValue());
            }
            System.out.println("}");
        }

    }




}
