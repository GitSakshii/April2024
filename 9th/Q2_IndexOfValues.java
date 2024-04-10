
import java.util.*;

public class Q2_IndexOfValues {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        // Map to store sums and their corresponding pairs of indices
        Map<Integer, ArrayList<Integer>> sumMap = new HashMap<>();

        // Iterate through all possible pairs of indices
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A.get(i) + A.get(j);
                // If the sum already exists in the map
                if (sumMap.containsKey(sum)) {
                    ArrayList<Integer> existingPair = sumMap.get(sum);
                    // Check if the conditions for lexicographical order are satisfied
                    if (existingPair.get(0) < i || (existingPair.get(0) == i && existingPair.get(1) < j)) {
                        result.addAll(existingPair);
                        result.add(i);
                        result.add(j);
                        return result;
                    }
                } else {
                    // Store the sum and its corresponding pair of indices
                    ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(i, j));
                    sumMap.put(sum, pair);
                }
            }
        }
        return result; // If no solution is found, return an empty list
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        ArrayList<Integer> A = new ArrayList<>();
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        scanner.close();

        ArrayList<Integer> indices = solve(A);
        System.out.println("Indices of values P, Q, R, and S: " + indices);
    }

}
