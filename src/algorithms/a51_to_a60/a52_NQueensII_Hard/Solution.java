package algorithms.a51_to_a60.a52_NQueensII_Hard;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	int N;
	int cnt = 0;
	
    public int totalNQueens(int n) {
        N = n;
        int[][] vis = new int[N][N];
        int[] positions = new int[N];
        place(0, vis, positions);
        return cnt;
    }
    
    public void place(int row, int[][] vis, int[] positions) {
    	if (row >= N) {
    		cnt++;
    		return;
    	}
    	for (int i = 0; i < N; i++) {
    		if (vis[row][i] == 0) {
    			vis[row][i] = 1;
    			positions[row] = i;
    			List<Point> points = new ArrayList<>();
    			for (int j = 0; j < N; j++) {
    				for (int k = 0; k < N; k++) {
    					if (j == row || k == i || j + k == row + i || j - k == row - i) {
    						if (vis[j][k] == 0) {
    							vis[j][k] = 2;
    							points.add(new Point(j, k));
    						}
    					}
    				}
    			}
    			place(row + 1, vis, positions);
    			for (Point point : points) {
    				vis[point.x][point.y] = 0;
    			}
    			vis[row][i] = 0;
    		}
    	}
    }
    
    class Point {
    	int x;
    	int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
    }
}