package jmx;

public class Hello implements  HelloMBean {

    private String name;

    public Hello(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void hello(String msg) {
        System.out.println(name + ": hello "+msg);
    }
}
