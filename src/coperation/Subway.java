package coperation;

public class Subway {
    private int lineName;
    private int pay;
    private int income;
    private int passengerCount;

    public Subway(int lineName, int pay) {
        this.lineName = lineName;
        this.pay = pay;
    }

    public int getPay() {
        return this.pay;
    }

    public void takeSubway() {
        this.income += this.pay;
        passengerCount++;
    }

    public void showSubwayInfo() {
        System.out.println(lineName+": 요금 "+pay+", 수익:"+income+", 탑승자:"+passengerCount);
    }
}
