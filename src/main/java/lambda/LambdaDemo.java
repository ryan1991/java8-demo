package lambda;

/**
 * lambda表达式的重要特征:
 *      1.可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 *      2.可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 *      3.可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 *      4.可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 *
 **/
public class LambdaDemo {

    public static void main(String[] args) {
        LambdaDemo tester = new LambdaDemo();

        MathOperation add = (a, b) -> a + b;
        MathOperation sub = (a, b) -> a - b;
//        MathOperation mul = (int a, int b) ->{ return a * b;};
        MathOperation mul = (a, b) -> a * b;
        MathOperation divide = (a, b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, add));
        System.out.println("10 - 5 = " + tester.operate(10, 5, sub));
        System.out.println("10 x 5 = " + tester.operate(10, 5, mul));
        System.out.println("10 / 5 = " + tester.operate(10, 5, divide));


        GreetingService greetingService1 = message -> System.out.println("Hello " + message);
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);

        greetingService1.sayMessage("nike");
        greetingService2.sayMessage("ua");

    }


    interface MathOperation{
        int operation(int a, int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}
