//Find Maximum profit which can be earned from these transactions
public class MaxProfit {
    public static int maxProfit(int n, int[] prices) {
        if (n <= 1)
            return 0;

        int[][] dp = new int[3][n]; // dp[i][j] represents the maximum profit up to i transactions on day j

        for (int i = 1; i <= 2; i++) {
            int maxDiff = -prices[0]; // maxDiff stores the maximum profit up to the previous day
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff); // max of not doing any transaction on day j and doing transaction on day j
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]); // update maxDiff for next iteration
            }
        }

        return dp[2][n - 1]; // maximum profit after 2 transactions on the last day
    }

    public static void main(String[] args) {
        int n = 6;
        int[] prices = {1, 3, 1, 2, 4, 8};
        System.out.println(maxProfit(n, prices)); // Output: 9

        n = 5;
        int[] prices2 = {5, 4, 3, 2, 1};
        System.out.println(maxProfit(n, prices2)); // Output: 0
    }
}
