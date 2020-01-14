package interfaceex;

public class CalcTest {
    public static void main(String[] args) {
        CompleteCalc calc = new CompleteCalc();
        int n1 = 10;
        int n2 = 2;
        int[] arr = {1,2,3,4,5,6,654,32};

        System.out.println(calc.add(n1, n2));
        System.out.println(calc.substract(n1, n2));
        System.out.println(calc.times(n1, n2));
        System.out.println(calc.divide(n1, n2));

        calc.description();
        System.out.println(Calc.total(arr));
    }
}
