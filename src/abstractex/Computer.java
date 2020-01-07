package abstractex;

public abstract class Computer {
    //abstract method
    public abstract void display();
    public abstract void typing();

    public void turnOn() {
        System.out.println("System on");
    }

    public void turnOff() {
        System.out.println("System off");
    }
}
