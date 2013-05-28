package tiralabra.data_structures;

/* @author mhaanran */
public class FibonaccinKeko {

    private FibNode min;
    private int heapSize;
  
    /**
     * Konstruktori luo uuden tyhjän Fibonaccin keon.
     */
    public FibonaccinKeko() {
        min = null;
        heapSize = 0;
    }
    
    /**
     * Metodi palauttaa keon pienimmän alkion key kentän arvon.
     * @return pienin alkio on tallennettu min muuttujan arvoksi.
     */
    public int min() {
        return min.getKey();
    }
    
    /**
     * Metodilla lisätään fibonaccin kekoon uusia nodeja.
     * @param lisattava kekoon lisätään FibNode.
     */
    public void insert(FibNode lisattava) {
        if (min == null) {
            min=lisattava;         
        } else {     
            lisattava.setLeft(min);
            lisattava.setRight(min.getRight());
            min.setRight(lisattava);
            FibNode node = lisattava.getRight();
            if(node != null) {
                node.setLeft(lisattava);
            }
            if (lisattava.getKey() < min.getKey()) {            
                min = lisattava;
            }
        }
        heapSize = heapSize + 1;
    }
    
    public int removeMin() {
        FibNode minTalteen=min;
        if(min.getDegree()==0) {
            FibNode left=min.getLeft();
            FibNode right=min.getRight();        
            left.setRight(right);
            right.setLeft(left);
            min=right;
            while(left!=null) {
                if(left.getKey()<right.getKey()) {
                    min=left;         
                }  
                left=left.getLeft();
            }
            while(right!=null) {
                if(right.getKey()<min.getKey()) {
                    min=right;                 
                }
                right=right.getRight();
            }
            
        }
        heapSize=heapSize-1;
        return minTalteen.getKey();
    }
    public FibonaccinKeko union(FibonaccinKeko fibKeko) {
        FibonaccinKeko keko = new FibonaccinKeko();
        keko.min=fibKeko.min;
        
        return keko;
    }
    
    @Override
    public String toString() {
        String keko="";
        FibNode node = min;
        while(node!=null) {
            keko+=node.getKey();
            node=node.getRight();
        }
        FibNode node2 = min.getLeft();
        while(node2!=null) {
            keko+=node.getKey();
            node=node.getLeft();
        }
        return min.getKey()+"--"+keko+"--"+heapSize;
    }
}
