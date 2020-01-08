package abstractex;

public class SuperLevel extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("run fast");
    }

    @Override
    public void jump() {
        System.out.println("jump high");
    }

    @Override
    public void turn() {
        System.out.println("turn");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("===== Super Level =====");
    }
}
