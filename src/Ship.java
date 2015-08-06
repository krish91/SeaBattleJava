import java.util.Random;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Ship {
    private int randomStartPositionOfShip;
    private int endPositionOfShip;
    private int randomRow;
    private int lengthOfShip;


    int createRandomLengthOfShip() {
        Random random = new Random();
        lengthOfShip = random.nextInt(4) + 1;
        return lengthOfShip;
    }

    void createRandomPositionOfShip() {
        Random random = new Random();
        Field field = new Field();
        char[][] cells = field.getCellsOfField();
        int randomLengthOfShip = createRandomLengthOfShip();
//        рандомная начальная позиция корабля
        randomStartPositionOfShip = random.nextInt(cells[0].length - randomLengthOfShip);
//        конечная позиция корабля
        endPositionOfShip = randomStartPositionOfShip + randomLengthOfShip;
//         рандомная строка, на которой будет располагаться корабль
        randomRow = random.nextInt(field.getROWS());
    }

//        делаем проверку - пересекается ли наш корабль с переданным в параметрах кораблем
    boolean isIntersected(Ship ship) {
        if (randomRow == ship.randomRow) {
            if (randomStartPositionOfShip < ship.endPositionOfShip + 1) {
                return true;
            }
            if (endPositionOfShip + 1 < ship.randomStartPositionOfShip) {
                return true;
            }
        }
        return false;
    }

    int getRandomStartPositionOfShip() {
        return randomStartPositionOfShip;
    }

    int getRandomRow() {
        return randomRow;
    }

    int getLengthOfShip() {
        return lengthOfShip;
    }
}
