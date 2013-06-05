package tiralabra.data_structures;


/**
 * Luokka toteuttaa AVL-puun.
 * @author mhaanran
 */
public class AVLpuu {

    private AvlNode k1;
    private int puunKoko;

   
    /**
     * Konstruktori jossa luodaan uusi puun juuri ja asetetaan sen 
     * arvoksi null.
     */
    public AVLpuu() {
        k1=null;
        puunKoko=0;
    }
    
    /**
     * Metodi tietyn solmun korkeuden kyselemiseen.
     * @param x solmu jonka korkeus halutaan selvittää
     * @return palautetaan solmun korkeus.
     */
    public int height(AvlNode x) {
        if (x == null) {
            return -1;
        }
        return x.getHeight();
    }

    /**
     *
     * @param k1
     * @return
     */
    public AvlNode rightRotate(AvlNode k1) {
        AvlNode k2 = k1.getLeft();
        k2.setParent(k1.getParent());
        k1.setParent(k2);
        k1.setLeft(k2.getRight());
        k2.setRight(k1);
        if (k1.getLeft() != null) {
            k1.getLeft().setParent(k1);
        }
        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        return k2;
    }

    public AvlNode leftRotate(AvlNode k1) {
        AvlNode k2 = k1.getRight();
        k2.setParent(k1.getParent());
        k1.setParent(k2);
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        if (k1.getRight() != null) {
            k1.getRight().setParent(k1);
        }
        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        return k2;
    }

    public AvlNode rightLeftRotate(AvlNode k1) {
        AvlNode k2 = k1.getRight();
        k1.setRight(rightRotate(k2));
        return leftRotate(k1);
    }

    public AvlNode leftRightRotate(AvlNode k1) {
        AvlNode k2 = k1.getLeft();
        k1.setLeft(leftRotate(k2));
        return rightRotate(k1);
    }
    public void avlInsert(int k) {
//        if(k1==null) {
//            k1=new AvlNode(k);
//        }
        AvlNode uusi = insert(k);
        AvlNode p=uusi.getParent();
        AvlNode vanhempi;
        AvlNode alipuu;
        while(p!=null) { 
            if(height(p.getLeft())==height(p.getRight())+2) {
                vanhempi = p.getParent();
                if(epaTasaPainoVasenVaiOikeaAlipuu(p)) {
                    alipuu=rightRotate(p);
                }
                else {
                    alipuu=leftRightRotate(p);
                }
                if(vanhempi==null) {
                    k1=alipuu;
                }
                else if(vanhempi.getLeft()==p) {
                    vanhempi.setLeft(alipuu);
                }
                else {
                    vanhempi.setRight(alipuu);
                }
                if(vanhempi!=null) {
                    vanhempi.setHeight(Math.max(height(vanhempi.getLeft()), height(vanhempi.getRight()))+1);
                }
                return;
            }
            if(height(p.getRight())==height(p.getLeft())+2) {
                vanhempi=p.getParent();
                if(height(p.getRight().getRight())>height(p.getRight().getLeft())) {
                    alipuu=leftRotate(p);
                }
                else {
                    alipuu=rightLeftRotate(p);
                }
                if(vanhempi==null) {
                    k1=alipuu;
                }
                else if(vanhempi.getLeft()==p) {
                    vanhempi.setLeft(alipuu);
                }
                else {
                    vanhempi.setRight(alipuu);
                }
                if(vanhempi!=null) {
                    vanhempi.setHeight(Math.max(height(vanhempi.getLeft()), height(vanhempi.getRight()))+1);
                }
                return;
            }
            p.setHeight(Math.max(height(p.getLeft()),height(p.getRight()))+1);
            p=p.getParent();
           
        }     
    }
    private AvlNode insert(int k) {
       puunKoko++; 
       AvlNode uusi=new AvlNode(k); 
       AvlNode p=null;     
       if(k1==null) {
           k1=uusi;
           return k1;
       }    
       AvlNode x=k1;
       while(x!=null) {
           p=x;
           if(uusi.getKey()<x.getKey()) {
               x=x.getLeft();
           }
           else {
               x=x.getRight();
           }
       }
       uusi.setParent(p);
       if(uusi.getKey()<p.getKey()) {
           p.setLeft(uusi);
       }
       else {
           p.setRight(uusi);
       }
       return uusi;
    }
    private boolean epaTasaPainoVasenVaiOikeaAlipuu(AvlNode p) {
        return height(p.getLeft().getLeft())>height(p.getLeft().getRight());
    }
    
    public void avlDelete(int x) {
        AvlNode pois = delete(x);
        
    }
    private AvlNode delete(int x) {
        puunKoko--;
        AvlNode pois = new AvlNode(x);
        AvlNode vanh;
        AvlNode lapsi;
        if(pois.getLeft()==null && pois.getRight()==null) {
            vanh=pois.getParent();
            if(vanh==null) {
                k1=null;
                return pois;
            }
            if(pois==vanh.getLeft()) {
                vanh.setLeft(null);
            }
            else {
                vanh.setRight(null);
            }
            return pois;
        }
        if(pois.getLeft()==null||pois.getRight()==null) {
            if(pois.getLeft()!=null) {
                lapsi=pois.getLeft();
            }
            else {
                lapsi=pois.getRight();
            }
            vanh=pois.getParent();
            lapsi.setParent(vanh);
            if(vanh==null) {
                k1=lapsi;
                return pois;
            }
            if(pois==vanh.getLeft()) {
                vanh.setLeft(lapsi);
            }
            else {
                vanh.setRight(lapsi);
            }
            return pois;
        }
        AvlNode seur=min(pois.getRight());
        pois.setKey(seur.getKey());
        lapsi=seur.getRight();
        vanh=seur.getParent();
        if(vanh.getLeft()==seur) {
            vanh.setLeft(lapsi);
        }
        else {
            vanh.setRight(lapsi);
        }
        if(lapsi!=null) {
            lapsi.setParent(vanh);
        }
        return seur;
    }
    private AvlNode min(AvlNode x) {
        while(x.getLeft()!=null) {
            x=x.getLeft();
        }
        return x;
    }
     
    public int getJuurenAvain() {
        return k1.getKey();
    }
    public int getPuunKoko() {
        return puunKoko;
    }
    public AvlNode getJuuri() {
        return k1;
    }
    
    @Override
    public String toString() {
        return ""+k1.getKey()+k1.getHeight();
    }
}
