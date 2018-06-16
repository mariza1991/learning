package tests.newTests.testNGFeatures.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestAnnotationListener implements IAnnotationTransformer {

    //run tests in appropriate days - like CRON
    @Override
    public void transform(ITestAnnotation iTestAnnotation,
                          Class aClass,
                          Constructor constructor,
                          Method method) {
        if(Arrays.toString(iTestAnnotation.getGroups()).contains("weekend")) {
            iTestAnnotation.setEnabled(false);
        }
    }
}
