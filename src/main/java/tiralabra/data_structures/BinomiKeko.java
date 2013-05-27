package tiralabra.data_structures;

/**
 * Luokka toteuttaa binomikeon.
 *
 * @author mhaanran
 */
public class BinomiKeko {

    private Node head;

    /**
     * Konstructorissa luodaan uusi tyhjä keko. head osoittaa binomikeon 
     * juurilistan ensimmäiseen alkioon ja se asetetaan arvoon null.
     * Make-Binomial-Heap
     */
    public BinomiKeko() {
        head = null;
    }

    /**
     * Metodilla voi tarkistaa onko keko tyhjä.
     * @return palauttaa true jos keko on tyhjä ja muuten false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Metodilla voi lisätä kekoon nodeja.
     * Aluksi luodaan uusi keko, jonka headiksi laitetaan lisättävä node
     * Tämän jälkeen mergetään tämä keko jo olemassa olevan keon kanssa ja
     * yhdistetty keko talletetaan uusikeko nimellä. Lopuksi luokkamuuttuja
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
     * Metodi yhdistää kaksi kekoa yhdeksi keoksi. Käyetään muunmuassa kun
     * kekoon lisätään alkioita. Käyttää apumetodina mergeJuuriLista ja pair 
     * metodeita. 
     * @param keko2 insertin parametrina annettu keko.
     * @return palauttaa yhdistetyn keon.
     */
    public BinomiKeko mergeHeap(BinomiKeko keko2) {
        BinomiKeko keko = new BinomiKeko();
        keko.head = mergeJuuriLista(this, keko2);
        head = null;
        keko2.head = null;

        if (keko.head == null) {
            return keko;
        }

        Node prevNode = null;
        Node node = keko.head;
        Node nextNode = node.getSibling();

        while (nextNode != null) {
            if (node.getDegree() != nextNode.getDegree()
            || (nextNode.getSibling() != null 
            &&  nextNode.getSibling().getDegree() == node.getDegree())
                ) {
                prevNode = node;
                node = nextNode;
            } else {
                if (node.getKey() < nextNode.getKey()) {
                    node.setSibling(nextNode.getSibling());
                    pair(nextNode, node);
                } else {
                    if (prevNode == null) {
                        keko.head = nextNode;
                    } else {
                        prevNode.setSibling(nextNode);
                    }
                    pair(node, nextNode);
                    node = nextNode;
                }
            }
            nextNode = node.getSibling();
        }
        return keko;
    }

    private Node mergeJuuriLista(BinomiKeko keko1, BinomiKeko keko2) {
        if (keko1.head == null) {
            return keko2.head;
        } else if (keko2.head == null) {
            return keko1.head;
        } else {
            Node headL;
            Node tail;
            Node keko1Next = keko1.head;
            Node keko2Next = keko2.head;

            if (keko1.head.getDegree() <= keko2.head.getDegree()) {
                headL = keko1.head;
                keko1Next = keko1Next.getSibling();
            } else {
                headL = keko2.head;
                keko2Next = keko2Next.getSibling();
            }
            tail = headL;

            while (keko1Next != null && keko2Next != null) {
                if (keko1Next.getDegree() <= keko2Next.getDegree()) {
                    tail.setSibling(keko1Next);
                    keko1Next = keko1Next.getSibling();
                } else {
                    tail.setSibling(keko2Next);
                    keko2Next = keko2Next.getSibling();
                }
                tail = tail.getSibling();
            }
            if (keko1Next != null) {
                tail.setSibling(keko1Next);
            } else {
                tail.setSibling(keko2Next);
            }
            return headL;
        }
    }

    private void pair(Node eka, Node toka) {
        eka.setParent(toka);
        eka.setSibling(toka.getChild());
        toka.setChild(eka);
        toka.setDegree(toka.getDegree() + 1);
    }
    
     /**
     * Binomial-Heap-Minimum(Heap)
     * Metodi palauttaa keon pienimmän alkion key arvon. Binomikeon pienin
     * arvon on juurilistan pienin arvon eli tarvitsee käydä läpi vain 
     * juurilista. 
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
     * Metodi poistaa ja palauttaa keon pienimmän alkion. Toteutus on 
     * aluksi melkein saman kuin pelkässä minimi alkion palautuksessa. Mutta
     * nykyistä node1.keytä pienemmän arvon löytyessä pidetään myös kirjaa
     * mistä sinne tultiin.
     * @return Palauttaa node1.key arvon.
     */
    public int removeMin() {
        int min;
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        Node node1 = head;
        Node node2 = node1.getSibling();
        Node node2Prev = node1;
        Node node1Prev = null;

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

        Node node3 = node1.getChild();
        while (node3 != null) {
            Node next = node3.getSibling();
            node3.setSibling(keko.head);
            keko.head = node3;
            node3 = next;
        }
        BinomiKeko uusiKeko = this.mergeHeap(keko);
        head = uusiKeko.head;      
        return min;
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
