package tiralabra.data_structures;

/* @author mhaanran */
public class FibonaccinKeko {

    private FibNode head;
    private FibNode min;
    private int heapSize;

    public FibonaccinKeko() {
        head = null;
        min = null;
        heapSize = 0;
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
    public String toString() {
        return ""+heapSize+"::"+min.getKey()+":"+head.getKey()+":"+head.getSibling();
    }
}
