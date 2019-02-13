package lambda;

/**
 * 变量的作用域
 *
 **/
public class LambdaVariableScope {


    public static void main(String[] args) {
        //即隐性的具有 final 的语义
        String salutation = "Hello ";
        GreetingService greetingService = message -> System.out.println(salutation + message);
        greetingService.sayMessage("nike");


    }

    interface GreetingService{
        void sayMessage(String message);

    }

}
