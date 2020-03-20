package strings;

public class StringUtils {

    private final static String  DISPATCH_ERROR_CONTENT = "下发Task调度消息失败,AppId[%s],JobId[%s],TaskId[%s]";

    private static final String NAMESPACE_PREFIX_SENTINEL = "middleware.sentinel.";
    public static void main(String[] args) {

        System.out.println(String.format(DISPATCH_ERROR_CONTENT, "maserati-web",null,""));

        extractApp("middleware.sentinel.aries-web");

    }

    public static String extractApp(String namespace){
        return namespace.substring(NAMESPACE_PREFIX_SENTINEL.length());
    }



}
