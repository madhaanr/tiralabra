package tiralabra.data_structures;

/* @author mhaanran */
public class AVLpuu {

    private AvlNode root;
    
    public int height(AvlNode x) {
        if(x==null) {
            return -1;
        }
        return x.getHeight();
    }
    
    public AvlNode rightRotate(AvlNode k1) {
        AvlNode k2 = k1.getLeft();
        k2.setParent(k1.getParent());
        k1.setParent(k2);
        k1.setLeft(k2.getRight());
        k2.setRight(k1);
        if(k1.getLeft()!=null) {
            k1.getLeft().setParent(k1);
        }
        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight()))+1);
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight()))+1);
        return k2;
    }
}
