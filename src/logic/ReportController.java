package logic;

/**
 * Esta clase se encarga de ser intermediario entre la capa de interfaz y la
 * capa de persistencia.
 */
public class ReportController {

    public static AvlTree reportTree = new AvlTree(); // Guardado reporte general
    public static LinkedList<Attempt> caseList = new LinkedList<>(); // Guardado resumen de reporte
    public static int id = 0; // Conteo de IDs para la inserción de datos

    /**
     * Dado un ID, busca el dato en una lista y devuelve el índice donde se
     * encuentra o en caso de no encontrarlo retorna -1.
     *
     * @param id
     * @return int que describe el indice donde se encuentra el objeto con el
     * ID.
     */
    private static int browseReport(int id) {
        int length = caseList.size();
        boolean flag = true;
        int counter = 0;

        while (counter < length && flag == true) {

            Attempt report = caseList.get(counter);
            int idReport = report.getId();
            if (id == idReport) {
                flag = false;
            }
            counter++;
        }

        if (flag == true) {
            return -1;
        } else {
            return counter - 1;
        }
    }

    /**
     * Busca el id y retorna si esta en la lista, haciendo uso del método
     * anterior y retorna un entero dada la salida de esta.
     *
     * @param id
     * @return <ul>
     * <li>true: existe el elemento en la lista.</li>
     * <li>false: no existe el elemento en la lista.</li>
     * </ul>
     */
    public static boolean exist(String id) {
        int idInt = Integer.parseInt(id);
        int index = browseReport(idInt);
        return index != -1;
    }

    /**
     * Recibe un arreglo con los datos y los agrega en el árbol y la lista.
     *
     * @param data
     */
    public static void addReport(String[] data) {
        id++;
        // CODIGO DE GENERACIÓN DE ID AQUÍ

        // Añadiendo al arbol AVL
        Stolen stolen = new Stolen();
        String[] stolenData = new String[9];
        stolenData[0] = Integer.toString(id);
        for (int i = 1; i < 9; i++) {
            stolenData[i] = data[i - 1];
        }
        stolen.setAllData(stolenData);
        reportTree.insert(stolen);

        // Añadiendo a la lista
        Attempt report = new Attempt();
        String[] attemptData = {Integer.toString(id), data[1], data[2], data[3], data[4], data[5]};
        report.setAllData(attemptData);
        caseList.add(report);
    }

    /**
     * Esta función retorna un matriz con todos los datos guardados en la lista
     * (resumen de reportes) para la lectura de esta en la interfaz.
     *
     * @return String[][] matriz con todos los datos guardados en la lista.
     */
    public static String[][] queryDataTable() {
        try {
            int length = caseList.size();
            String[][] data = new String[length][6];
            for (int i = 0; i < data.length; i++) {
                Attempt infoNode = caseList.get(i);
                if (infoNode != null) {
                    data[i] = infoNode.getAllData();
                }
            }
            return data;
        } catch (NegativeArraySizeException e) {
            String[][] data = new String[0][0];
            return data;
        }
    }

    /**
     * Retorna si dado un ID, existe un elemento identificado con este en el
     * árbol AVL
     *
     * @param id
     * @return <ul>
     * <li>true: existe el elemento en el árbol.</li>
     * <li>false: no existe el elemento en el árbol.</li>
     * </ul>
     */
    public static boolean existReport(String id) {
        int idInt = Integer.parseInt(id);
        return reportTree.exist(idInt);
    }

    /**
     * Retorna un arreglo con los datos guardados en el árbol para su lectura en
     * la interfaz.
     *
     * @param id
     * @return String[] data.
     */
    public static String[] queryReportById(String id) {
        try {
            int idInt = Integer.parseInt(id);
            String[] data = new String[9];
            if (reportTree.exist(idInt)) {
                Stolen stolen = reportTree.get(idInt);
                data = stolen.getAllData();
            }

            return data;
        } catch (NegativeArraySizeException e) {
            String[] data = new String[9];
            return data;
        }
    }

    /**
     * Dado un ID y un arreglo se busca el elemento y se actualiza los datos
     * tanto en el árbol como en la lista.
     *
     * @param id
     * @param data
     */
    public static void updateReport(String id, String[] data) {
        int idInt = Integer.parseInt(id);
        int index = browseReport(idInt);

        // Modificando en el árbol AVL
        Stolen stolen = reportTree.get(idInt);
        if (stolen == null) {
            throw new RuntimeException("ERROR: El ID no existe");
        } else {
            String[] stolenData = new String[9];
            stolenData[0] = id;
            for (int i = 1; i < 9; i++) {
                stolenData[i] = data[i - 1];
            }
            stolen.setAllData(stolenData);
        }

        // Modificando en lista
        Attempt attempt = caseList.get(index);
        if (attempt.getId() == idInt) {
            String[] attemptData = {id, data[1], data[2], data[3], data[4], data[5]};
            attempt.setAllData(attemptData);
        }
    }

    /**
     * Dado un ID elimina el dato en el árbol y la lista.
     *
     * @param id
     */
    public static void deleteReport(String id) {
        int idInt = Integer.parseInt(id);
        int index = browseReport(idInt);

        // Eliminando en lista
        Attempt report = caseList.get(index);
        if (report.getId() == idInt) {
            caseList.remove(index);
        }

        // Eliminando en árbol AVL
        if (reportTree.exist(idInt)) {
            reportTree.delete(idInt);
        }
    }
}
