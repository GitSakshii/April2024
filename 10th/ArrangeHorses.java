import java.util.Scanner;
//You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to accommodate the horses into the stables in such a way that the following conditions are satisfied:
//You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put horse 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
//No stable should be empty and no horse should be left unaccommodated.
//Take the product (number of white horses * number of black horses) for each stable and take the sum of all these products. This value should be the minimum among all possible accommodation arrangements
//Example:
//
//
//Input: {WWWB} , K = 2
//Output: 0
public class ArrangeHorses{
    public static int minProduct(String arr, int K) {
        int n = arr.length();
        int whiteCount = 0;
        int blackCount = 0;

        for (char c : arr.toCharArray()) {
            if (c == 'W') whiteCount++;
            else blackCount++;
        }

        if (whiteCount + blackCount < K || K == 0) return -1;

        int[][] dp = new int[K][n];
        int[] prefixWhite = new int[n + 1];
        int[] prefixBlack = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixWhite[i] = prefixWhite[i - 1] + (arr.charAt(i - 1) == 'W' ? 1 : 0);
            prefixBlack[i] = prefixBlack[i - 1] + (arr.charAt(i - 1) == 'B' ? 1 : 0);
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = prefixWhite[i + 1] * prefixBlack[i + 1];
        }

        for (int i = 1; i < K; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i - 1; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + prefixWhite[j + 1] * (prefixBlack[j + 1] - prefixBlack[k + 1]));
                }
            }
        }

        int minProduct = Integer.MAX_VALUE;
        for (int i = K - 1; i < n; i++) {
            minProduct = Math.min(minProduct, dp[K - 1][i]);
        }

        return minProduct;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String arr=scanner.nextLine();
        int K = 2;
        System.out.println(minProduct(arr, K));  // Output: 0
    }
}
