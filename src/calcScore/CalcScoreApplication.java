package calcScore;

public class CalcScoreApplication {
    public static void main(String[] args) {
        Subject math = new Subject("수학");
        Subject korean = new Subject("국어");

        Department computer = new Department("컴퓨터", math);
        Department language = new Department("국문", korean);

        Student kim = new Student("kim", computer);
        Student seo = new Student("seo", language);

        kim.addScore(new Score(kim.getStudentId(), math, 81));
        kim.addScore(new Score(kim.getStudentId(), korean, 81));

        seo.addScore(new Score(seo.getStudentId(), math, 81));
        seo.addScore(new Score(seo.getStudentId(), korean, 81));

        kim.printScoreGrade();
        seo.printScoreGrade();
    }
}
