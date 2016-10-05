package problemset.p1000_to_p1099.p1089_最短路径二_Floyd算法;

import java.util.Scanner;

/**
 * Created by 31798 on 2016/10/5.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] maze = new int[N + 1][N + 1], ans = new int[N + 1][N + 1];
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    maze[i][j] = (i == j ? 0 : Integer.MAX_VALUE);
                }
            }
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int length = sc.nextInt();
                maze[u][v] = maze[v][u] = Math.min(length, maze[v][u]);
            }
//            for (int i = 1; i <= N; i++) {
//                dijkstra(maze, i, N, ans[i]);
//            }
            floyd(maze, N, ans);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void floyd(int[][] maze, int n, int[][] ans) {
        for (int i = 0; i < maze.length; i++) {
            System.arraycopy(maze[i], 0, ans[i], 0, maze[i].length);
        }
        for (int k = 1; k <= n; k++) { // iterate k first!!!
            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= n; i++) {
                    if (i != j && j != k && i != k && ans[i][k] != Integer.MAX_VALUE
                            && ans[k][j] != Integer.MAX_VALUE) {
                        ans[i][j] = ans[j][i] = Math.min(ans[i][j], ans[i][k] + ans[k][j]);
                    }
                }
            }
        }
    }

    private static void dijkstra(int[][] maze, int start, int n, int[] ans) {
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = maze[start][i];
        }
        ans[start] = 0;
        vis[start] = true;
        for (int i = 0; i < n - 1; i++) {
            int minDist = Integer.MAX_VALUE, minIdx = 0;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && ans[j] < minDist) {
                    minDist = ans[j];
                    minIdx = j;
                }
            }
            vis[minIdx] = true;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && maze[minIdx][j] != Integer.MAX_VALUE
                        && maze[minIdx][j] + minDist < ans[j]) {
                    ans[j] = minDist + maze[minIdx][j];
                }
            }
        }
    }
}
