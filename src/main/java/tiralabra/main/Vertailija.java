package tiralabra.main;

import java.util.PriorityQueue;
import tiralabra.data_structures.BinaariKeko;
import tiralabra.data_structures.BinomiKeko;
import tiralabra.data_structures.Node;

/* @author mhaanran */
public class Vertailija {
    public static void main(String[] args) {
        int ylaraja=30000000;
//        PriorityQueue PQ = new PriorityQueue<Integer>();
//        for (int i = 0; i < ylaraja ; i++) {
//            PQ.add(i);
//        }
//        double timeStartPQ = System.currentTimeMillis();
//        for (int i = 0; i < ylaraja; i++) {
//            PQ.remove(i);
//        }
//        double timeEndPQ = System.currentTimeMillis();
//        double eroPQ = (timeEndPQ-timeStartPQ)/1000;
//        System.out.println(eroPQ+"s PQ");
//        
        BinaariKeko binaariKeko = new BinaariKeko();
        for (int i = 0; i < ylaraja; i++) {
            binaariKeko.heapInsert(i);
        }
        double timeStartBinKeko = System.currentTimeMillis();
        for (int i = 0; i < ylaraja; i++) {
            binaariKeko.deleteMin();
        }
        double timeEndBinKeko = System.currentTimeMillis();
        double eroBinaariKeko = (timeEndBinKeko-timeStartBinKeko)/1000;
        System.out.println(eroBinaariKeko+"s binäärikeko");
        
        BinomiKeko binomiKeko = new BinomiKeko();
        for (int i = 0; i < ylaraja; i++) {
            binomiKeko.insert(new Node(i));
        }
        double timeStartBinomiKeko = System.currentTimeMillis();
        for (int i = 0; i < ylaraja; i++) {
            binomiKeko.removeMin();
        }
        double timeEndBinomiKeko = System.currentTimeMillis();
        double eroBinomiKeko = (timeEndBinomiKeko-timeStartBinomiKeko)/1000;
        System.out.println((eroBinomiKeko+"s binomikeko"));
//        BinomiKeko binomiKeko=new BinomiKeko();
//        Node[] nodet = new Node[10];
//        nodet[0]=new Node(10);
//        nodet[1]=new Node(15);
//        nodet[2]=new Node(1);
//        nodet[3]=new Node(7);
//        nodet[4]=new Node(9);
//        nodet[5]=new Node(3);
//        nodet[6]=new Node(4);
//        nodet[7]=new Node(5);
//        nodet[8]=new Node(6);
//        nodet[9]=new Node(20);
//        binomiKeko.insert(nodet[0]);
//        binomiKeko.insert(nodet[1]);
//        binomiKeko.insert(nodet[2]);
//        binomiKeko.insert(nodet[3]);
//        binomiKeko.insert(nodet[4]);
//        binomiKeko.insert(nodet[5]);
//        binomiKeko.insert(nodet[6]);
//        binomiKeko.insert(nodet[7]);
//        binomiKeko.insert(nodet[8]);
//        binomiKeko.insert(nodet[9]);
//        System.out.println(binomiKeko.removeMin());
//        System.out.println(binomiKeko.removeMin());
//        System.out.println(binomiKeko.removeMin());
//        System.out.println(binomiKeko.min());
//        System.out.println(binomiKeko);
//        int[] binaariKeko={1,2,3,4,5,6,7,8,9,10,11};
//        int[] binKeko2={20,5,3,9,6,7,8,10,11};
//        BinaariKeko binaariKeko = new BinaariKeko(binKeko2);
//        System.out.println(binaariKeko);
//        System.out.println(binaariKeko.heapMin(binKeko2));
//        binaariKeko.heapInsert(2);
//        binaariKeko.heapInsert(1);
//        binaariKeko.heapInsert(4);
//        System.out.println(binaariKeko);
//        binaariKeko.deleteMin();
//        binaariKeko.deleteMin();
//        binaariKeko.deleteMin();
//        binaariKeko.deleteMin();
//        System.out.println(binaariKeko);
//        System.out.println(binaariKeko.parent(1)+"::"+binaariKeko.parent(2)+"::"+binaariKeko.left(3)+"::"+binaariKeko.right(3)); 
    }
}
