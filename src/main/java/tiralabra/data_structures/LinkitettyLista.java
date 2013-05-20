package tiralabra.data_structures;

/* @author mhaanran */
public class LinkitettyLista {
   
    private Link ekaLink;
    private Link vikaLink;
     
    public LinkitettyLista() {
        ekaLink=null;
        vikaLink=null;
    }
    
    public boolean isEmpty() {       
        return ekaLink==null&&vikaLink==null;    
    }
    
    public void lisaa(int key) {
        Link lisattava = new Link(key);
        if(isEmpty()) {
            ekaLink=lisattava;
            vikaLink=lisattava;
        }
        else {
            vikaLink.setNextLink(lisattava);
            lisattava.setNextLink(null);
            vikaLink=lisattava;
        }
    }
    
    /*
     * lisaa(Linkki lisattava)
     * tarkista onko tyhjä lista
     * 
     * vikaLink.next=lisattava
     * lisattava.prev = vikaLink
     * lisattava.next = null
     * 
     * vikaLink=lisattava
     */
}
