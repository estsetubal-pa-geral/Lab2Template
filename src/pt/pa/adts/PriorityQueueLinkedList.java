package pt.pa.adts;


/**
 *
 * @author brunomnsilva
 */
public class PriorityQueueLinkedList<E extends Comparable> implements Queue<E> {

    private final ListNode header, trailer;
    private int size;

    public PriorityQueueLinkedList() {
        this.trailer = new ListNode(null, null, null); //header not instantiated yet!
        this.header = new ListNode(null, null, this.trailer);
        this.trailer.prev = this.header;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }


    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public void clear() {
        /* return to empty state */
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
        this.size = 0;
    }

    @Override
    public void enqueue(E elem) throws QueueFullException {
        // Completar no Nivel 3

    }

    @Override
    public E dequeue() throws QueueEmptyException {
        if( this.header.next == this.trailer ) throw new QueueEmptyException();

        E front = this.header.next.elem;

        this.header.next = this.header.next.next;
        this.header.next.prev = this.header;

        this.size--;

        return front;
    }

    @Override
    public E front() throws QueueEmptyException {
        if( this.header.next == this.trailer ) throw new QueueEmptyException();

        return this.header.next.elem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PriorityQueueLinkedList{size=" + this.size() + ", front|[");

        ListNode node = this.header.next;

        while(node != this.trailer) {
            sb.append( node.elem );
            if(node != this.trailer.prev) { //don't place last comma
                sb.append( "," );
            }
            node = node.next;
        }

        sb.append("]|end}");
        return sb.toString();
    }

    private class ListNode {
        E elem;
        ListNode next, prev;

        public ListNode(E elem, ListNode prev, ListNode next) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

    }
}
