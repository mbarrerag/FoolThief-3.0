package logic;

/**
 * Clase Nodo utilizada en el árbol AVL.
 */
public class NodeTree {

    public Stolen data;
    public NodeTree left;
    public NodeTree right;
    int height;

    NodeTree(Stolen data) {
        this.data = data;
        right = null;
        left = null;
        height = 0;
    }

    public Stolen getData() {
        return data;
    }

    public void setData(Stolen data) {
        this.data = data;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }
}
