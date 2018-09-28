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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class XmlBeanReaderImpl implements XmlBeanReader {

    private static String xmlPath;
    private static SAXReader reader = new SAXReader();
    private Document xml;

    private static HashMap<String, HashMap<String, String>> beanList = new HashMap<>();

    @SuppressWarnings("all")
    @Override
    public void read(String xmlPath) {
        if (this.xmlPath == null) {
            this.xmlPath = xmlPath;
            parseXml();
        } else
            throw new XmlBeanParseException("重复读取xml文件！");
    }

    @Override
    public void read() {
        if (xml == null)
            parseXml();
        else
            throw new XmlBeanParseException("重复读取xml文件！");
    }

    @Override
    public Object getBean(String id) {
        Util.assertNull(id);
        HashMap<String, String> keyV = beanList.get("$" + id);
        return BeanFactory.injectBean(keyV.get("class"), null);
    }

    @SuppressWarnings("all")
    @Override
    public void parseXml() {
        URL resource;
        if (xmlPath != null)
            resource = Thread.currentThread().getContextClassLoader().getResource(xmlPath);
        else
            resource = Thread.currentThread().getContextClassLoader().getResource("beans.xml");

        Util.assertNull(resource, "找不到beans.xml，请检查文件位置！");

        try {
            xml = reader.read(resource);
        } catch (DocumentException e) {
            throw new XmlBeanParseException("读取XML时发生错误！", e);
        }

        Iterator<Element> bean = xml.getRootElement().elements("bean").iterator();
        while (bean.hasNext()) {
            Element element = bean.next();
            Iterator<Attribute> iterator = element.attributeIterator();
            HashMap<String, String> temp = new HashMap<>();
            while (iterator.hasNext()) {
                Attribute attribute = iterator.next();
                temp.put(attribute.getName(), attribute.getValue());
            }
            beanList.put("$" + temp.get("id"), temp);
        }

    }

    @Override
    public void showBeanList() {
        System.out.println(beanList.toString());
    }


}
