import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        init();
//        gameStart();
//
        Field field = new Field();
        System.out.println("This game is BattleField. \nRandom sizes of ships set on random places.\nHave fun!\n");
        field.fillCellsInArray();
        field.randomSetShipsOnTheField();
        field.showField();

        Player player = new Player();
        player.doShoot();

        int[] shot = {player.getxShoot(), player.getyShoot()};
        field.setShot(shot);

        field.showField();

    }

//    public static void init() {
//        Field field = new Field();
//        System.out.println("This game is BattleField. \nRandom sizes of ships set on random places.\nHave fun!\n");
//        field.fillCellsInArray();
//        field.randomSetShipsOnTheField();
//        field.showField();
//    }
//
//    public static void gameStart() throws IOException {
//        Player player = new Player();
//        player.doShoot();
//    }
}


