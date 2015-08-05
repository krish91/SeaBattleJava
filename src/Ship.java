import java.util.Random;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Ship {
    private int randomStartPositionOfShip;
    private int endPositionOfShip;


    int createRandomLengthOfShip() {
        Random random = new Random();
        int length = random.nextInt(4) + 1;
        return length;
    }

    void createRandomPositionOfShip() {
        Random random = new Random();
//        создаем объект Field, чтобы вытащить длину размер поля
        Field field = new Field();
        char[][] cells = field.getCellsOfField();
        int randomLengthOfShip = createRandomLengthOfShip();
        randomStartPositionOfShip = random.nextInt(cells[0].length - randomLengthOfShip);
        endPositionOfShip = randomStartPositionOfShip + randomLengthOfShip;
    }

    int getRandomStartPositionOfShip() {
        return randomStartPositionOfShip;
    }

    int getEndPositionOfShip() {
        return endPositionOfShip;
    }

    boolean isIntersected(Ship ship) {
        if (randomStartPositionOfShip < ship.endPositionOfShip + 1) {
            return true;
        }
        if (endPositionOfShip + 1 < ship.randomStartPositionOfShip) {
            return true;
        }
        return false;
    }
}
