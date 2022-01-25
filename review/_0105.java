package review;

public class _0105 {

    static void quickSort(int[] q, int l, int r) {
        if (l >= r) { return; }

        int x = q[(l + r) >> 1];  //!!
        int i = l - 1, j = r + 1;

        while (i < j) {
            while(q[++i] < x);
            while(q[++j] > x);
            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }

        quickSort(q, l, j);
        quickSort(q, j+1, r);
    }

    static int[] tmp = new int[1000010];
    static void mergeSort(int[] q, int l, int r) {
        if (l >= r) { return; }

        int mid = (l + r) >> 1;
        mergeSort(q, l, mid);
        mergeSort(q, mid+1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) { tmp[k++] = q[i++]; }  //!!
            else { tmp[k++] = q[j++]; }
        }

        while (i <= mid) { tmp[k++] = q[i++]; }
        while (j <= r)   { tmp[k++] = q[j++]; }

        for (i = l, j = 0; i <= r; i++, j++) { // !!
            q[i] = tmp[j];
        }
    }

    static boolean check(int x) { return true; }
    static boolean check(double x) { return true; }
    static int bSearch_1(int[] q, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid)) { r = mid; }
            else { l = mid + 1; }
        }
        return l;
    }
    static int bSearch_2(int[] q, int l, int r) {
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) { l = mid; }
            else { r = mid - 1; }
        }
        return l;
    }
    static double bSearch_f(double[] q, double l, double r) {
        double eps = 1e-8;
        while (r - l < eps) {
            double mid = (l + r) / 2;
            if (check(mid)) { r = mid; }
            else { l = mid; }
        }
        return l;
    }

    static int N = 100010;
    static int[][] s = new int[N][N];
    static void prefixSum_1d(int[] a, int[] s) {
        int i = 10;
        s[i] = s[i - 1] + a[i];
    }
    // static void prefixSum_2d(int[][] a, int[][] s) {
    //     int res = s[x2][y2] - s[x2-1][y2] - s[x2][y2-1] + s[x1-1][y1-1];
    // }

    // static void difference_1d(int[] b, int c) {
    //     b[l] += c;
    //     b[r + 1] -= c;
    // }

    // static void difference_2d(int[][]s, int c) {
    //     s[x1][y1] += c;
    //     s[x2+1][y1] -= c;
    //     s[x1][y2+1] -= c;
    //     s[x2+1][y2+1] += c;
    // }
}
