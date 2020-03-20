package regex;

import java.util.regex.Pattern;

public class Regexs {
    public static void main(String[] args) {
        String content = "[P1] [Heartbeat] [集群: cat-alarm] [监控项: 最近三分钟内FullGC次数过多告警 (prodops-cat-alarm-service001-jvm.gc-jvm.fullgc.count)][当前值: 0 ]触发规则: [最新3个点求和（1）>= 1.0 ][时间: 2020-01-09 00:35:10] ";
        String content1 = "[P1] [Problem] [集群: pangu] [监控项: 异常告警兜底策略][当前值: 216 ]触发规则: [最新1个点内，所有值 >= 200.0 ][时间: 2020-01-11 16:41:10] @周凯东  ";
        String content2 = "【Kafka消费积压告警】当前积压:1,011,968,913 " +
                "  应用: \n" +
                "  Topic: YPP-BURYING-POINT\n" +
                "  Group: tablestore-group\n" +
                "  kafka集群: 大数据&算法\n" +
                "消费积压过长会导致重复消费，请及时检查消费状态\n" +
                "此消费为默认告警设置, 如需调整请联系付晓磊";
        //正则特殊字符加转译
        boolean isMatched = Pattern.matches("(?s).*Kafka消费积压告警.*", content2);

        System.out.println(isMatched);

    }
}
