package data_structures;

/* @author mhaanran */
public class BinaariKeko {

    private int[] binKeko;
    private int heapSize;
    
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
    

    private int[] maxHeapify(int[] binKeko, int i) {
        int left = left(i);
        int right = right(i);
        int largest;
        if (right <= heapSize-1) {
            if (binKeko[left] > binKeko[right]) {
                largest = left;
            } else {
                largest = right;
            }
            if (binKeko[i] < binKeko[largest]) {
//                System.out.println(i+":#:"+smallest);
                int apu = binKeko[i];
                binKeko[i] = binKeko[largest];
                binKeko[largest] = apu;      
//                System.out.println(binKeko[i] +"::"+ binKeko[smallest]);
                maxHeapify(binKeko, largest);
            }
        } else if (left == heapSize-1 && binKeko[i] < binKeko[left]) {
            int apu = binKeko[i];
            binKeko[i] = binKeko[left];
            binKeko[left] = apu; 
            
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
            k += " : "+binKeko[i];
        }
        return k;
    }
}