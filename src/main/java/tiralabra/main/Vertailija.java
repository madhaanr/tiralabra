package tiralabra.main;

import java.util.PriorityQueue;
import tiralabra.data_structures.BinaariKeko;
import tiralabra.data_structures.BinomiKeko;
import tiralabra.data_structures.FibNode;
import tiralabra.data_structures.FibonaccinKeko;
import tiralabra.data_structures.Node;

/* @author mhaanran */
public class Vertailija {
    public static void main(String[] args) {
//        int ylaraja=30000000;
//        
//        //Alkiot syötetään normaalijärjestyksessä.
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
//        BinaariKeko binaariKeko = new BinaariKeko();
//        for (int i = 0; i < ylaraja; i++) {
//            binaariKeko.heapInsert(i);
//        }
//        double timeStartBinKeko = System.currentTimeMillis();
//        for (int i = 0; i < ylaraja; i++) {
//            binaariKeko.deleteMin();
//        }
//        double timeEndBinKeko = System.currentTimeMillis();
//        double eroBinaariKeko = (timeEndBinKeko-timeStartBinKeko)/1000;
//        System.out.println(eroBinaariKeko+"s binäärikeko");
//        
//        BinomiKeko binomiKeko = new BinomiKeko();
//        for (int i = 0; i < ylaraja; i++) {
//            binomiKeko.insert(new Node(i));
//        }
//        double timeStartBinomiKeko = System.currentTimeMillis();
//        for (int i = 0; i < ylaraja; i++) {
//            binomiKeko.removeMin();
//        }
//        double timeEndBinomiKeko = System.currentTimeMillis();
//        double eroBinomiKeko = (timeEndBinomiKeko-timeStartBinomiKeko)/1000;
//        System.out.println((eroBinomiKeko+"s binomikeko"));
//        
//
//        //Alkiot syötetään käänteisessä järjestyksessä.
//        int vahenna=ylaraja;
//        PriorityQueue PQ2 = new PriorityQueue<Integer>();
//        for (int i = 0; i < ylaraja ; i++) {
//            PQ2.add(vahenna-i);
//        }
//        double timeStartPQ2 = System.currentTimeMillis();
//        for (int i = 0; i < ylaraja; i++) {
//            PQ2.remove(i);
//        }
//        double timeEndPQ2 = System.currentTimeMillis();
//        double eroPQ2 = (timeEndPQ2-timeStartPQ2)/1000;
//        System.out.println(eroPQ2+"s PQ käänteinenjärjestys");
//        
//        BinaariKeko binaariKeko2 = new BinaariKeko();
//        for (int i = 0; i < ylaraja; i++) {
//            binaariKeko2.heapInsert(vahenna-i);
//        }
//        double timeStartBinKeko2 = System.currentTimeMillis();
//        for (int i = 0; i < ylaraja; i++) {
//            binaariKeko2.deleteMin();
//        }
//        double timeEndBinKeko2 = System.currentTimeMillis();
//        double eroBinaariKeko2 = (timeEndBinKeko2-timeStartBinKeko2)/1000;
//        System.out.println(eroBinaariKeko2+"s binäärikeko käänteinenjärjestys ");
//        
//        BinomiKeko binomiKeko2 = new BinomiKeko();
//        for (int i = 0; i < ylaraja; i++) {
//            binomiKeko2.insert(new Node(vahenna-i));
//        }
//        double timeStartBinomiKeko2 = System.currentTimeMillis();
//        for (int i = 0; i < ylaraja; i++) {
//            binomiKeko2.removeMin();
//        }
//        double timeEndBinomiKeko2 = System.currentTimeMillis();
//        double eroBinomiKeko2 = (timeEndBinomiKeko2-timeStartBinomiKeko2)/1000;
//        System.out.println((eroBinomiKeko2+"s binomikeko käänteinenjärjestys"));
        
//        //Alkioita syötetään satunnaisessa järjestyksessä.
//        int satunnainenKoko=100000;   
//        int[] satunnainen = new int[satunnainenKoko];
//        for (int i = 0; i < satunnainenKoko; i++) {
//            satunnainen[i]=(int)Math.random() * 500000;
//        }
//        
//        System.gc();
//        
//        PriorityQueue PQ3 = new PriorityQueue<Integer>();
//        for (int i = 0; i < satunnainenKoko ; i++) {
//            PQ3.add(satunnainen[i]);
//        }
//        double timeStartPQ3 = System.currentTimeMillis();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            PQ3.remove(i);
//        }
//        double timeEndPQ3 = System.currentTimeMillis();
//        double eroPQ3 = (timeEndPQ3-timeStartPQ3)/1000;
//        System.out.println(eroPQ3+"s PQ satunnaisjärjestys");
//        
//        System.gc();
//        BinaariKeko binaariKeko3 = new BinaariKeko();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            binaariKeko3.heapInsert(satunnainen[i]);
//        }
//        double timeStartBinKeko3 = System.currentTimeMillis();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            binaariKeko3.deleteMin();
//        }
//        double timeEndBinKeko3 = System.currentTimeMillis();
//        double eroBinaariKeko3 = (timeEndBinKeko3-timeStartBinKeko3)/1000;
//        System.out.println(eroBinaariKeko3+"s binäärikeko satunnaisjärjestys ");
//        
//        BinomiKeko binomiKeko3 = new BinomiKeko();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            binomiKeko3.insert(new Node(satunnainen[i]));
//        }
//        double timeStartBinomiKeko3 = System.currentTimeMillis();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            binomiKeko3.removeMin();
//        }
//        double timeEndBinomiKeko3 = System.currentTimeMillis();
//        double eroBinomiKeko3 = (timeEndBinomiKeko3-timeStartBinomiKeko3)/1000;
//        System.out.println((eroBinomiKeko3+"s binomikeko satunnaisjärjestys"));
        
        FibonaccinKeko fibonaccinKeko = new FibonaccinKeko();
        FibNode fibNode1 = new FibNode(1);
        FibNode fibNode2 = new FibNode(2);
        FibNode fibNode3 = new FibNode(3);
        FibNode fibNode4 = new FibNode(4);
        FibNode fibNode5 = new FibNode(5);
        FibNode fibNode6 = new FibNode(6);
        FibNode fibNode7 = new FibNode(7);
        FibNode fibNode8 = new FibNode(8);
        FibNode fibNode9 = new FibNode(9);
        fibonaccinKeko.insert(fibNode1);
        fibonaccinKeko.insert(fibNode2);
        fibonaccinKeko.insert(fibNode3);
        fibonaccinKeko.insert(fibNode4);
        fibonaccinKeko.insert(fibNode5);
        fibonaccinKeko.insert(fibNode6);
        fibonaccinKeko.insert(fibNode7);
        fibonaccinKeko.insert(fibNode8);
        fibonaccinKeko.insert(fibNode9);
        String poisto="";
        poisto+=    fibonaccinKeko.removeMin();
        poisto+=" "+fibonaccinKeko.removeMin();
        poisto+=" "+fibonaccinKeko.removeMin();
        poisto+=" "+fibonaccinKeko.removeMin();
        poisto+=" "+fibonaccinKeko.removeMin();
        poisto+=" "+fibonaccinKeko.removeMin();
 
        
        
        System.out.println(fibonaccinKeko+"\npoistettu: "+poisto);
    }
}
