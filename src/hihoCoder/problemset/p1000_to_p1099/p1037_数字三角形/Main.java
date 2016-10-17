package problemset.p1000_to_p1099.p1037_数字三角形;

import java.util.Scanner;

/**
 * Created by 31798 on 2016/10/17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int[][] maze = new int[N][];
            int[] dp = new int[N];
            for (int l = 0; l < N; l++) {
                maze[l] = new int[l + 1];
                for (int i = 0; i <= l; i++) {
                    maze[l][i] = sc.nextInt();
                }
            }
            for (int i = 0; i < N; i++) {
                dp[i] = maze[N - 1][i];
            }
            for (int l = N - 2; l >= 0; l--) {
                for (int i = 0; i <= l; i++) {
                    dp[i] = Math.max(dp[i], dp[i + 1]) + maze[l][i];
                }
            }
            System.out.println(dp[0]);
        }
    }
}
