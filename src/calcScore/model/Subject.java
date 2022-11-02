package calcScore.model;

public class Subject implements IDomainModel {
    private String subjectId;
    private String subjectName;

    public Subject(String subjectName) {
        this.subjectId = generateId("SUB");
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
