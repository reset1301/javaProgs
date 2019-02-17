package ru.rrr;

import lombok.Cleanup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {
    private static WriterToFile ourInstance = new WriterToFile();
    private static Boolean a = true;
    private static String fileName = "c.txt";
    static {
        try {
            new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static WriterToFile getInstance() {
        return ourInstance;
    }

    private WriterToFile() {
    }

    public synchronized void writeToFile(String s) throws IOException {
        @Cleanup BufferedWriter bwC = new BufferedWriter(new FileWriter(fileName, true));
        bwC.write(s);
        bwC.newLine();
        a = s.equals("A");
    }

    public boolean isA() {
        return a;
    }
}
