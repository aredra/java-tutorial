package objectex;

class Student {
    int studentNum;
    String studentName;

    public Student(int num, String name) {
        this.studentName = name;
        this.studentNum = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student std = (Student)obj;
            return (this.studentNum == std.studentNum && this.studentName.equals(std.studentName));
        }
        return false;
    }
}

public class EqualsTest {
    public static void main(String[] args) {
        //String str1 = new String("abc");
        //String str2 = new String("abc");

        //이럴 경우 모두 true 이유는?? 같은 주소를 참고하나? 누가 어떻게?
        String str1 = "abc";
        String str2 = "abc";

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        Student std1 = new Student(100, "aredra");
        Student std2 = std1;
        Student std3 = new Student(100, "aredra");

        System.out.println(std1 == std2);
        System.out.println(std1 == std3);
        System.out.println(std1.equals(std3));
    }
}
