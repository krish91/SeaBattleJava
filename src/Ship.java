import java.util.Random;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Ship {

    int createRandomLengthOfShip() {
        Random random = new Random();
        int length = random.nextInt(4) + 1;
        return length;
    }
}
