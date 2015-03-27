import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tisachenko on 25.03.2015.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node header, tailor;
    private int size;

    public Deque() {
        header = null;
        tailor = null;
        size = 0;
    }                     // construct an empty deque

    public static void main(String[] args) {

    }   // unit tes

    public boolean isEmpty() {
        return header == null;
    }                 // is the deque empty?eque

    public int size() {
        return size;
    }   // return the number of items on the dront

    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        Node oldHeader = header;
        header = new Node();
        header.value = item;
        header.next = oldHeader;
        size++;
        if (size == 1) {
            tailor = header;
        }

    }          // add the item to the f end

    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        Node oldTailor = tailor;
        tailor = new Node();
        tailor.value = item;
        tailor.next = null;

        size++;
        if (size == 1) {
            header = tailor;
        } else {
            oldTailor.next = tailor;
        }
    }           // add the item to theront

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item temp = header.value;
        if (size == 1) {
            header = null;
            tailor = null;
        } else {
            header = header.next;
        }
        size--;
        return temp;

    }                // remove and return the item from the f end

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item temp = tailor.value;
        MyListIterator iterator = (MyListIterator) iterator();
        for (Node el = header; el != null; el = el.next) {
            if (el.next == tailor) {
                el.next = null;
                tailor = el;
            }
        }

        if (size == 1) {
            header = null;
            tailor = null;
        }


        size--;
        return temp;
    }                 // remove and return the item from the end

    public Iterator<Item> iterator() {

        return new MyListIterator();
    }         // return an iterator over items in order from front toting

    private class MyListIterator<Item> implements Iterator<Item> {
        Node current = header;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = (Item) current.value;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        public Node next;
        public Item value;
    }
}