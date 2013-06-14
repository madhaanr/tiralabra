package tiralabra.data_structures;

/**
 * AvlNode luokkaa käytetään Avl-puun kanssa. Jokainen avl-puun solmu on
 * avlnode-luokan ilmentymä ja sillä on luokan määrittelemät muuttujat.
 * @author mhaanran
 */
public class AvlNode {
    
    private AvlNode left;
    private AvlNode right;
    private AvlNode parent;
    private int key;
    private int height;

    /**
     * Konstruktori uuden AvlPuun solmun luontia varten.
     * @param key Avain joka puuhun halutaan tallentaa.
     */
    public AvlNode(int key) {
        this.key=key;
        this.left=null;
        this.right=null;
        this.parent=null;
        this.height=0;     
    }
    
    public AvlNode getLeft() {
        return left;
    }

    public void setLeft(AvlNode left) {
        this.left = left;
    }

    public AvlNode getRight() {
        return right;
    }

    public void setRight(AvlNode right) {
        this.right = right;
    }

    public AvlNode getParent() {
        return parent;
    }

    public void setParent(AvlNode parent) {
        this.parent = parent;
    }
    
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }   
}
