package abstractex;

public class AICar extends Car {
    @Override
    public void drive() {
        System.out.println("AICar is driving");
    }

    @Override
    public void stop() {
        System.out.println("AICar stop");
    }

    @Override
    public void washCar() {
        System.out.println("Wash automatic");
    }
}
