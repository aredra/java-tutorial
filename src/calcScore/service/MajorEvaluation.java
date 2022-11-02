package calcScore.service;

public class MajorEvaluation implements GradeEvaluation {

    @Override
    public String getGrade(int point) {
        String grade;
        if (point > 95) {
            grade = "S";
        } else if (point > 85) {
            grade = "A";
        } else if (point > 75) {
            grade = "B";
        } else if (point > 65) {
            grade = "C";
        } else if (point > 55) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}
