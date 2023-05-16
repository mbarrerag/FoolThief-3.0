package logic;

public class VehicleController {

    // Aquí tabla hash
    final static String[] colors = new String[]{"Rojo", "Negro", "Blanco", "Azul", "Plata", "Amarillo", "Purpura", "Marrón", "Verde", "Multicolor"};

    public static String[] getColors() {
        return colors;
    }

    public static boolean exist(String id) {
        int idInt = Integer.parseInt(id);
        return true;
    }

    public static boolean existReportById(String id) {
        int idInt = Integer.parseInt(id);

        return true;
    }

    public static String[][] queryDataTable() {
        String[][] data = new String[0][0];
        return data;
    }

    public static void addReport(String[] data) {

    }

    public static String[] queryReportById(String id) {
        String[] data = new String[0];
        return data;

    }

    public static void updateReport(String id, String[] data) {
        int idInt = Integer.parseInt(id);
    }

    public static void deleteReport(String id) {
        
    }
}
