package innerclass;

class Outer{
    int outNum = 100;
    static int sNum = 200;

    // 전부 변수가 상수가 됨 final 생략 가능
    Runnable getRunnable(int i) {
        int num = 300;

        //Local inner class
        class MyRunnable implements Runnable{
            @Override
            public void run() {
                //Class 반환 시 언제든 호출 가능하여 불가능
//                num += 10;
//                i = 200;

                System.out.println(num);
                System.out.println(i);
                System.out.println(outNum);
                System.out.println(Outer.sNum);
            }
        }
        return new MyRunnable();
    }
}

public class LocalInnerClassTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Runnable runnable = outer.getRunnable(50);

        runnable.run();
    }
}
