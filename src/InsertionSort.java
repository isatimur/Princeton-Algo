/**
 * Created by tisachenko on 23.03.2015.
 */
public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }

            }
        }

    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) == -1);
    }

    private static void exch(Comparable[] a, int i, int min) {
        Comparable t = a[i];
        a[i] = a[min];
        a[min] = t;
    }
}