import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Rambo {
    public static int randInt(int min, int max) {
        Random rand;
        rand= ThreadLocalRandom.current();
        int randomNumber=rand.nextInt((max-min)+1)+min;
        return randomNumber;
    }
}
