package calcScore.model;

import java.util.ArrayList;
import java.util.List;

public class Student implements IDomainModel {
    private String studentId;
    private String studentName;
    private Department department;
    private List<Score> scores = new ArrayList<>();

    public Student(String studentName) {
        this.studentId = generateId("STU");
        this.studentName = studentName;
    }

    public Student(String studentName, Department department) {
        this.studentId = generateId("STU");
        this.studentName = studentName;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public void addScore(Score score) {
        scores.add(score);
    }
}
