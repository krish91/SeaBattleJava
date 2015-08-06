import java.util.Random;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Field {
    private final int ROWS = 5;
    private final int COLUMNS = 10;
    private char[][] cells = new char[ROWS][COLUMNS];
    final int SHIPS_AMOUNT = 5;
    Ship[] ships = new Ship[SHIPS_AMOUNT];

//    "закрашиваем" наше поле точками
    public void fillCellsInArray() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '.';
            }
        }
    }

//    рандомное расположение кораблей на поле
    public void randomSetShipsOnTheField() {
        Random random = new Random();
        for (int i = 0; i < SHIPS_AMOUNT; i++) {
            Ship tempShip = new Ship();
            boolean isIntersected;

            do {
//                предположим, что нет пересечений
                isIntersected = false;
//                создаем произвольный размер корабля и рандомную позицию на рандомной строке
                tempShip.createRandomLengthOfShip();
                tempShip.createRandomPositionOfShip();
//                делаем проверку на пересечение tempShip с предыдущими кораблями. если не проходим - цикл do{} идет заново
                for (int j = 0; j < i; j++) {
                    if (tempShip.isIntersected(ships[j])) {
                        isIntersected = true;
                    }
                }
            } while (isIntersected);
//            выйдя из цикла - рисуем наш корабль в массиве и заносим его в массив объектов под индексом i
            drawShipOnTheField(tempShip);
            ships[i] = tempShip;
        }
    }

    void drawShipOnTheField(Ship tempShip) {
        int randomRow = tempShip.getRandomRow();
        int lengthOfShip = tempShip.getLengthOfShip();
        int randomStartPositionOfShip = tempShip.getRandomStartPositionOfShip();

        for (int j = 0; j < lengthOfShip; j++) {
            cells[randomRow][randomStartPositionOfShip + j] = 'x';
        }
    }

    void showField() {
        for (int i = 0; i < cells.length; i++) {
            System.out.println(cells[i]);
        }
    }

    int getROWS() {
        return ROWS;
    }

    char[][] getCellsOfField() {
        return cells;
    }
}
