package tiralabra.data_structures;

/**
 * Luokka toteuttaa AVL-puun.
 *
 * @author mhaanran
 */
public class AVLpuu {

    private AvlNode head;
    private int treeSize;

    /**
     * Konstruktori jossa luodaan uusi puun juuri ja asetetaan sen arvoksi null
     * ja puunKooksi 0;
     */
    public AVLpuu() {
        head = null;
        treeSize = 0;
    }

    /**
     * Metodi tietyn solmun korkeuden kyselemiseen.
     *
     * @param node solmu jonka korkeus halutaan selvittää
     * @return palautetaan solmun korkeus.
     */
    public int height(AvlNode node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    /**
     * Metodi joka kiertää AVL-puun solmuja oikealle epätasapainon
     * korjaamiseksi.
     *
     * @param kaannettava solmu, joka epätasapainossa.
     * @return vasenLapsi palautetaan solmu joka oli kaannettavan vasen lapsi.
     */
    private AvlNode rightRotate(AvlNode kaannettava) {
        AvlNode vasenLapsi = kaannettava.getLeft();
        vasenLapsi.setParent(kaannettava.getParent());
        kaannettava.setParent(vasenLapsi);
        kaannettava.setLeft(vasenLapsi.getRight());
        vasenLapsi.setRight(kaannettava);
        if (kaannettava.getLeft() != null) {
            kaannettava.getLeft().setParent(kaannettava);
        }
        kaannettava.setHeight(Math.max(height(kaannettava.getLeft()), height(kaannettava.getRight())) + 1);
        vasenLapsi.setHeight(Math.max(height(vasenLapsi.getLeft()), height(vasenLapsi.getRight())) + 1);
        return vasenLapsi;
    }

    /**
     * Metodi joka kiertää AVL-puun solmuja vasemmalle epätasapainon
     * korjaamiseksi.
     *
     * @param kaannettava solmu, joka epätasapainossa.
     * @return oikeaLapsi palautetaan solmu joka oli aiemmin kaannettavan solmun
     * oikea lapsi.
     */
    private AvlNode leftRotate(AvlNode kaannettava) {
        AvlNode oikeaLapsi = kaannettava.getRight();
        oikeaLapsi.setParent(kaannettava.getParent());
        kaannettava.setParent(oikeaLapsi);
        kaannettava.setRight(oikeaLapsi.getLeft());
        oikeaLapsi.setLeft(kaannettava);
        if (kaannettava.getRight() != null) {
            kaannettava.getRight().setParent(kaannettava);
        }
        kaannettava.setHeight(Math.max(height(kaannettava.getLeft()), height(kaannettava.getRight())) + 1);
        oikeaLapsi.setHeight(Math.max(height(oikeaLapsi.getLeft()), height(oikeaLapsi.getRight())) + 1);
        return oikeaLapsi;
    }

    /**
     * Kaksoiskierto puun epätasapainon korjaamiseen. Ensin kierretään head
     * solmun oikea lapsi oikealle ja sen jälkeen head solmu vasemmalle.
     *
     * @param kaannettava solmu, joka epätasapainossa.
     * @return palautetaan leftRotate(kaannettava).
     */
    private AvlNode rightLeftRotate(AvlNode kaannettava) {
        AvlNode oikeaLapsi = kaannettava.getRight();
        kaannettava.setRight(rightRotate(oikeaLapsi));
        return leftRotate(kaannettava);
    }

    /**
     * Kaksoiskierto puun epätasapainon korjaamiseen. Ensin kierretään head
     * solmun vasen solmu vasemmalle ja sen jälkeen head solmu oikealle
     *
     * @param kaannettava node jota kaannetaan
     * @return palautetaan rightRotate(kaannettava).
     */
    private AvlNode leftRightRotate(AvlNode kaannettava) {
        AvlNode vasenLapsi = kaannettava.getLeft();
        kaannettava.setLeft(leftRotate(vasenLapsi));
        return rightRotate(kaannettava);
    }

    /**
     * Metodi solmun lisäämiseen avl-puuhun. Varsinainen solmun lisäys 
     * tehdään apumetodissa insert ja sen jälkeen puulle tehdään tarvittavat 
     * kierrot.
     *
     * @param lisattava lisättävän solmun avain.
     * @return palautetaan lisättävä solmu.
     */
    public AvlNode avlInsert(int lisattava) {
        AvlNode uusi = insert(lisattava);
        AvlNode parent = uusi.getParent();
        AvlNode vanhempi;
        AvlNode alipuu;
        while (parent != null) {
            if (height(parent.getLeft()) == height(parent.getRight()) + 2) {
                vanhempi = parent.getParent();
                if (epaTasaPainoVasenVaiOikeaAlipuu(parent)) {
                    alipuu = rightRotate(parent);
                } else {
                    alipuu = leftRightRotate(parent);
                }
                if (vanhempi == null) {
                    head = alipuu;
                } else if (vanhempi.getLeft() == parent) {
                    vanhempi.setLeft(alipuu);
                } else {
                    vanhempi.setRight(alipuu);
                }
                if (vanhempi != null) {
                    vanhempi.setHeight(Math.max(height(vanhempi.getLeft()), height(vanhempi.getRight())) + 1);
                }
                return uusi;
            }
            if (height(parent.getRight()) == height(parent.getLeft()) + 2) {
                vanhempi = parent.getParent();
                if (height(parent.getRight().getRight()) > height(parent.getRight().getLeft())) {
                    alipuu = leftRotate(parent);
                } else {
                    alipuu = rightLeftRotate(parent);
                }
                if (vanhempi == null) {
                    head = alipuu;
                } else if (vanhempi.getLeft() == parent) {
                    vanhempi.setLeft(alipuu);
                } else {
                    vanhempi.setRight(alipuu);
                }
                if (vanhempi != null) {
                    vanhempi.setHeight(Math.max(height(vanhempi.getLeft()), height(vanhempi.getRight())) + 1);
                }
                return uusi;
            }
            parent.setHeight(Math.max(height(parent.getLeft()), height(parent.getRight())) + 1);
            parent = parent.getParent();

        }
        return uusi;
    }
    /**
     * Apumetodi jonka tarkoitus on selkeyttää koodia. Vertailu tehdään
     * apumetodissa jolloin oikeassa koodissa ei ole hankalasti avattavaa
     * vertailua.
     *
     * @param parent Node jonka lapsen lapsia vertaillaan.
     * @return palautetaan true jos ehto on tosi. Muuten false.
     */
    private boolean epaTasaPainoVasenVaiOikeaAlipuu(AvlNode p) {
        return height(p.getLeft().getLeft()) > height(p.getLeft().getRight());
    }


    /**
     * Apumetodi solmun lisäämiseen avl-puuhun. Hoitaa varsinaisen solmun
     * lisäämisen puuhun.
     *
     * @param lisattava solmun avain.
     * @return palautetaan lisätty solmu.
     */
    private AvlNode insert(int lisattava) {
        AvlNode uusi = new AvlNode(lisattava);
        AvlNode parent = null;
        if (head == null) {
            head = uusi;
            treeSize++;
            return head;
        }
        AvlNode x = head;
        while (x != null) {
            parent = x;
            if (uusi.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        uusi.setParent(parent);
        if (uusi.getKey() < parent.getKey()) {
            parent.setLeft(uusi);
        } else {
            parent.setRight(uusi);
        }
        treeSize++;
        return uusi;
    }

    
    /**
     * Metodi jolla poistetaan nodeja AVL-puusta. Varsinainen poistaminen
     * tapahtuu apumetodissa delete. Kun node on poistettu niin sitten avlDelete
     * suorittaa tarvittavan määrän kiertoja jotta puuhun ei jää epätasapainoa.
     *
     * @param poistettava avlnode joka poistetaan
     */
    public void avlDelete(AvlNode poistettava) {
        AvlNode pois = delete(poistettava);
        AvlNode parent = pois.getParent();
        AvlNode vanhempi;
        AvlNode alipuu;
        while (parent != null) {
            if (height(parent.getLeft()) == height(parent.getRight()) + 2) {
                vanhempi = parent.getParent();
                if (epaTasaPainoVasenVaiOikeaAlipuu(parent)) {
                    alipuu = rightRotate(parent);
                } else if (height(parent.getRight().getRight()) > height(parent.getRight().getLeft())) {
                    alipuu = leftRotate(parent);
                } else if (height(parent.getLeft().getRight()) > height(parent.getLeft().getLeft())) {
                    alipuu = leftRightRotate(parent);
                } else {
                    alipuu = rightLeftRotate(parent);
                }
                if (parent==head) {
                    head = alipuu;
                    return;
                }
                vanhempi.setRight(alipuu);
                alipuu.setParent(vanhempi);
                parent = vanhempi;
            }
            if(height(parent.getRight()) == height(parent.getLeft()) + 2) {
                vanhempi = parent.getParent();
                if (height(parent.getRight().getRight()) > height(parent.getRight().getLeft())) {
                    alipuu = leftRotate(parent);
                } else if (height(parent.getLeft().getLeft()) > height(parent.getLeft().getRight())) {
                    alipuu = rightRotate(parent);
                } else if (height(parent.getRight().getLeft()) > height(parent.getRight().getRight())) {
                    alipuu = rightLeftRotate(parent);
                } else {
                    alipuu = leftRightRotate(parent);
                }
                if (parent==head) {
                    head = alipuu;
                    return;
                }
                vanhempi.setLeft(alipuu);
                alipuu.setParent(vanhempi);
                parent = vanhempi;
            }
            else {
                parent.setHeight(Math.max(height(parent.getLeft()), height(parent.getRight())) + 1);
                parent = parent.getParent();
            }
        }
    }

    /**
     * delete metodi on avlDelete metodin apu metodi joka huolehtii
     * varsinaisesta noden poistamisesta.
     *
     * @param poistettava poistettava node.
     * @return palautetaan
     */
    private AvlNode delete(AvlNode poistettava) {  
        AvlNode pois = poistettava;
        AvlNode vanhempi;
        AvlNode lapsi;
        if (pois.getLeft() == null && pois.getRight() == null) {
            vanhempi = pois.getParent();
            if (vanhempi == null) {
                head = null;
                return pois;
            }
            if (pois == vanhempi.getLeft()) {
                vanhempi.setLeft(null);
            } else {
                vanhempi.setRight(null);
            }
            treeSize--;
            return pois;
        }
        if (pois.getLeft() == null || pois.getRight() == null) {
            if (pois.getLeft() != null) {
                lapsi = pois.getLeft();
            } else {
                lapsi = pois.getRight();
            }
            vanhempi = pois.getParent();
            lapsi.setParent(vanhempi);
            if (vanhempi == null) {
                head = lapsi;
                return pois;
            }
            if (pois == vanhempi.getLeft()) {
                vanhempi.setLeft(lapsi);
            } else {
                vanhempi.setRight(lapsi);
            }
            treeSize--;
            return pois;
        }
        AvlNode seur = min(pois.getRight());
        pois.setKey(seur.getKey());
        lapsi = seur.getRight();
        vanhempi = seur.getParent();
        if (vanhempi.getLeft() == seur) {
            vanhempi.setLeft(lapsi);
        } else {
            vanhempi.setRight(lapsi);
        }
        if (lapsi != null) {
            lapsi.setParent(vanhempi);
        }
        treeSize--;
        return seur;
    }

    /**
     * Palauttaa pinon pienimmän noden. Aloittaa juuresta ja käy silmukassa läpi
     * vasemmat lapset kunnes tullaan arvoon null eli ei ole enää vasenta lasta.
     * Tällöin on tultu pienimpään nodeen.
     *
     * @return pinon pienin node.
     */
    private AvlNode min(AvlNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Palauttaa juuren avaimen. Käytetään testeissä. Ei kuulu AVL-puun
     * varsinaiseen toteutukseen.
     *
     * @return juuri noden avain.
     */
    public int getJuurenAvain() {
        return head.getKey();
    }

    /**
     * Palauttaa tiedon montako nodea on puussa. Käytetään testeissä. Ei kuulu
     * AVL-puun varsinaiseen toteutukseen.
     *
     * @return treeSize eli monta node puussa on.
     */
    public int getTreeSize() {
        return treeSize;
    }

    /**
     * Palauttaa puun juuren. Käytetään testeissä. Ei kuulu AVL-puun
     * varsinaiseen toteutukseen.
     *
     * @return head
     */
    public AvlNode getJuuri() {
        return head;
    }
    /**
     * Puun alkioiden tulostaminen pienimmästä suurimpaan. Eli sisä-
     * järjestyksessä. 
     * Hupimetodi testailuun.
     * @param x mistä aloitetaan
     */
    public void tulostaAlkiot(AvlNode x) {
        if(x!=null) {
            tulostaAlkiot(x.getLeft());
            System.out.print(x.getKey()+" ");
            tulostaAlkiot(x.getRight());         
        }
    }
    
    /**
     * AvlPuun pienimmän avaimen palautus.
     * @return node jossa on AVL-puun pienin arvo.
     */
    public AvlNode min() {
        AvlNode node = head;
        while(node.getLeft()!=null) {
            node=node.getLeft();
        }
        return node;
    }
    
    @Override
    public String toString() {
        return "" + head.getKey();
    }
}
