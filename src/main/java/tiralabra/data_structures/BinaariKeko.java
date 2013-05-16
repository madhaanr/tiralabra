package tiralabra.data_structures;

/**
 *
 * @author mhaanran
 * Luokka toteuttaa minimi binäärikeon.
 */
public class BinaariKeko {
    
    private int[] binKeko;
    private int heapSize;
    
    
    /**
     * Luodaan syötteenä saadusta taulukosta minimi binäärikeko.
     * @param binKeko
     */
    public BinaariKeko(int[] binKeko) {
        this.binKeko=buildHeap(binKeko);
    }
   
    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    public int getHeapSize() {
        return heapSize;
    }
    
    public int heapMin(int[] binKeko) {
        return binKeko[0];
    }
    
    /**
     * Poistaa pienimmän arvon keosta. Käyttää apumetodina decreaseHeapSizea 
     * joka pienentää keon kokoa yhdellä ja kopioi muut paitsi viimeisenä keossa
     * olevan alkion uuteen kekoon
     * @return poistettava arvo
     */
    public int deleteMin() {
        int min = binKeko[0];
//        System.out.println(binKeko[heapSize-1]+"::"+heapSize);
        binKeko[0]=binKeko[heapSize-1];
        binKeko=decreaseHeapSize();
        minHeapify(binKeko,0);
        return min;
    }
    private int[] decreaseHeapSize() {
        heapSize=heapSize-1;
        int[] binKeko2 = new int[heapSize];
        for (int i = 0; i < binKeko2.length; i++) {
            binKeko2[i]=binKeko[i];
        }          
        return binKeko2;
    }
    /**
     * Lisää arvon keokoon. Käyttää apumetodina increaseHeapSizea 
     * joka kasvattaa keon kokoa yhdellä ja kopioi alkiot kekoon
     * @return poistettava arvo
     */
    public void heapInsert(int k) {
        binKeko=increaseHeapSize();
        int i=heapSize-1;
//        System.out.println(this.binKeko.length+"--");
        while(i>0 && binKeko[parent(i)]>k) {
            binKeko[i]=binKeko[parent(i)];
            i=parent(i);
        }
        binKeko[i]=k;
    }
    private int[] increaseHeapSize() {
        heapSize=heapSize+1;
        int[] binKeko2 = new int[heapSize];
//        System.out.println(binKeko2.length+"--");
        for (int i = 0; i < binKeko.length; i++) {
            binKeko2[i] = binKeko[i];
        } 
        return binKeko2;
    }
    
    private int[] buildHeap(int[] binKeko) {
        heapSize=binKeko.length;
        for(int i=binKeko.length/2; i>=0;--i ) {
//            System.out.println("i="+i);
//            String k = "";
//            for (int l = 0; l < heapSize; l++) {
//                k += binKeko[l];
//            }
//            System.out.println(k);
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
//                System.out.println(i+":#:"+smallest);
                int apu = binKeko[i];
                binKeko[i] = binKeko[smallest];
                binKeko[smallest] = apu;      
//                System.out.println(binKeko[i] +"::"+ binKeko[smallest]);
                minHeapify(binKeko, smallest);
            }
        } else if (left == heapSize-1 && binKeko[i] > binKeko[left]) {
            int apu = binKeko[i];
            binKeko[i] = binKeko[left];
            binKeko[left] = apu; 
            
        }
        return binKeko;
    } 

    @Override
    public String toString() {
        String k = "";
        for (int i = 0; i < heapSize; i++) {
            k += " "+binKeko[i];
        }
        return k;
    }
    
//    private int[] maxHeapify(int[] binKeko, int i) {
//        int left = left(i);
//        int right = right(i);
//        int largest;
//        if (right <= heapSize-1) {
//            if (binKeko[left] > binKeko[right]) {
//                largest = left;
//            } else {
//                largest = right;
//            }
//            if (binKeko[i] < binKeko[largest]) {
////                System.out.println(i+":#:"+smallest);
//                int apu = binKeko[i];
//                binKeko[i] = binKeko[largest];
//                binKeko[largest] = apu;      
////                System.out.println(binKeko[i] +"::"+ binKeko[smallest]);
//                maxHeapify(binKeko, largest);
//            }
//        } else if (left == heapSize-1 && binKeko[i] < binKeko[left]) {
//            int apu = binKeko[i];
//            binKeko[i] = binKeko[left];
//            binKeko[left] = apu; 
//            
//        }
//        return binKeko;
//    }
}
