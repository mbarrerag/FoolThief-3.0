package logic;

public class DynamicArray {

    int sizeofarray = 0;
    private int count;
    String arrayList[];

    /**
     * Crea un arreglo dinamico de tamaño 1 con unos atributos como Size y Count
     *
     */
    public DynamicArray() {

        arrayList = new String[1];
        count = 0;
        sizeofarray = 1;

    }

    /**
     * Agrega un valor al arreglo dinamico
     *
     * @param recibe un String que sera almacenado
     */
    public void addElement(String infDynamic) {

        if (count == sizeofarray) {
            growSize();
        }
        arrayList[count] = infDynamic;
        count++;
    }

    /**
     * Metodo para hacer crecer el arreglo una vez se llena
     */
    public void growSize() {

        String temp[] = null;
        if (count == sizeofarray) {
            temp = new String[sizeofarray * 2];
            {
                for (int i = 0; i < sizeofarray; i++) {
                    temp[i] = arrayList[i];
                }
            }
        }
        arrayList = temp;
        sizeofarray = sizeofarray * 2;
    }

    /**
     * Permite agregar elementos al arreglo en la posicion que desemeos
     *
     * @param index Posicion en la cual queremos que sea ingresado el dato
     * @param infDynamic Dato tipo String que queremos ingresar
     */
    public void addElementAt(int index, String infDynamic) { //Clase la cual puede eliminar un elemntos en cualquier index

        if (count == sizeofarray) {
            growSize();
        }
        for (int i = count - 1; i > index; i--) {
            arrayList[i + 1] = arrayList[i];
        }
        arrayList[index] = infDynamic;
        count++;
    }

    /**
     * Permite conocer los elementos de arreglo dinamico
     */
    public String showElements() {

        String resoult = "";
        for (int i = 0; i < sizeofarray; i++) {
            resoult += (arrayList[i] + " ");
        }
        System.out.println(resoult);
        return resoult;
    }

    /**
     * Permite hacer nulo el ultimo elemento del arreglo dinamico
     */
    public void Eliminar() {
        for (int i = 0; i == count; i++) {
            if (i == count) {
                arrayList[i] = "";
                count = count - 1;
                sizeofarray = sizeofarray - 1;
            }
        }
    }
}
