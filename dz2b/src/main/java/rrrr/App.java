package rrrr;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    //    s1=args[0],s2=args[1],outputFile=args[2];
    public static void main(String[] args) throws IOException {
        String s="17.11.2014 11:43:51.410 TRACE: 9.6.25.83:54650\t> Position [pos_ID=2, item=202129_KG, dateOperation=Mon Nov 17 10:43:53 MSK 2014, depart=0, quant=0.644, price=320.19, priceDisc=320.19, ck_Summa=206.20236, ck_NDS=0.0, discSumma=0.0, discPercent=0.0, minPrice=0.0, defDiscSumma=0.0, numOldPos=2, numKit=0, barCode=2400154006442, barCode1=, fixPrice=0.0, isGift=false]\n";
//        String s1=" ";
//        String s2="c:\\111\\log\\";
//        String outputFile="c:\\111\\dz2b_output.log";
        try {
            String s1 = args[0];
            String s2 = args[1];
            String outputFile = args[2];
//            Pattern p = Pattern.compile(s1);
            File f = new File(outputFile+".csv");
            FileWriter fr = new FileWriter(f);
            File folder = new File(s2);
            String[] files = folder.list(new FilenameFilter() {
                @Override
                public boolean accept(File folder, String name) {
                    return name.contains("");
                }
            });
            for (String fileName : files) {
                System.out.println("File: " + fileName);
//            --
                File file = new File(s2 + fileName);
                FileReader fr1 = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr1);
                s = reader.readLine();
                while (s != null) {
//                System.out.println(s);
//                    Matcher m = p.matcher(s);
//                    while (m.find())
                    fr.write(s.replace(" ",s1)+System.getProperty("line.separator"));
                    s = reader.readLine();
                }
            }
            fr.close();
        }catch (Exception e){
            System.out.println("Params not input!");
            e.printStackTrace();
        }

    }
}
