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
    private AVLpuu avlPuu2;
    
    public AVLpuuTest() {
        
    }
    
    @Before
    public void setUp() {
        avlPuu = new AVLpuu();
     
    }
    @Test
    public void konstruktoriTesti() {
        avlPuu2 = new AVLpuu();
        assertEquals(0,avlPuu2.getPuunKoko());
    }
    @Test
    public void heightNull() {
        AvlNode nodeX = null;
        assertEquals(-1,avlPuu.height(nodeX));
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
    public void puuhunLisatytAvaimetOvatOikeillaPaikoilla2() {
        AvlNode node1 = avlPuu.avlInsert(1);
        AvlNode node2 = avlPuu.avlInsert(2);
        AvlNode node3 = avlPuu.avlInsert(3);
        AvlNode node4 = avlPuu.avlInsert(4);
        AvlNode node5 = avlPuu.avlInsert(5);
        AvlNode node6 = avlPuu.avlInsert(6);
        AvlNode node7 = avlPuu.avlInsert(7);  
        AvlNode node10 = avlPuu.avlInsert(10);
        AvlNode node9 = avlPuu.avlInsert(9);  
        assertEquals(4,avlPuu.getJuurenAvain());
        assertEquals(2,avlPuu.getJuuri().getLeft().getKey());
        assertEquals(6,avlPuu.getJuuri().getRight().getKey());
        assertEquals(1,avlPuu.getJuuri().getLeft().getLeft().getKey());
        assertEquals(3,avlPuu.getJuuri().getLeft().getRight().getKey());
        assertEquals(5,avlPuu.getJuuri().getRight().getLeft().getKey());
        assertEquals(9,avlPuu.getJuuri().getRight().getRight().getKey());
        assertEquals(7,avlPuu.getJuuri().getRight().getRight().getLeft().getKey());
        assertEquals(10,avlPuu.getJuuri().getRight().getRight().getRight().getKey());
    }
    @Test
    public void puuhunLisatytAvaimetOvatOikeillaPaikoilla3() {
        AvlNode node5 = avlPuu.avlInsert(5);
        AvlNode node6 = avlPuu.avlInsert(6);
        AvlNode node8 = avlPuu.avlInsert(8);
        AvlNode node10 = avlPuu.avlInsert(10);
        AvlNode node12 = avlPuu.avlInsert(12);
        AvlNode node15 = avlPuu.avlInsert(14);
        AvlNode node20 = avlPuu.avlInsert(20);  
        AvlNode node3 = avlPuu.avlInsert(3);
        AvlNode node4 = avlPuu.avlInsert(4);  
        assertEquals(10,avlPuu.getJuurenAvain());
        assertEquals(6,avlPuu.getJuuri().getLeft().getKey());
        assertEquals(14,avlPuu.getJuuri().getRight().getKey());
        assertEquals(4,avlPuu.getJuuri().getLeft().getLeft().getKey());
        assertEquals(8,avlPuu.getJuuri().getLeft().getRight().getKey());
        assertEquals(12,avlPuu.getJuuri().getRight().getLeft().getKey());
        assertEquals(20,avlPuu.getJuuri().getRight().getRight().getKey());
        assertEquals(3,avlPuu.getJuuri().getLeft().getLeft().getLeft().getKey());
        assertEquals(5,avlPuu.getJuuri().getLeft().getLeft().getRight().getKey());      
    }
    @Test
    public void puuhunLisatytAvaimetOvatOikeillaPaikoilla4() {
        AvlNode node5 = avlPuu.avlInsert(5);
        AvlNode node6 = avlPuu.avlInsert(6);
        AvlNode node8 = avlPuu.avlInsert(8);
        AvlNode node10 = avlPuu.avlInsert(10);
        AvlNode node12 = avlPuu.avlInsert(12);
        AvlNode node14 = avlPuu.avlInsert(14);
        AvlNode node20 = avlPuu.avlInsert(20);  
        AvlNode node18 = avlPuu.avlInsert(18);
        AvlNode node26 = avlPuu.avlInsert(26); 
        AvlNode node19 = avlPuu.avlInsert(19); 
        assertEquals(10,avlPuu.getJuurenAvain());
        assertEquals(6,avlPuu.getJuuri().getLeft().getKey());
        assertEquals(18,avlPuu.getJuuri().getRight().getKey());
        assertEquals(5,avlPuu.getJuuri().getLeft().getLeft().getKey());
        assertEquals(8,avlPuu.getJuuri().getLeft().getRight().getKey());
        assertEquals(20,avlPuu.getJuuri().getRight().getRight().getKey());
        assertEquals(26,avlPuu.getJuuri().getRight().getRight().getRight().getKey());
        assertEquals(19,avlPuu.getJuuri().getRight().getRight().getLeft().getKey()); 
        assertEquals(14,avlPuu.getJuuri().getRight().getLeft().getKey());
        assertEquals(12,avlPuu.getJuuri().getRight().getLeft().getLeft().getKey());
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
    @Test
    public void deletenJalkeenLisatytAvaimetOvatOikeillaPaikoilla() {
        AvlNode node1 = avlPuu.avlInsert(1);
        AvlNode node2 = avlPuu.avlInsert(2);
        AvlNode node3 = avlPuu.avlInsert(3);
        AvlNode node4 = avlPuu.avlInsert(4);
        AvlNode node5 = avlPuu.avlInsert(5);
        AvlNode node6 = avlPuu.avlInsert(6);
        AvlNode node7 = avlPuu.avlInsert(7);  
        avlPuu.avlDelete(node4);
        assertEquals(5,avlPuu.getJuuri().getKey());
        assertEquals(6,avlPuu.getJuuri().getRight().getKey());
        assertEquals(7,avlPuu.getJuuri().getRight().getRight().getKey());
        assertEquals(2,avlPuu.getJuuri().getLeft().getKey());
        assertEquals(1,avlPuu.getJuuri().getLeft().getLeft().getKey());
        assertEquals(3,avlPuu.getJuuri().getLeft().getRight().getKey());
    }
    
    
    @Test
    public void insertLisaaPuuhunTuhatNodea() {
        for (int i = 0; i < 1000; i++) {
            avlPuu.avlInsert(i);
        }
        assertEquals(1000,avlPuu.getPuunKoko());
    }
    @Test
    public void insertLisaaPuuhunKymmenenTuhattaNodeKaanteisessaJarjestyksessa() {
        for (int i = 10000; i>0 ; i--) {
            avlPuu.avlInsert(i);
        }
        assertEquals(10000,avlPuu.getPuunKoko());
    }
    @Test
    public void puunKorkeusOikeinKunPuussaMiljoonaNodea() {
        for (int i = 0; i < 1000000; i++) {
            avlPuu.avlInsert(i);
        }
        assertEquals(19,avlPuu.getJuuri().getHeight());
    }
    @Test
    public void deleteJuuriKunPuussaKymmenenTuhattaNodea() {
        AvlNode[] nodet = new AvlNode[10001];
        for (int i = 10000; i>0 ; i--) {
            nodet[i]=avlPuu.avlInsert(i);
        }
        avlPuu.avlDelete(avlPuu.getJuuri());
        assertEquals(5906,avlPuu.getJuurenAvain());     
    }
    @Test
    public void deleteSeitsemanNodea() {
        AvlNode node1 = avlPuu.avlInsert(1);
        AvlNode node2 = avlPuu.avlInsert(2);
        AvlNode node3 = avlPuu.avlInsert(3);
        AvlNode node4 = avlPuu.avlInsert(4);
        AvlNode node5 = avlPuu.avlInsert(5);
        AvlNode node6 = avlPuu.avlInsert(6);
        AvlNode node7 = avlPuu.avlInsert(7);  
        avlPuu.avlDelete(node1);
        avlPuu.avlDelete(node5);
        
        avlPuu.avlDelete(node2);
//        avlPuu.avlDelete(node3);
        avlPuu.avlDelete(node7);
       
        assertEquals(4,avlPuu.getJuurenAvain());
        
    }
//    @Test
//    public void deleteKymmenenMiljoonaaNodea() {
//        AvlNode[] nodet = new AvlNode[1000];
//        for (int i = 0; i < 100; i++) {
//            nodet[i]=avlPuu.avlInsert(i);
//        }
//        for (int i = 99; i > 96; i--) {
//            avlPuu.avlDelete(nodet[i]);
//        }
//        assertEquals(64,avlPuu.getJuurenAvain());
//        
//    }
}
