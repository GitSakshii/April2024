package April4Assignment;
//1. Given A, B, C, find whether C is formed by the interleaving of A and B.
//
//        Input Format:*
//
//        The first argument of input contains a string, A.
//        The second argument of input contains a string, B.
//        The third argument of input contains a string, C.
//        Output Format:
//
//        Return an integer, 0 or 1:
//        => 0 : False
//        => 1 : True
//        Constraints:
//
//        1 <= length(A), length(B), length(C) <= 150
//        Examples:
//
//        Input 1:
//        A = "aabcc"
//        B = "dbbca"
//        C = "aadbbcbcac"
//
//        Output 1:
//        1

import java.util.Scanner;

public class InterleavingString {

    // Function to check whether string C can be formed by interleaving strings A and B
    public static boolean isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();

        // If the length of A + B is not equal to the length of C, return false
        if (m + n != C.length())
            return false;

        // Create a dynamic programming table to store the results of subproblems
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Fill the DP table using bottom-up approach
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Base case: if both A and B are empty strings, C is considered interleaved
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                    // If A is empty, check if B matches C
                else if (i == 0)
                    dp[i][j] = (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
                    // If B is empty, check if A matches C
                else if (j == 0)
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1));
                    // If both A and B are non-empty, check if A or B matches C
                else
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
            }
        }

        // The result is stored in the bottom-right cell of the DP table
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string A:");
        String A = scanner.nextLine();
        System.out.println("Enter string B:");
        String B = scanner.nextLine();
        System.out.println("Enter string C:");
        String C = scanner.nextLine();

        // Check whether C can be formed by interleaving A and B
        if (isInterleave(A, B, C))
            System.out.println("Output: 1"); // C can be formed by interleaving A and B
        else
            System.out.println("Output: 0"); // C cannot be formed by interleaving A and B

        scanner.close();
    }
}
