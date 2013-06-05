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
import tiralabra.data_structures.AvlNode;

/**
 *
 * @author mhaanran
 */
public class AVLpuuTest {
    
    private AVLpuu avlPuu;
   
    
    public AVLpuuTest() {
    }
    
    @Before
    public void setUp() {
        avlPuu=new AVLpuu();
     
    }
    
    @Test
    public void puuhunVoiLisataYhdenAvaimen() {
        avlPuu.avlInsert(1);
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
    @Test
    public void deleteKey() {
        AvlNode node5 = avlPuu.avlInsert(5);
        avlPuu.avlDelete(node5);
        assertEquals(null,avlPuu.getJuuri());
    }
    @Test
    public void deleteKeyPoistaaVasemmanLapsen() {
        AvlNode node5 = avlPuu.avlInsert(5);
        AvlNode node4 = avlPuu.avlInsert(4);
        avlPuu.avlDelete(node4);
        assertEquals(null,avlPuu.getJuuri().getLeft());
    }
    @Test
    public void deleteKeyPoistaOikeanLapsen() {
        avlPuu.avlInsert(5);
        AvlNode node6=avlPuu.avlInsert(6);
        avlPuu.avlDelete(node6);
        assertEquals(null,avlPuu.getJuuri().getRight());
    }
    @Test
    public void deleteKeyKunPuussaSeitsemanNodea() {
        AvlNode node1 = avlPuu.avlInsert(1);
        AvlNode node2 = avlPuu.avlInsert(2);
        AvlNode node3 = avlPuu.avlInsert(3);
        AvlNode node4 = avlPuu.avlInsert(4);
        AvlNode node5 = avlPuu.avlInsert(5);
        AvlNode node6 = avlPuu.avlInsert(6);
        AvlNode node7 = avlPuu.avlInsert(7);       
        avlPuu.avlDelete(node7);
        assertEquals(node6.getKey(),node4.getRight().getKey());
    }
    @Test
    public void deleteJuuriKunPuussaSeitsemanNodea() {
        AvlNode node1 = avlPuu.avlInsert(1);
        AvlNode node2 = avlPuu.avlInsert(2);
        AvlNode node3 = avlPuu.avlInsert(3);
        AvlNode node4 = avlPuu.avlInsert(4);
        AvlNode node5 = avlPuu.avlInsert(5);
        AvlNode node6 = avlPuu.avlInsert(6);
        AvlNode node7 = avlPuu.avlInsert(7);       
        avlPuu.avlDelete(node4);
        assertEquals(5,avlPuu.getJuuri().getKey());
    }
}
