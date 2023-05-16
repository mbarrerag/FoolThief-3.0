package logic;

public class BinaryTree implements ImplementationTree<Tops> {

    private BinaryTree left;
    private BinaryTree right;
    private Tops value;

    /**
     * Permite conocer si el arbol esta vacio
     *
     * @return Si es null retornara true
     */
    @Override
    public boolean itsEmpty() {
        return value == null;
    }

    /**
     * Permite vaciar el arbol
     */
    @Override
    public void makeEmpty() {
        value = null;
        right = null;
        left = null;
    }

    /**
     * Permite conocer si se encuentra una id en el arbol
     *
     * @param id identificador a buscar
     * @return Retorna true o false si encuentra o no el dato
     */
    @Override
    public boolean exist(int id) {
        if (value == null) {
            if (id == value.getNumRobberies()) {
                return true;

            } else if (id < value.getNumRobberies() && left != null) {
                return left.exist(id);
            } else if (id < value.getNumRobberies() && right != null) {
                return right.exist(id);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Permite obtener el valor relacionado con la id
     *
     * @param id
     * @return true o false si se encontro dicho valor
     */
    @Override
    public Tops get(int id) {
        if (value != null) {
            if (id == value.getNumRobberies()) {
                return value;
            } else if (id < value.getNumRobberies() && left != null) {
                return left.get(id);
            } else if (id > value.getNumRobberies() && right != null) {
                return right.get(id);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Permite insertar valor en el arbol binario
     *
     * @param top instacia del objeto a insertar
     */
    @Override
    public void insert(Tops top) {
        if (value == null) {
            this.value = top;
        } else {
            if (top.compareTo(value) < 0) {
                if (left == null) {
                    left = new BinaryTree();
                }
                left.insert(top);
            } else if (top.compareTo(top) >= 0) {
                if (right == null) {
                    right = new BinaryTree();
                }
                right.insert(top);
            } else {
                //throw new RuntimeException("Insertando un dato duplicado");
                System.out.println("No se inserto " + top.getData() + ", dato duplicado");
            }
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Permite leer en forma la informacion en orden preorder
     */
    @Override
    public void preorder() {
        if (value != null) {
            System.out.println(value.getData());
            if (left != null) {
                left.preorder();
            }
            if (right != null) {
                right.preorder();
            }
        }
    }

    /**
     * Permite leer la informacion en orden inorder
     */
    @Override
    public void inorder() {
        if (value != null) {
            if (left != null) {
                left.inorder();
            }
            System.out.println(value.getData());
            if (right != null) {
                right.inorder();
            }
        }
    }

    /**
     * Permite leer la informacion en orden postorder
     */
    @Override
    public void postorder() {
        if (value != null) {
            if (left != null) {
                left.postorder();
            }
            if (right != null) {
                right.postorder();
            }
            System.out.println(value.getData());
        }
    }

    /**
     * Permite leer la informacion en orden Inorder
     */
    public String inorderData() {
        String data = "";
        if (value != null) {
            if (left != null) {
                data += left.inorderData();
            }
            data += value.getData() + ",";
            if (right != null) {
                data += right.inorderData();
            }
        }
        return data;
    }

    /**
     * Permite saber si es una hoja
     *
     * @return
     */
    @Override
    public boolean isLeaf() {
        return value != null && left == null && right == null;
    }
}
