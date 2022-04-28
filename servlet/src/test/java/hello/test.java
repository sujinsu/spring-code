package hello;


import org.junit.jupiter.api.Test;

public class test {
    @Test
    void test(){
        int a = 1;
        Integer b = a;
        System.out.println("b = " + b);

        int c = b;
        System.out.println("c = " + c);
    }
}
