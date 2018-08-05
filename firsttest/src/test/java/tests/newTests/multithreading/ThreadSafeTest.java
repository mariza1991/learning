package tests.newTests.multithreading;

import multithreading.threadsafe.GetInfo;
import org.testng.annotations.Test;

public class ThreadSafeTest {

    @Test
    public void test1(){
        System.out.println("1");
        GetInfo gits = new GetInfo();
        gits.setAsThree();
    }

    @Test
    public void test2(){
        System.out.println("2");
        GetInfo gits = new GetInfo();
        gits.setAsFour();
    }

    @Test
    public void test3(){
        System.out.println("3");
        GetInfo gits = new GetInfo();
        gits.setAsFive();
    }
}
