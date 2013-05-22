/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.data_structures.BinomiKeko;
import tiralabra.data_structures.Node;

/**
 *
 * @author mhaanran
 */
public class BinomiKekoTest {
    
    private BinomiKeko binomiKeko = new BinomiKeko();
    private Node[] nodet=new Node[20];
    private int[] numeroita = {100,20,10,5,3,2,1,7,8,9,11,15,17,19,21,101,102,66,33,99};
   
    
    public BinomiKekoTest() {
         for (int i = 0; i < 10; i++) {
            nodet[i]=new Node(numeroita[i]);
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
         assertEquals(1,binomiKeko.min());
     }
}
