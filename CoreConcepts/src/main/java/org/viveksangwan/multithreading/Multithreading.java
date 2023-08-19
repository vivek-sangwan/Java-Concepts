package org.viveksangwan.multithreading;

public class Multithreading {
    public static void main(String[] args){
        BasicMultiThreadingThreadExtend basicMultiThreadingThreadExtend = new BasicMultiThreadingThreadExtend();
//        basicMultiThreadingThreadExtend.run();
        BasicMultiThreadingImplRunnable basicMultiThreadingImplRunnable = new BasicMultiThreadingImplRunnable();
//        basicMultiThreadingImplRunnable.run();

//      Implementing a Runnable Interface
        Runnable th = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++) System.out.println(i);
            }
        };
//        th.run();

//      Implementing a Runnable Interface with lambda
      Runnable th2 = ()->{
            for(int i=0;i<5;i++) System.out.println(i);
        };
        th2.run();
    }
}
