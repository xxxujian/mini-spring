package com.minis;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ClassPathXmlApplicationContext {
   private List<BeanDefination> beanDefinations = new ArrayList<>();
    private Map<String, Object> singletons = new HashMap<>();
    public ClassPathXmlApplicationContext(String fileName) {
        this.readXml(fileName);
        this.instanceBeans();
    }

    private void readXml(String fileName) {
        SAXReader sr = new SAXReader();

        try {
            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
            Document document = sr.read(xmlPath);

            Element rooElement = document.getRootElement();
            for (Element element : (List<Element>) rooElement.elements()) {
                String beanID = element.attributeValue("id");
                String beanClassName = element.attributeValue("class");

                BeanDefination beanDefination = new BeanDefination(beanID, beanClassName);

                beanDefinations.add(beanDefination);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void instanceBeans() {
        for (BeanDefination beanDefination : beanDefinations) {
            try {
                singletons.put(beanDefination.getId(), Class.forName(beanDefination.getClassName()).newInstance());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }
}
