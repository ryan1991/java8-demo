package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.moreimpl.BizService;
import guice.moreimpl.Modules;


public class Client {




    public static void main(String[] args) {

        Injector context = Guice.createInjector(new Modules());
        HelloServiceHolder holder = context.getInstance(HelloServiceHolder.class);
        holder.hello();


        BizService bizService = context.getInstance(BizService.class);
        bizService.process();

    }


}
