package RK;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LogParser {
    String query = "";
    private static final String ALL_FIELDS_TO_INSERT = "1,2,3,4,5,6,7,8,9";
    private String insertedFields = "";
    private boolean moreThanLessThan = true;
    private Path logDir;
    private List<String> logFiles = new ArrayList<>();
    private PartOfLog partOfLog = new PartOfLog();
    private int responceTime = Integer.MIN_VALUE;
    private Date after = null, before = null;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        processFilesFromFolder(logDir.toFile());
    }

    private void processFilesFromFolder(File file) {
        File[] folderEntries = file.listFiles();
        for (File f : folderEntries) {
            if (f.isDirectory()) {
                processFilesFromFolder(f);
            }
            if (f.isFile() && f.getName().endsWith(".log")) {
                logFiles.add(file.getAbsolutePath() + File.separator + f.getName());
            }
        }
    }

    public void readFiles() {
        try {
            parseQuery();
            BufferedWriter bw = new BufferedWriter(new FileWriter("parsedLogFile.tsv"));
            for (String s : logFiles) {
                Helper.printMessage("Process file: " + s);
                Path file = Paths.get(s);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file.toFile()));
                    String line;
                    while (br.ready()) {
                        try {
                            line = br.readLine();
                            if (proccessWithLine(line)) {
                                if (isInDate(partOfLog.field4ToDate(partOfLog.getField4())) &&
                                        isResponseMoreThanThreshold(1000 * Double.parseDouble(partOfLog.getField9()), moreThanLessThan)) {
                                    writeToFile(bw);
                                    partOfLog.resetData();
                                }
                            } else Helper.printMessage("String is not in required format!");
                        } catch (Exception e) {
                            LogException.log(e);
                        }
                    }
                    br.close();
                } catch (IOException e) {
                    LogException.log(e);
                }
                Helper.printMessage("End processing file: " + s);
            }
            bw.close();
        } catch (IOException e) {
            LogException.log(e);
        }
    }

    private void writeToFile(BufferedWriter bw) {
        try {
            if (insertedFields.contains("1"))
                bw.write(partOfLog.getField1());
            bw.write("\t");
            if (insertedFields.contains("2"))
                bw.write(partOfLog.getField2());
            bw.write("\t");
            if (insertedFields.contains("3"))
                bw.write(partOfLog.getField3());
            bw.write("\t");
            if (insertedFields.contains("4"))
                bw.write(partOfLog.getField4());
            bw.write("\t");
            if (insertedFields.contains("5"))
                bw.write(partOfLog.getField5());
            bw.write("\t");
            if (insertedFields.contains("6"))
                bw.write(partOfLog.getField6());
            bw.write("\t");
            if (insertedFields.contains("7"))
                bw.write(partOfLog.getField7());
            bw.write("\t");
            if (insertedFields.contains("8"))
                bw.write(partOfLog.getField8());
            bw.write("\t");
            if (insertedFields.contains("9"))
                bw.write(partOfLog.getField9());
            bw.write(System.lineSeparator());
        } catch (Exception e) {
            LogException.log(e);
        }
    }

    private void parseQuery() {
        try {
            if (query.equals("") || query.equals("*")) {
                before = null;
                after = null;
                responceTime = Integer.MIN_VALUE;
                moreThanLessThan = true;
                this.insertedFields = ALL_FIELDS_TO_INSERT;
            } else {
                String[] s = query.split(" ");
                this.insertedFields = s[1];
                if (this.insertedFields.equals("*") || this.insertedFields.contains("*"))
                    this.insertedFields = ALL_FIELDS_TO_INSERT;
                moreThanLessThan = s[6].equals(">");
                responceTime = Integer.parseInt(s[7]);
                this.after = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss").parse(s[11]);
                this.before = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss").parse(s[13]);
            }
        } catch (Exception e) {
            LogException.log(e);
            before = null;
            after = null;
            responceTime = Integer.MIN_VALUE;
            moreThanLessThan = true;
        }
    }

    private boolean isResponseMoreThanThreshold(double v, boolean b) {
        return b ? v > responceTime : v < responceTime;
    }

    private boolean isInDate(Date date) {
        if (date == null) return false;
        if (after == null && before == null) return true;
        else if (before != null && after == null && date.before(before))
            return true;
        else if (after != null && before == null && date.after(after)) return true;
        else return date.after(after) && date.before(before);
    }

    private boolean proccessWithLine(String line) {
        try {
            partOfLog.setField1(line.substring(0, line.indexOf("p00")).trim());
            line = line.substring(line.indexOf("p00")).trim();

            partOfLog.setField2(line.substring(0, line.indexOf(" ")).trim());
            line = line.substring(line.indexOf(" ")).trim();

            partOfLog.setField3(line.substring(0, line.indexOf(" ")).trim());
            line = line.substring(line.indexOf(" ")).trim();

            partOfLog.setField4(line.substring(0, line.indexOf(" ")).trim());
            line = line.substring(line.indexOf(" ")).trim();

            partOfLog.setField4(partOfLog.getField4() + " " + line.substring(0, line.indexOf(" ")).trim());
            line = line.substring(line.indexOf(" ")).trim();

            partOfLog.setField5(line.substring(0, line.indexOf(" ")).trim());
            line = line.substring(line.indexOf(" ")).trim();
            line = line.substring(line.indexOf(" ")).trim();

            partOfLog.setField6(line.substring(0, line.indexOf(" ")).trim());
            line = line.substring(line.indexOf(" ")).trim();

            partOfLog.setField7(line.substring(0, line.indexOf(" - ")).trim());
            line = line.substring(line.indexOf(" - ")).trim();

            partOfLog.setField8(line.substring(2, line.lastIndexOf(" ")).trim());
            line = line.substring(line.indexOf(" ")).trim();
            line = line.substring(line.indexOf(" ")).trim();

            partOfLog.setField9(line);

            return true;
        } catch (Exception e) {
            LogException.log(e);
            partOfLog.resetData();
        }
        return false;
    }
}
