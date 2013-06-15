package tiralabra.data_structures;

/**
 *
 * @author mhaanran Luokka toteuttaa minimi binäärikeon.
 */
public class BinaariKeko {

    private Integer[] binKeko;
    private int heapSize;
    private int taulukonKoko = 100;

    /**
     * Luodaan syötteenä saadusta taulukosta minimi binäärikeko.
     *
     * @param binKeko Binäärikeko tallennetaan tähän muuttujaan.
     */
    public BinaariKeko(Integer[] binKeko) {
        this.binKeko = buildHeap(binKeko);
    }

    /**
     * Konstruktori jolla luodaan parametrin taulukonKoko suuruinen int
     * tyyppinen taulukko binäärikeon tallentamista varten. default arvo
     * taulukonKoolle on 100.
     */
    public BinaariKeko() {
        this.binKeko = new Integer[taulukonKoko];
    }

    /**
     * Metodi palauttaa syötteenä annetun indeksin parentin eli keossa ylemmällä
     * tasolla olevan arvon indeksin.
     *
     * @param i alkion indeksi taulukossa binKeko.
     * @return i/2 palauttaa parentin indeksin.
     */
    public int parent(int i) {
        return i / 2;
    }

    /**
     * Metodi palauttaa ylemmän tason indeksiä alemmalla tasolla olevan lapsen
     * indeksin.
     *
     * @param i alkion indeksi taulukossa binKeko.
     * @return i*2 palauttaa vasemman lapsen indeksin.
     */
    public int left(int i) {
        return 2 * i;
    }

    /**
     * Metodi palauttaa ylemmän tason indeksiä alemmalla tasolla olevan lapsen
     * indeksin.
     *
     * @param i alkion indeksi taulukossa binKeko.
     * @return i*2+1 palauttaa oikean lapsen indeksin
     */
    public int right(int i) {
        return 2 * i + 1;
    }

    /**
     * Metodi keon koon kyselemiseen.
     * @return palauttaa keon koon joka on tallessa heapSize muuttujassa.
     */
    public int getHeapSize() {
        return heapSize;
    }

    /**
     * Metodi palauttaa keon pienimmän alkion arvon.
     * @param binKeko taulukko jossa keko sijaitsee.
     * @return binKeko[0] Minimi keon pienin alkio on taulukon indeksissä 0. 
     * Eli palautetaan sen sisältö.
     */
    public Integer min(Integer[] binKeko) {
        return binKeko[0];
    }

    /**
     * Poistaa pienimmän arvon keosta. Käyttää apumetodina 
     * decreaseHeapSizea joka pienentää keon kokoa yhdellä ja kopioi muut 
     * paitsi viimeisenä keossa olevan alkion uuteen kekoon jolloin tämä alkio
     * jää keosta pois.
     * @return poistettava, keon pienin arvo.
     */
    public Integer delete() {
        int min = binKeko[0];
        binKeko[0] = binKeko[heapSize - 1];
        binKeko = decreaseHeapSize();
        heapify(binKeko, 0);
        return min;
    }

    /**
     * Apumetodi pienimmän alkion poistamiseen. Metodi pienentää 
     * taulukon koko jos heapSize on pienempi kuin taulukonKoko/2.
     * @return palauttaa pienemmän keon tai saman keon.
     */
    private Integer[] decreaseHeapSize() {
        heapSize = heapSize - 1;
        if (heapSize < (taulukonKoko / 2) && taulukonKoko >= 100) {
            taulukonKoko = taulukonKoko / 2;
            Integer[] binKeko2 = new Integer[taulukonKoko];
            for (int i = 0; i < binKeko2.length; i++) {
                binKeko2[i] = binKeko[i];
            }
            return binKeko2;
        }
        return binKeko;
    }

    /**
     * Lisää arvon kekoon. Käyttää apumetodina increaseHeapSizea joka 
     * kasvattaa keon kokoa tarpeen vaatiessa.
     * @param k avain joka kekoon lisätään.
     */
    public void insert(Integer k) {
        binKeko = increaseHeapSize();
        int i = heapSize - 1;
        while (i > 0 && binKeko[parent(i)] > k) {
            binKeko[i] = binKeko[parent(i)];
            i = parent(i);
        }
        binKeko[i] = k;
    }

    /**
     * Apumetodi heapInsertille joka kasvattaa keon kokoa. Keon 
     * tallentamiseen  käytettävän taulukon koko tuplataan jos heapSize 
     * on suurempi tai yhtäsuuri kuin nykyinen keon koko.
     * @return palauttaa 2 kertaa suuremman taulukon.
     */
    private Integer[] increaseHeapSize() {
        heapSize = heapSize + 1;
        if (taulukonKoko <= heapSize) {
            taulukonKoko = taulukonKoko * 2;
            Integer[] binKeko2 = new Integer[taulukonKoko];
            for (int i = 0; i < binKeko.length; i++) {
                binKeko2[i] = binKeko[i];
            }
            return binKeko2;
        }

        return binKeko;
    }

    /**
     * Apumetodi jolla valmiista taulukosta saa tehty binaarikeon.
     *
     * @param binKeko taulukko josta tehdään keko.
     * @return palautetaan valmis keko kutsujalle.
     */
    private Integer[] buildHeap(Integer[] binKeko) {
        heapSize = binKeko.length;
        taulukonKoko = heapSize;
        for (int i = binKeko.length / 2; i >= 0; --i) {
            heapify(binKeko, i);
        }
        return binKeko;
    }

    /**
     * heapify korjaa keko ehdon jos se on mennyt rikki, kun alkioita poistetaan
     * keosta.
     *
     * @param binKeko taulukko jossa keko sijaitsee.
     * @param i taulukon indeksi, josta on poistettu alkio.
     * @return binKeko palauttaa korjatun keon.
     */
    private Integer[] heapify(Integer[] binKeko, int i) {
        int left = left(i);
        int right = right(i);
        int smallest;
        if (right <= heapSize - 1) {
            if (binKeko[left] < binKeko[right]) {
                smallest = left;
            } else {
                smallest = right;
            }
            if (binKeko[i] > binKeko[smallest]) {
                swapSmallestwithI(binKeko, i, smallest);
                heapify(binKeko, smallest);
            }
        } else if (left == heapSize - 1 && binKeko[i] > binKeko[left]) {
            swapSmallestwithI(binKeko, i, left);
        }
        return binKeko;
    }

    /**
     * Apumetodi heapifylle jolla vaihdetaan kahden alkion paikkaa.
     *
     * @param binKeko keko jolle operaatio suoritettaan.
     * @param i taulukon indeksi.
     * @param smallest keon pienin arvo.
     */
    private void swapSmallestwithI(Integer[] binKeko, int i, int smallest) {
        int apu = binKeko[i];
        binKeko[i] = binKeko[smallest];
        binKeko[smallest] = apu;
    }

    @Override
    public String toString() {
        String k = "";
        for (int i = 0; i < heapSize; i++) {
            k += " " + binKeko[i];
        }
        return k;
    }
}