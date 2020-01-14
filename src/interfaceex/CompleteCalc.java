package interfaceex;

public class CompleteCalc extends Calculator {
    @Override
    public int times(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        return num2 == 0 ? ERROR : num1/num2;
    }

    public void showInfo() {
        System.out.println("Success");
    }

    @Override
    public void description() {
        System.out.println("Override Calculator");
    }
}
