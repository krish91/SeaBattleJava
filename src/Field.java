import java.util.Random;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Field {
    final int ROWS = 5;
    final int COLUMNS = 10;
    private char[][] cells = new char[ROWS][COLUMNS];
    final int SHIPS_AMOUNT = 5;
    Ship[] ships = new Ship[SHIPS_AMOUNT];

    public void fillCellsInArray() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '.';
            }
        }
    }

    public char[][] getCellsOfField() {
        return cells;
    }

    /**
     * чтобы рандомно поставить наш корабль - нам нужно из длины поля вычесть длину этого рандомного корабля
     * и опираясь на полученное число, сделать рандомное место расположения
     */
    public void randomSetShipOnTheField() {
        Random random = new Random();
        for (int i = 0; i < SHIPS_AMOUNT; i++) {
            Ship tempShip = new Ship();
            boolean isIntersected;
            do {
                isIntersected = false;

                int lengthOfShip = tempShip.createRandomLengthOfShip();
                tempShip.createRandomPositionOfShip();

                int randomStartPositionOfShip = tempShip.getRandomStartPositionOfShip();
                int endPositionOfShip = tempShip.getEndPositionOfShip();
                //сделать проверку на пересечение палуб корабля

                int randomRow = random.nextInt(ROWS);
                for (int j = 0; j < lengthOfShip; j++) {
                    cells[randomRow][randomStartPositionOfShip + j] = 'x';
                }
            } while (isIntersected);

            ships[i] = tempShip;
        }
    }
}
