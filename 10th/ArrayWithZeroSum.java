import java.util.Scanner;
//Given an array A of N integers.
//
//Find the largest continuous sequence in a array which sums to zero.
//Problem Constraints
//1 <= N <= 106
//
//        -107 <= A[i] <= 107
//Input Format
//Single argument which is an integer array A.
//Output Format
//Return an array denoting the longest continuous sequence with total sum of zero.
//
//     NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

class ArrayWithZeroSum {

    // Returns length of the largest subarray
    // with 0 sum
    static int maxLen(int arr[], int N)
    {
        int max_len = 0;

        // Pick a starting point
        for (int i = 0; i < N; i++) {

            // Initialize curr_sum for every
            // starting point
            int curr_sum = 0;

            // try all subarrays starting with 'i'
            for (int j = i; j < N; j++) {
                curr_sum += arr[j];

                // If curr_sum becomes 0, then update
                // max_len
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }

    // Driver's code
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        //Taking input from the user
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        // Function call
        System.out.println("Length of the longest 0 sum "
                + "subarray is " + maxLen(arr, n));
    }
}
