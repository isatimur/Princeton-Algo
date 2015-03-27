import java.util.Arrays;

/**
 * Created by tisachenko on 24.03.2015.
 */
public class Graph {
    public Graph(int V) {

    }

    public Graph(In in) {

    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                StdOut.println(v + "-" + w);
            }
        }
    }

    public void addEdge(int v, int w) {

    }

    public Iterable<Integer> adj(int v) {
        return null;
    }

    public int V() {
        return 0;
    }

    public int E() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
