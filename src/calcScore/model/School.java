package calcScore.model;

import java.util.ArrayList;

public class School implements IDomainModel {

    private static School instance = new School();
    private ArrayList<Subject> subjects = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    private School() {}

    public School getInstance() {
        if (instance == null) {
            instance = new School();
        }
        return instance;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
