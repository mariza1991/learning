package multithreading.threadsafe;

public class GetInfo {

    public void setAsFive() {
        ThreadSafe.setThreadSafeVar(5);
        System.out.println("Method set as five:" + ThreadSafe.getThreadSafeVar());
        ThreadSafe.setDefault();
    }

    public void setAsThree() {
        ThreadSafe.setThreadSafeVar(3);
        System.out.println("Method set as three:" + ThreadSafe.getThreadSafeVar());
        ThreadSafe.setDefault();
    }

    public void setAsFour() {
        ThreadSafe.setThreadSafeVar(4);
        System.out.println("Method set as four:" + ThreadSafe.getThreadSafeVar());
        ThreadSafe.setDefault();
    }

}
