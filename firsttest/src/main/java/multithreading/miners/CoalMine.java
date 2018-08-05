package multithreading.miners;

import static java.lang.Thread.sleep;

public class CoalMine {

    private static Integer capacity = 1000;

    //https://github.com/otus-qa/Autotest2018-03/blob/master/TestClass
    public static synchronized Integer getCapacityAndDecreaseByTen() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        return capacity-=10; //capacity = capacity - 10;
    }

}
