package coperation;

public class Bus {
    private int busName;
    private int pay;
    private int income;
    private int passengerCount;

    public Bus(int busName, int pay) {
        this.busName = busName;
        this.pay = pay;
    }

    public int getPay() {
        return this.pay;
    }

    public void takeBus() {
        this.income += this.pay;
        passengerCount++;
    }

    public void showBusInfo() {
        System.out.println(busName+": 요금 "+pay+", 수익:"+income+", 탑승자:"+passengerCount);
    }
}
