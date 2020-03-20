package xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookParserHandler extends DefaultHandler {
    private volatile int bookindex = 1;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //开始解析book元素的属性
        if(qName.equals("book")) {
            System.out.println("------------现在开始遍历第" + bookindex + "本书---------");
            //已知book元素下属性的名称，根据名称获取属性值
            String value = attributes.getValue("id");
            System.out.println("book的属性值是：" + value);
            //不知道book元素下属性的名称以及个数，如何获取元素名称及属性
            int num = attributes.getLength();
            for(int i = 0;i < num;i++) {
                System.out.print("第" + (i + 1) + "个book元素的属性名是" + attributes.getQName(i));
                System.out.println("----book元素的属性值是" + attributes.getValue(i));
            }
        }else if(!qName.equals("book") && !qName.equals("bookstore")){
            System.out.print("节点名是" + qName);
        }

    }

    /**
     * 用来遍历xml文件的结束标签
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // TODO Auto-generated method stub
        super.endElement(uri, localName, qName);
        if(qName.equals("book")) {
            System.out.println("------------结束遍历第" + bookindex++ + "本书---------");
        }
    }
    /**
     * 用来表示解析开始
     */
    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.startDocument();
        System.out.println("SAX解析开始");
    }
    /**
     * 用来表示解析结束
     */
    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.endDocument();
        System.out.println("SAX解析结束");
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // TODO Auto-generated method stub
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        //通过trim()截掉空格和换行符，如果是空字符则跳过if执行语句
        if(!value.trim().equals(""))
            System.out.println("节点值为" + value);
    }
}
