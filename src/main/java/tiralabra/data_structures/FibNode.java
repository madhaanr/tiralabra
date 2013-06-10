package tiralabra.data_structures;

/**
 * FibNode luokkaa käytetään fibonaccin keon kanssa. Jokainen 
 * fibonaccin keon solmu on
 * fibnodeluokan ilmentymä ja sillä on luokan määrittelemät muuttujat.
 * @author mhaanran
 */
public class FibNode {

    private int key;
    private FibNode parent;
    private FibNode child;
    private FibNode left;
    private FibNode right;
    private int degree;
    private boolean mark;
   
    public FibNode(int key) {
        this.key=key; 
        parent=null;
        child=null;
        left=this;
        right=this;  
        degree=0;
        mark=false;
    }
  
    public int getKey() {
        return key;
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
    public int getChildKey() {
        return child.key;
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

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }
    
    
}
