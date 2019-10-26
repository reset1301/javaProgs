package ru.rrr;

import lombok.Cleanup;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ru.rrr.enums.Level;
import ru.rrr.handler.ArichmeticsHandler;
import ru.rrr.handler.Handler;
import ru.rrr.handler.MultiplicationHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ru.rrr.enums.Level.Easy;

/**
 * Hello world!
 */
public class App {

    private static final int MAX_COUNT = 100;
    private static final int NUMBER_OF_EXAMPLES = 48;
    private static final Level difficultLevel = Easy;

    public static void main(String[] args) throws IOException {
        Handler handler = new ArichmeticsHandler();
        StringBuilder sb = new StringBuilder();
        File file = new File("Lesson.csv");
        @Cleanup OutputStreamWriter bw = new OutputStreamWriter(new FileOutputStream(file), "Windows-1251");

        sb.append(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        sb.append(System.lineSeparator());
        sb.append("Домашняя работа");
        sb.append(System.lineSeparator());

        //create .xls and create a worksheet.
        FileOutputStream fos = new FileOutputStream("Lesson.xls");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("My Worksheet");

        //Create ROW-1
        HSSFRow row1 = worksheet.createRow(0);

        //Create COL-A from ROW-1 and set data
        HSSFCell cellA1 = row1.createCell(0);
        cellA1.setCellValue(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

        HSSFRow row2 = worksheet.createRow(1);
        HSSFCell cellA2 = row2.createCell(0);
        cellA2.setCellValue("Домашняя работа");

        for (int i = 0; i < NUMBER_OF_EXAMPLES / 2; i++) {
            String example1 = handler.getExample(MAX_COUNT);
            String example2 = handler.getExample(MAX_COUNT);
            appendExample(sb, example1, example2);

            HSSFRow row = worksheet.createRow((short) 3 + i);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(example1);
            cell = row.createCell(3);
            cell.setCellValue(example2);

        }
        bw.write(sb.toString());

        handler = new MultiplicationHandler();
        for (int i = 0; i < NUMBER_OF_EXAMPLES / 2; i++) {
            int count = handler.getCount(difficultLevel);
            String example1 = handler.getExample(count);
            String example2 = handler.getExample(count);
            appendExample(sb, example1, example2);

            HSSFRow row = worksheet.createRow((short) 4+ NUMBER_OF_EXAMPLES / 2 + i);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(example1);
            cell = row.createCell(3);
            cell.setCellValue(example2);

        }
        bw.write(sb.toString());
        System.out.println(sb.toString());

        //Save the workbook in .xls file
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

    private static void appendExample(StringBuilder sb, String example1, String example2) {
        sb.append(example1)
                .append("\t")
                .append(example2)
                .append(System.lineSeparator());
    }

}
