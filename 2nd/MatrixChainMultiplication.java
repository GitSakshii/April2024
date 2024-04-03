public class MatrixChainMultiplication {
    public static int minCost(int[] arr) {
        int n = arr.length - 1; // Number of matrices

        // Create a 2D array to store minimum cost
        int[][] dp = new int[n][n];

        // Initialize dp[i][i] to 0 as cost of multiplying a single matrix is 0
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // Calculate minimum cost for chains of increasing length
        for (int chainLen = 2; chainLen <= n; chainLen++) {
            for (int i = 0; i < n - chainLen + 1; i++) {
                int j = i + chainLen - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i] * arr[k + 1] * arr[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // Minimum cost to multiply all matrices is stored at dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 3, 2};
        System.out.println(minCost(arr1)); // Output: 70

        int[] arr2 = {10, 15, 20, 25};
        System.out.println(minCost(arr2)); // Output: 8000
    }
}
