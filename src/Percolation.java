/**
 * Created by tisachenko on 18.03.2015.
 */
public class Percolation {
    private final int N;
    private int[] array;
    private WeightedQuickUnionUF quickUnionUF;


    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        this.N = N;
        quickUnionUF = new WeightedQuickUnionUF(N * N + 2);
        array = new int[N * N + 2];
        array[N * N] = 1;
        array[N * N + 1] = 1;
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
        isOutOfBounds(i, j);
        if (isOpen(i, j)) return;
        //top
        int cell = getIndex(i, j);
        array[cell] = 1;
        if (i != 1 && isOpen(i - 1, j)) {
            quickUnionUF.union(getIndex(i - 1, j), cell);
        } else if (i == 1) {
            quickUnionUF.union(cell, N * N);
        }

        //bottom
        if (i != N && isOpen(i + 1, j)) {
            quickUnionUF.union(getIndex(i + 1, j), cell);
        } else if (i == N) {
            quickUnionUF.union(cell, N * N + 1);
        }

        //left
        if (j != 1 && isOpen(i, j - 1)) {
            quickUnionUF.union(getIndex(i, j - 1), cell);
        }

        //right
        if (j != N && isOpen(i, j + 1)) {
            quickUnionUF.union(getIndex(i, j + 1), cell);
        }

    }

    private int getIndex(int i, int j) {
        return (N * (i - 1) + (j - 1));
    }

    private void isOutOfBounds(int i, int j) {
        if ((i <= 0 || i > N) || (j <= 0 || j > N)) throw new IndexOutOfBoundsException();
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        isOutOfBounds(i, j);
        return array[getIndex(i, j)] == 1;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        isOutOfBounds(i, j);
        return quickUnionUF.connected(getIndex(i, j), N * N);
    }

    // does the system percolate?
    public boolean percolates() {
        return quickUnionUF.connected(N * N, N * N + 1);
    }

}