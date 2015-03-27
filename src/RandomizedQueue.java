import java.util.Iterator;

/**
 * Created by tisachenko on 25.03.2015.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int length;
    private int head;
    private int tail;
    private Node current;
    private RandomizedQueue currentQueue;

    public RandomizedQueue() {
        currentQueue = this;
    }

    public static void main(String[] args) {

    }   // unit testing

    public boolean isEmpty() {
        return array == null;
    }                 // is the queue empty?

    public int size() {

        return array.length;
    }                        // return the number of items on the queue

    public void enqueue(Item item) {

    }           // add the item

    public Item dequeue() {
        Item temprory = array[head];
        array[head] = null;
        return temprory;
    }                    // remove and return a random item

    public Item sample() {

        return array[StdRandom.uniform(length)];
    }                     // return (but do not remove) a random item

    public Iterator<Item> iterator() {
        return new ListIterator<Item>();
    }         // return an independent iterator over items in random order

    private class Node {
        private Item current;
        private Node next;

    }

    private class ListIterator<Item> implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            return (Item) current.next;
        }

        @Override
        public void remove() {

        }
    }


}
