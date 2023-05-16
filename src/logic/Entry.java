package logic;

public class Entry {

    int key;
    StolenVehicle value;
    Entry next;

    public Entry(int key, StolenVehicle value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public Entry() {
        next = null;
    }

    public int GetKey() {
        return key;
    }

    public StolenVehicle GetValue() {
        return value;
    }
}
