package tiralabra.data_structures;

/* @author mhaanran */
public class Link {

    private int key;
    private Link nextLink=null;
    private Link prevLink=null;

    
    public Link(int key, Link nextLink, Link prevLink) {
        this.key=key;
        this.nextLink=nextLink;
        this.prevLink=prevLink;
    }
    
    public Link(int key) {
	 this.key=key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Link getNextLink() {
        return nextLink;
    }

    public void setNextLink(Link nextLink) {
        this.nextLink = nextLink;
    }

    public Link getPrevLink() {
        return prevLink;
    }

    public void setPrevLink(Link prevLink) {
        this.prevLink = prevLink;
    }
}
