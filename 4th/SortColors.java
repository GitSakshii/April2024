package April4Assignment;
//Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//        We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.
//
//        Note: Using the library sort function is not allowed.
//
//        Problem Constraints
//        1 <= N <= 1000000
//        0 <= A[i] <= 2

//        Input Format
//        First and only argument of input contains an integer array A.

//        Output Format
//        Return an integer array in asked order

import java.util.Scanner;

public class SortColors {
    public static int[] sortColors(int[] A) {
        int n = A.length;
        if (n <= 1)
            return A;

        int low = 0; // Index to track the next position for 0
        int high = n - 1; // Index to track the next position for 2
        int mid = 0; // Current index

        // Traverse the array
        while (mid <= high) {
            if (A[mid] == 0) {
                // Swap A[mid] with A[low] and increment both pointers
                int temp = A[low];
                A[low] = A[mid];
                A[mid] = temp;
                low++;
                mid++;
            } else if (A[mid] == 1) {
                // No action needed for 1, just move to the next element
                mid++;
            } else {
                // Swap A[mid] with A[high] and decrement high pointer
                int temp = A[mid];
                A[mid] = A[high];
                A[high] = temp;
                high--;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        int[] A = new int[n];
        System.out.println("Enter the elements of the array (0, 1, or 2 only):");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int[] sortedArray = sortColors(A);
        System.out.println("Output:");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}