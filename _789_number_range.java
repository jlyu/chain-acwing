import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        double n = scanner.nextDouble();

        double eps = 1e-8;
        double l = -10000, r = 10000;

        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= n) { r = mid; }
            else { l = mid; }
        }

        System.out.println(String.format("%.6f", l));


        scanner.close();
    }
}