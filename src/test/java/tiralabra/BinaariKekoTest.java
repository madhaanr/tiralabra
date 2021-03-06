/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tiralabra.data_structures.BinaariKeko;

/**
 *
 * @author mhaanran
 */
public class BinaariKekoTest {
    
    BinaariKeko binaariKeko;
    Integer[] binKeko ={20,5,3,9,6,7,8,10,11};
      
    public BinaariKekoTest() {    
        
    }
    @Before
    public void setUp() {
        binaariKeko = new BinaariKeko(binKeko);
    }
    
    @Test
    public void parentPalauttaaOikeinKunLapsiOnOikea() {
        assertEquals(3,binaariKeko.parent(7));
    }
    @Test
    public void parentPalauttaaOikeinKunLapsiOnOikea2() {
        assertEquals(1,binaariKeko.parent(3));
    }
    @Test
    public void parentPalauttaaOikeinKunLapsiOnVasen() {
        assertEquals(2,binaariKeko.parent(4));
    }
    @Test
    public void parentPalauttaaOikeinKunLapsiOnVasen2() {
        assertEquals(1,binaariKeko.parent(2));
    }
    @Test
    public void leftPalauttaaVasemmanLapsen() {
        assertEquals(6,binaariKeko.left(3));
    }
    @Test
    public void rightPalauttaOikeanLapsen() {
        assertEquals(7,binaariKeko.right(3));
    }
    @Test
    public void getHeapSizeToimiiOikein() {
        assertEquals(9,binaariKeko.getHeapSize());
    }
    @Test
    public void heapMinPalauttaaKeonPienimmanAlkion() {
        assertEquals(3,(int)binaariKeko.min(binKeko));
    }
    @Test
    public void heapMinPalauttaaKeonPienimmanAlkionIsommallaKeolla() {
        Integer[] binKeko2 ={20,5,3,9,6,7,8,10,11,1,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko2 = new BinaariKeko(binKeko2);
        assertEquals(1,(int)binaariKeko2.min(binKeko2));
    }
    @Test
    public void konstruktoriRakentaaMinimiKeonOikein() {
        String oikeaJarjestys=" 3 5 6 8 11 7 9 10 20";
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys);      
    }
    @Test
    public void konstruktoriRakentaaMinimiKeonOikeinSuuremmallaKeolla() {
        Integer[] binKeko2 ={20,5,3,9,6,7,8,10,11,1,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko2 = new BinaariKeko(binKeko2);
        String oikeaJarjestys=" 1 3 5 8 6 7 9 10 11 20 100 54 100 111 112 113 114 115 117 118";
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko2;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys);      
    }
    @Test
    public void deleteMinToimiiKunPoistetaanYksi() {
        Integer[] binKeko3 ={20,5,3,9,6,7,8,10,11,1,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko3 = new BinaariKeko(binKeko3);
        String oikeaJarjestys=" 3 5 6 8 11 7 9 10 114 20 100 54 100 111 112 113 118 115 117";
        binaariKeko3.delete();
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko3;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys);    
    }
    @Test
    public void heapInsertLisaaYhdenAlkion() {
        Integer[] binKeko2 ={20,5,3,9,6,7,8,10,11,1,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko2 = new BinaariKeko(binKeko2);
        String oikeaJarjestys=" 1 3 5 8 6 7 9 10 11 20 44 54 100 111 112 113 114 115 117 118 100";
        binaariKeko2.insert(44);
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko2;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys); 
    }
    @Test
    public void heapInsertLisaaPienimmanAlkion() {
        Integer[] binKeko2 ={20,5,3,9,6,7,8,10,11,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko2 = new BinaariKeko(binKeko2);
        String oikeaJarjestys=" 1 3 5 8 6 7 9 10 20 11 54 100 111 112 113 114 115 117 118 100";
        binaariKeko2.insert(1);
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko2;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys); 
    }
    @Test
    public void kekoonVoiLisataSataTuhattaAlkiota() {
        int maara=100000;
        Integer[] numeroita2=new Integer[maara];
        for (int i = 1; i< maara; ++i) {
            numeroita2[i]=i;         
        }
        BinaariKeko binaariKeko5 = new BinaariKeko();
        for (int i = 1; i < maara; ++i) {
            binaariKeko5.insert(numeroita2[i]); 
      
        }
        assertEquals(null,binaariKeko5.min(numeroita2));
    }
    @Test
    public void keostaVoiPoistaaSataTuhattaAlkiota() {
        int maara=100000;
        Integer[] numeroita2=new Integer[maara];
        for (int i = 1; i< maara; ++i) {
            numeroita2[i]=i;         
        }
        BinaariKeko binaariKeko5 = new BinaariKeko();
        for (int i = 1; i < maara; ++i) {
            binaariKeko5.insert(numeroita2[i]); 
      
        }
        for (int i = 1; i < maara; i++) {
            binaariKeko5.delete();
        }
        assertEquals(0,binaariKeko5.getHeapSize());
    }  
}
