package algorithms.a51_to_a60.a51_NQueens_Hard;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int N;
	List<List<String>> ans = new ArrayList<>();
	
    public List<List<String>> solveNQueens(int n) {
    	N = n;
        int[] positions = new int[n];
        int[][] vis = new int[n][n];
        place(0, vis, positions);
        return ans;
    }
    
    public List<String> drawGraph(int[] positions) {
    	char[][] graph = new char[N][N];
    	List<String> res = new ArrayList<>();
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (positions[i] == j) {
    				graph[i][j] = 'Q';
    			} else {
					graph[i][j] = '.';
				}
    		}
    		res.add(new String(graph[i]));
    	}
    	return res;
    }
    
    public void place(int row, int[][] vis, int[] positions) {
    	if (row >= N) {
    		ans.add(drawGraph(positions));
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