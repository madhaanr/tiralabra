/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import static org.junit.Assert.*;
import org.junit.Test;
import tiralabra.data_structures.BinaariKeko;

/**
 *
 * @author mhaanran
 */
public class BinaariKekoTest{
    
    int[] binKeko ={20,5,3,9,6,7,8,10,11};
    BinaariKeko binaariKeko;
    
    public BinaariKekoTest() {    
        this.binaariKeko = new BinaariKeko(binKeko);
    }
    
    
    protected void setUp() throws Exception {
        
    }
    
   
    protected void tearDown() throws Exception {
        
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    @Test
    public void parentPalauttaaOikeinKunLapsiOnOikea() {
        assertEquals(3,binaariKeko.parent(7));
    }
    @Test
    public void parentPalauttaaOikeinKunLapsiOnVasen() {
        assertEquals(2,binaariKeko.parent(4));
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
        assertEquals(3,binaariKeko.heapMin(binKeko));
    }
    @Test
    public void heapMinPalauttaaKeonPienimmanAlkionIsommallaKeolla() {
        int[] binKeko2 ={20,5,3,9,6,7,8,10,11,1,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko2 = new BinaariKeko(binKeko2);
        assertEquals(1,binaariKeko2.heapMin(binKeko2));
    }
    @Test
    public void konstruktoriRakentaaMinimiKeonOikein() {
        String oikeaJarjestys=" 3 5 6 8 11 7 9 10 20";
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys);      
    }
    @Test
    public void konstruktoriRakentaaMinimiKeonOikeinSuuremmallaKeolla() {
        int[] binKeko2 ={20,5,3,9,6,7,8,10,11,1,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko2 = new BinaariKeko(binKeko2);
        String oikeaJarjestys=" 1 3 5 8 6 7 9 10 11 20 100 54 100 111 112 113 114 115 117 118";
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko2;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys);      
    }
    @Test
    public void deleteMinToimiiKunPoistetaanYksi() {
        int[] binKeko2 ={20,5,3,9,6,7,8,10,11,1,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko2 = new BinaariKeko(binKeko2);
        String oikeaJarjestys=" 3 5 6 8 11 7 9 10 114 20 100 54 100 111 112 113 118 115 117";
        binaariKeko2.deleteMin();
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko2;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys);    
    }
    @Test
    public void heapInsertLisaaYhdenAlkion() {
        int[] binKeko2 ={20,5,3,9,6,7,8,10,11,1,100,54,100,111,112,113,114,115,117,118};
        BinaariKeko binaariKeko2 = new BinaariKeko(binKeko2);
        String oikeaJarjestys=" 1 3 5 8 6 7 9 10 11 20 44 54 100 111 112 113 114 115 117 118 100";
        binaariKeko2.heapInsert(44);
        String konstruktoriKutsunAntamaJarjestys = ""+binaariKeko2;
        assertEquals(oikeaJarjestys,konstruktoriKutsunAntamaJarjestys); 
    }
    
}
