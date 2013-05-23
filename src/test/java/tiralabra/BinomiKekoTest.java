/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tiralabra.data_structures.BinomiKeko;
import tiralabra.data_structures.Node;

/**
 *
 * @author mhaanran
 */
public class BinomiKekoTest {

    private BinomiKeko binomiKeko = new BinomiKeko();
    private int[] numeroita = {100, 20, 10, 5, 3, 2, 1, 7, 8, 9, 11, 15, 17, 19, 21, 101, 102, 66, 33, 99, 1000};
    private Node[] nodet = new Node[numeroita.length];

    public BinomiKekoTest() {
        for (int i = 0; i < numeroita.length; i++) {
            nodet[i] = new Node(numeroita[i]);
            binomiKeko.insert(new Node(numeroita[i]));
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void minMetodiPalauttaaMinimin() {
        assertEquals(1, binomiKeko.min());
    }

    @Test
    public void minMetodiPalauttaaMinIntegerKunKekoOnTyhja() {
        Node node = null;
        BinomiKeko binomiKeko2 = new BinomiKeko();
        binomiKeko2.insert(node);
        assertEquals(Integer.MIN_VALUE, binomiKeko2.min());
    }

    @Test
    public void kekoonVoiLisataAlkionInsertilla() {
        Node node = new Node(100);
        BinomiKeko binomiKeko3 = new BinomiKeko();
        binomiKeko3.insert(node);
        assertEquals(100 + " ", binomiKeko3.toString());
    }

    @Test
    public void kekoonVoiLisataUseitaAlkoitaInsertilla() {
        Node node1 = new Node(100);
        Node node2 = new Node(99);
        Node node3 = new Node(555);
        Node node4 = new Node(1);
        Node node5 = new Node(100);
        BinomiKeko binomiKeko3 = new BinomiKeko();
        binomiKeko3.insert(node1);
        binomiKeko3.insert(node2);
        binomiKeko3.insert(node3);
        binomiKeko3.insert(node4);
        binomiKeko3.insert(node5);
        String lisatty = "1 99 100 100 555 ";
        assertEquals(lisatty, binomiKeko3.toString());
    }
    
    @Test
    public void keostaVoiPoistaaPienimmanAlkion() {
        binomiKeko.removeMin();
        assertEquals(2,binomiKeko.min());
    }
    @Test
    public void keostaVoiPoistaaUseitaPienimpiaAlkioita() {
        for (int i = 0; i < 10; i++) {
            binomiKeko.removeMin();
        }
        assertEquals(17,binomiKeko.min());
    }
    @Test
    public void removeMinMetodiPalauttaaMinIntegerKunKekoOnTyhja() {
        Node node = null;
        BinomiKeko binomiKeko4 = new BinomiKeko();
        binomiKeko4.insert(node);
        int min = binomiKeko4.removeMin();
        assertEquals(Integer.MIN_VALUE, min);
    }
    @Test
    public void isEmptyPalauttaaTrueKunKekoOnTyhja() {
        BinomiKeko binomiKeko4 = new BinomiKeko();
        assertTrue(binomiKeko4.isEmpty());
    }
    @Test
    public void isEmptyPalauttaaTrueKunKekoonOnLisattyJaPoistettuAlkio() {
        Node node = new Node(100);
        BinomiKeko binomiKeko4 = new BinomiKeko();
        binomiKeko4.insert(node);
        binomiKeko4.removeMin();
        assertTrue(binomiKeko4.isEmpty());
    }
    @Test
    public void isEmptyPalauttaaFalseKunKekoEiOleTyhja() {
        assertFalse(binomiKeko.isEmpty());
    }
    @Test
    public void kekoonVoiLisataKymmenenMiljoonaaAlkiota() {
        Node[] kymmenenMiljoonaa = new Node[10000000];
        int[] numeroita2=new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            numeroita2[i]=i;         
        }
        BinomiKeko binomiKeko5 = new BinomiKeko();
        int vahenna=9999999;
        for (int i = 0; i < 10000000; ++i) {
            kymmenenMiljoonaa[i]=new Node(numeroita2[vahenna]);
            binomiKeko5.insert(kymmenenMiljoonaa[i]); 
            --vahenna;
        }
        assertEquals(0,binomiKeko5.min());
    }
    
}