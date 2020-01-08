package abstractex;

public class BeginnerLevel extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("run slow");
    }

    @Override
    public void jump() {
        System.out.println("Can not jump");
    }

    @Override
    public void turn() {
        System.out.println("Can not turn");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("===== Beginner Level =====");
    }
}
