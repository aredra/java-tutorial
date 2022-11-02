package calcScore.service;

public class BasicEvaluation implements GradeEvaluation{

    @Override
    public String getGrade(int point) {
        String grade;
        if (point > 90) {
            grade = "S";
        } else if (point > 80) {
            grade = "A";
        } else if (point > 70) {
            grade = "B";
        } else if (point > 60) {
            grade = "C";
        } else if (point > 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}
