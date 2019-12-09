package coperation;

public class TakeTransTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Aredra", 20, 10000);
        Bus bus1 = new Bus(1, 1200);
        Bus bus2 = new Bus(2, 2500);
        Subway subway1 = new Subway(1, 1250);
        Subway subway2 = new Subway(2, 5000);
        StarCoffee coffee = new StarCoffee();

        p1.showPersonInfo();
        p2.showPersonInfo();

        p2.buyCoffee(coffee, "americano");

        p2.takeBus(bus1);
        p2.takeBus(bus2);
        p2.takeBus(bus1);
        p2.takeBus(bus1);
        p2.takeSubway(subway1);
        p2.takeSubway(subway2);

        bus1.showBusInfo();
        bus2.showBusInfo();
        subway1.showSubwayInfo();
        subway2.showSubwayInfo();
        p2.showPersonInfo();
    }
}
