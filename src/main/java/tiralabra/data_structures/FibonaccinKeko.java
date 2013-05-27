package tiralabra.data_structures;

/* @author mhaanran */
public class FibonaccinKeko {

    private FibNode head;
    private FibNode min;
    private int heapSize;

    
    /**
     * Konstruktori luo uuden tyhjän keon.
     */
    public FibonaccinKeko() {
        head = null;
        min = null;
        heapSize = 0;
    }
    
    /**
     * Metodi palauttaa keon pienimmän alkion
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
        FibonaccinKeko fibKeko = new FibonaccinKeko();
        fibKeko.head = lisattava;
        if (min == null) {
            head = fibKeko.head;
            min = fibKeko.head;
        } else {
            head = fibKeko.head;
            if (fibKeko.head.getKey() < min.getKey()) {
               
                min = fibKeko.head;
            }
        }
        heapSize = heapSize + 1;
    }
    public FibonaccinKeko union(FibonaccinKeko fibKeko) {
        FibonaccinKeko keko = new FibonaccinKeko();
        keko.min=fibKeko.min;
        
        return keko;
    }
    public String toString() {
        return ""+heapSize+"::"+min.getKey()+":"+head.getKey();
    }
}
