package beginJava;

public class Student {
    private static int serialNum = 1000;
    private int studentID;
    private String studentName;
    private String address;

    //default constructor
    public Student() {
        this.studentID = serialNum;
        serialNum++;
    }

    public Student(int id, String name, String address) {
        this.studentID = serialNum;
        this.studentName = name;
        this.address = address;
        serialNum++;
    }

    public void showStudentInfo() {
        System.out.println(studentName + ", " + address);
    }
    public void setStudentID(int id) {
        this.studentID = id;
    }
    public int getStudentID() {
        return this.studentID;
    }
    public void setStudentName(String name) {
        this.studentName = name;
    }
    public String getStudentName() {
        return this.studentName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }
    public static int getSerialNum() {
        int i = 0;
        System.out.println("Student's serial no : " + serialNum);
        return serialNum;
    }
}
