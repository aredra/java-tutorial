package beginJava;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student.getSerialNum();
        Student student2 = new Student(23, "jy", "Busan");
        Student.getSerialNum();
        student1.setStudentName("Aredra");
        student1.setAddress("Seoul");
        student1.setStudentID(1);

        student1.showStudentInfo();

        Person person1 = new Person(20, "Aredra", true);
        person1.showPersonInfo();

        Order order1 = new Order();
        order1.setOrderId(201910202);
        order1.setItemId("blah");
        order1.setOrderAddress("EveryWhere~~");
        order1.setRegDate("now");
        order1.setUserId("aredra");
        order1.setUserName("Are");
        order1.showOrderInfo();
    }
}
