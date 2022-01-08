/*
实现一个单链表，链表初始为空，支持三种操作：

1向链表头插入一个数；
2删除第 k 个插入的数后面的数；
3在第 k 个插入的数后插入一个数。


现在要对该链表进行 M 次操作，进行完所有操作后，从头到尾输出整个链表。

注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。

例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，
这 n 个数依次为：第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。

输入格式
第一行包含整数 M，表示操作次数。

接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：

H x，表示向链表头插入一个数 x。
D k，表示删除第 k 个插入的数后面的数（当 k 为 0 时，表示删除头结点）。
I k x，表示在第 k 个插入的数后面插入一个数 x（此操作中 k 均大于 0）。

输出格式
共一行，将整个链表从头到尾输出。

数据范围
1≤M≤100000
所有操作保证合法。

输入样例：
10
H 9
I 1 1
D 1
D 0
H 6
I 3 6
I 4 5
I 4 5
I 3 4
D 6
输出样例：
6 4 6 5
*/

import java.util.*;

public class Main {

    static int N = 100010;

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        int M = scanner.nextInt();

        MyLinkedList list = new MyLinkedList(N);

        for (int i = 0; i < M; i++) {
            String op = scanner.next();

            if (op.equals("H")) {
                int v = scanner.nextInt();
                list.addHead(v);


            } else if  (op.equals("D")) {
                int k = scanner.nextInt();
                if (k == 0)
                    list.deleteHead();
                else
                    list.deleteNode(k - 1);

            } else if (op.equals("I")) {
                int k = scanner.nextInt();
                int v = scanner.nextInt();
                list.insertNode(k - 1, v);
            }
        }

        list.printList();
        scanner.close();
    }
}

class MyLinkedList {
    int head;
    int[] e;
    int[] ne;
    int idx;

    MyLinkedList(int N) {
        this.e = new int[N];
        this.ne = new int[N];
        this.idx = 0;
        this.head = -1;
    }

    public void addHead(int v) {
        e[idx] = v;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    public void insertNode(int k, int v) {
        e[idx] = v;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx ++ ;
    }

    public void deleteNode(int k) {
        ne[k] = ne[ne[k]];
    }

    public void deleteHead() {
        head = ne[head];
    }

    public void printList() {
        int i = head;
        while (i != -1) {
            System.out.print(e[i] + " ");
            i = ne[i];
        }
    }

}