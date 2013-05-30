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

    public boolean isEmpty() {
        return min == null;
    }

    /**
     * Metodilla lisätään fibonaccin kekoon uusia nodeja.
     *
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
    }

    /**
     * Metodi poistaa pienimmän Fibonaccin keon alkion ja tekee 
     * käyttää apumetodina consolidate metodia. 
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
            //poistetaan vanhaMin from root list
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
    public void consolidate() {
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
                    FibNode apu = x;
                    x = y;
                    y = apu;
                }
                link(y, x);
                A[d] = null;
                d = d + 1;
            }
            A[d] = x; 
        } 
        min = null;
        for (int i = 0; i < size; i++) {
            if (A[i] != null) {
                if (min == null) {
                    min = A[i];
                } else {
                    if (A[i].getKey() < min.getKey()) {
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
     * @param y
     * @param x
     */
    public void link(FibNode y, FibNode x) {
        y.getLeft().setRight(y.getRight());
        y.getRight().setLeft(y.getLeft());
        y.setParent(x);
        x.setChild(y);
        x.setDegree(+1);
        y.setMark(false);
    }

    public FibonaccinKeko union(FibonaccinKeko fibKeko) {
        FibonaccinKeko keko = new FibonaccinKeko();
        keko.min = fibKeko.min;

        return keko;
    }
    public ArrayList rootList() {
        FibNode w=min;
        ArrayList<FibNode> k = new ArrayList();
        k.add(w);
        while(min!=w.getRight()) {
            k.add(w.getRight());
            w=w.getRight();
        }
        k.add(w.getRight());
        System.out.println(k.size());
        return k;           
    }

    public int getHeapSize() {
        return heapSize;
    }
    
    @Override
    public String toString() {
        String keko = "";
        String parent="";
        FibNode node = min.getRight();
        while (node != min) {
            if(node.getParent()!=null) {
                parent+=node.getParent().getKey();
            }
            keko += node.getKey();
            node = node.getRight();
        }
        keko += min.getKey();
        return min.getKey() + "--" + keko+"--" +parent+ "--" + heapSize;
    }
}
