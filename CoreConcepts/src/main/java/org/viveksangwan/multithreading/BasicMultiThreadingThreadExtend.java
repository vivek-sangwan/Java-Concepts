package org.viveksangwan.multithreading;

public class BasicMultiThreadingThreadExtend extends Thread{

    @Override
    public void run(){
        Thread.currentThread().setName("BasicMultiThreadingThreadExtend");
        for(int i=0;i<5;i++) System.out.println(Thread.currentThread().getName()+" "+i);
    }
}
