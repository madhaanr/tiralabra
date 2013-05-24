package tiralabra.data_structures;

/**
 *
 * @author mhaanran
 * Luokka toteuttaa minimi binäärikeon.
 */
public class BinaariKeko {
    
    private int[] binKeko;
    private int heapSize;
    private int taulukonKoko=100;
       
    /**
     * Luodaan syötteenä saadusta taulukosta minimi binäärikeko.
     * @param binKeko
     */
    public BinaariKeko(int[] binKeko) {
        this.binKeko=buildHeap(binKeko);
    }
    public BinaariKeko() {
        this.binKeko = new int[taulukonKoko];
    }
   
    /**
     * Metodi palauttaa syötteenä annetun indeksin parentin eli keossa 
     * ylemmällä tasolla olevan arvon indeksin.
     * @param i alkion indeksi.
     * @return indeksi jaettuna kahdella.
     */
    public int parent(int i) {
        return i / 2;
    }

    /**
     * Metodi palauttaa ylemmän tason indeksiä alemmalla tasolla olevan 
     * lapsen indeksin. Tässä tapauksessa vasemman lapsen indeksin.
     * @param i alkion indeksi.
     * @return indeksi i*2.
     */
    public int left(int i) {
        return 2 * i;
    }

    /**
     * Metodi palauttaa ylemmän tason indeksiä alemmalla tasolla olevan 
     * lapsen indeksin. Tässä tapauksessa oikean lapsen indeksin.
     * @param i alkion indeksi.
     * @return indeksi*2+1
     */
    public int right(int i) {
        return 2 * i + 1;
    }

    public int getHeapSize() {
        return heapSize;
    }
    
    /**
     * Metodi palauttaa keon pienimmän alkion.
     * Minimi keon pienin alkio on indeksissä 0.
     * @param binKeko 
     * @return 
     */
    public int heapMin(int[] binKeko) {
        return binKeko[0];
    }
    
    /**
     * Poistaa pienimmän arvon keosta. Käyttää apumetodina decreaseHeapSizea 
     * joka pienentää keon kokoa yhdellä ja kopioi muut paitsi viimeisenä keossa
     * olevan alkion uuteen kekoon
     * @return poistettava, keon pienin arvo.
     */
    public int deleteMin() {
        int min = binKeko[0];
        binKeko[0]=binKeko[heapSize-1];
        binKeko=decreaseHeapSize();
        minHeapify(binKeko,0);
        return min;
    }
    
    private int[] decreaseHeapSize() {
        heapSize=heapSize-1;
        if(heapSize<taulukonKoko/2&&heapSize>=100) {
            taulukonKoko=taulukonKoko/2;
            int[] binKeko2 = new int[taulukonKoko];
            for (int i = 0; i < binKeko2.length; i++) {
                 binKeko2[i]=binKeko[i];
             }
            return binKeko2;
        }             
        return binKeko;
    }
    
    /**
     * Lisää arvon keokoon. Käyttää apumetodina increaseHeapSizea 
     * joka kasvattaa keon kokoa yhdellä ja kopioi alkiot kekoon
     * @return poistettava arvo
     */
    public void heapInsert(int k) {
        binKeko=increaseHeapSize();
        int i=heapSize-1;
        while(i>0 && binKeko[parent(i)]>k) {
            binKeko[i]=binKeko[parent(i)];
            i=parent(i);
        }
        binKeko[i]=k;
    }
    private int[] increaseHeapSize() {
        heapSize=heapSize+1;
        if(taulukonKoko<heapSize) {
            taulukonKoko=taulukonKoko*2;
            int[] binKeko2 = new int[taulukonKoko];
            for (int i = 0; i < binKeko.length; i++) {
                binKeko2[i] = binKeko[i];
            }
            return binKeko2;
        }  
        
        return binKeko;
    }
    
    private int[] buildHeap(int[] binKeko) {
        heapSize=binKeko.length;
        for(int i=binKeko.length/2; i>=0;--i ) {
            minHeapify(binKeko,i);
        }
        return binKeko;
    }
    
    private int[] minHeapify(int[] binKeko, int i) {
        int left = left(i);
        int right = right(i);
        int smallest;
        if (right <= heapSize-1) {
            if (binKeko[left] < binKeko[right]) {
                smallest = left;
            } else {
                smallest = right;
            }
            if (binKeko[i] > binKeko[smallest]) {
                swapSmallestwithI(binKeko, i, smallest);      
                minHeapify(binKeko, smallest);
            }
        } else if (left == heapSize-1 && binKeko[i] > binKeko[left]) {
            swapSmallestwithI(binKeko, i, left);         
        }
        return binKeko;
    } 
    
    private void swapSmallestwithI(int[] binKeko, int i, int smallest) {
        int apu = binKeko[i];
        binKeko[i] = binKeko[smallest];
        binKeko[smallest] = apu;
    }

    @Override
    public String toString() {
        String k = "";
        for (int i = 0; i < heapSize; i++) {
            k += " "+binKeko[i];
        }
        return k;
    }
}