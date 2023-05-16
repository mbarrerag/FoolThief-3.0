package logic;

/**
 * Está clase se encarga de guardar los datos de resumen de un reporte. Estos
 * datos serán mostrados en la tabla principal en la interfaz.
 */
public class Attempt {

    private int id;
    private String date;
    private String hour;
    private String neighborhood;
    private String object;
    private String modusOperandi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getModusOperandi() {
        return modusOperandi;
    }

    public void setModusOperandi(String modusOperandi) {
        this.modusOperandi = modusOperandi;
    }

    public String[] getAllData() {
        String[] data = new String[6];
        data[0] = String.valueOf(id); // Converting id from int to String
        data[1] = date;
        data[2] = hour;
        data[3] = neighborhood;
        data[4] = object;
        data[5] = modusOperandi;
        return data;
    }

    public void setAllData(String[] data) {
        id = Integer.parseInt(data[0]); // Converting id from String to int
        date = data[1];
        hour = data[2];
        neighborhood = data[3];
        object = data[4];
        modusOperandi = data[5];
    }
}
