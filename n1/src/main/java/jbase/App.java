package jbase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine();
//        System.out.println( s.substring(0,1) );
//        System.out.println(s.substring((int)(s.length()/2),(int)(s.length()/2)+1));
//        System.out.print(s.substring(0,1));
//        System.out.println(s.substring(s.length()-1));
//        System.out.print(s.substring(0,1));
//        System.out.println(s.substring(0,1));
//        String
//                s=s.substring(0,1).toUpperCase()+s.substring(1,s.length()-1)+s.substring(s.length()-1).toLowerCase();
//        System.out.println(s.indexOf('a')+1);
//        System.out.println(s.trim());
//            String s1=s.substring(0,(int) (s.length()/2));
//            s=s.substring((int)(s.length()/2));
//        System.out.println(s1);
//        System.out.println(s);
        System.out.println(s.substring(0,(int) (s.length()/2)).toUpperCase()+s.substring((int)(s.length()/2)).toLowerCase());
    }
}
