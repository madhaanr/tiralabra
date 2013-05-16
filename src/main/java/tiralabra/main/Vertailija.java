package tiralabra.main;

import tiralabra.data_structures.BinaariKeko;

/* @author mhaanran */
public class Vertailija {
    public static void main(String[] args) {
        int[] binKeko={1,2,3,4,5,6,7,8,9,10,11};
        int[] binKeko2={20,5,3,9,6,7,8,10,11};
        BinaariKeko binaariKeko = new BinaariKeko(binKeko2);
        System.out.println(binaariKeko);
        System.out.println(binaariKeko.heapMin(binKeko2));
        binaariKeko.heapInsert(2);
        binaariKeko.heapInsert(1);
        binaariKeko.heapInsert(4);
        System.out.println(binaariKeko);
        binaariKeko.deleteMin();
        binaariKeko.deleteMin();
        binaariKeko.deleteMin();
        binaariKeko.deleteMin();
        System.out.println(binaariKeko);
//        System.out.println(binaariKeko.parent(2)+"::"+binaariKeko.left(3)+"::"+binaariKeko.right(3)); 
    }
}
