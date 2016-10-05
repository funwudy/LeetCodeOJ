package problemset.p1000_to_p1099.p1038_01背包;

import java.util.Scanner;

/**
 * Created by 31798 on 2016/10/3.
 */
public class MainWithExceededMemory {

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
            int[][] best = new int[N + 1][M + 1];
            for (int i = 0; i < M + 1; i++) {
                best[0][i] = 0;
            }
            for (int i = 1; i < N + 1; i++) {
                for (int j = 0; j < M + 1; j++) {
                    if (j >= needs[i]) {
                        best[i][j] = Math.max(best[i - 1][j],
                                best[i - 1][j - needs[i]] + values[i]);
                    } else {
                        best[i][j] = best[i - 1][j];
                    }
                }
            }
            System.out.println(best[N][M]);
        }
    }
}
