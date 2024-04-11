
import java.util.*;
//Given an array A with non negative numbers, divide the array into two parts such that the average of both the parts is equal.
//
//Return both parts (If exist). If there is no solution. return an empty list.
//
//        NOTE:
//
//If a solution exists, you should return a list of exactly 2 lists of integers A and B which follow the following condition :
//
//numElements in A <= numElements in B
//If numElements in A = numElements in B, then A is lexicographically smaller than B ( Lexicographical Order )
//If multiple solutions exist, return the solution where length(A) is minimum. If there is still a tie, return the one where A is lexicographically smallest.
//
//The array will contain only non-negative numbers.

//Problem Constraints
//1 <= |A| <= 100
//        0 <= Ai <= 100
//        0 <= Σ(Ai) <= 5000

//Input Format
//First and only argument is an integer array A.

//Output Format
//Return 2D array consisting of two rows where each row denoted a partition.

class PartitionArray
{

    static boolean[][][] dp;
    static Vector<Integer> res = new Vector<>();
    static int[] original;
    static int total_size;

    // Function that returns true if it is possible to
    // use elements with index = ind to construct a set of s
    // ize = curr_size whose sum is curr_sum.
    static boolean possible(int index, int curr_sum,
                            int curr_size)
    {

        // base cases
        if (curr_size == 0)
            return (curr_sum == 0);
        if (index >= total_size)
            return false;

        // Which means curr_sum cant be found for curr_size
        if (dp[index][curr_sum][curr_size] == false)
            return false;

        if (curr_sum >= original[index])
        {
            res.add(original[index]);

            // Checks if taking this element at
            // index i leads to a solution
            if (possible(index + 1, curr_sum - original[index],
                    curr_size - 1))
                return true;

            res.remove(res.size() - 1);
        }

        // Checks if not taking this element at
        // index i leads to a solution
        if (possible(index + 1, curr_sum, curr_size))
            return true;

        // If no solution has been found
        return dp[index][curr_sum][curr_size] = false;
    }

    // Function to find two Partitions having equal average
    static Vector<Vector<Integer>> partition(int[] Vec)
    {

        // Sort the vector
        Arrays.sort(Vec);
        original = Vec;
        res.clear();

        int total_sum = 0;
        total_size = Vec.length;

        for (int i = 0; i < total_size; ++i)
            total_sum += Vec[i];

        // building the memoization table
        dp = new boolean[original.length][total_sum + 1][total_size];

        for (int i = 0; i < original.length; i++)
            for (int j = 0; j < total_sum + 1; j++)
                for (int k = 0; k < total_size; k++)
                    dp[i][j][k] = true;

        for (int i = 1; i < total_size; i++)
        {

            // Sum_of_Set1 has to be an integer
            if ((total_sum * i) % total_size != 0)
                continue;
            int Sum_of_Set1 = (total_sum * i) / total_size;

            // We build our solution vector if its possible
            // to find subsets that match our criteria
            // using a recursive function
            if (possible(0, Sum_of_Set1, i))
            {

                // Find out the elements in Vec, not in
                // res and return the result.
                int ptr1 = 0, ptr2 = 0;
                Vector<Integer> res1 = res;
                Vector<Integer> res2 = new Vector<>();
                while (ptr1 < Vec.length || ptr2 < res.size())
                {
                    if (ptr2 < res.size() &&
                            res.elementAt(ptr2) == Vec[ptr1])
                    {
                        ptr1++;
                        ptr2++;
                        continue;
                    }
                    res2.add(Vec[ptr1]);
                    ptr1++;
                }

                Vector<Vector<Integer>> ans = new Vector<>();
                ans.add(res1);
                ans.add(res2);
                return ans;
            }
        }

        // If we havent found any such subset.
        Vector<Vector<Integer>> ans = new Vector<>();
        return ans;
    }

    // Function to print partitions
    static void Print_Partition(Vector<Vector<Integer>> sol)
    {

        // Print two partitions
        for (int i = 0; i < sol.size(); i++)
        {
            System.out.print("[");
            for (int j = 0; j < sol.elementAt(i).size(); j++)
            {
                System.out.print(sol.elementAt(i).elementAt(j));
                if (j != sol.elementAt(i).size() - 1)
                    System.out.print(" ");
            }
            System.out.print("]");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] Vec = { 1, 7, 15, 29, 11, 9 };
        Vector<Vector<Integer>> sol = partition(Vec);

        // If partition possible
        if (sol.size() > 0)
            Print_Partition(sol);
        else
            System.out.println("-1");
    }
}

