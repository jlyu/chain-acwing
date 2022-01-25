import java.util.*;

public class _850_topological_sequences_of_directed_graphs {
    static int N = 100010;

    static int n;
    static int m;

    static int h[] = new int[N];
    static int ne[] = new int[N];//无向图，边的个数是点的两倍
    static int e[] = new int[N]; //无向图，边的个数是点的两倍
    static int idx = 0;

    static int d[] = new int[N]; //点的入度

    static List<Integer> res = new LinkedList<>();


    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
        d[b]++; //更新入度
    }

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        //d = new int[n + 1];

        Arrays.fill(h, -1);
        //Arrays.fill(d, 0);

        for(int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
        }

        topSort();

        scanner.close();
    }

    private static void topSort() {

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int t = q.poll();
            res.add(t);

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    q.offer(j);
                }
            }
        }
        //return q.isEmpty();
        if (res.size() == n) {
            for(int x: res){
                System.out.printf("%d ", x);
            }
        } else {
            System.out.println("-1");
        }
    }

}

