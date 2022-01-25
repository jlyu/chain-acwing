import java.util.*;

public class _847_bfs_gh_short_path {
    static int N = 100010, M = 2 * N;

    static int h[] = new int[N];
    static int ne[] = new int[M];//无向图，边的个数是点的两倍
    static int e[] = new int[M]; //无向图，边的个数是点的两倍
    static int d[] = new int[N];

    static boolean visited[] = new boolean[N];

    static int idx = 0;
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        Arrays.fill(h, -1);
        Arrays.fill(d, -1);

        for(int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b); //add(b,a);
        }

        System.out.println(bfs());
        scanner.close();
    }

    private static int bfs() {

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        d[1] = 0;

        while(!q.isEmpty()) {
            int t = q.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] == -1) {
                    d[j] = d[t] + 1;
                    q.offer(j);
                }
            }
        }
        return d[n];
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

