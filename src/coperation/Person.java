package coperation;

public class Person {
    private String name;
    private int age;
    private boolean sex;
    private int money;

    public Person() {
        this("no name", 20, 0);
    };

    public Person(String name, int age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void takeBus(Bus bus) {
        if (this.money >= bus.getPay()) {
            bus.takeBus();
            this.money -= bus.getPay();
        } else {
            System.out.println("Lack Balance");
        }
    }

    public void takeSubway(Subway subway) {
        if (this.money >= subway.getPay()) {
            subway.takeSubway();
            this.money -= subway.getPay();
        } else {
            System.out.println("Lack Balance");
        }
    }

    public void showPersonInfo() {
        System.out.println(this.name+", "+this.age+"세, 잔액:"+this.money);
    }
}
