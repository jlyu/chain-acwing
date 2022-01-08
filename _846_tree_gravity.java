

import java.util.Scanner;


public class _846_tree_gravity {
    static int N = 100010, M = 2 * N;

    static int head[] = new int[N];
    static int ne[] = new int[M];//无向图，边的个数是点的两倍
    static int e[] = new int[M]; //无向图，边的个数是点的两倍
    static boolean visited[] = new boolean[N];

    static int idx = 0;
    static int n;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();

        for(int i = 1 ; i <= n; i++) { head[i] = -1; } //Arrays.fill(head, -1);
        for(int i = 1; i <= n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
            add(b,a);//无向图添加双向边
        }

        dfs(1);
        System.out.println(res);
        scanner.close();
    }

    private static int dfs(int u) {
        visited[u] = true;
        int cur = 1; //用于计算以当前节点为根节点的子树的节点的数量
        int max = -1;//统计以当前节点为根节点的子树中节点数量的最大值

        for(int i = head[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!visited[j]) {
                int t = dfs(j);
                cur += t;
                max = Math.max(t, max);
            }

        }
        max = Math.max(max, n - cur);
        res = Math.min(res, max);
        return cur;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx++;
    }
}

