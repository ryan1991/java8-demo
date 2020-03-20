package xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.*;

public class Dom4jXmlParser {
    private  static  List<String> validAppenderList = Arrays.asList("ALL", "WARN", "ERROR", "LOG_STASH");
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("logback.xml");

        Map<String, Map<String, String>> appenderMap = new HashMap<>();
        Element root = document.getRootElement();
//        System.out.println("根节点的名字是:" + root.getName());
        //获取子节点列表
        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element fistChild = (Element) it.next();
            if (!fistChild.getName().equals("appender")){
                continue;
            }
            String appenderName = fistChild.attributeValue("name");
            if (!validAppenderList.contains(appenderName)){
                continue;
            }

            //获取节点的属性值
//            System.out.println(appenderName);

            //获取子节点的下一级节点
            Iterator iterator = fistChild.elementIterator();
            while (iterator.hasNext()) {
                Element element = (Element) iterator.next();
                String rollPolicy = element.getName();
                if (!"rollingPolicy".equals(rollPolicy)){
                    continue;
                }
//                System.out.println(rollPolicy);
                Iterator rollPolicyIterator = element.elementIterator();
                Map<String, String> rollPolicyMap = new HashMap<>();
                while (rollPolicyIterator.hasNext()){
                    Element rollPolicyChild = (Element) rollPolicyIterator.next();
//                    System.out.println(rollPolicyChild.getName() + ":" +rollPolicyChild.getStringValue());
                    rollPolicyMap.put(rollPolicyChild.getName(), rollPolicyChild.getStringValue());
                    appenderMap.put(appenderName, rollPolicyMap);
                }


            }
        }

        System.out.println(appenderMap);

    }


}
