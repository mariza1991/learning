package multithreading.miners.miner;

import multithreading.miners.CoalMine;

import static java.lang.Thread.sleep;

public class CoalMiner implements Runnable {

    static boolean shouldTheJobBeFinished = false;

    int workerId;

    public CoalMiner(int workerId) {
        this.workerId = workerId;
    }

    public void atWork() {
        int leftCapacity = CoalMine.getCapacityAndDecreaseByTen();
/**
        try {
            sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }*/
        if(leftCapacity == 0) {
            shouldTheJobBeFinished = true;
            return;
        }
        System.out.println("How much coal left " + leftCapacity + " miner " + workerId);
    }

    public void run() {
        long startTimer = System.currentTimeMillis();
        try {
            sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        while(!shouldTheJobBeFinished) {
            atWork();
        }
        long endTimer = System.currentTimeMillis();
        long finishedTime = endTimer - startTimer;
        System.out.println("Miner ID " + workerId + ". Finished the job by time " + finishedTime);
    }
}
