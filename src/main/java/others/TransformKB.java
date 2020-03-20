package others;

public class TransformKB {

    public static void main(String[] args) {

        System.out.println(transformByte("10GB"));

        String source = "${logger.dir}/${applicationName}/warn-%d{yyyy-MM-dd-HH}.log.gz";
        System.out.println(isGz(source));

    }

    private static long transformByte(String source){
        if (source.contains("KB")){
            return Long.parseLong(source.replaceAll("KB", ""));
        }

        if (source.contains("MB")){
            return Long.parseLong(source.replaceAll("MB", "")) * 1024;
        }

        if (source.contains("GB")){
            return Long.parseLong(source.replaceAll("GB", "")) * 1024 * 1024;
        }

        throw new IllegalArgumentException("max file size error");
    }


    private static boolean isGz(String source){
        String suffix = source.substring(source.lastIndexOf("."));
        System.out.println(suffix);
        return ".gz".equals(suffix);
    }
}
