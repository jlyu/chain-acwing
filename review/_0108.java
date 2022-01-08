package review;

public class _0108 {

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