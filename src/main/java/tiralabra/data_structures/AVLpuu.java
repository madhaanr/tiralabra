package tiralabra.data_structures;

/* @author mhaanran */
public class AVLpuu {

    private AvlNode k1;

    public AVLpuu() {
        k1=null;
    }
    
    public int height(AvlNode x) {
        if (x == null) {
            return -1;
        }
        return x.getHeight();
    }

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
        if(k1==null) {
            k1=new AvlNode(k);
        }
        AvlNode uusi = insert(k1,k);
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
    private AvlNode insert(AvlNode k1,int k) {
       AvlNode uusi=new AvlNode(k); 
       AvlNode p=null;
       uusi.setKey(k);
       
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
       uusi.setHeight(0);
       return uusi;
    }

    private boolean epaTasaPainoVasenVaiOikeaAlipuu(AvlNode p) {
        return height(p.getLeft().getLeft())>height(p.getLeft().getRight());
    }
    
    @Override
    public String toString() {
        return ""+k1.getKey()+k1.getRight().getKey();
    }
}
