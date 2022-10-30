package calcScore;

import java.util.concurrent.atomic.AtomicReference;

public class Department implements IDomainModel{
    private String departmentId;
    private String departmentName;
    private Subject requiredSubject;

    public Department(String departmentName, Subject requiredSubject) {
        this.departmentId = generateId("DEP");
        this.departmentName = departmentName;
        this.requiredSubject = requiredSubject;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Subject getRequiredSubject() {
        return requiredSubject;
    }

    public void setRequiredSubject(Subject requiredSubject) {
        this.requiredSubject = requiredSubject;
    }

    public String getMajorSubjectGrade(int score) {
        String grade;
        if (score > 95) {
            grade = "S";
        } else if (score > 85) {
            grade = "A";
        } else if (score > 75) {
            grade = "B";
        } else if (score > 65) {
            grade = "C";
        } else if (score > 55) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }

    public String getNormalSubjectGrade(int score) {
        String grade;
        if (score > 90) {
            grade = "S";
        } else if (score > 80) {
            grade = "A";
        } else if (score > 70) {
            grade = "B";
        } else if (score > 60) {
            grade = "C";
        } else if (score > 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}
