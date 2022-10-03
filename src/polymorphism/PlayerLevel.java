package polymorphism;

public abstract class PlayerLevel {

    protected abstract void walk();

    protected abstract void jump();

    protected abstract void turn();

    protected abstract void showLevelMessage();

    final void go (int jumpCount) {
        showLevelMessage();
        walk();
        for (int i=0; i < jumpCount; i++) {
            jump();
        }
        turn();
    }
}
