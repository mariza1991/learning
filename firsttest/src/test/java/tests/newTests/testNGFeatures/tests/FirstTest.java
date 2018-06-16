package tests.newTests.testNGFeatures.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.newTests.testNGFeatures.listeners.TestAnnotationListener;

@Listeners(TestAnnotationListener.class)
public class FirstTest {

    @Test(groups = {"ui", "weekend"})
    public void test(){
        System.out.println("some text");
    }
}
