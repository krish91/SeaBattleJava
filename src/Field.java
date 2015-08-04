import java.util.Random;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Field {
    char[][] cells = createField();
    Ship ship = new Ship();

    char[][] createField() {
        return cells = new char[5][10];
    }

    public void fillCellsInFieldArray() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '.';
            }
        }
    }

    /**
     * чтобы рандомно поставить наш корабль - нам нужно из длины поля вычесть длину этого рандомного корабля
     * и опираясь на полученное число, сделать рандомное место расположения
     */
    public void randomSetShipOnTheField() {
        Random random = new Random();
        int randomStartPositionOfShip = random.nextInt(cells.length - ship.createRandomLengthOfShip());
        int endPosition = randomStartPositionOfShip + ship.createRandomLengthOfShip();

        int randomColumn = random.nextInt(5);
        for (int i = randomStartPositionOfShip; i < endPosition; i++) {
            cells[randomColumn][randomStartPositionOfShip + i] = 'x';
        }
    }

}
