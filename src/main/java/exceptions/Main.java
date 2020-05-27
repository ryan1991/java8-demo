package exceptions;

public class Main {

    public static void main(String[] args)  {
        try {
            testException();
        }finally {
            System.out.println("null");
        }

    }

    public static void testException(){
        throw new NullPointerException();
    }
}
