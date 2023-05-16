package logic;

/**
 * Reporte de robo, Arbol AVL Arbol el cual guarda instancias del objeto Stolen
 * (Reporte de robo), los cuales seran los datos generales de los reportes.
 */
public class AvlTree implements ImplementationTree<Stolen> {

    private NodeTree root;

    AvlTree() {
        root = null;
    }

    /**
     * Verificacion del contenido del arbol
     *
     * @return root
     */
    @Override
    public boolean itsEmpty() {
        return root == null;
    }

    /**
     * Vacia el arbol, haciendo que la raiz sea null.
     */
    @Override
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * Al recibir una id, el arbol buscara dicha Id dentro de los nodos que
     * contega para confirmar lo contiene
     *
     * @param id
     * @return True si encuentra el valor o false donde no lo contenga
     */
    @Override
    public boolean exist(int id) {
        NodeTree node = searchNode(root, id);
        if (node != null) {
            if (node.getData().getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna el valor.
     *
     * @param id
     * @return Objeto Stolen
     */
    @Override
    public Stolen get(int id) {
        NodeTree node = searchNode(root, id);
        if (node != null) {
            return node.getData();
        }
        return null;
    }

    /**
     * Medotodo publico que realiza la insercion deontro del arbol al recibir
     * una instancia tipo Stolen
     *
     * @param obj instancia tipo Stolen
     */
    @Override
    public void insert(Stolen obj) {
        root = insert(root, obj);
    }

    /**
     * Metodo publico que permite eliminar una id del contenido del arbol
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        root = delete(root, id);
    }

    /**
     * Metodo privada el cual validadara si el arbol esta vacio o no, si el caso
     * lo requiere el lugar el cual debera ocupar un nuevo nodo
     *
     * @param node el cual contedra el objeto a insertar
     * @param obj tipo Stolen el cual se guardara
     * @return el nodo balanceado si es necesario
     */
    private NodeTree insert(NodeTree node, Stolen obj) {
        if (node == null) {
            return new NodeTree(obj);
        } else if (obj.compareTo(node.getData()) == 1) {
            node.right = insert(node.right, obj);
        } else if (obj.compareTo(node.getData()) == -1) {
            node.left = insert(node.left, obj);
        } else {
            throw new RuntimeException("ERROR: Duplicated insertion");
        }
        return rebalance(node);
    }

    /**
     * Metodo privado para eliminar del arbol un valor determinado de id, por
     * medio de comparaciones identificara el lugar del nodo y procedera a hacer
     * las validaciones necesarias para eliminar
     *
     * @param node en el cual se guardara el nuevo dato.
     * @param id a eliminar.
     * @return nodo sin el nodo que se ordeno eliminar.
     */
    private NodeTree delete(NodeTree node, int id) {
        if (node == null) {
            return node;
        } else if (id > node.getData().getId()) {
            node.right = delete(node.right, id);
        } else if (id < node.getData().getId()) {
            node.left = delete(node.left, id);
        } else {
            if (node.left == null || node.right == null) {
                if (node.left == null) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            } else {
                NodeTree mostLeftChild = mostLeftChild(node.right);
                node.setData(mostLeftChild.getData());
                node.right = delete(node.right, node.getData().getId());
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    /**
     * Buscara en el arbol el valor de la id idicado
     *
     * @param node
     * @param id valor el cual se quiere buscar
     * @return un nodo si lo encuentra
     */
    private NodeTree searchNode(NodeTree node, int id) {
        if (node == null || id == node.getData().getId()) {
            return node;
        }
        if (id < node.getData().getId()) {
            return searchNode(node.left, id);
        } else {
            return searchNode(node.right, id);
        }
    }

    /**
     * Permitira conocer el hijo que se encuentre mas a la izquierda dentro del
     * arbol (El dato menor)
     *
     * @param node
     * @return El nodo menor si lo encuentra
     */
    private NodeTree mostLeftChild(NodeTree node) {
        NodeTree current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Permite realizar un balanceo al evaluar cual deber ser el metodo de
     * balanceo necesario una vez pasa la altura maxima
     *
     * @param node
     * @return Retorna el nodo balanceado
     */
    private NodeTree rebalance(NodeTree node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.right.right) > height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (height(node.left.left) > height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }

        }
        return node;
    }

    /**
     * Permite realizar una rotacion hacia la derecha en el subarbol que tiene
     * como raiz el nodo pasado por parametro
     *
     * @param y
     * @return x permite saber la altura una vez rotado
     */
    private NodeTree rotateRight(NodeTree y) {
        NodeTree x = y.left;
        NodeTree z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     * Permite realizar una rotacion hacia la izquierda en el subarbol que tiene
     * como raiz el nodo pasado por parametro.
     *
     * @param y nodo raiz del subarbol a rotar
     * @return x permite nodo que pasa a ser la raiz
     */
    private NodeTree rotateLeft(NodeTree y) {
        NodeTree x = y.right;
        NodeTree z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     * Permite calcular la diferencia de la altura del nodo
     *
     * @param node recibe la raiz del arbol rotado
     */
    private void updateHeight(NodeTree node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Compara la altura de los sub arboles del nodo
     *
     * @param node
     * @return Altura de los subarboles
     */
    public int getBalance(NodeTree node) {
        if (node == null) {
            return 0;
        } else {
            return height(node.right) - height(node.left);
        }
    }

    /**
     * Permite conocer la altura de un node
     *
     * @param node
     * @return Altura del nodo
     */
    private int height(NodeTree node) {
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

    /**
     * Permite leer en forma la informacion en orden preorder
     */
    @Override
    public void preorder() {
        preorderHelper(root);
    }

    /**
     * Permite leer en forma la informacion en orden Inorder
     */
    @Override
    public void inorder() {
        inorderHelper(root);
    }

    /**
     * Permite leer en forma la informacion en orden postorder
     */
    @Override
    public void postorder() {
        postorderHelper(root);
    }

    /**
     * Permite seleccionar el order Inorder en el cual se presentaran los datos
     *
     * @param node nodo raiz que sea ingresado
     */
    private void inorderHelper(NodeTree node) {
        if (node != null) {
            inorderHelper(node.left);
            printData(node.getData());
            inorderHelper(node.right);
        }
    }

    /**
     * Permite seleccionar el order Preorder en el cual se presentaran los datos
     *
     * @param node nodo raiz que sea ingresado
     */
    private void preorderHelper(NodeTree node) {
        if (node != null) {
            printData(node.getData());
            preorderHelper(node.left);
            preorderHelper(node.right);
        }
    }

    /**
     * Permite seleccionar el order Preorder en el cual se presentaran los datos
     *
     * @param node nodo raiz que sea ingresado
     *
     */
    private void postorderHelper(NodeTree node) {
        if (node != null) {
            postorderHelper(node.left);
            postorderHelper(node.right);
            printData(node.getData());
        }
    }

    /**
     * Permite obtener la almacenada acerca de la informacion del informe
     *
     * @param stolen Parametro del objeto stolen
     */
    private void printData(Stolen stolen) {
        System.out.println("=======================");
        System.out.println("ID: " + stolen.getId());
        System.out.println("Nombre: " + stolen.getName());
        System.out.println("Fecha: " + stolen.getDate());
        System.out.println("Hora: " + stolen.getHour());
        System.out.println("Localidad: " + stolen.getNeighborhood());
        System.out.println("Objeto: " + stolen.getObject());
        System.out.println("Modalidad: " + stolen.getModusOperandi());
        System.out.println("Lugar: " + stolen.getPlace());
        System.out.println("Descripcion: " + stolen.getDescription());
        System.out.println("");
    }

    @Override
    public boolean isLeaf() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
