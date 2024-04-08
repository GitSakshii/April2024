//There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
//        There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
//
//        An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
//
//        Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
//
//        In one jump a person can move to the adjacent seat (if available).
//
//        NOTE:  1. Return your answer modulo 107 + 3.
//
//
//
//        Problem Constraints
//        1 <= N <= 1000000
//
//        A[i] = 'x' or '.'
//
//
//
//        Input Format
//        The first and only argument is a string A of size N.
//
//
//
//        Output Format
//        Return an integer denoting the minimum number of jumps required.
//


import java.util.*;
class MinimumJumps{

    static int MOD = (int)1e9 + 7;

    // Function to find the minimum
// jumps required to make the
// whole group sit adjacently
    static int minJumps(String seats)
    {
// Store the indexes
        Vector<Integer> position =
                new Vector<>();

// Stores the count of
// occupants
        int count = 0;

// Length of the String
        int len = seats.length();

// Traverse the seats
        for (int i = 0; i < len; i++)
        {
            // If current place is occupied
            if (seats.charAt(i) == 'x')
            {
                // Push the current position
                // in the vector
                position.add(i - count);
                count++;
            }
        }

// Base Case:
        if (count == len ||
                count == 0)
            return 0;

// The index of the median
// element
        int med_index = (count - 1) / 2;

// The value of the median
// element
        int med_val = position.get(med_index);

        int ans = 0;

// Traverse the position[]
        for (int i = 0;
             i < position.size(); i++)
        {
            // Update the ans
            ans = (ans % MOD +
                    Math.abs(position.get(i) -
                            med_val) % MOD) % MOD;
        }

// Return the final count
        return ans % MOD;
    }

    // Driver Code
    public static void main(String[] args)
    {

       Scanner scanner=new Scanner(System.in);
       String S=scanner.nextLine();

// Function Call
        System.out.print(minJumps(S));
    }
}

