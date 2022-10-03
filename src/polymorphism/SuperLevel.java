package polymorphism;

public class SuperLevel extends PlayerLevel{
    @Override
    protected void walk() {
        System.out.println("Super walk");
    }

    @Override
    protected void jump() {
        System.out.println("Super jump");
    }

    @Override
    protected void turn() {
        System.out.println("Super turn");
    }

    @Override
    protected void showLevelMessage() {
        System.out.println("Super level");
    }
}
