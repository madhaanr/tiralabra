package tiralabra.data_structures;

/**
 * Luokka toteuttaa Fibonaccin keon. Kyseessä on minimi keko.
 * @author mhaanran
 */
public class FibonaccinKeko {

    private FibNode min;
    private int heapSize;

    /**
     * Konstruktori luo uuden tyhjän Fibonaccin keon.
     */
    public FibonaccinKeko() {
        min = null;
        heapSize = 0;
    }

    /**
     * Metodi palauttaa keon pienimmän alkion key kentän arvon.
     * @return pienin alkio on tallennettu min muuttujan avaimen arvoksi.
     */
    public int min() {
        return min.getKey();
    }
    
    /**
     * Tarkistus onko keko tyhjä.
     * @return palauttaa true jos keko on tyhjä
     */
    public boolean isEmpty() {
        return min == null;
    }

    /**
     * Metodilla lisätään fibonaccin kekoon uusia nodeja.
     * @param lisattava kekoon lisätään FibNode.
     */
    public void insert(FibNode lisattava) {
        if (min == null) {
            min = lisattava;
        } else {
            lisattava.setLeft(min);
            lisattava.setRight(min.getRight());
            min.setRight(lisattava);
            lisattava.getRight().setLeft(lisattava);
            if (lisattava.getKey() < min.getKey()) {
                min = lisattava;
            }
        }
        heapSize++;
    }

    /**
     * Metodi poistaa pienimmän Fibonaccin keon alkion. 
     * Käyttää apumetodina consolidate metodia. 
     * Consolidate metodi tekee keosta Fibonaccin keon.
     * @return palauttaa poistettavan alkion avaimen arvon.
     */
    public int remove() {
        if(min==null) {
            return Integer.MIN_VALUE;
        }
        FibNode vanhaMin = min;      
        FibNode kasiteltava = vanhaMin.getChild();
      
        poistettavanSolmunLapsetLisataanJuuriSolmuListaan(vanhaMin, kasiteltava);
        //poistetaan vanhaMin juuriSolmuListalta
        vanhaMin.getLeft().setRight(vanhaMin.getRight());
        vanhaMin.getRight().setLeft(vanhaMin.getLeft());
        
        if (vanhaMin == vanhaMin.getRight()) {
            min = null;
        } else {
            min = vanhaMin.getRight();
            consolidate();
        }  
        heapSize--;
        return vanhaMin.getKey();
    }
    /**
     * Apumetodi jossa poistettavan solmun eli entisen min solmun
     * lapset lisätään juurisolmulistaan.
     * @param vanhaMin poistettava solmu
     * @param kasiteltava poistettavan solmun lapsi jota lisätään juuri
     * solmulistaan.
     */
    private void poistettavanSolmunLapsetLisataanJuuriSolmuListaan(FibNode vanhaMin, FibNode kasiteltava) {
        FibNode temp;
        for (int i = vanhaMin.getDegree(); i > 0; i--) {
            temp = kasiteltava.getRight();
            kasiteltava.getLeft().setRight(kasiteltava.getRight());
            kasiteltava.getRight().setLeft(kasiteltava.getLeft());
            kasiteltava.setLeft(min);
            kasiteltava.setRight(min.getRight());
            min.setRight(kasiteltava);
            kasiteltava.getRight().setLeft(kasiteltava);
            kasiteltava.setParent(null);
            kasiteltava = temp;
        }
    }
    
    /**
     * Consolidate metodi luo fibonaccin keon. Metodia kutsutaan 
     * kun keosta poistetaan node. Alussa matemaattinen kaava jolla lasketaan
     * keon koko.
     */
    private void consolidate() {
              
        double phi = (1.0 + Math.sqrt(5.0)) / 2.0;
        int size = (int) Math.floor(Math.log(heapSize) / Math.log(phi))+1; 
        FibNode[] taulu = new FibNode[size];    
        
        int juuriNodejenLKM=1;
        FibNode kasiteltava=min;
        kasiteltava=kasiteltava.getRight();
        while(kasiteltava!=min) {
            juuriNodejenLKM++;
            kasiteltava=kasiteltava.getRight();
        }
        juuriSolmuListanLapiKayntiJaSolmujenLinkitys(juuriNodejenLKM, kasiteltava, taulu); 
        min = null;
        uudenJuuriSolmuListanLuonti(size, taulu);
    }
    /**
     * Consolidate metodin apumetodi uuden juurinodelistan läpikäymiseen
     * ja nodejen keskinäisten suhteiden asetteluun. Käyttää apumetodina
     * link metodia, joka hoitaa vanhempi lapsi suhteen asettamisen.
     * @param juuriNodejenLKM kuinka monta juuri nodea listalla on.
     * @param kasiteltava juurinode jota käsitellään
     * @param taulu taulukko johon tallennetaan kaikki puut.
     */
    private void juuriSolmuListanLapiKayntiJaSolmujenLinkitys(int juuriNodejenLKM, FibNode kasiteltava, FibNode[] taulu) {
        while(juuriNodejenLKM>0) {
            FibNode seuraava = kasiteltava.getRight();
            int xDegree = seuraava.getDegree();
            while (taulu[xDegree] != null) {
                FibNode tauluY = taulu[xDegree];
                if (kasiteltava.getKey() > tauluY.getKey()) {
                    FibNode apu = tauluY;
                    tauluY = kasiteltava;
                    kasiteltava = apu;
                }
                link(tauluY, kasiteltava);
                taulu[xDegree] = null;
                xDegree++;
            }
            taulu[xDegree] = kasiteltava;
            kasiteltava=seuraava;
            juuriNodejenLKM--;
            
        }
    }
    /**
     * Consolidate metodin apumetodi uuden juurinodelistan luomiseen.
     * @param size uuden juurinodelistan koko
     * @param taulu taulukko johon juurinodelistalle lisättävät puut on 
     * allennettu.
     */
    private void uudenJuuriSolmuListanLuonti(int size, FibNode[] taulu) {
        for (int i = 0; i < size; i++) {
            if (taulu[i] != null) {
                if (min == null) {
                    min = taulu[i];
                    min.setLeft(min);
                    min.setRight(min);
                } 
                else {
                    taulu[i].setRight(min);
                    taulu[i].setLeft(min.getLeft());
                    min.getLeft().setRight(taulu[i]);
                    min.setLeft(taulu[i]);
                    if (taulu[i].getKey() < min.getKey()) {
                        min = taulu[i];   
                    }
                }
            }
        }
    }

    /**
     * Consolidate metodin apumetodi, joka linkittää kaksi solmua. 
     * Ekana annetusta tulee child ja toisena parametrina annetusta 
     * parent.
     * @param y solmu josta tulee child.
     * @param x solmu josta tulee parent
     */
    public void link(FibNode y, FibNode x) {
        FibNode yLeft = y.getLeft();
        FibNode yRight = y.getRight();     
        yLeft.setRight(yRight);
        yRight.setLeft(yLeft);
        y.setParent(x);
        
        if(x.getChild()!=null) {
            y.setLeft(x.getChild());
            y.setRight(x.getChild().getRight());         
            x.getChild().setRight(y);
            y.getRight().setLeft(y);
        }
        else {
            x.setChild(y);
            y.setLeft(y);
            y.setRight(y);
        }
        x.setDegree(x.getDegree()+1);
        y.setMark(false);
    }

//    /**
//     * Toteutus ei ole valmis.
//     * Yhdistää kaksi fibonaccin kekoa toisiinsa. 
//     * @param keko1 Ensimmäinen yhdistettävä keko.
//     * @param keko2 Toinen yhdistettävä keko.
//     * @return yhdistettyKeko palauttaa yhdistetyn keon
//     */
//    public FibonaccinKeko union(FibonaccinKeko keko1, FibonaccinKeko keko2) {
//        FibonaccinKeko yhdistettyKeko = new FibonaccinKeko();
//        yhdistettyKeko.min = keko1.min;
//        if(keko1==null) {
//            yhdistettyKeko.min=keko2.min;
//        }
//        else if(keko2.min!=null&&keko2.min.getKey()<keko1.min.getKey()) {
//            yhdistettyKeko.min=keko2.min;
//        }
//        yhdistettyKeko.heapSize=keko1.heapSize+keko2.heapSize;
//        return yhdistettyKeko;
//    }
    
    /**
     * Palauttaa fibonaccin keon koon. Käytetään testeissä.
     * @return heapSize eli keon koko.
     */
    public int getHeapSize() {
        return heapSize;
    }      
}
