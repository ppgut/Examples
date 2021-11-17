package examples.csvIO.securityCheck;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CsvIO {

    public static void addLineToCsv(List<String> dataLine, String filePath) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filePath, true));
            writer.writeNext(dataLine.stream()
                    .map(CsvIO::escapeSpecialCharacters)
                    .toArray(String[]::new));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveCSV(List<List<String>> dataLines, String filePath) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filePath, false));
            for (List<String> dataLine :dataLines) {
                writer.writeNext(dataLine.stream()
                        .map(CsvIO::escapeSpecialCharacters)
                        .toArray(String[]::new));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<List<String>> loadCSV(String filePath) {
        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }




}
