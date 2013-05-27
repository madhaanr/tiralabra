package tiralabra.data_structures;

/* @author mhaanran */
public class FibNode {

    private int key;
    private FibNode parent;
    private FibNode child;
    private FibNode left;
    private FibNode right;
    private int degree;
   
    public FibNode(int key) {
        this.key=key;
        this.parent=null;
        this.child=null;
        this.left=null;
        this.right=null;
        this.degree=0;
                
    }
    public FibNode() {
        
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public FibNode getParent() {
        return parent;
    }

    public void setParent(FibNode parent) {
        this.parent = parent;
    }

    public FibNode getChild() {
        return child;
    }

    public void setChild(FibNode child) {
        this.child = child;
    }
 
    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public FibNode getLeft() {
        return left;
    }

    public void setLeft(FibNode left) {
        this.left = left;
    }

    public FibNode getRight() {
        return right;
    }

    public void setRight(FibNode right) {
        this.right = right;
    }
    
    
}
