package innerclass;

class Outer2{
    int outNum = 100;
    static int sNum = 200;

    // 전부 변수가 상수가 됨 final 생략 가능
    Runnable getRunnable(int i) {
        int num = 300;

        return new Runnable() {
            @Override
            public void run() {
                System.out.println(num);
                System.out.println(i);
                System.out.println(outNum);
                System.out.println(Outer.sNum);
            }
        };
    }

    //interface, abstract 를 1개만 받을 경우 아래와 같이 생성 가능
    Runnable runner = new Runnable() {
        @Override
        public void run() {
            System.out.println("test");
        }
    };
}

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.runner.run();
        Runnable runnable = outer.getRunnable(50);

        runnable.run();

    }
}
