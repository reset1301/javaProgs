import java.util.Random;

public class rand {
    public static void main(String[] args) {
        int x = Integer.parseInt("10");
        for (int i = 0; i < 10; i++)
            System.out.println((int) (x * Math.random())+1);
    }
}
