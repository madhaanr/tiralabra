package tiralabra.data_structures;

/**
 * Luokka toteuttaa binomikeon.
 *
 * @author mhaanran
 */
public class BinomiKeko {

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
     * Metodilla voi lisätä kekoon nodeja.
     * Aluksi luodaan uusi uusi, jonka headiksi laitetaan lisättävä node
     * Tämän jälkeen mergetään tämä uusi jo olemassa olevan keon kanssa ja
     * yhdistetty uusi talletetaan uusikeko nimellä. Lopuksi luokkamuuttuja
     * head pistetään osoittamaan uuden keon headiin.
     * @param lisattava on lisättävä node
     */
    public void insert(Node lisattava) {
        BinomiKeko keko = new BinomiKeko();
        keko.head = lisattava;
        BinomiKeko uusiKeko = this.mergeHeap(keko);
        head = uusiKeko.head;
    }

    /**
     * Metodi yhdistää kaksi kekoa yhdeksi keoksi. Käytetään 
     * kun kekoon lisätään alkioita. Käyttää apumetodina mergeJuuriLista 
     * ja pair metodeita. 
     * @param keko insertin parametrina annetusta nodesta luotu uusi.
     * @return uusi palauttaa yhdistetyn keon.
     */
    public BinomiKeko mergeHeap(BinomiKeko keko) {
        BinomiKeko uusi = new BinomiKeko();
        uusi.head = mergeJuuriLista(this, keko);
        head = null;
        keko.head = null;

        if (uusi.isEmpty()) {
            return uusi;
        }
        
        Node node = uusi.head;
        Node prev = null;
        Node next = node.getSibling();

        while (next != null) {
            if (node.getDegree() != next.getDegree()) {
                prev = node;
                node = next;
            } 
            else if(next.getSibling() != null &&  
                    next.getSibling().getDegree() == node.getDegree()) {
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
     * mergeHeap metodin apumetodi.
     * Yhdistää parametrina annettujen kekojen juurilistat toisiinsa.
     * @param keko1 yhdistettävä keko1.
     * @param uusi yhdistettävä uusi.
     * @return uusiHead palauttaa uuden juurilistan headin eli listan alun.
     */
    private Node mergeJuuriLista(BinomiKeko keko1, BinomiKeko keko2) {
        if (keko1.isEmpty()) {
            return keko2.head;
        } 
        else if (keko2.isEmpty()) {
            return keko1.head;
        } 
        else {
            Node uusiHead;
            Node tail;
            Node k1Head = keko1.head;
            Node k2Head = keko2.head;

            if (k1Head.getDegree() <= k2Head.getDegree()) {
                uusiHead = keko1.head;
                k1Head = k1Head.getSibling();
            } 
            else {
                uusiHead = keko2.head;
                k2Head = k2Head.getSibling();
            }
            tail = uusiHead;
            while (k1Head != null && k2Head != null) {
                if (k1Head.getDegree() <= k2Head.getDegree()) {
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
            return uusiHead;
        }
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
     * Binomial-Heap-Minimum(Heap)
     * Metodi palauttaa keon pienimmän alkion key arvon. 
     * Binomikeon pienin arvo on juurilistan pienin arvon eli tarvitsee 
     * käydä läpi vain juurilista. 
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
    public int removeMin() {
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
        BinomiKeko uusiKeko = this.mergeHeap(keko);
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

    @Override
    public String toString() {
        String keko = "";
        while (head != null) {
            keko += removeMin() + " ";
        }
        return keko;
    }
}
