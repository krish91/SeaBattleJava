public class Main {
    public static void main(String[] args) {
        init();

    }

    public static void init() {
        Field field = new Field();
        field.fillCellsInArray();
        field.randomSetShipsOnTheField();
        field.showField();
    }
}


