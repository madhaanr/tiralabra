package tiralabra.data_structures;

/**
 * Luokka toteuttaa binomikeon.
 * @author mhaanran
 */
public class BinomiKeko {

    private LinkitettyLista lista;
    
    /**
     * Make-Binomial-Heap
     */
    public BinomiKeko(int key) {
        lista=new LinkitettyLista();
        lista.lisaa(key);
    }
    
    /**
     * Binomial-Heap-Minimum(Heap)
     * @return
     */
    public int min() {
       return 0; 
    }
    public void insert(Link x) {
        
    }
}
