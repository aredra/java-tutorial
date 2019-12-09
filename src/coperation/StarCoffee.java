package coperation;

public class StarCoffee {
    private int americano = 4000;
    private int capucino = 5600;
    private int income = 0;

    public StarCoffee() {};

    public int getAmericano() {
        return americano;
    }

    public int getCapucino() {
        return capucino;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getPay(String coffee) {
        int pay = 0;
        switch (coffee) {
            case "americano":
                pay = this.americano;
                break;
            case "capucino":
                pay = this.capucino;
                break;
            default:
                break;
        }
        return pay;
    }

    public void buyCoffee(String coffee) {
        System.out.println(coffee);
        switch (coffee) {
            case "americano":
                this.income += this.americano;
                break;
            case "capucino":
                this.income += this.capucino;
                break;
            default:
                break;
        }
    }

}
