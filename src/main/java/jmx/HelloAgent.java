package jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;


//agent层
public class HelloAgent {
    public static void main(String[] args) throws Exception {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");

        server.registerMBean(new Hello("songjunbao"), helloName);

        Thread.sleep(60*60*1000);


    }

}
