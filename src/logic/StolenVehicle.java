package logic;

public class StolenVehicle {

    public StolenVehicle(String placa, String marca, String referencia, String color, String localidad, String modus) {
        this.placa = placa;
        this.marca = marca;
        this.referencia = referencia;
        this.color = color;
        this.localidad = localidad;
        this.modus = modus;
    }

    private String placa;
    private String marca;
    private String referencia;
    private String color;
    private String localidad;
    private String modus;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getModus() {
        return modus;
    }

    public void setModus(String modus) {
        this.modus = modus;
    }
}
