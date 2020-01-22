package lambda;

@FunctionalInterface
interface PrintString {
    void showString(String str, int i);
}

public class TestLambda {
    public static void main(String[] args) {
        PrintString lambdaStr = (str, i) -> System.out.println(str);
        lambdaStr.showString("Test", 1);

        showMyString(lambdaStr);

        PrintString test = returnString();
        test.showString("TEST3", 3);
    }

    public static void showMyString(PrintString p) {
        p.showString("test2", 2);
    }

    public static PrintString returnString() {
        return (s, i) -> System.out.println(s + "!!!!!!!" + i);
    }
}
