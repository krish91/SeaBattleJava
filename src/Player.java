import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Player {
    private int xShoot;
    private int yShoot;

    void doShoot() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Do your shot.\nCoordinate X:");
            int x = Integer.parseInt(reader.readLine());
            setxShoot(x);
        } catch (NumberFormatException e) {
            System.out.println("You sent empty string, so... You're bad boy :D\nI set first position instead of you");
            setxShoot(0);
        }

        try {
            System.out.println("Coordinate Y:");
            int y = Integer.parseInt(reader.readLine());
            setyShoot(y);
        } catch (NumberFormatException e) {
            System.out.println("You sent empty string, so... You're bad boy :D\nI set first position instead of you");
            setyShoot(0);
            System.out.println();
        }
    }

    public int getxShoot() {
        return xShoot;
    }

    public void setxShoot(int xShoot) {
        this.xShoot = xShoot;
    }

    public int getyShoot() {
        return yShoot;
    }

    public void setyShoot(int yShoot) {
        this.yShoot = yShoot;
    }
}
