package org.viveksangwan.multithreading.printevenodd;

public class ExercisePrintEvenOddWithDifferentThreads {
    private static volatile int number = 0;
    private static String evenThreadName = "EvenThread";
    private static String oddThreadName = "OddThread";
    private static volatile Object lock = new Object();
    public static void main(String[] args){
        System.out.println("Start of Exercise");
        ExercisePrintEvenOddWithDifferentThreads exercise = new ExercisePrintEvenOddWithDifferentThreads();
        Thread evenThread = new Thread(()->{
            exercise.printEvenNumber();
        },evenThreadName);
        Thread oddThread = new Thread(()->{
            exercise.printOddNumber();
        },oddThreadName);
        evenThread.start();
        oddThread.start();
        System.out.println("End of Exercise");
    }
    private void printOddNumber(){
        synchronized (lock){
            while(number<=10){
                while(number%2==0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+" : "+number++);
                lock.notify();
            }
        }
    }
    private void printEvenNumber(){
        synchronized (lock){
            while(number<=10){
                while(number%2!=0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+" : "+number++);
                lock.notify();
            }
        }
    }
}
