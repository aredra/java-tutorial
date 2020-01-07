package abstractex;

public class ManualCar extends Car{
    @Override
    public void drive() {
        System.out.println("ManualCar is driving");
    }

    @Override
    public void stop() {
        System.out.println("ManualCar stop");
    }
}
