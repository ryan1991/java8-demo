package guice;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HelloServiceHolder {

    @Inject
    private HelloService helloService;

    public void hello(){
        helloService.sayHello();
    }
}
