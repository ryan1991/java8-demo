package guice;

import javax.inject.Singleton;

@Singleton
public class HelloService {

    public void sayHello(){
        System.out.println("hello");
    }

}
