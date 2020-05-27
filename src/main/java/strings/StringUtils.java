package strings;

import java.util.UUID;

public class StringUtils {

    private final static String  DISPATCH_ERROR_CONTENT = "下发Task调度消息失败,AppId[%s],JobId[%s],TaskId[%s]";

    private static final String NAMESPACE_PREFIX_SENTINEL = "middleware.sentinel.";
    public static void main(String[] args) {

        System.out.println(String.format(DISPATCH_ERROR_CONTENT, "maserati-web",null,""));

//        extractApp("middleware.sentinel.aries-web");


        int hash = "1011000069020170446".hashCode();
        System.out.println("hash:"+ hash % 6);

        System.out.println(round("29.01"));

        System.out.println("version compare:" + ("1.2.5.2-SNAPSHOT".compareTo("1.2.4.2") > 0));

        System.out.println("UUID:" + UUID.randomUUID().toString());
    }

    public static String extractApp(String namespace){
        return namespace.substring(NAMESPACE_PREFIX_SENTINEL.length());
    }


    private static String round(String metric){
        return metric.substring(0, metric.indexOf("."));
    }


}
