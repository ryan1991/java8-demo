package strings;

import java.util.Arrays;
import java.util.UUID;

public class StringUtils {

    private final static String  DISPATCH_ERROR_CONTENT = "下发Task调度消息失败,AppId[%s],JobId[%s],TaskId[%s]";

    private static final String NAMESPACE_PREFIX_SENTINEL = "middleware.sentinel.";
    private static final int SYN_CONSUMER_LOCK_SIZE = 1 << 5;
    public static void main(String[] args) {

        System.out.println(String.format(DISPATCH_ERROR_CONTENT, "maserati-web",null,""));

//        extractApp("middleware.sentinel.aries-web");


        int hash = "1011000069020170446".hashCode();
        System.out.println("hash:"+ hash % 6);

        System.out.println(round("29.01"));

        System.out.println("version compare:" + ("1.2.5.2-SNAPSHOT".compareTo("1.2.4.2") > 0));

        System.out.println("UUID:" + UUID.randomUUID().toString());

        int i = (int) Double.parseDouble("2.0000");
        System.out.println("i:" + i);

        System.out.println("lock size:" + SYN_CONSUMER_LOCK_SIZE);
        System.out.println("monthAndDay:" + extractMonthDay("2020-06-06"));

        String origin = originCrash();
        Arrays.stream(origin.split("\n")).forEach(s -> System.out.println(s + "||||"));

        System.out.println("file uuid:"+Math.abs(UUID.randomUUID().getMostSignificantBits()));

    }

    public static String extractApp(String namespace){
        return namespace.substring(NAMESPACE_PREFIX_SENTINEL.length());
    }


    private static String round(String metric){
        return metric.substring(0, metric.indexOf("."));
    }

    private static String extractMonthDay(String date){
        return date.substring(date.indexOf("-") + 1);
    }


    private static String originCrash(){
        return "0x00000001a5231994 cpsr: 0x0000000060000000 Binary Images: 0x102150000 - 0x104d2ffff +YppLife arm64 <06bb400f93a43bf8bbbb45ca86ed155f> /private/var/containers/Bundle/Application/0CB7C1C2-81DD-4F53-BA55-FA4EEFBB0566/YppLife.app/YppLife 0x105be0000 - 0x105bebfff MapiSignFramework arm64 <26df349ccbb23a689aa0502e5633cfa5> /private/var/containers/Bundle/Application/0CB7C1C2-81DD-4F53-BA55-FA4EEFBB0566/YppLife.app/Frameworks/MapiSignFramework.framework/MapiSignFramework 0x105ee0000 - 0x105f67fff HelpDesk arm64 <e7b63b091cc93e3493173bfdd5080e44> /private/var/containers/Bundle/Application/0CB7C1C2-81DD-4F53-BA55-FA4EEFBB0566/YppLife.app/Frameworks/HelpDesk.framework/HelpDesk 0x105fdc000 - 0x10672ffff Hyphenate arm64";
    }
}
