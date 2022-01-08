import java.util.*;

public class Main {

    static int n, m, x;
    static int q[];


    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = new int[n];

        for(int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }

        while (m-- != 0) {
            x = scanner.nextInt();

            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (q[mid] >= x) { r = mid; }
                else { l = mid + 1; }
            }
            if (q[l] != x) { System.out.println("-1 -1"); }
            else {
                System.out.printf("%d ", l);

                l = 0; r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (q[mid] <= x) { l = mid; }
                    else { r = mid - 1; }
                }
                System.out.printf("%d\r\n", l);
            }
        }
        scanner.close();
    }
}