package org.viveksangwan.multithreading.printevenodd;

public class Main {
    public static void main(String[] args) {
        final int limit = 20;
        final int steps = 1;
        final State state = new State(PrinterType.OddPrinter);
        final PrinterService evenNumberPrintService = new PrinterService(PrinterType.EvenPrinter,
                PrinterType.OddPrinter,2,limit,steps,state);
        final PrinterService oddNumberPrintService = new PrinterService(PrinterType.OddPrinter,PrinterType.EvenPrinter,
                1,limit,steps,state);

        final Thread evenThread = new Thread(evenNumberPrintService);
        final Thread oddThread = new Thread(oddNumberPrintService);
        evenThread.start();
        oddThread.start();
    }
}
