/**
 * Created by tisachenko on 20.03.2015.
 */
public class ResizedQueue<T> {
    private T s[] = null;
    private int N = 0;
    private int capacity = 0;
    private int head;
    private int tail;

    public ResizedQueue(int capacity) {
        s = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        ResizedQueue<String> arrayOfStrings = new ResizedQueue<String>(5);
        arrayOfStrings.push("to");
        arrayOfStrings.push("be");
        arrayOfStrings.push("or");
        arrayOfStrings.push("not");
        StdOut.println(arrayOfStrings.pop());
        StdOut.println(arrayOfStrings);
        StdOut.println(arrayOfStrings.pop());
        StdOut.println(arrayOfStrings);
        arrayOfStrings.push("to");
        arrayOfStrings.push("be");
        StdOut.println(arrayOfStrings);

    }

    public void push(T item) {
        if (tail == s.length) {
            resize(2 * s.length);
        }
        s[tail] = item;
        tail++;

    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                copy[i] = s[i];
            }
        }
        s = copy;
    }

    private T pop() {

        T item = s[head];
        s[head] = null;
        head++;
        //if(head>0 && head == s.length/4) resize(s.length/2);
        return item;
    }

    private boolean isEmpty() {
        return s == null;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < s.length; i++) {
            output = output + s[i] + ",";
        }
        return output;
    }
}
