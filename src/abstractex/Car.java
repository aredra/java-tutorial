package abstractex;

public abstract class Car {
    public abstract void drive();
    public abstract void stop();

    public void startCar() {
        System.out.println("Start the car");
    }

    public void turnOff() {
        System.out.println("Turn off the car");
    }

    //Hook Method
    public void washCar() {}

    final public void run() {
        startCar();
        drive();
        stop();
        turnOff();
        washCar();
    }
}
