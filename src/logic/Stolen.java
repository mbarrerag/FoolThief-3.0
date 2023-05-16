package logic;

/**
 * Está clase se encarga del guardado de los datos del reporte general. Se
 * utiliza en la consulta de datos completo (Busqueda).
 */
public class Stolen implements Comparable<Stolen> {

    private int id;
    private String name;
    private String date;
    private String hour;
    private String neighborhood;
    private String object;
    private String modusOperandi;
    private String place;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModusOperandi() {
        return modusOperandi;
    }

    public void setModusOperandi(String modusOperandi) {
        this.modusOperandi = modusOperandi;
    }

    public String[] getAllData() {
        String[] data = new String[9];
        data[0] = String.valueOf(id); // Converting id from int to String
        data[1] = name;
        data[2] = date;
        data[3] = hour;
        data[4] = neighborhood;
        data[5] = object;
        data[6] = modusOperandi;
        data[7] = place;
        data[8] = description;
        return data;
    }

    public void setAllData(String[] data) {
        id = Integer.parseInt(data[0]);
        name = data[1];
        date = data[2];
        hour = data[3];
        neighborhood = data[4];
        object = data[5];
        modusOperandi = data[6];
        place = data[7];
        description = data[8];
    }

    @Override
    public int compareTo(Stolen stolen) {
        if (id > stolen.id) {
            return 1;
        } else if (id < stolen.id) {
            return -1;
        } else {
            return 0;
        }
    }
}
