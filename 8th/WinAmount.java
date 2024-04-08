//There are A coins (Assume A is even) in a line.
//
//        Two players take turns to take a coin from one of the ends of the line until there are no more coins left.
//
//        The player with the larger amount of money wins, Assume that you go first.
//
//        Return the maximum amount of money you can win.
//
//        NOTE:
//
//        You can assume that opponent is clever and plays optimally.
//
//
//        Problem Constraints
//        1 <= length(A) <= 500
//
//        1 <= A[i] <= 105
//
//
//
//        Input Format
//        The first and the only argument of input contains an integer array A.
//
//
//
//        Output Format
//        Return an integer representing the maximum amount of money you can win.

import java.util.*;

class WinAmount {
    static ArrayList<Integer> arr = new ArrayList<>();
    static HashMap<ArrayList<Integer>, Integer> memo
            = new HashMap<>();
    static int n = 0;

    // recursive top down memoized solution
    static int solve(int i, int j)
    {
        if ((i > j) || (i >= n) || (j < 0))
            return 0;

        ArrayList<Integer> k = new ArrayList<Integer>();
        k.add(i);
        k.add(j);
        if (memo.containsKey(k))
            return memo.get(k);

        // if the user chooses ith coin, the opponent can
        // choose from i+1th or jth coin. if he chooses
        // i+1th coin, user is left with [i+2,j] range. if
        // opp chooses jth coin, then user is left with
        // [i+1,j-1] range to choose from. Also opponent
        // tries to choose in such a way that the user has
        // minimum value left.
        int option1 = arr.get(i)
                + Math.min(solve(i + 2, j),
                solve(i + 1, j - 1));

        // if user chooses jth coin, opponent can choose ith
        // coin or j-1th coin. if opp chooses ith coin,user
        // can choose in range [i+1,j-1]. if opp chooses
        // j-1th coin, user can choose in range [i,j-2].
        int option2 = arr.get(j)
                + Math.min(solve(i + 1, j - 1),
                solve(i, j - 2));

        // since the user wants to get maximum money
        memo.put(k, Math.max(option1, option2));
        return memo.get(k);
    }

    static int optimalStrategyOfGame()
    {

        memo.clear();
        return solve(0, n - 1);
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        //Taking input from the user
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(optimalStrategyOfGame());

       }
}


