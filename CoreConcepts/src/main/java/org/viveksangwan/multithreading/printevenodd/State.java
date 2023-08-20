package org.viveksangwan.multithreading.printevenodd;

public class State {
    private PrinterType nextPrinterType;

    public State( PrinterType nextPrinterType) {
        this.nextPrinterType = nextPrinterType;
    }

    public PrinterType getNextPrinterType() {
        return nextPrinterType;
    }

    public void setNextPrinterType(PrinterType nextPrinterType) {
        this.nextPrinterType = nextPrinterType;
    }
}
