package org.viveksangwan.multithreading;

public class BasicMultiThreadingImplRunnable implements Runnable{
    @Override
    public void run() {
        Thread.currentThread().setName("BasicMultiThreadingImplRunnable");
        for(int i=0;i<5;i++) System.out.println(Thread.currentThread().getName()+" "+i);
    }
}
