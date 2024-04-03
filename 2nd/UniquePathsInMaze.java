public class UniquePathsInMaze {
    public static int countPaths(int[][] maze) {
        int MOD = 1000000007;
        int rows = maze.length;
        int cols = maze[0].length;

        int[][] dp = new int[rows][cols];

        // Initialize DP array
        dp[0][0] = 1;

        // Update DP array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] != -1) {
                    if (i > 0 && maze[i - 1][j] != -1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    }
                    if (j > 0 && maze[i][j - 1] != -1) {
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] maze1 = {
                {0, 0},
                {0, 0}
        };
        System.out.println(countPaths(maze1)); // Output: 2

        int[][] maze2 = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        System.out.println(countPaths(maze2)); // Output: 2
    }
}
