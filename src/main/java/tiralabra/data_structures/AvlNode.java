package tiralabra.data_structures;

/* @author mhaanran */
public class AvlNode {
    
    private AvlNode left;
    private AvlNode right;
    private AvlNode parent;
    private int key;
    private int height;

    public AvlNode(int key) {
        this.key=key;
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
