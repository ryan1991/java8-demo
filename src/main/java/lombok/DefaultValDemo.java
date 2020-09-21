package lombok;

public class DefaultValDemo {
    public static void main(String[] args) {

        DefaultVal defaultVal = DefaultVal.builder().build();
        System.out.println(defaultVal.getValue());

    }

    @Builder
    @Getter
    private static class DefaultVal{

        /**
         * Builder.Default 注解后，builder有默认值
         */
        @Builder.Default
        private int value = 5;

    }

}
