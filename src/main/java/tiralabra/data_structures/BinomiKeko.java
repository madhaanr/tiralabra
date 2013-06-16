package tiralabra.data_structures;

/**
 * Luokka toteuttaa binomikeon. Kyseessä on minimi keko.
 *
 * @author mhaanran
 */
public class BinomiKeko {

    //linkitetyn listan alku solmu.
    private Node head;

    /**
     * Konstructorissa luodaan uusi tyhjä uusi. head osoittaa binomikeon 
     * juurilistan ensimmäiseen alkioon ja se asetetaan arvoon null.
     * Make-Binomial-Heap
     */
    public BinomiKeko() {
        head = null;
    }

    /**
     * Metodilla voi tarkistaa onko uusi tyhjä.
     * @return palauttaa true jos uusi on tyhjä ja muuten false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Metodilla voi lisätä kekoon solmuja.
     * Aluksi luodaan uusi binomikeko, jonka headiksi laitetaan lisättävä solmu.
     * Tämän jälkeen yhdistetään tämä uusi keko jo olemassa olevan keon kanssa ja
     * yhdistetty keko talletetaan uusikeko nimellä.
     * Lopuksi luokkamuuttuja head pistetään osoittamaan uusiKeko headiin.
     * @param lisattava on lisättävä solmu.
     */
    public void insert(Node lisattava) {
        BinomiKeko keko = new BinomiKeko();
        keko.head = lisattava;
        BinomiKeko uusiKeko = this.union(keko);
        head = uusiKeko.head;
    }

    /**
     * Metodi yhdistää kaksi kekoa yhdeksi keoksi. Käytetään 
     * kun kekoon lisätään alkioita. Käyttää apumetodina merge 
     * ja pair metodeita. 
     * @param keko insertin parametrina annetusta nodesta luotu uusi.
     * @return uusi palauttaa yhdistetyn keon.
     */
    public BinomiKeko union(BinomiKeko keko) {
        BinomiKeko uusi = new BinomiKeko();
        uusi.head = merge(this, keko);
        head = null;
        keko.head = null;

        if (uusi.isEmpty()) {
            return uusi;
        }
        
        Node node = uusi.head;
        Node prev = null;
        Node next = node.getSibling();

        while (next != null) {
            if (degreesOfNodeNextNotSame(node, next)) {
                prev = node;
                node = next;
            } 
            else if(nextSiblingNotNullAndNodeNextDegreesSame(next, node)) {
                prev = node;
                node = next;
            }
            else {
                if (node.getKey() < next.getKey()) {
                    node.setSibling(next.getSibling());
                    pair(next, node);
                } 
                else {
                    if (prev == null) {
                        uusi.head = next;
                    } 
                    else {
                        prev.setSibling(next);
                    }
                    pair(node, next);
                    node = next;
                }
            }
            next = node.getSibling();
        }
        return uusi;
    }
    /**
     * Union metodin apumetodi.
     * Yhdistää parametrina annettujen kekojen juurisolmulistat toisiinsa.
     * @param keko1 yhdistettävä keko1.
     * @param keko2 yhdistettävä keko2.
     * @return head palauttaa uuden juurilistan headin eli listan alun.
     */
    private Node merge(BinomiKeko keko1, BinomiKeko keko2) {
        if (keko1.isEmpty()) {
            return keko2.head;
        } 
        if (keko2.isEmpty()) {
            return keko1.head;
        } 
        
        Node head;
        Node tail;
        Node k1Head = keko1.head;
        Node k2Head = keko2.head;
        if (k1HeadDegreeSmallerThanK2Heads(k1Head, k2Head)) {
            head = keko1.head;
            k1Head = k1Head.getSibling();
        } 
        else {
            head = keko2.head;
            k2Head = k2Head.getSibling();
        }
        tail = head;
        while (k1HeadAndk2HeadNotNull(k1Head, k2Head)) {
            if (k1HeadDegreeSmallerThanK2Heads(k1Head, k2Head)) {
                tail.setSibling(k1Head);
                k1Head = k1Head.getSibling();
            } 
            else {
                tail.setSibling(k2Head);
                k2Head = k2Head.getSibling();
            }
            tail = tail.getSibling();
        }
        if (k1Head != null) {
            tail.setSibling(k1Head);
        } 
        else {
            tail.setSibling(k2Head);
        }
        return head;
    }
    /**
     * Parittaa kaksi nodea keskenään.
     * @param eka Tästä nodesta tulee tokan child.
     * @param toka Tästä nodesta tulee ekan parent.
     */
    private void pair(Node eka, Node toka) {
        eka.setParent(toka);
        eka.setSibling(toka.getChild());
        toka.setChild(eka);
        toka.setDegree(toka.getDegree() + 1);
    }
    
    /**
     * Metodi palauttaa keon pienimmän alkion key arvon. 
     * Binomikeon pienin arvo on juurilistan pienin arvon eli tarvitsee 
     * käydä läpi vain juurinodelista. 
     * @return palautetaan node1.key eli keon pienin arvo.
     */
    public int min() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        Node node1 = head;
        Node node2 = node1.getSibling();

        while (node2 != null) {
            if (node2.getKey() < node1.getKey()) {
                node1 = node2;
            }
            node2 = node2.getSibling();
        }      
        return node1.getKey();
    }

    /**
     * Metodi poistaa ja palauttaa keon pienimmän alkion. 
     * Toteutus on aluksi melkein saman kuin pelkässä minimi alkion 
     * palautuksessa. Mutta nykyistä node1.keytä pienemmän arvon 
     * löytyessä pidetään myös kirjaa mistä sinne tultiin.
     * @return Palauttaa node1.key arvon.
     */
    public int remove() {
        int min;
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        Node node1 = head;
        Node node2 = node1.getSibling();
        Node node1Prev = null;
        Node node2Prev = node1;
        
        while (node2 != null) {
            if (node2.getKey() < node1.getKey()) {
                node1 = node2;
                node1Prev = node2Prev;
            }
            node2Prev = node2;
            node2 = node2.getSibling();
        }

        min = node1.getKey();
        if (node1 == head) {
            head = node1.getSibling();
        } else {
            node1Prev.setSibling(node1.getSibling());
        }

        BinomiKeko keko = new BinomiKeko();
        node1 = node1.getChild();
        while (node1 != null) {
            Node next = node1.getSibling();
            node1.setSibling(keko.head);
            keko.head = node1;
            node1 = next;
        }
        BinomiKeko uusiKeko = this.union(keko);
        head = uusiKeko.head;      
        return min;
    }

    
    /**
     * Metodi jolla saa tietää mikä node on keon head.
     * @return head palauttaa keon head noden.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Apumetodi mergeHeapille. Tarkistus onko nextin sibling not null 
     * ja ovatko node ja next saman asteisia.
     * @param node käsiteltävä node.
     * @param next noden sibling.
     * @return palautetaan true jos nextillä on sisarus ja noden sekä nextin 
     * degreet ovat samat
     */
    private boolean nextSiblingNotNullAndNodeNextDegreesSame(Node next, Node node) {
        return next.getSibling() != null &&  
               next.getSibling().getDegree() == node.getDegree();
    }
    /**
     * Apumetodi mergeHeapille. Tarkistetaan ettei noden ja nextin 
     * degree ole sama. 
     * @param node käsiteltävä node.
     * @param next noden sibling.
     * @return palautetaan vertailun tulos. True jos degree eivät ole samat.
     */
    private boolean degreesOfNodeNextNotSame(Node node, Node next) {
        return node.getDegree() != next.getDegree();
    }
    
    /**
     * Metodin merge apumetodi joka tarkistaa ovatko k1Head ja k2Head null
     * @param k1Head keon 1 head.
     * @param k2Head keon 2 head.
     * @return palautetaan true jos molemmat eivät ole null.
     */
    private boolean k1HeadAndk2HeadNotNull(Node k1Head, Node k2Head) {
        return k1Head != null && k2Head != null;
    }
    
    /**
     * Metodin merge apumetodi jolla tarkistetaan onko k1Head 
     * degree pienempi tai sama kuin k2Head degree.
     * @param k1Head keon 1 head node.
     * @param k2Head keon 2 head node
     * @return palautetaan true jos k1Head degree on pienempi tai yhtäsuuri
     * kuin k2Head degree. 
     */
    private boolean k1HeadDegreeSmallerThanK2Heads(Node k1Head, Node k2Head) {
        return k1Head.getDegree() <= k2Head.getDegree();
    }
    
    @Override
    public String toString() {
        String keko = "";
        while (head != null) {
            keko += remove() + " ";
        }
        return keko;
    }
}
