package numberprinter;

public class HelloPrinterThreadExtend extends Thread {

    HelloPrinterThreadExtend(int number) {
        System.out.println("Constructor");
    }
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
