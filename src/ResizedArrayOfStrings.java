/**
 * Created by tisachenko on 20.03.2015.
 */
public class ResizedArrayOfStrings {
    private String s[] = null;
    private int N = 0;
    private int capacity = 0;

    public ResizedArrayOfStrings(int capacity) {
        s = new String[capacity];
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        ResizedArrayOfStrings arrayOfStrings = new ResizedArrayOfStrings(5);
        arrayOfStrings.push("to");
        arrayOfStrings.push("be");
        arrayOfStrings.push("or");
        arrayOfStrings.push("not");
        StdOut.print(arrayOfStrings.pop());
        StdOut.print(arrayOfStrings);


    }

    public void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < s.length; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    private String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) resize(s.length / 2);
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
