import java.util.Scanner;

public class MinimumPathSumInTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Number of rows in the triangular array
            int[][] triangle = new int[N][N]; // Initialize the triangular array

            // Input the triangular array
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = scanner.nextInt();
                }
            }

            // Dynamic programming to find minimum path sum
            int[][] dp = new int[N][N];
            dp[0][0] = triangle[0][0];
            for (int i = 1; i < N; i++) {
                dp[i][0] = dp[i - 1][0] + triangle[i][0]; // First element of each row
                dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]; // Last element of each row
                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }

            // Find minimum path sum in the last row
            int minPathSum = dp[N - 1][0];
            for (int j = 1; j < N; j++) {
                minPathSum = Math.min(minPathSum, dp[N - 1][j]);
            }

            // Output the minimum path sum
            System.out.println(minPathSum);
        }
    }
}
