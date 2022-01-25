import java.util.*;

public class _787_merge_sort {

    static int n;
    static int q[];
    static int tmp[];

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();
        q = new int[n];
        tmp = new int[n];

        for(int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }

        mergeSort(q, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.printf("%d ", q[i]);
        }
        scanner.close();
    }

    private static void mergeSort(int[] q, int l, int r) {
        if (l >= r) { return; }
        int mid = (l + r) >> 1;

        mergeSort(q, l, mid);
        mergeSort(q, mid+1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) { tmp[k++] = q[i++]; }
            else { tmp[k++] = q[j++]; }
        }
        while (i <= mid) { tmp[k++] = q[i++]; }
        while (j <= r)   { tmp[k++] = q[j++]; }

        for (i = l, j = 0; i <= r; i++, j++ ) {
            q[i] = tmp[j];
        }
    }

    // private static void swap(int[] q, int l, int r) {
    //     int t = q[l];
    //     q[l] = q[r];
    //     q[r] = t;
    // }

}