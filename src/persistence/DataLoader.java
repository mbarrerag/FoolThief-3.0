package persistence;

import logic.ReportController;
import logic.TopsController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DataLoader {

    String pathFile = "C:\\Users\\Usuario\\Documents\\Netbeans Projects\\FoolThief\\FoolThief.v2\\src\\persistence\\Pruebas100Coma.txt";

    public static String[] string;
    public static String[] lines;
    public static String newName, newDate, newHour, newObject, newPlace, newNeighborhood, newDescription, newModusOperandi;
    public static String text = "";
    public static int u = 0;
    public static int d = 8;
    public static int w = 0;
    public static int y = 0;

    public void loadData() {
        try {
            File file = new File(pathFile);
            BufferedReader obj = new BufferedReader(new FileReader(file));
            String temp = "";
            String bfRead;
            while ((bfRead = obj.readLine()) != null) {
                temp = temp + bfRead;
            }
            
            text = temp;
            System.out.println(text);
        } catch (Exception e) {
            
        }

        for (int i = 0; i < 800; i++) {
            lines = text.split(",");
            if (lines == null) {
                break;
            }
        }

        for (int i = 0; i < 100; i++) {

            y++;

            for (int c = w; c < y; c++) {
                newName = lines[c];

            }
            y++;
            w++;
            for (int c = w; c < y; c++) {
                newDate = lines[c];

            }
            y++;
            w++;
            for (int c = w; c < y; c++) {
                newHour = lines[c];

            }
            y++;
            w++;
            for (int c = w; c < y; c++) {
                newObject = lines[c];

            }
            y++;
            w++;
            for (int c = w; c < y; c++) {
                newPlace = lines[c];

            }
            y++;
            w++;
            for (int c = w; c < y; c++) {
                newNeighborhood = lines[c];

            }
            y++;
            w++;
            for (int c = w; c < y; c++) {
                newDescription = lines[c];

            }

            w++;
            y++;
            for (int c = w; c < y; c++) {
                newModusOperandi = lines[c];

            }
            
            System.out.println(w+"l"+y);
            
            String[] data = new String[9];
            data[0] = newName;
            data[1] = newDate;
            data[2] = newHour;
            data[3] = newNeighborhood;
            data[4] = newObject;
            data[5] = newModusOperandi;
            data[6] = newPlace;
            data[7] = newDescription;

            ReportController.addReport(data);
            TopsController.addReportCount(newNeighborhood, newObject, newModusOperandi);
            u++;
        }
    }
}
