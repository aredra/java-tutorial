package abstractex;

public class AdvancedLevel extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void jump() {
        System.out.println("jump");
    }

    @Override
    public void turn() {
        System.out.println("Can not turn");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("===== Advanced Level =====");
    }
}
