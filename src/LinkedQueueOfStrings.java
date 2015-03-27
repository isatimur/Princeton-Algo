/**
 * Created by tisachenko on 20.03.2015.
 */
public class LinkedQueueOfStrings {

    private Node first,last = null;

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first =last;
        else oldLast.next = last;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if(isEmpty()) last=null;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }


    // 16 bytes object overhead
    private class Node {
        // 8 bytes inner class extra
        String item;//8 bytes string reference
        Node next;//8 bytes object reference
    }

    public static void main(String[] args) {

    }
}
