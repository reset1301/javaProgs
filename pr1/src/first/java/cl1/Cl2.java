package first.java.cl1;
import Cl1.Cl1;
/**
 * Created by Роман on 11.07.2017.
 */
public class Cl2 {
    public static void main(String[] args) {
        System.out.println("2");
        Cl1.main(args);
        System.out.println(args.length);
        for (String arg:args
             ) {
            System.out.println(arg);
        }
    }
}
