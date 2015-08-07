import java.util.Arrays;
import java.util.Random;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Field {
    private final int ROWS = 5;
    private final int COLUMNS = 10;
    private char[][] cells = new char[ROWS][COLUMNS];
    final int SHIPS_AMOUNT = ROWS + 1;
    Ship[] ships = new Ship[SHIPS_AMOUNT];
    Player player = new Player();

    //    set points(.) on our field
    public void fillCellsInArray() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '.';
            }
        }
    }

    //    random set ships on the field
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
            System.out.print((i + 1) + ") ");
            System.out.println(cells[i]);
        }
        System.out.println();
    }

    void setShot(int[] shot) {
//        take coordinates(where our player did shot) and check - if hit by X and Y set on that place '-'
        int x = shot[0];
        int y = shot[1];

        switch (cells[x][y]) {
            case 'x':
                System.out.println("Hit!!!");
                cells[x][y] = '-';
                break;
            case '.':
                System.out.println("Miss!!!");
                cells[x][y] = '*';
                break;
            case '*':
                System.out.println("Try again!!!");
            case '-':
                System.out.println("Do you want to kill dead ship? LOL");
                break;
            default:
                System.out.println("hmm..");
        }
    }

    int getROWS() {
        return ROWS;
    }

    char[][] getCellsOfField() {
        return cells;
    }
}
