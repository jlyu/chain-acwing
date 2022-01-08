/*
给定一个长度为 n 的数列，请你求出数列中每个数的二进制表示中 1 的个数。

输入格式
第一行包含整数 n。

第二行包含 n 个整数，表示整个数列。

输出格式
共一行，包含 n 个整数，其中的第 i 个数表示数列中的第 i 个数的二进制表示中 1 的个数。

数据范围
1≤n≤100000,
0≤数列中元素的值≤109

输入样例：
5
1 2 3 4 5
输出样例：
1 1 2 1 2
*/

import java.util.*;

public class Main {

    static int N = 1010;

    static int n;
    static int a[];


    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];


        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }



        for (int i = 0; i < n; i++) {
            int sum = 0;
            while(a[i] != 0) {
                a[i] -= lowBit(a[i]);
                sum++;
            }
            a[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }


        scanner.close();
    }

    private static int lowBit(int x) {
        return x & -x;
    }
}