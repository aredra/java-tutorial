package beginJava;

public class Student {
    private int studentID;
    private String studentName;
    private String address;

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
}
