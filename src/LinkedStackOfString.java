/**
 * Created by tisachenko on 20.03.2015.
 */
public class LinkedStackOfString {

    private Node first = null;

    public static void main(String[] args) {
        LinkedStackOfString stack = new LinkedStackOfString();
        stack.push("to");
        StdOut.print(stack.pop());
    }

    public void push(String entry) {
        Node oldFirst = first;
        first = new Node();
        first.item = entry;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
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

}
