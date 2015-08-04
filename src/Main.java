import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        Field field = new Field();
        field.createField();
        field.fillCellsInFieldArray();
        field.randomSetShipOnTheField();
        for (int i = 0; i < field.cells.length; i++) {
            System.out.println(field.cells[i]);
        }
    }
}


