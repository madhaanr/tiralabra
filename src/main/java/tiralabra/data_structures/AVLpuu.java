package tiralabra.data_structures;

/**
 * Luokka toteuttaa AVL-puun.
 *
 * @author mhaanran
 */
public class AVLpuu {

    private AvlNode juuriNode;
    private int puunKoko;

    /**
     * Konstruktori jossa luodaan uusi puun juuri ja asetetaan sen arvoksi null
     * ja puunKooksi 0;
     */
    public AVLpuu() {
        juuriNode = null;
        puunKoko = 0;
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
     * Kaksoiskierto puun epätasapainon korjaamiseen. Ensin kierretään juuriNode
     * solmun oikea lapsi oikealle ja sen jälkeen juuriNode solmu vasemmalle.
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
     * Kaksoiskierto puun epätasapainon korjaamiseen. Ensin kierretään juuriNode
     * solmun vasen solmu vasemmalle ja sen jälkeen juuriNode solmu oikealle
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
     * Metodi solmun lisäämiseen avl-puuhun. Varsinainen solmun lisäys tehdään
     * apumetodissa ja sen jälkeen puulle tehdään tarvittavat kierrot.
     *
     * @param lisattava lisättävän solmun avain.
     * @return palautetaan lisättävä solmu.
     */
    public AvlNode avlInsert(int lisattava) {
//        if(juuriNode==null) {
//            juuriNode=new AvlNode(lisattava);
//        }
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
                    juuriNode = alipuu;
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
                    juuriNode = alipuu;
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
     * Apumetodi solmun lisäämiseen avl-puuhun. Hoitaa varsinaisen solmun
     * lisäämisen puuhun.
     *
     * @param lisattava solmun avain.
     * @return palautetaan lisätty solmu.
     */
    private AvlNode insert(int lisattava) {
        puunKoko++;
        AvlNode uusi = new AvlNode(lisattava);
        AvlNode parent = null;
        if (juuriNode == null) {
            juuriNode = uusi;
            return juuriNode;
        }
        AvlNode x = juuriNode;
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
            if (height(parent.getLeft()) == height(parent.getRight()) + 2
                    || height(parent.getLeft()) + 2 == height(parent.getRight())) {
                vanhempi = parent.getParent();
                if (height(parent.getLeft().getLeft()) > height(parent.getLeft().getRight())) {
                    alipuu = rightRotate(parent);
                } else if (height(parent.getRight().getLeft()) > height(parent.getRight().getRight())) {
                    alipuu = leftRotate(parent);
                } else if (height(parent.getLeft().getRight()) > height(parent.getLeft().getLeft())) {
                    alipuu = leftRightRotate(parent);
                } else {
                    alipuu = rightLeftRotate(parent);
                }
                if (parent.equals(juuriNode)) {
                    juuriNode = alipuu;
                    return;
                }
                if (alipuu.getKey() > vanhempi.getKey()) {
                    vanhempi.setRight(alipuu);
                } else {
                    vanhempi.setLeft(alipuu);
                }
                alipuu.setParent(vanhempi);
                parent = vanhempi;
            } else {
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
        puunKoko--;
        AvlNode pois = poistettava;
        AvlNode vanh;
        AvlNode lapsi;
        if (pois.getLeft() == null && pois.getRight() == null) {
            vanh = pois.getParent();
            if (vanh == null) {
                juuriNode = null;
                return pois;
            }
            if (pois == vanh.getLeft()) {
                vanh.setLeft(null);
            } else {
                vanh.setRight(null);
            }
            return pois;
        }
        if (pois.getLeft() == null || pois.getRight() == null) {
            if (pois.getLeft() != null) {
                lapsi = pois.getLeft();
            } else {
                lapsi = pois.getRight();
            }
            vanh = pois.getParent();
            lapsi.setParent(vanh);
            if (vanh == null) {
                juuriNode = lapsi;
                return pois;
            }
            if (pois == vanh.getLeft()) {
                vanh.setLeft(lapsi);
            } else {
                vanh.setRight(lapsi);
            }
            return pois;
        }
        AvlNode seur = min(pois.getRight());
        pois.setKey(seur.getKey());
        lapsi = seur.getRight();
        vanh = seur.getParent();
        if (vanh.getLeft() == seur) {
            vanh.setLeft(lapsi);
        } else {
            vanh.setRight(lapsi);
        }
        if (lapsi != null) {
            lapsi.setParent(vanh);
        }
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
        return juuriNode.getKey();
    }

    /**
     * Palauttaa tiedon montako nodea on puussa. Käytetään testeissä. Ei kuulu
     * AVL-puun varsinaiseen toteutukseen.
     *
     * @return puunKoko eli monta node puussa on.
     */
    public int getPuunKoko() {
        return puunKoko;
    }

    /**
     * Palauttaa puun juuren. Käytetään testeissä. Ei kuulu AVL-puun
     * varsinaiseen toteutukseen.
     *
     * @return juuriNode
     */
    public AvlNode getJuuri() {
        return juuriNode;
    }

    @Override
    public String toString() {
        return "" + juuriNode.getKey();
    }
}
