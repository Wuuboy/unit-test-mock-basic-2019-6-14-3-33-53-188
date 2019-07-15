package cashregister;

public class FakePrinter extends Printer{
    private boolean isCalled;
    private String text;

    @Override
    public void print(String printThis) {
        isCalled = true;
        text = printThis;
    }

    public Boolean printMethodIsCalled(){
        return isCalled;
    }

    public String printedString() {
        return text;
    }
}
