package array;

public class StudentTest {
    public static void main(String[] args) {
        Student aredra = new Student(13, "aredra");
        aredra.addSubject("math", 80);
        aredra.addSubject("magic", 99);
        aredra.showStudentInfo();
        aredra.addSubject("history", 85);
        aredra.showStudentInfo();
        aredra.addBook("Harry Potter", "J. K. Rowling");
        aredra.addBook("The Lord of the Rings", "J. R. R. T");
        aredra.addBook("O Alquimista", "Paulo Coelho");
        aredra.showBookList();
    }
}
