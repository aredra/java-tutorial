package calcScore.service;

import calcScore.model.Department;
import calcScore.model.Score;
import calcScore.model.Student;

import java.util.Objects;

public class GenerateReport {

    public void printScoreGrade(Student student) {
        StringBuilder builder = new StringBuilder();
        Department department = student.getDepartment();

        for (Score score : student.getScores()) {
            builder.append(student.getStudentId()).append(", ").append(student.getStudentName()).append(", ");

            int scoreInt = score.getScore();
            boolean isMajorSubject =
                    Objects.equals(score.getSubject().getSubjectId(), student.getDepartment().getRequiredSubject().getSubjectId());

            String scoreGrade = isMajorSubject ? department.getMajorSubjectGrade(scoreInt) : department.getNormalSubjectGrade(scoreInt);
            builder.append(score.getSubject().getSubjectName()).append(", ").append(scoreInt).append(", ").append(scoreGrade).append("\n");
        }
        System.out.println(builder);
    }
}
