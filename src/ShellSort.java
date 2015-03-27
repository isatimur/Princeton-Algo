import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by tisachenko on 23.03.2015.
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j],a[j-h]); j-=h) {
                    exch(a, j, j - h);
                }

            }
            h = h/3;
        }

    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w)<0);
    }

    private static void exch(Comparable[] a, int i, int min) {
        Comparable t =a[i];
        a[i] = a[min];
        a[min] = t;
    }


    private static boolean isSorted(Comparable[] a){
        for (int i = 1; i <a.length ; i++) {
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a= new String[]{"B","T","R","A","C","J","O"};
        ShellSort.sort(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+",");
        }
        System.out.println(isSorted(a));



    }
}