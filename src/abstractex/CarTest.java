package abstractex;

public class CarTest {
    public static void main(String[] args) {
        Car aiCar = new AICar();
        System.out.println("=========== AICar start ===========");
        aiCar.run();
        Car manualCar = new ManualCar();
        System.out.println("=========== ManualCar start ===========");
        manualCar.run();
    }
}
