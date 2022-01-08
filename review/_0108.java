package review;

public class _0108 {

    static void quickSort(int[] q, int l, int r) {
        if (l >= r) { return; }

        int x = q[(l + r) >> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x);
            while (q[++j] > x);
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

        int mid = (l + r) / 2;
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) { tmp[k++] = q[i++]; }
            else { tmp[k++] = q[j++]; }
        }
        while (i <= mid) { tmp[k++] = q[i++]; }
        while (j <= r)   { tmp[k++] = q[j++]; }

        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[l];
        }
    }

    static boolean check(int x) { return true; }
    static boolean check(double x) { return false; }
    static int bSearch_int1(int[] q, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid)) { r = mid; }
            else { l = mid + 1; }
        }
        return l;
    }
    static int bSearch_int2(int[] q, int l, int r) {
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) { l = mid; }
            else { r = mid - 1; }
        }
        return l;
    }
    static double bSearch_d(double[] q, double l, double r) {
        double eps = 1e-6;
        while (r - l < eps) {
            double mid = (l + r) / 2;
            if (check(mid)) { r = mid; }
            else { l = mid; }
        }
        return l;
    }

    // prefix sum - 1d
    // s[i] = a[1] + a[2] + a[3] + ... + a[i] (index from 1)
    // sum[l, r] = a[l] + a[l + 1] + ... + a[r] = s[r] - s[l - 1];
    // s[l, r] = s[r] - s[l - 1];

    // prefix sum - 2d
    /*
        sum of s[(x1, y1),(x2, y2)] =
        s[x2, y2] - s[x1 - 1, y2] - s[x2, y1 - 1] + s[x1 - 1, y1 - 1]
    */

    // difference_1d
    // add c for range [l, r] = b[l] += c, b[r + 1] -= c

    // difference_2d
    /* add c for range [(x1, y1), (x2, y2)]
        s[x1, y1] += c;
        s[x1, y2 + 1] -= c;
        s[x2 - 1, y1] -= c;
        s[x2 + 1, y2 + 1] += c;
    */
    static boolean check(int x, int y) { return true; }
    static void twoPointers(int n) {
        for (int i = 0, j = 0; i < n; i++) {
            while (j < i && check(i, j)) { j++; }
            //TODO:
        }
    }

    // x >> k & 1;
    // lowBit(x) = x & -x;

}


class LinkedList {
    int[] e;
    int[] ne;
    int head;
    int idx;

    public LinkedList(int N) {
        this.e = new int[N];
        this.ne = new int[N];
        head = -1;
        idx = 0;
    }

    public void insert(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    public void insertHead(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    public void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    public void print() {
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }

        // for (int i = r[0]; i != 1; i = r[i]){
        //     System.out.print(e[i] + " ");
        // }
    }
}

class DoubleLinkedList {
    int[] e;
    int[] l;
    int[] r;
    int idx;

    public DoubleLinkedList(int N) {
        this.e = new int[N];
        this.l = new int[N];
        this.r = new int[N];
        l[0] = 1;
        r[1] = 0;
        idx = 2;
    }

    public void insert(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx++;
    }

    public void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    public void print() {
        for (int i = r[0]; i != -1; i = r[i]) {
            System.out.print(e[i] + " ");
        }
    }
}