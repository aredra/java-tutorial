package hiding;

import java.util.*;

public class MyDate {
    int classId;
    private int year = 0;
    private int month = 0;
    private int day = 0;
    //boolean의 초기값은 false;
    private boolean isValid = true;
    private int[] oddMonth = {1,3,5,7,8,10,12};
    private int[] evenMonth = {4,6,9,11};

    public MyDate (int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void checkDateValid () {
        int yyyy = this.year;
        int mm = this.month;
        int dd = this.day;

        if (yyyy < 1) {
            System.out.println("기원전 입니다.");
            isValid = false;
        }
        if (dd < 1) {
            System.out.println("시간이 거꾸로 갑니다.");
            isValid = false;
        }
        switch (mm) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (dd>31) {
                    System.out.println("해당 월에 해당 일을 없슴다.");
                    isValid = false;
                }
                break;
            case 4: case 6: case 9: case 11:
                if (dd>30) {
                    System.out.println("해당 월에 해당 일을 없슴다.");
                    isValid = false;
                }
                break;
            case 2:
                if (yyyy%4!=0 || yyyy%100==0) {
                    if (yyyy%400 != 0) {
                        if (dd>28) {
                            System.out.println("해당 월에 해당 일을 없슴다.");
                            isValid = false;
                        }
                    }
                    else {
                        if (dd>29) {
                            System.out.println("해당 월에 해당 일을 없슴다.");
                            isValid = false;
                        }
                    }
                }
                else {
                    if (dd>29) {
                        System.out.println("해당 월에 해당 일을 없슴다.");
                        isValid = false;
                    }
                }
                break;
            default:
                System.out.println("지구가 아닌것 같습니다.");
                isValid = false;
                break;
        }
//        if (Arrays.asList(oddMonth).indexOf(mm) > -1) {
//            if (dd>31) {
//                System.out.println("해당 월에 해당 일을 없슴다.");
//                isValid = false;
//            }
//        }
//        else if (Arrays.asList(evenMonth).indexOf(mm) > -1) {
//            if (dd>30) {
//                System.out.println("해당 월에 해당 일을 없슴다.");
//                isValid = false;
//            }
//        }
//        else if (mm == 2) {
//            if (yyyy%4!=0 || yyyy%100==0) {
//                if (yyyy%400 != 0) {
//                    isValid = false;
//                }
//            }
//        }
//        else {
//            System.out.println("해당 월에 존재할 수 없슴다.");
//            isValid = false;
//        }
        if (isValid) {
            System.out.println("유효한 날짜임다.");
        }
        else {
            System.out.println("유효하지 않은 날짜임다.");
        }
    }

    public void setDay(int day) {
        if (day < 1 || day >31) {
            isValid = false;
        } else {
            this.day = day;
        }
    }
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            isValid = false;
        } else {
            this.month = month;
        }
    }
    public void setYear(int year) {
        this.year = year;
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
