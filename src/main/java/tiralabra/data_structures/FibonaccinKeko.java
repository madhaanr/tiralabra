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
     *
     * @return pienin alkio on tallennettu min muuttujan arvoksi.
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
     * kun keosta poistetaan node.
     */
    private void consolidate() {
        double phi = (1.0 + Math.sqrt(5.0)) / 2.0;
        int size = (int) Math.floor(Math.log(heapSize) / Math.log(phi));
        FibNode[] A = new FibNode[size+1];    
        for (int i = 0; i < size; ++i) {
            A[i] = null;
        }
//        FibNode w = min;
        ArrayList<FibNode> H = rootList();
        for (FibNode w : H) {
//        while(w!=min.getRight()) {
            FibNode x = w;
            int d = x.getDegree();
            while (A[d] != null) {
                FibNode y = A[d];
                if (x.getKey() > y.getKey()) {
                    FibNode apu = y;
                    y = x;
                    x = apu;
                }
                link(y, x);
                A[d] = null;
                d = d + 1;
            }
            A[d] = x;     
        } 
        min = null;
        for (int i = 0; i < size; ++i) {
            if (A[i] != null) {
                if (min == null) {
                    min = A[i];
//                    System.out.println(min.getKey()+"täällä");
                } 
                else {
                    A[i].getLeft().setRight(A[i].getRight());
                    A[i].getRight().setLeft(A[i].getLeft());
                    A[i].setLeft(min);
                    A[i].setRight(min.getRight());
                    min.setRight(A[i]);
                    A[i].getRight().setLeft(A[i]);
//                    System.out.println(min.getKey()+"täälläfgd");
                    if (A[i].getKey() < min.getKey()) {
//                        System.out.println(min.getKey()+"täällägdfgggggg");
                        min = A[i];        
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
        
        System.out.println("y:"+y.getKey()+" yLeft:"+y.getLeft().getKey()+" yRight:"+y.getRight().getKey()+" yParent:"+y.getParent().getKey()+" xChild:"+x.getChild().getKey());
    }
//    lisattava.setLeft(min);
//    lisattava.setRight(min.getRight());
//    min.setRight(lisattava);
//    lisattava.getRight().setLeft(lisattava);

    /**
     * Yhdistää kaksi fibonaccin kekoa toisiinsa. 
     * @param H1 Ensimmäinen yhdistettävä keko.
     * @param H2 Toinen yhdistettävä keko.
     * @return H palauttaa yhdistetyn keon
     */
    public FibonaccinKeko union(FibonaccinKeko H1, FibonaccinKeko H2) {
        FibonaccinKeko H = new FibonaccinKeko();
        H.min = H1.min;
        //concatenate the root list of H2 with root list of H
        if(H1==null) {
            H.min=H2.min;
        }
        else if(H2.min!=null&&H2.min.getKey()<H1.min.getKey()) {
            H.min=H2.min;
        }
        H.heapSize=H1.heapSize+H2.heapSize;
        return H;
    }
    
    /**
     * Kaikki juurilistan nodet pistetään arraylistiin josta 
     * niitä sitten kivasti saa haettua.
     * @return k palauttaa arraylistin jossa kaikki juurilistan nodet
     */
    public ArrayList rootList() {
        FibNode w=min;
        ArrayList<FibNode> k = new ArrayList();
        k.add(w);
        while(min!=w.getRight()) {
            k.add(w.getRight());
            w=w.getRight();
        }
        k.add(w.getRight());
//        System.out.println(k.size());
        return k;           
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
