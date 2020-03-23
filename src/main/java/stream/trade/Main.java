package stream.trade;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * (1) 找出2011年发生的所有交易，并按交易额排序(从低到高)。
 * (2) 交易员都在哪些不同的城市工作过?
 * (3) 查找所有来自于上海的交易员，并按姓名排序。
 * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
 * (5) 有没有交易员是在南京工作的?
 * (6) 打印生活在上海的交易员的所有交易额。
 * (7) 所有交易中，最高的交易额是多少?
 * (8) 找到交易额最小的交易。
 */
public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = getTransactions();
        List<Transaction> r1 = transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println("r1:" + r1);

        List<String> r2 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println("r2:" + r2);

        List<String> r3 = transactions.stream().filter(t -> "shanghai".equals(t.getTrader().getCity())).map(t -> t.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
        System.out.println("r3:" + r3);


    }


    private static List<Transaction> getTransactions(){
        Trader A = new Trader("A", "shanghai");
        Trader B = new Trader("B", "shanghai");
        Trader C = new Trader("C", "hangzhou");
        Trader D = new Trader("D", "nanjing");

        return Arrays.asList(new Transaction(A, 2011, 300), new Transaction(A, 2012, 200),
                new Transaction(B, 2011, 800), new Transaction(C, 2013, 100),
                new Transaction(D, 2015, 1300));

    }

}
