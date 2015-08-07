import java.io.IOException;

public class Main {
    static Field field = new Field();
    static Player player = new Player();

    public static void main(String[] args) throws IOException {
        init();
        gameCycle();
    }

    //    init our field
    public static void init() {
        System.out.println("This game is BattleField. \nRandom sizes of ships set on random places.\nHave fun!\n");
        field.fillCellsInArray();
        field.randomSetShipsOnTheField();
        field.showField();
    }

    //    cycle of game
    public static void gameCycle() throws IOException {
        boolean isAllDead;
        do {
            isAllDead = false;
            player.doShoot();
            int[] shot = {player.getxShoot(), player.getyShoot()};
            field.setShot(shot);
            field.showField();
            if (isAlive()) {
                isAllDead = true;
                System.out.println("You win!");
            }
        } while (!isAllDead);
    }

    //   here we check alive ships on our field (field.cells).
    public static boolean isAlive() {
        char[][] cells = field.getCellsOfField();
        for (char[] cell : cells) {
            for (char c : cell) {
                if (c == 'x') {
                    return false;
                }
            }
        }
        return true;
    }
}


