package rrrr;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine(),s1=reader.readLine();
        System.out.println( "Hello World!" );


//        String s = "17.11.2014 16:03:35.801 TRACE: 9.6.25.83:59883\t> Position [pos_ID=1, item=152301_ST, dateOperation=Mon Nov 17 15:03:33 MSK 2014, depart=0, quant=1.0, price=46.09, priceDisc=46.09, ck_Summa=46.09, ck_NDS=0.0, discSumma=0.0, discPercent=0.0, minPrice=0.0, defDiscSumma=0.0, numOldPos=1, numKit=0, barCode=4600682477150, barCode1=, fixPrice=0.0, isGift=false]";
//        System.out.println(s);
//        s=s.replace(' ',';');
//        System.out.println(s);
//        ArrayList<String> a=new ArrayList();
//        int i=0;
//        for (String retval:s.split(", ")) {
//            a.add(retval);
//            i++;
//        }
//        for (String ss:a
//             ) {
//            System.out.println(ss);
//        }

//        1
//        System.out.println("Vvedi name of file");
//        String s=reader.readLine(),s1=reader.readLine();
//        String s="c:\\111\\main.log.2014-11-17",s1="c:\\111\\Java\\log\\vova_";
//        try (BufferedReader reader1 = new BufferedReader(
//                new InputStreamReader(
//                        new FileInputStream(s), StandardCharsets.UTF_8))){
//            String line;
//            while ((line = reader1.readLine()) != null) {
//                System.out.println(line);
//                line=line.replace(' ',';');
//
//            }
//        } catch (IOException e) {
//            // log error
//        }
        RandomAccessFile raf = new RandomAccessFile(s, "r");
        long numSplits = 20; //from user input, extract it from args
        long sourceSize = raf.length();
        long bytesPerSplit = sourceSize/numSplits ;
        long remainingBytes = sourceSize % numSplits;
        int maxReadBufferSize = 8 * 1024; //8KB
        for(int destIx=1; destIx <= numSplits; destIx++) {
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(s1+destIx+".log"));
            if(bytesPerSplit > maxReadBufferSize) {
                long numReads = bytesPerSplit/maxReadBufferSize;
                long numRemainingRead = bytesPerSplit % maxReadBufferSize;
                for(int i=0; i<numReads; i++) {
                    readWrite(raf, bw, maxReadBufferSize);
                }
                if(numRemainingRead > 0) {
                    readWrite(raf, bw, numRemainingRead);
                }
            }else {
                readWrite(raf, bw, bytesPerSplit);
            }
            bw.close();
        }
        if(remainingBytes > 0) {
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split."+(numSplits+1)));
            readWrite(raf, bw, remainingBytes);
            bw.close();
        }
        raf.close();

    }
    static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if(val != -1) {
            bw.write(buf);
        }
    }
}

