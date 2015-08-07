import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Кирилл on 04.08.2015.
 */
public class Player {
    private int xShoot;
    private int yShoot;

    void doShoot () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do your shot.\nCoordinate X:");
        int x = Integer.parseInt(reader.readLine());
        System.out.println("Coordinate Y:");
        int y = Integer.parseInt(reader.readLine());

        setxShoot(x);
        setyShoot(y);
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
