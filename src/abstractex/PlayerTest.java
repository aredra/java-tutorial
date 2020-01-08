package abstractex;

public class PlayerTest {
    public static void main(String[] args) {
        Player player = new Player();
        player.play(3);

        player.upgradeLevel(new SuperLevel());
        player.play(2);
    }
}
