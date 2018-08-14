package rrr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine();//,s1=reader.readLine();
        ArrayList<String>a=new ArrayList();
//        int i=0;
        for (String retval:s.split(" ")) {
            a.add(retval);
//            i++;
        }
        int i=0;
        for (String str:a
             ) {
            i++;
            if(i%2==0)
                System.out.print(str+' ');
        }
//        System.out.println( "Hello World!" );
//        System.out.println(s.substring(0,(int) (s.length()/2)).toUpperCase()+s.substring((int)(s.length()/2)).toLowerCase());
//        System.out.println(s.substring(0,s.toUpperCase().indexOf(s1.toUpperCase()))+"WORLD"+s.substring(s.toUpperCase().indexOf(s1.toUpperCase())+s1.length()));
//        System.out.println(s.substring(s.toUpperCase().indexOf(s1.toUpperCase())+s1.length()));
    }
}
