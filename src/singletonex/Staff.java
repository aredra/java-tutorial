package singletonex;

public class Staff {
    private static int serialNumber = 1000;
    private int staffNumber;

    public Staff() {
        this.staffNumber = serialNumber;
        serialNumber++;
    }

    public void getStaffNumber() {
        System.out.println(this.staffNumber);
    }
}
