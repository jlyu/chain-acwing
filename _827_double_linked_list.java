/*
实现一个双链表，双链表初始为空，支持 5 种操作：

1 在最左侧插入一个数；
2 在最右侧插入一个数；
3 将第 k 个插入的数删除；
4 在第 k 个插入的数左侧插入一个数；
5 在第 k 个插入的数右侧插入一个数


现在要对该链表进行 M 次操作，进行完所有操作后，从左到右输出整个链表。

注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。
例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，
这 n 个数依次为：第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。

输入格式
第一行包含整数 M，表示操作次数。

接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：

L x，表示在链表的最左端插入数 x。
R x，表示在链表的最右端插入数 x。
D k，表示将第 k 个插入的数删除。
IL k x，表示在第 k 个插入的数左侧插入一个数。
IR k x，表示在第 k 个插入的数右侧插入一个数。
输出格式
共一行，将整个链表从左到右输出。

数据范围
1≤M≤100000
所有操作保证合法。

输入样例：
10
R 7
D 1
L 3
IL 2 10
D 3
IL 2 7
L 8
R 9
IL 4 7
IR 2 2
输出样例：
8 7 7 3 2 9
*/

import java.util.*;

public class Main {

    static int N = 100010;

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        int M = scanner.nextInt();

        DoubleLinkedList dList = new DoubleLinkedList(N);

        for (int i = 0; i < M; i++) {
            String op = scanner.next(); // R D L IL IR

            if (op.equals("L")) {
                int x = scanner.nextInt();
                dList.insertFromKRight(0, x);


            } else if (op.equals("R")) {
                int x = scanner.nextInt();
                dList.insertFromKLeft(0, x);


            } else if (op.equals("IL")) {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                dList.insertFromKLeft(k + 1, x);


            }else if (op.equals("IR")) {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                dList.insertFromKRight(k + 1, x);


            }else if  (op.equals("D")) {
                int k = scanner.nextInt();
                dList.deleteNode(k + 1);

            }
        }

        dList.printList();
        scanner.close();
    }
}

class DoubleLinkedList {
    public int[] e;
    public int[] l;
    public int[] r;
    public int idx;

    DoubleLinkedList(int N) {
        this.e = new int[N];
        this.l = new int[N];
        this.r = new int[N];
        this.idx = 2;
        r[0] = 1;
        l[1] = 0;
    }

    // 在K 的左边边插入节点x => k=l[k]
    public void insertFromKLeft (int k, int x) {
        if (k == 0) {
            insertFromKRight(l[1], x);
            return;
        }
        insertFromKRight(l[k], x);
    }
    // 在K 的右边插入节点x
    public void insertFromKRight(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx++;
    }

    public void deleteNode(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    public void printList() {
        // int i = r[0];
        // while (i != -1) {
        //     System.out.print(e[i] + " ");
        //     i = r[i];
        // }
        for (int i = r[0]; i != 1; i = r[i]){
            System.out.print(e[i] + " ");
        }
    }

}