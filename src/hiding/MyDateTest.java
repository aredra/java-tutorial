package hiding;

public class MyDateTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(31, 5, 2019);
        MyDate date2 = new MyDate(29, 2, 2016);
        date1.showMyDate();
        date1.checkDateValid();
        date2.checkDateValid();
    }
}
