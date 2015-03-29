import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tisachenko on 25.03.2015.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int N;
    private int first;
    private int last;
    private int capacity;

    public RandomizedQueue() {
        capacity = 7;
        array = (Item[]) new Object[capacity];
        first = 0;
        last = 0;
        N = 0;
    }

    public static void main(String[] args) {
//        RandomizedQueue<String> strings = new RandomizedQueue<String>();
//        strings.enqueue("A");
//        strings.enqueue("B");
//        strings.enqueue("C");
//        System.out.print(strings.sample());
//        System.out.print(strings.sample());
//        System.out.println(strings.sample());
//
//        for (String str : strings) {
//            System.out.println(str);
//        }
    }   // unit testing

    public boolean isEmpty() {
        return (N == 0);
    }                 // is the queue empty?

    public int size() {
        return N;
    }                        // return the number of items on the queue

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (N == capacity) {
            resize(capacity * 2);
        }
        if (N == 0) {
            last = 0;
        }
        array[last] = item;
        last++;
        N++;

    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        if (capacity == N) {
            int step = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    copy[step] = array[i];
                    step++;
                }
            }
            array = copy;
            first = 0;
            last = N;

        } else {
            for (int i = 0; i < array.length; i++) {
                copy[i] = array[i];
            }
            array = copy;
            this.capacity = capacity;
        }

    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomIndex = 0;

        if (N == 1) {
            last = first;
        } else {
            randomIndex = StdRandom.uniform(last - first);
        }
        int selectedIdx = first + randomIndex;
        Item item = array[selectedIdx];
        array[selectedIdx] = null;
        N--;
        resize(N);
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomIndex = 0;

        if (N == 1) {
            last = first;
        } else {
            randomIndex = StdRandom.uniform(last - first);
        }
        int selectedIdx = first + randomIndex;
        Item item = array[selectedIdx];
        resize(N);
        return item;
    }                     // return (but do not remove) a random item

    public Iterator<Item> iterator() {
        return new ListIterator<Item>();
    }         // return an independent iterator over items in random order

    private class ListIterator<Item> implements Iterator<Item> {
        @Override
        public boolean hasNext() {
            return (size() > 0);
        }

        @Override
        public Item next() {
            if (isEmpty()) throw new NoSuchElementException();
            return (Item) dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
