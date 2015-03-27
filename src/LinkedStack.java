import java.util.Iterator;

/**
 * Created by tisachenko on 20.03.2015.
 */
public class LinkedStack<Item> implements Iterable<Item> {

    private Node first = null;

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push("to");
        stack.push("to1");
        stack.push("to2");
        StdOut.print(stack.pop());
    }

    public void push(Item entry) {
        Node oldFirst = first;
        first = new Node();
        first.item = entry;
        first.next = oldFirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // 16 bytes object overhead
    private class Node {
        // 8 bytes inner class extra
        Item item;//8 bytes string reference
        Node next;//8 bytes object reference
    }

}
