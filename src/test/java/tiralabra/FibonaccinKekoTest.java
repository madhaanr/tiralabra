package tiralabra;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.data_structures.FibNode;
import tiralabra.data_structures.FibonaccinKeko;

/**
 *
 * @author mhaanran
 */
public class FibonaccinKekoTest {
    
    FibonaccinKeko fibKeko;
    FibNode node1;
    
    public FibonaccinKekoTest() {
        
    }
    
    @Before
    public void setUp() {
        fibKeko = new FibonaccinKeko();
        node1 = new FibNode(1);
    }
    
    @After
    public void tearDown() {
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
}
