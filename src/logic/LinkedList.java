package logic;

/**
 * Lista doblementa enlazada utilizada en el guardado de resumen de reporte,
 * Lista que guarda instancias de la clase Attempt
 *
 * @param <T> Tipo de objeto que guardará la lista
 */
public class LinkedList<T> {

    private NodeLinkedList<T> head;
    private NodeLinkedList<T> tail;
    private int length;

    LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Retorna el número de elementos contenidos en la lista.
     *
     * @return int: tamaño de la lista
     */
    public int size() {
        return length;
    }

    /**
     * Verifica si la lista no tiene elementos.
     *
     * @return boolean:
     * <ul>
     * <li>true: la lista esta vacia</li>
     * <li>false: la lista no esta vacia</li>
     * </ul>
     */
    public boolean itsEmpty() {
        return head == null;
    }

    /**
     * Vacia completamente la lista.
     */
    public void makeEmpty() {
        head = null;
        tail = null;
    }

    /**
     * Agrega un elemento al principio de la lista.
     *
     * @param data
     */
    public void addFirst(T data) {
        NodeLinkedList<T> node = new NodeLinkedList<T>(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
    }

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param data
     */
    public void add(T data) {
        NodeLinkedList<T> node = new NodeLinkedList<T>(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        length++;
    }

    /**
     * Recarga del método add(T data), recibe un indice e inserta el elemento en
     * el indice especificado.
     *
     * @param data
     * @param index
     */
    public void add(T data, int index) {
        if (index == length) {
            add(data);
        } else if (index == 0) {
            addFirst(data);
        } else if (index > 0 && index <= (length - 1)) {
            NodeLinkedList<T> node = new NodeLinkedList<T>(data);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                NodeLinkedList<T> pointer = head;
                int counter = 0;
                while ((counter < (index - 1)) && (pointer.getNext() != null)) {
                    pointer = pointer.getNext();
                    counter++;
                }
                node.setNext(pointer.getNext());
                pointer.getNext().setPrev(node);
                pointer.setNext(node);
                node.setPrev(pointer);
            }
        }
        length++;
    }

    /**
     * Retorna el objeto contenido en el primer nodo de la lista.
     *
     * @return T
     */
    public T getFirst() {
        if (head == null) {
            return null;
        } else {
            return head.getData();
        }
    }

    /**
     * Retorna el objeto contenido en el i-ésimo nodo de la lista.
     *
     * @param index
     * @return T
     */
    public T get(int index) {
        if (index == length) {
            getLast();
        } else if (index >= 0 && index <= (length - 1)) {
            NodeLinkedList<T> pointer = head;
            int counter = 0;
            while ((counter < index) && (pointer.getNext() != null)) {
                pointer = pointer.getNext();
                counter++;
            }
            if (counter != index) {
                return null;
            } else if (counter == index) {
                return pointer.getData();
            }
        }
        return null;
    }

    /**
     * Retorna el objeto contenido en el último nodo de la lista.
     *
     * @return T
     */
    public T getLast() {
        if (head == null) {
            return null;
        } else {
            return tail.getData();
        }
    }

    /**
     * Elimina el primer nodo de la lista.
     */
    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
            length--;
        }
    }

    /**
     * Elimina el i-ésimo nodo de la lista.
     *
     * @param index
     */
    public void remove(int index) {
        if (head != null) {
            if (index == 0) {
                removeFirst();
            } else if (index == length - 1) {
                removeLast();
            } else if ((index > 0) && (index < length)) {
                NodeLinkedList<T> pointer = head;
                int counter = 0;
                while ((counter < index - 1) && (pointer.getNext() != null)) {
                    pointer = pointer.getNext();
                    counter++;
                }
                NodeLinkedList<T> temp = pointer.getNext();
                pointer.setNext(temp.getNext());
                temp.getNext().setPrev(pointer);
                temp.setNext(null);
                temp.setPrev(null);
            }
        }
    }

    /**
     * Elimina el último nodo de la lista.
     */
    public void removeLast() {
        if (head != null) {
            NodeLinkedList<T> last = tail;
            tail = tail.getPrev();
            tail.setNext(null);
            last.setPrev(null);
            length--;
        }
    }

    /**
     * Método para prueba, recorre e imprime todos los datos de la lista.
     */
    public void displayElements() {
        if (head == null) {
            System.out.println("No elements");
        } else {
            NodeLinkedList<T> pointer = head;
            while (pointer != null) {
                System.out.println(pointer.getData().toString());
                pointer = pointer.getNext();
            }
        }
    }
}
