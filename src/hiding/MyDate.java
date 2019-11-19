package hiding;

public class MyDate {
    int classId;
    private int year = 0;
    private int month = 0;
    private int day = 0;
    //boolean의 초기값은 false;
    private boolean isValid = true;

    public void setDay(int day) {
        if (day < 1 || day >31) {
            isValid = false;
        } else {
            this.day = day;
        }
    }
    public int getDay() {
        return day;
    }
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            isValid = false;
        } else {
            this.month = month;
        }
    }
    public int getMonth() {
        return month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }

    private boolean checkValid() {
        boolean result = true;
        if (year == 0 || month == 0 || day == 0) {
            result = false;
        } else if(!isValid) {
            result = false;
        }
        return result;
    }

    public void showMyDate() {
        if (checkValid()) {
            System.out.println(year + "." + month + "." + day);
        } else {
            System.out.println("Unhandled Error in MyDate");
        }
    }

}
