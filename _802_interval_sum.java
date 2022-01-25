/*
假定有一个无限长的数轴，数轴上每个坐标上的数都是 0。

现在，我们首先进行 n 次操作，每次操作将某一位置 x 上的数加 c。

接下来，进行 m 次询问，每个询问包含两个整数 l 和 r，
你需要求出在区间 [l,r] 之间的所有数的和。

输入格式
第一行包含两个整数 n 和 m。

接下来 n 行，每行包含两个整数 x 和 c。

再接下来 m 行，每行包含两个整数 l 和 r。

输出格式
共 m 行，每行输出一个询问中所求的区间内数字和。

数据范围
−109≤x≤109,
1≤n,m≤105,
−109≤l≤r≤109,
−10000≤c≤10000
输入样例：
3 3  = n, m

1 2  = n=3,
3 6  = x,c
7 5

1 3  = m
4 6
7 8
输出样例：
8
0
5
*/

import java.util.*;

public class _802_interval_sum {

    static int N = 300010;

    static int n, m;
    static int a[], s[];


    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        a = new int[N];
        s = new int[N];

        List<Integer> alls = new ArrayList<Integer>();
        List<Pair> add = new ArrayList<Pair>();
        List<Pair> query = new ArrayList<Pair>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int c = scanner.nextInt();
            add.add(new Pair(x, c));
            alls.add(x);
        }

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            query.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }

        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);

        for (Pair item: add) {
            int index = find(item.first, alls);
            a[index] += item.second;
        }

        for (int i = 1; i <= alls.size(); i++) s[i] = s[i - 1] + a[i];

        for (Pair item: query) {
            int l = find(item.first, alls);
            int r = find(item.second, alls);
            System.out.println(s[r] - s[l - 1]);
        }

        scanner.close();
    }

    static int unique(List<Integer> list) {
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                list.set(j, list.get(i));
                j++;
            }
        }
        return j;
    }

    static int find(int x, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }
}

class Pair {
    int first;
    int second;
    public Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
}