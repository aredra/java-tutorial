package polymorphism;

public class Player {

    private PlayerLevel level;

    public Player() {
        this.level = new BeginnerLevel();
    }

    public Player(PlayerLevel level) {
        this.level = level;
    }

    public void getLevel() {
        this.level.showLevelMessage();
    }

    public void upgradeLevel(PlayerLevel level) {
        this.level = level;
        this.level.showLevelMessage();
    }

    public void play(int count) {
        this.level.go(count);
    }
}
