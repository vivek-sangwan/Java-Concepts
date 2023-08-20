package org.viveksangwan.multithreading.printevenodd;

public class PrinterService implements Runnable{
    private int number;
    private final int limit;
    private final int steps;
    private final State state;

    private final PrinterType currentPrinterType;

    private final PrinterType nextPrinterType;

    public PrinterService(final PrinterType currentPrinterType, final PrinterType nextPrinterType,
                          final int number,final int limit, final int steps,final State state){
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.limit = limit;
        this.steps = steps;
        this.state = state;
        this.number = number;
    }

    @Override
    public void run() {
        while(number<=limit){
            synchronized (state){
                while(state.getNextPrinterType()!=currentPrinterType){
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(currentPrinterType+" : "+number);
                number += steps;
                state.setNextPrinterType(nextPrinterType);
                state.notifyAll();
            }
        }
    }
}
