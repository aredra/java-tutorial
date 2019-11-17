package beginJava;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setStudentName("Aredra");
        student1.setAddress("Seoul");
        student1.setStudentID(1);

        student1.showStudentInfo();
    }
}
