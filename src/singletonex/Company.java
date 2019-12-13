package singletonex;

public class Company {
    private static Company instance = new Company();

    private Company() {

    };

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public Staff enterCompany() {
        return new Staff();
    }
}
