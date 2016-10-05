package problemset.p1000_to_p1099.p1038_01背包;

import java.util.Scanner;

/**
 * Created by 31798 on 2016/10/3.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] needs = new int[N + 1];
            int[] values = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                needs[i] = sc.nextInt();
                values[i] = sc.nextInt();
            }
            int[] best = new int[M + 1];
            for (int i = 0; i < M + 1; i++) {
                best[i] = 0;
            }
            for (int i = 1; i < N + 1; i++) {
                for (int j = M; j >= 0; j--) {
                    if (j >= needs[i]) {
                        best[j] = Math.max(best[j], best[j - needs[i]] + values[i]);
                    }
                }
            }
            System.out.println(best[M]);
        }
    }
}
