package ru.rrr;

import lombok.Cleanup;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ru.rrr.handler.ArichmeticsHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 */
public class App {

    private static final int MAX_COUNT = 15;
    private static final int NUMBER_OF_EXAMPLES = 70;

    public static void main(String[] args) throws IOException {
        ArichmeticsHandler arichmeticsHandler = new ArichmeticsHandler();
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
            String example1 = arichmeticsHandler.getExample(MAX_COUNT);
            String example2 = arichmeticsHandler.getExample(MAX_COUNT);
            sb.append(example1)
              .append("\t")
              .append(example2);
            sb.append(System.lineSeparator());

            HSSFRow row = worksheet.createRow((short) 3 + i);
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

}
