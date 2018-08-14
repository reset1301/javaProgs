package rrr;

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
//        System.out.println( "Hello World!" );
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
//        System.out.println(s.substring(0,(int) (s.length()/2)).toUpperCase()+s.substring((int)(s.length()/2)).toLowerCase());
//        String s1=s.substring(0,(int)s.length()/3);
//        String s2=s.substring((int)s.length()/3,(int)2*s.length()/3);
//        String s3=s.substring((int)2*s.length()/3);
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s.substring(0,(int)s.length()/3).toUpperCase()+" the "+s.substring((int)2*s.length()/3).toLowerCase());
//        if (s.lastIndexOf('@')==-1){
//            System.out.println("No");
//        }
//        else {
//        System.out.println(s.lastIndexOf('@'));}
//        System.out.println(s.replaceFirst("\\(.+?\\)",String.valueOf(s.length())));
//        if(s.startsWith("World"))
//            System.out.println("Yes");
//        else System.out.println("No");
//        if(s.toUpperCase().endsWith("ABC"))
//            System.out.println("Yes");
//        else System.out.println("No");
//        String s1=reader.readLine();
//        if (s.compareTo(s1)==1)
//            System.out.println(s+'\n'+s1);
//        else System.out.println(s1+'\n'+s);
//        String s1=reader.readLine();
//        if (s.compareTo(s1)==0)
//            System.out.println("Yes");
//        else System.out.println("No");
//        String s1=reader.readLine();
//        System.out.println(s.toLowerCase().indexOf(s1.toLowerCase()));
        String s1=reader.readLine();
        System.out.println(s.substring(0,s.indexOf(s1))+s.substring(s.indexOf(s1)+s1.length()));
//        System.out.println(s.substring(s.indexOf(s1)+s1.length()));
    }
}
