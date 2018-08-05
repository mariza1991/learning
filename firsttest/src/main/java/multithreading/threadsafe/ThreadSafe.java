package multithreading.threadsafe;

public class ThreadSafe {

    static Integer threadSafeVar;

    public static void setThreadSafeVar(Integer value){
        threadSafeVar = value;
        print(threadSafeVar);
    }

    public static Integer getThreadSafeVar(){
        return threadSafeVar;
    }

    public static void setDefault(){
        threadSafeVar = 0;
        print(threadSafeVar);
    }

    private static void print(Integer value){
        System.out.println("Thread safe variable is " + value);
    }
}
