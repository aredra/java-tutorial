package lambda;

public class TestMyNumber {
    public static void main(String[] args) {
        MyMaxNumber max = Math::max;
        System.out.println(max.getMaxNumber(10, 20));
    }
}
