package jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

//参考
public class HelloAgent2 {
    public static void main(String[] args) throws Exception {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        Hello hello = new Hello("songjunbao");
        server.registerMBean(hello, new ObjectName("yunge:name=hello"));

        Jack jack = new Jack();

        server.registerMBean(jack, new ObjectName("jack:name=jack"));
        jack.addNotificationListener(new HelloListener(), null, hello);
        Thread.sleep(600000);

    }

}
