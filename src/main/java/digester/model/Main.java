package digester.model;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.Rule;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating(false);
//        digester.addObjectCreate("web-app/servlet", ServletBean.class);
//        digester.addCallMethod("web-app/servlet/servlet-name", "setServletName", 0);
//        digester.addCallMethod("web-app/servlet/servlet-name", "setServletClass", 0);
//        digester.addCallMethod("web-app/servlet/init-param", "addInitParam", 2);
//        digester.addCallParam("web-app/servlet/init-param/param-name", 0);
//        digester.addCallParam("web-app/servlet/init-param/param-value", 1);

//        ServletBean servletBean = digester.parse(Main.class.getClassLoader().getResourceAsStream("web.xml"));
//        System.out.println(servletBean);

        digester.addRule("web-app/servlet/servlet-class", new Rule() {
            @Override
            public void body(String namespace, String name, String text) throws Exception {
                System.out.println(text);
            }
        });

        digester.parse(Main.class.getClassLoader().getResourceAsStream("web.xml"));

    }

}
