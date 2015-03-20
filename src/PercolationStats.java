/**
 * Created by tisachenko on 19.03.2015.
 */
public class PercolationStats {

    private double[] xt;
    // perform T independent experiments on an N-by-N grid

    public PercolationStats(int T, int N) {
        if (N <= 0) throw new IndexOutOfBoundsException();
        xt = new double[T];
        for (int k = 0; k < T; k++) {
            Percolation percolation = new Percolation(N);
            int count = 0;
            while (!percolation.percolates()) {
                int i = StdRandom.uniform(N) + 1;
                int j = StdRandom.uniform(N) + 1;
                if (!percolation.isOpen(i, j)) {
                    percolation.open(i, j);
                    count++;
                }

            }
            xt[k] = (double) count / (N * N);
        }
    }

    public static void main(String[] args) {
        int T = StdIn.readInt();
        int N = StdIn.readInt();
        Stopwatch stopwatch = new Stopwatch();
        PercolationStats stats = new PercolationStats(200, 1000);
        System.out.println(stopwatch.elapsedTime());
        System.out.println(stats.mean());
        System.out.println(stats.stddev());
        System.out.println(stats.confidenceLo() + ", " + stats.confidenceHi());


    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(xt);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(xt);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean() - ((1.96 * stddev()) / Math.sqrt(xt.length)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean() - ((1.96 * stddev()) / Math.sqrt(xt.length)));
    }
}
