package polymorphism;

public class BeginnerLevel extends PlayerLevel {

    @Override
    protected void walk() {
        System.out.println("Beginner walk");
    }

    @Override
    protected void jump() {
    }

    @Override
    protected void turn() {
    }

    @Override
    protected void showLevelMessage() {
        System.out.println("Beginner level");
    }
}
