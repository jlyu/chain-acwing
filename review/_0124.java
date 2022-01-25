package review;

public class _0124 {
    static int kmp(String s, String p) {

        int n = s.length();
        int m = p.length();
        s = " " + s; // 变相字符全部右移1位，等于下标从 1 开始
        p = " " + p; // 变相字符全部右移1位，等于下标从 1 开始
        int[] next = new int[m + 1];

        for (int i = 2, j = 0; i <= m; i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j+1)) j = next[j];
            if (p.charAt(i) == p.charAt(j+1)) j++;
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= n; i++) {
            while (j != 0 && s.charAt(i) != p.charAt(j+1)) j = next[j];
            if (s.charAt(i) == p.charAt(j+1)) j++;
            if (j == m) {
                j = next[j];
                System.out.printf("match found at: %d\n", i - m);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _0124.kmp("ccccccchain3dfadchainfchinachainchaincxx", "chain");
    }
}
