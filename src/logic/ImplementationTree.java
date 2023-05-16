package logic;

/**
 * Esta interface es utilizada en la implementación de arboles binarios y
 * arboles AVL.
 *
 * Establece los métodos en común entre los arboles que le implementará.
 *
 * @param <T> Clase que implemente la interfaz Comparable
 */
public interface ImplementationTree<T extends Comparable> {

    boolean itsEmpty();

    void makeEmpty();

    boolean exist(int id);

    T get(int id);

    void insert(T obj);

    void delete(int id);

    void preorder();

    void inorder();

    void postorder();

    boolean isLeaf();
}
