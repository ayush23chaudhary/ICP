package Day_7;

import java.util.Arrays;

public class UniquePaths {
	class Solution {
	    public int uniquePaths(int m, int n) {
	        int[][] dp = new int[m][n];

	        for (int[] arr : dp) {
	            Arrays.fill(arr, -1);
	        }

	        return recursion(0, 0, m, n, dp);
	    }

	    public int recursion(int i, int j, int m, int n, int[][] dp) {
	        if (i == m - 1 && j == n - 1) {
	            return 1;
	        }
	        if (i >= m || j >= n) {
	            return 0;
	        }
	        if (dp[i][j] != -1)
	            return dp[i][j];

	        int down = recursion(i, j + 1, m, n, dp);
	        int right = recursion(i + 1, j, m, n, dp);

	        return dp[i][j] = down + right;
	    }
	}
}
