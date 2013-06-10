package tiralabra;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tiralabra.data_structures.FibNode;
import tiralabra.data_structures.FibonaccinKeko;

/**
 *
 * @author mhaanran
 */
public class FibonaccinKekoTest {
    
    FibonaccinKeko fibKeko;
    FibNode node0;
    FibNode node1;
    FibNode node2;
    FibNode node3;
    FibNode node4;
    FibNode node5;
    FibNode node100;
    FibNode node89;
    
    public FibonaccinKekoTest() {
        
    }
    
    @Before
    public void setUp() {
        fibKeko = new FibonaccinKeko();
        node0 = new FibNode(0);
        node1 = new FibNode(1);
        node2 = new FibNode(2);
        node3 = new FibNode(3);
        node4 = new FibNode(4);
        node5 = new FibNode(5);     
        node89 = new FibNode(89);
        node100= new FibNode(100);
    }
    
    @After
    public void tearDown() {
    }
   
    @Test
    public void isEmptyTrue() {
        assertTrue(fibKeko.isEmpty());
    }
    @Test
    public void isEmptyFalse() {
        fibKeko.insert(node0);
        assertFalse(fibKeko.isEmpty());
    }
    
    @Test
    public void kekoonVoiLisataYhdenNoden() {
        fibKeko.insert(node1);
        assertEquals(1,fibKeko.getHeapSize());
    }
    @Test
    public void kekoonVoiLisataSataNode() {
        for (int i = 0; i < 100; i++) {
            fibKeko.insert(new FibNode(i));
        }
        assertEquals(100,fibKeko.getHeapSize());
    }
    @Test
    public void minPalauttaaOikeinKunKeossaYksiNode() {
        fibKeko.insert(node1);
        assertEquals(1,fibKeko.min());
    }
    @Test
    public void minReturnOikeinKunKekoonLisataanSataNodeaKaanteisJarj() {
        for (int i = 200; i>100; --i) {
            fibKeko.insert(new FibNode(i));
        }
        assertEquals(101,fibKeko.min());
    }
    @Test
    public void kekoonVoiLisataViisiNodeaJaNiidenLeftRightOvatOikein() {
        fibKeko.insert(node1);
        fibKeko.insert(node2);
        fibKeko.insert(node3);
        fibKeko.insert(node4);
        fibKeko.insert(node5);
        assertEquals(node2,node1.getLeft());
        assertEquals(node5,node1.getRight());
        assertEquals(node1,node2.getRight());
        assertEquals(node3,node2.getLeft());
        assertEquals(node2,node3.getRight());
        assertEquals(node4,node3.getLeft());
        assertEquals(node3,node4.getRight());
        assertEquals(node5,node4.getLeft());
        assertEquals(node4,node5.getRight());
        assertEquals(node1,node5.getLeft());
    }
    @Test
    public void kekoOnTyhja() {
        assertEquals(true,fibKeko.isEmpty());
    }
    @Test
    public void removeMinKunKeossaYksi() {
        fibKeko.insert(node1);
        assertEquals(1,fibKeko.removeMin());
    }
    @Test
    public void removeMinKaksiNodea() {
        fibKeko.insert(node1);
        fibKeko.insert(node2);
        fibKeko.insert(node3);
        fibKeko.insert(node4);
        fibKeko.insert(node5);
        fibKeko.insert(node89);
        fibKeko.insert(node100);
        assertEquals(1,fibKeko.removeMin());
        assertEquals(2,fibKeko.removeMin());
    }
    @Test
    public void removeMinKolmeNodea() {
        fibKeko.insert(node1);
        fibKeko.insert(node2);
        fibKeko.insert(node3);
        fibKeko.insert(node4);
        fibKeko.insert(node5);
        fibKeko.insert(node89);
        fibKeko.insert(node100);
        assertEquals(1,fibKeko.removeMin());
        assertEquals(2,fibKeko.removeMin());
        assertEquals(3,fibKeko.removeMin());
    }   
    @Test
    public void removeMinKuusiNodea() {
        for (int i = 10; i > 0; i--) {
            fibKeko.insert(new FibNode(i));
        }
//        for (int i = 0; i < 10; i++) {
//            fibKeko.removeMin();
//        }
        assertEquals(1,fibKeko.removeMin());
        assertEquals(2,fibKeko.removeMin());
        assertEquals(3,fibKeko.removeMin());
        assertEquals(4,fibKeko.removeMin());
        assertEquals(5,fibKeko.removeMin());
        assertEquals(6,fibKeko.removeMin());
    }
    @Test
    public void removeMinSataNodea() {
        for (int i = 200; i < 1000; i++) {
            fibKeko.insert(new FibNode(i));
        }
        for (int i = 0; i < 100; i++) {
            fibKeko.removeMin();
        }
        assertEquals(310,fibKeko.min());
    }
//    @Test
//    public void removeNolla() {
//        fibKeko.insert(node0);
//        fibKeko.insert(node1);
//        fibKeko.insert(node2);
//        fibKeko.insert(node3);
//        assertEquals(0,fibKeko.removeMin());
////        assertEquals(3,node2.getChildKey());
//        assertEquals(1,node3.getParentKey());
////        assertEquals(1,node2.getDegree());
//    }
}