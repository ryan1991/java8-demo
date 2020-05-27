package pattern;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * 靓号
 */
public class BeautifulNumber {

    public static void main(String[] args) {
        List<String> patterns = Arrays.asList("([\\d])\\1{3,}",
                "(\\d)\\1((?!\\1)\\d)\\2",
                "(\\d\\d)\\1",
                "\\d*(\\d)\\1\\1(\\d)\\2\\2\\d*",
                "^(19[7-9]\\d|20\\d\\d)\\d*",
                "^[1-9](19[7-9]\\d|20\\d\\d)(1[0-2]|0\\d)(0\\d|[1-2]\\d|3[0-1])$|^(19[7-9]\\d|20\\d\\d)(1[0-2]|0\\d)(0\\d|[1-2]\\d|3[0-1])\\d$",
                "d*(520|521|1314|3344|5299|2099|920|921|9120|9121|214)d*",
                "(\\d)(\\d\\d\\d)\\1\\2",
                "(\\d)(\\d\\d)\\1\\2",
                "(\\d)(\\d)(\\d)\\1\\2\\3",
                "((?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){2}\\d){2}",
                "(\\d)(\\d)\\2\\1\\2\\2",
                "(\\d)\\1(\\d)\\1\\1\\2",
                "(\\d)\\1((?!\\1)\\d)\\2((?!\\1)\\d)\\3",
                "(\\d)((?!\\1)\\d)\\1\\2\\1\\2",
                "(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){3}\\d",
                "(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){3}\\d",
                "(\\d\\d)\\1\\1",
                "(\\d)(\\d)(\\d)(\\d)\\1\\2\\3\\4"
                );


        List<Long> longs = getBeautifulIds(patterns, 10022000, 2000000);
        System.out.println("long.size:" + longs.size() + ", data:" + longs);

    }

    public static List<Long> buildId(List<String> patterns, long startId, int allocCount, boolean shuffle) {
        long endId = startId + allocCount;
        List<Long> list = LongStream.range(startId, endId).map(num -> {
            for (String pattern : patterns) {
                Pattern pa = Pattern.compile(pattern);
                String mc = String.valueOf(num);
                Matcher ma = pa.matcher(mc);
                boolean match = ma.find();
                if (match) {
                    return 0L;
                }
            }
            return num;
        }).filter(id -> id != 0L).boxed().collect(Collectors.toList());
        if (shuffle) {
            Collections.shuffle(list);
        }
        return list;
    }

    private static List<Long> getBeautifulIds(List<String> patterns, long startId, int allocCount){
        long endId = startId + allocCount;
        return LongStream.range(startId, endId).filter(id -> isMatch(patterns, id)).boxed().collect(Collectors.toList());
    }

    private static boolean isMatch(List<String> patterns, long num){
        for (String pattern : patterns) {
            Pattern pa = Pattern.compile(pattern);
            String mc = String.valueOf(num);
            Matcher ma = pa.matcher(mc);
            boolean match = ma.find();
            if (match) {
                return true;
            }
        }
        return false;

    }

}
