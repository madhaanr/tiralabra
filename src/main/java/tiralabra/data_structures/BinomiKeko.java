package tiralabra.data_structures;

/**
 * Luokka toteuttaa binomikeon.
 * @author mhaanran
 */
public class BinomiKeko {

    private Node head;
    
    /**
     * Make-Binomial-Heap
     */
    public BinomiKeko() {
        head=null;
    }
    
    /**
     * Binomial-Heap-Minimum(Heap)
     * @return
     */
    public int min() {
       return 0; 
    }
    
    public boolean isEmpty() {
        return head==null;
    }
    
    public void insert(Node lisattava) {
        BinomiKeko keko = new BinomiKeko();
        keko.head=lisattava;
        BinomiKeko uusiKeko = this.mergeHeap(keko);
        head=uusiKeko.head;
    }
    
    public BinomiKeko mergeHeap(BinomiKeko keko2) {
        BinomiKeko keko = new BinomiKeko();
        keko.head=mergeRootList(this, keko2);
        head=null;
        keko2.head=null;
        
        if(keko.head==null) {
            return keko;
        }
        
        Node prevNode=null;
        Node node=keko.head;
        Node nextNode=node.getSibling();
        
        while(nextNode!=null) {
            if(node.getDegree()!=nextNode.getDegree()||
              (nextNode.getSibling()!=null&&nextNode.getSibling().getDegree()==node.getDegree())) {
                prevNode=node;
                node=nextNode;
            }
            else {
                if(node.getKey()<nextNode.getKey()) {
                    node.setSibling(nextNode.getSibling());
                    pair(nextNode,node);
                }
                else {
                    if(prevNode==null) {
                        keko.head=nextNode;
                    }
                    else {
                        prevNode.setSibling(nextNode);
                    }
                    pair(node,nextNode);
                    node=nextNode;
                }
            }
            nextNode=node.getSibling();
        }
        return keko;
    }
    
    private Node mergeRootList(BinomiKeko keko1, BinomiKeko keko2) {
        if(keko1.head==null) {
            return keko2.head;
        }
        else if(keko2.head==null) {
            return keko1.head;
        }
        else {
            Node head;
            Node tail;
            Node keko1Next=keko1.head;
            Node keko2Next=keko2.head;
            
            if(keko1.head.getDegree()<=keko2.head.getDegree()) {
                head=keko1.head;
                keko1Next=keko1Next.getSibling();
            }
            else {
                head=keko2.head;
                keko2Next=keko2Next.getSibling();
            }
            tail=head;
            
            while(keko1Next!=null&&keko2Next!=null) {
                if(keko1Next.getDegree()<=keko2Next.getDegree()) {
                    tail.setSibling(keko1Next);
                    keko1Next=keko1Next.getSibling();
                }
                else {
                    tail.setSibling(keko2Next);
                    keko2Next=keko2Next.getSibling();
                }
                tail=tail.getSibling();
            }
            if(keko1Next!=null) {
                tail.setSibling(keko1Next);
            }
            else {
                tail.setSibling(keko2Next);
            }
            return head;
        }   
    }
    private void pair(Node eka, Node toka) {
        eka.setParent(toka);
        eka.setSibling(toka.getChild());
        toka.setChild(eka);
        toka.setDegree(+1);
    }
    public int removeMin() {
        if (head == null) {
            return -1;
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
   
        int min=node1.getKey();
        if (node1 == head) {
            head = node1.getSibling();
        }
        else {
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
        BinomiKeko newH = this.mergeHeap(keko);
        head = newH.head;
        return min;
    }
}
