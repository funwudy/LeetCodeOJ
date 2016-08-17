package algorithms.a51_NQueens;

import java.util.List;

public class Solution {
	int N;
	
    public List<List<String>> solveNQueens(int n) {
    	N = n;
        int[] positions = new int[n];
        int[][] vis = new int[n][n];
        
    }
    
    public void place(int row, int[][] vis, int[] positions) {
    	for (int i = 0; i < N; i++) {
    		if (vis[row][i] == 0) {
    			vis[row][i] = 1;
    			positions[row] = i;
    			for (int j = 0; j < N; j++) {
    				for (int k = 0; k < N; k++) {
    					if (j == row || k == i || j + k == row + i || j - k == row - i) {
    						if (vis[j][k] == 0) {
    							
    						}
    					}
    				}
    			}
    		}
    	}
    }
    
}