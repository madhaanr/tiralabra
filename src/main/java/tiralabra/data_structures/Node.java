package tiralabra.data_structures;

/* @author mhaanran */
public class Node {

    private int key;
    private Node parent;
    private Node child;
    private Node sibling;
    private int degree;
   
    public Node(int key) {
        this.key=key;
        this.parent=null;
        this.child=null;
        this.sibling=null;
        this.degree=0;
                
    }
    public Node() {
        
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getSibling() {
        return sibling;
    }

    public void setSibling(Node sibling) {
        this.sibling = sibling;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
    
}
