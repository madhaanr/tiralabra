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
import tiralabra.data_structures.AVLpuu;

/**
 *
 * @author mhaanran
 */
public class AVLpuuTest {
    
    private AVLpuu avlPuu;
    private int k;
    
    public AVLpuuTest() {
    }
    
    @Before
    public void setUp() {
        avlPuu=new AVLpuu();
        k=1;
    }
    
    @Test
    public void puuhunVoiLisataYhdenAvaimen() {
        avlPuu.avlInsert(k);
        assertEquals(1,avlPuu.getJuurenAvain());
    }
    @Test
    public void puuhunVoiLisataKymmenenAvainta() {
        for (int i = 0; i < 10; i++) {
            avlPuu.avlInsert(i);
        }
        assertEquals(10,avlPuu.getPuunKoko());
    }
    @Test
    public void puuhunLisatytAvaimetOvatOikeillaPaikoilla() {
        for (int i = 1; i < 8; i++) {
            avlPuu.avlInsert(i);
        }
        assertEquals(4,avlPuu.getJuurenAvain());
        assertEquals(2,avlPuu.getJuuri().getLeft().getKey());
        assertEquals(6,avlPuu.getJuuri().getRight().getKey());
        assertEquals(1,avlPuu.getJuuri().getLeft().getLeft().getKey());
        assertEquals(3,avlPuu.getJuuri().getLeft().getRight().getKey());
        assertEquals(5,avlPuu.getJuuri().getRight().getLeft().getKey());
        assertEquals(7,avlPuu.getJuuri().getRight().getRight().getKey());
    }
}