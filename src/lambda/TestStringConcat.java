package lambda;

//public class TestStringConcat implements StringConcat{
//    @Override
//    public void makeString(String s1, String s2) {
//        System.out.println(s1 + "" + s2);
//    }
//}

public class TestStringConcat {
    public static void main(String[] args) {
        StringConcat concat = (s, v) -> System.out.println(s+""+v);
        concat.makeString("are", "dra");

//        StringConcat concat2 = new StringConcat() {
//            @Override
//            public void makeString(String s1, String s2) {
//                System.out.println(s1+""+s2);
//            }
//        }
    }
}