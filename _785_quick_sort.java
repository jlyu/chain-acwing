import java.util.*;

public class _785_quick_sort {

    static int n;
    static int q[];

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();
        q = new int[n];

        for(int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }

        quickSort(q, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.printf("%d ", q[i]);
        }
        scanner.close();
    }

    private static void quickSort(int[] q, int l, int r) {
        if (l >= r) { return; }

        int x = q[l];
        int i = l - 1, j = r + 1;

        while (i < j) {
            while (q[++i] < x);
            while (q[--j] > x);
            if (i < j) { swap(q, i, j); }
        }

        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    private static void swap(int[] q, int l, int r) {
        int t = q[l];
        q[l] = q[r];
        q[r] = t;
    }

}