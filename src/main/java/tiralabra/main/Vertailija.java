package tiralabra.main;

import java.util.PriorityQueue;
import tiralabra.data_structures.AVLpuu;
import tiralabra.data_structures.BinaariKeko;
import tiralabra.data_structures.BinomiKeko;
import tiralabra.data_structures.FibNode;
import tiralabra.data_structures.FibonaccinKeko;
import tiralabra.data_structures.Node;
/**
 * Vertailija on luokka tietorakenteiden vertailuun.
 * @author mhaanran
 */
public class Vertailija {
    public static void main(String[] args) {
        int ylaraja=100;
        
        //Alkiot syötetään normaalijärjestyksessä.
        PriorityQueue PQ = new PriorityQueue<Integer>();
        double inserttimeStartPQ = System.nanoTime();
        for (int i = 0; i < ylaraja ; i++) {
            PQ.add(i);
        }
        double inserttimeEndPQ = System.nanoTime();
        double inserteroPQ=(inserttimeEndPQ-inserttimeStartPQ)/1000000000;
        double timeStartPQ = System.nanoTime();
        for (int i = 0; i < ylaraja; i++) {
            PQ.remove(i);
        }
        double timeEndPQ = System.nanoTime();
        double eroPQ = (timeEndPQ-timeStartPQ)/1000000000;
        System.out.println(inserteroPQ+"s PQ lisäys\t\t\t"+eroPQ+"s PQ poisto");
        
        System.gc();
//        
//        BinaariKeko binaariKeko = new BinaariKeko();
//        double inserttimeStartBinKeko = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            binaariKeko.heapInsert(i);
//        }
//        double inserttimeEndBinKeko = System.nanoTime();
//        double inserteroBinKeko=(inserttimeEndBinKeko-inserttimeStartBinKeko)/1000000000;
//        double timeStartBinKeko = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            binaariKeko.deleteMin();
//        }
//        double timeEndBinKeko = System.nanoTime();
//        double eroBinaariKeko = (timeEndBinKeko-timeStartBinKeko)/1000000000;
//        System.out.println(inserteroBinKeko+"s binäärikeko lisäys\t\t"+eroBinaariKeko+"s binäärikeko poisto");
//        
//        System.gc();
//        
//        BinomiKeko binomiKeko = new BinomiKeko();
//        double inserttimeStartBinomiKeko = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            binomiKeko.insert(new Node(i));
//        }
//        double inserttimeEndBinomiKeko = System.nanoTime();
//        double inserteroBinomiKeko = (inserttimeEndBinomiKeko-inserttimeStartBinomiKeko)/1000000000;
//        double timeStartBinomiKeko = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            binomiKeko.removeMin();
//        }
//        double timeEndBinomiKeko = System.nanoTime();
//        double eroBinomiKeko = (timeEndBinomiKeko-timeStartBinomiKeko)/1000000000;
//        System.out.println(inserteroBinomiKeko+"s binomikeko lisäys\t\t"+eroBinomiKeko+"s binomikeko poisto");
//        
//        System.gc();
//        
//        FibonaccinKeko fiboKeko = new FibonaccinKeko();
//        double inserttimeStartFibonaccinKeko = System.nanoTime();
//        for (int i = 0; i < ylaraja+1; i++) {
//            fiboKeko.insert(new FibNode(i));
//        }
//        double inserttimeEndFibonaccinKeko = System.nanoTime();
//        double inserteroFibonaccinKeko = (inserttimeEndFibonaccinKeko-inserttimeStartFibonaccinKeko)/1000000000;
////        fiboKeko.removeMin();
//        double timeStartFibonaccinKeko = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            fiboKeko.removeMin();
//        }
//        double timeEndFibonaccinKeko = System.nanoTime();
//        double eroFibonaccinKeko = (timeEndFibonaccinKeko-timeStartFibonaccinKeko)/1000000000;
//        System.out.println(inserteroFibonaccinKeko+"s Fibonaccinkeko lisäys\t"+eroFibonaccinKeko+"s Fibonaccinkeko poisto");
//        
//        System.gc();
        
//        AVLpuu avlPuu = new AVLpuu();
//        double inserttimeStartAvlpuu = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            avlPuu.insert(i);
//        }
//        double inserttimeEndAvlpuu = System.nanoTime();
//        double inserteroAvlpuu = (inserttimeEndAvlpuu-inserttimeStartAvlpuu)/1000000000;
//        double timeStartAVLpuu = System.currentTimeMillis();
//        for (int i = 0; i < ylaraja; i++) {
//            avlPuu.delete(avlPuu.getJuuri());
//        }
//        double timeEndAVLpuu = System.currentTimeMillis();
//        double eroAVLpuu = (timeEndAVLpuu-timeStartAVLpuu)/1000;
//        System.out.println(inserteroAvlpuu+"s AVL-puu lisäys\t\t"+eroAVLpuu+"s AVL-puu poisto");
//        System.out.println("----------------------------------------------------------------");
//        System.gc();

//        //Alkiot syötetään käänteisessä järjestyksessä.
//        int vahenna=ylaraja;
//        PriorityQueue PQ2 = new PriorityQueue<Integer>();
//        for (int i = 0; i < ylaraja ; i++) {
//            PQ2.add(vahenna-i);
//        }
//        double timeStartPQ2 = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            PQ2.remove(i);
//        }
//        double timeEndPQ2 = System.nanoTime();
//        double eroPQ2 = (timeEndPQ2-timeStartPQ2)/1000000000;
//        System.out.println(eroPQ2+"s PQ käänteinenjärjestys");
//        
//        BinaariKeko binaariKeko2 = new BinaariKeko();
//        for (int i = 0; i < ylaraja; i++) {
//            binaariKeko2.heapInsert(vahenna-i);
//        }
//        double timeStartBinKeko2 = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            binaariKeko2.deleteMin();
//        }
//        double timeEndBinKeko2 = System.nanoTime();
//        double eroBinaariKeko2 = (timeEndBinKeko2-timeStartBinKeko2)/1000000000;
//        System.out.println(eroBinaariKeko2+"s binäärikeko käänteinenjärjestys ");
//        
//        BinomiKeko binomiKeko2 = new BinomiKeko();
//        for (int i = 0; i < ylaraja; i++) {
//            binomiKeko2.insert(new Node(vahenna-i));
//        }
//        double timeStartBinomiKeko2 = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            binomiKeko2.removeMin();
//        }
//        double timeEndBinomiKeko2 = System.nanoTime();
//        double eroBinomiKeko2 = (timeEndBinomiKeko2-timeStartBinomiKeko2)/1000000000;
//        System.out.println((eroBinomiKeko2+"s binomikeko käänteinenjärjestys"));
//        
//        FibonaccinKeko fiboKeko2 = new FibonaccinKeko();
//        for (int i = 0; i < ylaraja+1; i++) {
//            fiboKeko2.insert(new FibNode(vahenna-i));
//        }
//        fiboKeko2.removeMin();
//        double timeStartFibonaccinKeko2 = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            fiboKeko2.removeMin();
//        }
//        double timeEndFibonaccinKeko2 = System.nanoTime();
//        double eroFibonaccinKeko2 = (timeEndFibonaccinKeko2-timeStartFibonaccinKeko2)/1000000000;
//        System.out.println((eroFibonaccinKeko2+"s Fibonaccinkeko käänteinenjärjestys"));
//        
//        AvlNode[] nodet = new AvlNode[ylaraja];
//        AVLpuu avlPuu2 = new AVLpuu();
//         for (int i = 0; i < ylaraja; i++) {
//            nodet[i]=avlPuu2.insert(vahenna-i);
//        }
//        double timeStartAVLpuu2 = System.nanoTime();
//        for (int i = 0; i < ylaraja; i++) {
//            avlPuu2.delete(nodet[i]);
//        }
//        double timeEndAVLpuu2 = System.nanoTime();
//        double eroAVLpuu2 = (timeEndAVLpuu2-timeStartAVLpuu2)/1000000000;
//        System.out.println((eroAVLpuu2+"s AVL-puu poisto"));
//        
//        System.out.println("----------------------------------------------------------------");
//        System.gc();
//        //Alkioita syötetään satunnaisessa järjestyksessä.
//        int satunnainenKoko=500000;   
//        int[] satunnainen = new int[satunnainenKoko];
//        for (int i = 0; i < satunnainenKoko; i++) {
//            satunnainen[i]=(int)Math.random() * 5000000;
//        }
//        
//        System.gc();
//        
////        PriorityQueue PQ3 = new PriorityQueue<Integer>();
////        for (int i = 0; i < satunnainenKoko ; i++) {
////            PQ3.add(satunnainen[i]);
////        }
////        double timeStartPQ3 = System.nanoTime();
////        for (int i = 0; i < satunnainenKoko; i++) {
////            PQ3.remove(i);
////        }
////        double timeEndPQ3 = System.nanoTime();
////        double eroPQ3 = (timeEndPQ3-timeStartPQ3)/1000000000;
////        System.out.println(eroPQ3+"s PQ satunnaisjärjestys");
////        
////        System.gc();
//        BinaariKeko binaariKeko3 = new BinaariKeko();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            binaariKeko3.heapInsert(satunnainen[i]);
//        }
//        double timeStartBinKeko3 = System.nanoTime();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            binaariKeko3.deleteMin();
//        }
//        double timeEndBinKeko3 = System.nanoTime();
//        double eroBinaariKeko3 = (timeEndBinKeko3-timeStartBinKeko3)/1000000000;
//        System.out.println(eroBinaariKeko3+"s binäärikeko satunnaisjärjestys ");
//        
//        BinomiKeko binomiKeko3 = new BinomiKeko();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            binomiKeko3.insert(new Node(satunnainen[i]));
//        }
//        double timeStartBinomiKeko3 = System.nanoTime();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            binomiKeko3.removeMin();
//        }
//        double timeEndBinomiKeko3 = System.nanoTime();
//        double eroBinomiKeko3 = (timeEndBinomiKeko3-timeStartBinomiKeko3)/1000000000;
//        System.out.println((eroBinomiKeko3+"s binomikeko satunnaisjärjestys"));
//        
//        FibonaccinKeko fiboKeko3 = new FibonaccinKeko();
//         for (int i = 0; i < satunnainenKoko+1; i++) {
//            fiboKeko3.insert(new FibNode(i));
//        }
//        fiboKeko3.removeMin();
//        double timeStartFibonaccinKeko3 = System.nanoTime();
//        for (int i = 0; i < satunnainenKoko; i++) {
//            fiboKeko3.removeMin();
//        }
//        double timeEndFibonaccinKeko3 = System.nanoTime();
//        double eroFibonaccinKeko3 = (timeEndFibonaccinKeko3-timeStartFibonaccinKeko3)/1000000000;
//        System.out.println((eroFibonaccinKeko3+"s Fibonaccinkeko satunnaisjärjestys"));
//        
//        AVLpuu avlPuu = new AVLpuu();
//         for (int i = 0; i < ylaraja; i++) {
//            avlPuu.insert(i);
//        }
//        double timeStartAVLpuu = System.currentTimeMillis();
//        for (int i = 0; i < ylaraja; i++) {
//            avlPuu.delete(avlPuu.getJuuri());
//        }
//        double timeEndAVLpuu = System.currentTimeMillis();
//        double eroAVLpuu = (timeEndAVLpuu-timeStartAVLpuu)/1000;
//        System.out.println((eroAVLpuu+"s AVL-puu"));
//        FibonaccinKeko fibonaccinKeko = new FibonaccinKeko();
//        FibNode fibNode1 = new FibNode(1);
//        FibNode fibNode2 = new FibNode(2);
//        FibNode fibNode3 = new FibNode(3);
//        FibNode fibNode4 = new FibNode(4);
//        FibNode fibNode5 = new FibNode(5);
//        FibNode fibNode6 = new FibNode(6);
//        FibNode fibNode7 = new FibNode(7);
//        FibNode fibNode8 = new FibNode(8);
//        FibNode fibNode9 = new FibNode(9);
//        fibonaccinKeko.insert(fibNode1);
//        fibonaccinKeko.insert(fibNode2);
//        fibonaccinKeko.insert(fibNode3);
//        fibonaccinKeko.insert(fibNode4);
//        fibonaccinKeko.insert(fibNode5);
//        fibonaccinKeko.insert(fibNode6);
//        fibonaccinKeko.insert(fibNode7);
//        fibonaccinKeko.insert(fibNode8);
//        fibonaccinKeko.insert(fibNode9);
//        String poisto="";
//        poisto+=    fibonaccinKeko.removeMin();
//        poisto+=" "+fibonaccinKeko.removeMin();
//        poisto+=" "+fibonaccinKeko.removeMin();
//        poisto+=" "+fibonaccinKeko.removeMin();
//        poisto+=" "+fibonaccinKeko.removeMin();
//        poisto+=" "+fibonaccinKeko.removeMin();
// 
//        
//        
//        System.out.println(fibonaccinKeko+"\npoistettu: "+poisto);
//        AVLpuu avlPuu=new AVLpuu();
//        for (int i = 0; i < 5; i++) {
//            avlPuu.insert(i);
//        }
//        for (int i = 500; i < 505; i++) {
//            avlPuu.insert(i);
//        }
//        for (int i = 30; i < 36; i++) {
//            avlPuu.insert(i);
//        }
//        for (int i = 1000; i < 1005; i++) {
//            avlPuu.insert(i);
//        }
//        avlPuu.tulostaAlkiot(avlPuu.getJuuri());
       
//        avl.insert(4);
//        avl.insert(8);
//        avl.insert(9);
//        avl.insert(100);
//        avl.insert(30);
//        avl.insert(15);
//        avl.insert(3000);
//        avl.delete(5);
            
    }
}
