package April4Assignment;
//Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
//
//        Assume that there will only be one solution.
//
//
//
//        Problem Constraints
//        -3 * 108 <= B <= 3 * 108
//        1 <= N <= 104
//        -108 <= A[i] <= 108
//
//
//        Input Format
//        First argument is an integer array A of size N.
//
//        Second argument is an integer B denoting the sum you need to get close to.
//
//
//
//        Output Format
//        Return a single integer denoting the sum of three integers which is closest to B.

import java.util.Arrays;
import java.util.Scanner;

public class ClosestSum {
    // Function to find the sum of three integers in the array closest to the given number B
    public static int threeSumClosest(int[] A, int B) {
        int n = A.length;
        if (n < 3)
            return -1; // Invalid input

        // Sorting the array for easier traversal
        Arrays.sort(A);
        int closestSum = A[0] + A[1] + A[2]; // Initialize the closest sum

        // Loop through the array
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Use two-pointer technique to find the sum closest to B
            while (left < right) {
                int sum = A[i] + A[left] + A[right];

                // Update closestSum if the current sum is closer to B
                if (Math.abs(sum - B) < Math.abs(closestSum - B))
                    closestSum = sum;

                // Move pointers based on the current sum compared to B
                if (sum < B)
                    left++;
                else
                    right--;
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        int[] A = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println("Enter the target sum:");
        int B = scanner.nextInt();

        // Find the closest sum of three integers to B
        int closestSum = threeSumClosest(A, B);
        System.out.println("Output: " + closestSum);

        scanner.close();
    }
}