package logic;

/**
 * Esta clase administra un árbol binario para la organización de datos para
 * Tops.
 */
public class TopsController {

    public static BinaryTree treeTop = new BinaryTree();
    private static final String[] neighborhoods = new String[]{"Usaquen", "Chapinero", "Santa Fe", "San Cristobal", "Usme", "Tunjuelito", "Bosa", "Kennedy", "Fontibon", "Engativa", "Suba", "Barrios Unidos", "Teusaquillo", "Los Martires", "Antonio Nariño", "Puente Aranda", "La Candelaria", "Rafael Uribe Uribe", "Ciudad Bolivar", "Sumapaz"};
    private static final String[] objects = new String[]{"Billetera", "Celular", "Bolso", "Bicicleta", "Computador", "Papeles", "Vehiculo"};
    private static final String[] modusOperandi = new String[]{"Raponazo", "Cosquilleo", "Asalto", "Paseo Millonario", "Estafa"};
    private static int[] countNeighborhoods = new int[neighborhoods.length];
    private static int[] countObjects = new int[objects.length];
    private static int[] countModusOperandi = new int[modusOperandi.length];

    public static String[] getNeighborhoods() {
        return neighborhoods;
    }

    public static String[] getObjects() {
        return objects;
    }

    public static String[] getModusOperandi() {
        return modusOperandi;
    }

    /**
     * Aumenta el conteo en un arreglo de los datos que son insertados.
     *
     * @param neighborhood
     * @param object
     * @param modus
     */
    public static void addReportCount(String neighborhood, String object, String modus) {
        int n = countNeighborhoods.length;
        for (int i = 0; i < n; i++) {
            if (neighborhood == neighborhoods[i]) {
                countNeighborhoods[i]++;
                break;
            }
        }

        int m = countObjects.length;
        for (int i = 0; i < m; i++) {
            if (object == objects[i]) {
                countObjects[i]++;
                break;
            }
        }

        int l = countModusOperandi.length;
        for (int i = 0; i < l; i++) {
            if (modus == modusOperandi[i]) {
                countModusOperandi[i]++;
                break;
            }
        }
    }

    /**
     * Disminuye el conteo en un arreglo de los datos que son insertados.
     *
     * @param neighborhood
     * @param object
     * @param modus
     */
    public static void deleteReportCount(String neighborhood, String object, String modus) {
        int n = countNeighborhoods.length;
        for (int i = 0; i < n; i++) {
            if (neighborhood == neighborhoods[i]) {
                countNeighborhoods[i]--;
                break;
            }
        }

        int m = countObjects.length;
        for (int i = 0; i < m; i++) {
            if (object == objects[i]) {
                countObjects[i]--;
                break;
            }
        }

        int l = countModusOperandi.length;
        for (int i = 0; i < l; i++) {
            if (modus == modusOperandi[i]) {
                countModusOperandi[i]--;
                break;
            }
        }
    }

    /**
     * Tomando el arreglo de conteo realiza la inserción y el ordenamiento de
     * datos con un árbol binario.
     *
     * @return arreglo con las localidades con más robos organizados.
     */
    public static String[] topNeighborhoods() {
        if (treeTop.itsEmpty() == false) {
            treeTop.makeEmpty();
        }

        int n = countNeighborhoods.length;
        for (int i = 0; i < n; i++) {
            Tops top = new Tops(neighborhoods[i], countNeighborhoods[i]);
            treeTop.insert(top);
        }

        String dataString = treeTop.inorderData();
        String[] data = dataString.split(",");
        return data;
    }

    /**
     * Tomando el arreglo de conteo realiza la inserción y el ordenamiento de
     * datos con un árbol binario.
     *
     * @return arreglo con los objetos más robados más organizados.
     */
    public static String[] topObjects() {
        if (treeTop.itsEmpty() == false) {
            treeTop.makeEmpty();
        }

        int n = countObjects.length;
        for (int i = 0; i < n; i++) {
            Tops top = new Tops(objects[i], countObjects[i]);
            treeTop.insert(top);
        }

        String dataString = treeTop.inorderData();
        String[] data = dataString.split(",");
        return data;
    }

    /**
     * Tomando el arreglo de conteo realiza la inserción y el ordenamiento de
     * datos con un árbol binario.
     *
     * @return arreglo con los ModusOperandi más utilizados organizados.
     */
    public static String[] topModusOperandi() {
        if (treeTop.itsEmpty() == false) {
            treeTop.makeEmpty();
        }

        int n = countModusOperandi.length;
        for (int i = 0; i < n; i++) {
            Tops top = new Tops(modusOperandi[i], countModusOperandi[i]);
            treeTop.insert(top);
        }
        String dataString = treeTop.inorderData();
        String[] data = dataString.split(",");
        return data;
    }

    /**
     * Función de prueba para la impresión de conteo de datos.
     */
    public static void displayData() {
        int n = countNeighborhoods.length;
        for (int i = 0; i < n; i++) {
            System.out.println(neighborhoods[i] + ": " + countNeighborhoods[i]);
        }
        System.out.println("");
        int m = countObjects.length;
        for (int i = 0; i < m; i++) {
            System.out.println(objects[i] + ": " + countObjects[i]);
        }
        System.out.println("");
        int l = countModusOperandi.length;
        for (int i = 0; i < l; i++) {
            System.out.println(modusOperandi[i] + ": " + countModusOperandi[i]);
        }
        System.out.println("");
    }
}
