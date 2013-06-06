package tiralabra.data_structures;

import java.util.ArrayList;

/* @author mhaanran */
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
        heapSize = heapSize + 1;
        System.out.println("");
    }

    /**
     * Metodi poistaa pienimmän Fibonaccin keon alkion. 
     * Käyttää apumetodina consolidate metodia. 
     * Consolidate metodi tekee keosta Fibonaccin keon.
     * @return palauttaa poistettavan alkion avaimen arvon.
     */
    public int removeMin() {
        FibNode vanhaMin = min;
        if (vanhaMin != null) {
            FibNode kasiteltava = vanhaMin.getChild();
            FibNode temp;
            for (int i = vanhaMin.getDegree(); i > 0; --i) {
                temp = kasiteltava.getRight();
                kasiteltava.getLeft().setRight(kasiteltava.getRight());
                kasiteltava.getRight().setLeft(kasiteltava.getLeft());
                kasiteltava.setLeft(vanhaMin);
                kasiteltava.setRight(vanhaMin.getRight());
                min.setRight(kasiteltava);
                kasiteltava.getRight().setLeft(kasiteltava);
                kasiteltava.setParent(null);
                kasiteltava = temp;
            }
            vanhaMin.getLeft().setRight(vanhaMin.getRight());
            vanhaMin.getRight().setLeft(vanhaMin.getLeft());
            if (vanhaMin == vanhaMin.getRight()) {
                min = null;
            } else {
                min = vanhaMin.getRight();
                consolidate();
            }
            heapSize = heapSize - 1;
        }
        return vanhaMin.getKey();
    }

    /**
     * Consolidate metodi luo fibonaccin keon. Metodia kutsutaan 
     * kun keosta poistetaan node. Alussa matemaattinen kaava jolla lasketaan
     * keon koko.
     */
    private void consolidate() {
        double phi = (1.0 + Math.sqrt(5.0)) / 2.0;
        int size = (int) Math.floor(Math.log(heapSize) / Math.log(phi));
        
        FibNode[] taulu = new FibNode[size+1];    
        for (int i = 0; i < size; ++i) {
            taulu[i] = null;
        }
//       juuriNL=juuriNodeLista
        ArrayList<FibNode> juuriNL = rootList();
        for (FibNode juuriNode : juuriNL) {
//        juuriNodeLista alkio x jota käsitellään
            FibNode juuriNLnodeX = juuriNode;
            int xDegree = juuriNLnodeX.getDegree();
            while (taulu[xDegree] != null) {
                FibNode tauluY = taulu[xDegree];
                if (juuriNLnodeX.getKey() > tauluY.getKey()) {
                    FibNode apu = tauluY;
                    tauluY = juuriNLnodeX;
                    juuriNLnodeX = apu;
                }
                link(tauluY, juuriNLnodeX);
                taulu[xDegree] = null;
                xDegree = xDegree + 1;
            }
            taulu[xDegree] = juuriNLnodeX;     
        } 
        min = null;
        for (int i = 0; i < size; ++i) {
            if (taulu[i] != null) {
                if (min == null) {
                    min = taulu[i];
                } 
                else {
                    taulu[i].getLeft().setRight(taulu[i].getRight());
                    taulu[i].getRight().setLeft(taulu[i].getLeft());
                    taulu[i].setLeft(min);
                    taulu[i].setRight(min.getRight());
                    min.setRight(taulu[i]);
                    taulu[i].getRight().setLeft(taulu[i]);
                    if (taulu[i].getKey() < min.getKey()) {
                        min = taulu[i];        
                    }
                }
            }
        }
    }

    /**
     * Consolidate metodin apumetodi joka linkittää kaksi nodea. 
     * Ekana annetusta tulee child ja toisena parametrina annetusta 
     * parent.
     * @param y node josta tulee child.
     * @param x node josta tulee parent.
     */
    public void link(FibNode y, FibNode x) {
        FibNode yLeft = y.getLeft();
        FibNode yRight = y.getRight();     
        yLeft.setRight(yRight);
        yRight.setLeft(yLeft);
        if(x.getChild()!=null) {
            y.setLeft(x.getChild());
            y.setRight(x.getChild().getRight());         
            x.getChild().setRight(y);
            y.getRight().setLeft(y);
        }
        else {
            y.setLeft(y);
            y.setRight(y);
        }
        y.setParent(x);
        x.setChild(y);
        x.setDegree(x.getDegree()+1);
        y.setMark(false);
        
//        System.out.println("y:"+y.getKey()+" yLeft:"+y.getLeft().getKey()+" yRight:"+y.getRight().getKey()+" yParent:"+y.getParent().getKey()+" xChild:"+x.getChild().getKey());
    }

    /**
     * Yhdistää kaksi fibonaccin kekoa toisiinsa. 
     * @param keko1 Ensimmäinen yhdistettävä keko.
     * @param keko2 Toinen yhdistettävä keko.
     * @return yhdistettyKeko palauttaa yhdistetyn keon
     */
    public FibonaccinKeko union(FibonaccinKeko keko1, FibonaccinKeko keko2) {
        FibonaccinKeko yhdistettyKeko = new FibonaccinKeko();
        yhdistettyKeko.min = keko1.min;
        if(keko1==null) {
            yhdistettyKeko.min=keko2.min;
        }
        else if(keko2.min!=null&&keko2.min.getKey()<keko1.min.getKey()) {
            yhdistettyKeko.min=keko2.min;
        }
        yhdistettyKeko.heapSize=keko1.heapSize+keko2.heapSize;
        return yhdistettyKeko;
    }
    
    /**
     * Kaikki juurilistan nodet pistetään arraylistiin josta 
     * niitä sitten kivasti saa haettua.
     * @return juuriNodeLista palauttaa arraylistin jossa kaikki juurilistan 
     * nodet
     */
    public ArrayList rootList() {
        FibNode lisattava=min;
        ArrayList<FibNode> juuriNodeLista = new ArrayList();
        juuriNodeLista.add(lisattava);
        while(min!=lisattava.getRight()) {
            juuriNodeLista.add(lisattava.getRight());
            lisattava=lisattava.getRight();
        }
        juuriNodeLista.add(lisattava.getRight());
//        System.out.println(juuriNodeLista.size());
        return juuriNodeLista;           
    }

    /**
     * Palauttaa fibonaccin keon koon. Käytetään testeissä.
     * @return heapSize eli keon koko.
     */
    public int getHeapSize() {
        return heapSize;
    }
    
    @Override
    public String toString() {
        String keko = "";
        String parent="";
//        FibNode node = min.getRight();
//        while (node != min) {
//            if(node.getParent()!=null) {
//                parent+=node.getParent().getKey();
//            }
//            keko += node.getKey();
//            node = node.getRight();
//        }
       
//        keko += min.getKey();
//        return "min key: "+min.getKey() + "\nkeko: " + keko+"\nheapSize: " + heapSize;'
        return "heapSize: "+heapSize;
    }
}
