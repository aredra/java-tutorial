package calcScore;

import calcScore.model.Department;
import calcScore.model.Score;
import calcScore.model.Student;
import calcScore.model.Subject;
import calcScore.service.GenerateReport;
import calcScore.utils.Constant;

public class CalcScoreApplication {
    public static void main(String[] args) {
        Subject math = new Subject(Constant.MATH);
        Subject korean = new Subject(Constant.KOREAN);

        Department computer = new Department(Constant.COMPUTER, math);
        Department language = new Department(Constant.LANGUAGE, korean);

        Student kim = new Student("kim", computer);
        Student seo = new Student("seo", language);

        kim.addScore(new Score(kim.getStudentId(), math, 81));
        kim.addScore(new Score(kim.getStudentId(), korean, 81));

        seo.addScore(new Score(seo.getStudentId(), math, 81));
        seo.addScore(new Score(seo.getStudentId(), korean, 81));

        GenerateReport report = new GenerateReport();

        report.printScoreGrade(kim);
        report.printScoreGrade(seo);
    }
}
