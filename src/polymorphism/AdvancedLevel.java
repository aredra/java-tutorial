package polymorphism;

public class AdvancedLevel extends PlayerLevel {
    @Override
    protected void walk() {
        System.out.println("Advanced walk");
    }

    @Override
    protected void jump() {
        System.out.println("Advanced jump");
    }

    @Override
    protected void turn() {
    }

    @Override
    protected void showLevelMessage() {
        System.out.println("Advanced level");
    }
}
