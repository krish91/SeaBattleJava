public class Main {
    public static void main(String[] args) {
        init();

    }

    public static void init() {
        Field field = new Field();
        char[][] cellsOfField = field.getCellsOfField();
        field.fillCellsInArray();
        field.randomSetShipOnTheField();
        for (int i = 0; i < cellsOfField.length; i++) {
            System.out.println(cellsOfField[i]);
        }
    }
}


