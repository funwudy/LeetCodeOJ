package problemset.p1000_to_p1099.p1081_最短路径一;

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
            int S = sc.nextInt();
            int T = sc.nextInt();
            int[][] maze = new int[N + 1][N + 1];
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    maze[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int length = sc.nextInt();
                maze[u][v] = maze[v][u] = Math.min(maze[u][v], length);
            }
            int[] minDists = new int[N + 1];
            boolean[] vis = new boolean[N + 1];
            for (int i = 1; i < N + 1; i++) {
                minDists[i] = maze[S][i];
            }
            minDists[S] = 0;
            vis[S] = true;
            while (true) {
                int tmpMin = Integer.MAX_VALUE, minIdx = 0;
                for (int i = 1; i < N + 1; i++) {
                    if (!vis[i] && tmpMin > minDists[i]) {
                        tmpMin = minDists[i];
                        minIdx = i;
                    }
                }
                if (minIdx == T) {
                    System.out.println(tmpMin);
                    break;
                }
                vis[minIdx] = true;
                minDists[minIdx] = tmpMin;
                for (int i = 1; i < N + 1; i++) {
                    if(!vis[i] && maze[minIdx][i] != Integer.MAX_VALUE &&
                            minDists[i] > tmpMin + maze[minIdx][i]) {
                        minDists[i] = tmpMin + maze[minIdx][i];
                    }
                }
            }
        }
    }
}
