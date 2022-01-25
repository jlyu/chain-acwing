/*
给定一个长度为 n 的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。

输入格式
第一行包含整数 n。

第二行包含 n 个整数（均在 0∼105 范围内），表示整数序列。

输出格式
共一行，包含一个整数，表示最长的不包含重复的数的连续区间的长度。

数据范围
1≤n≤105
输入样例：
5
1 2 2 3 5
输出样例：
3
*/

import java.util.*;

public class _799_longest_norepeat_substring {

    static int N = 1010;

    static int n;
    static int a[], s[];


    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        s = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int res = 0;

        for (int i = 0, j = 0; i < n; i++) {

            s[a[i]]++;
            while(s[a[i]] > 1) {
                s[a[j]]--;
                j++;
            }

           // while (j <= i && check(i, j)) { j++; }
            res = Math.max(res, i - j + 1);
        }



        scanner.close();
    }


}