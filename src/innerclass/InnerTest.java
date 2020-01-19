package innerclass;

class OutClass {
    private int num = 10;
    private static int sNum = 20;
    private InClass inClass;

    public OutClass() {
        inClass = new InClass();
    }

    //Instance Inner Class
    class InClass {
        int iNum = 100;

        void inTest() {
            System.out.println(num);
            System.out.println(sNum);
        }
    }

    public void usingInner() {
        System.out.println(inClass.iNum);
        inClass.inTest();
    }

    static class StaticInClass {
        int inNum = 1000;
        static int sInNum = 1004;

        void staticIntest() {
            System.out.println(inNum);
            System.out.println(sNum);
        }

        static void sTest() {
            System.out.println(sInNum);
            System.out.println(sNum);
        }
    }
}


public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingInner();

        OutClass.InClass myInClass = outClass.new InClass();
        myInClass.inTest();

        System.out.println();

        OutClass.StaticInClass sInClass = new OutClass.StaticInClass();
        sInClass.staticIntest();
        OutClass.StaticInClass.sTest();
    }
}
