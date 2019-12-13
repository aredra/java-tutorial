package singletonex;

import java.util.Calendar;

public class CompanyTest {
    public static void main(String[] args) {
        Company company = Company.getInstance();

        System.out.println(company);

        Staff staff1 = company.enterCompany();
        Staff staff2 = company.enterCompany();

        staff1.getStaffNumber();
        staff2.getStaffNumber();
    }
}
