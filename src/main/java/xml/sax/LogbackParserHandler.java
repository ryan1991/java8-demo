package xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LogbackParserHandler extends DefaultHandler {

    private int appenderIndex = 1;
    private Stack<String> appenderStack = new Stack<>();

    private List<String> validAppenderList = Arrays.asList("ALL", "WARN", "ERROR", "LOG_STASH");

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //开始解析book元素的属性
        if(qName.equals("appender")) {
            System.out.println("------------现在开始遍历第" + appenderIndex + "appender---------");
            String name = attributes.getValue("name");
            String className = attributes.getValue("class");
            System.out.println("appender name：" + name + ", class:"+ className);
            if (validAppenderList.contains(name)){
                appenderStack.push(name);
                return;
            }

        }else if(!qName.equals("appender") && !qName.equals("configuration")){
            System.out.println("节点名是" + qName);
        }

    }

    /**
     * 用来遍历xml文件的结束标签
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals("appender")) {
            System.out.println("结束遍历 第"+ appenderIndex ++ + " appender");
        }
    }
    /**
     * 用来表示解析开始
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("logback解析开始");
    }
    /**
     * 用来表示解析结束
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("logback解析结束");
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        //通过trim()截掉空格和换行符，如果是空字符则跳过if执行语句
        if(!value.trim().equals(""))
            System.out.println("节点值为" + value);
    }
}
