
import java.util.ArrayList;
import java.util.Scanner;

public class Q1_SteppingNumbers {
    // Method to find stepping numbers in the range A to B
    public static ArrayList<Integer> steppingNumbers(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        // Iterate through the range from A to B
        for (int i = A; i <= B; i++) {
            // Check if the current number is a stepping number
            if (isSteppingNumber(i))
                result.add(i); // If yes, add it to the result list
        }
        return result; // Return the list of stepping numbers
    }

    // Method to check if a number is a stepping number
    public static boolean isSteppingNumber(int num) {
        String numString = String.valueOf(num);
        // Iterate through the digits of the number
        for (int i = 0; i < numString.length() - 1; i++) {
            int digit1 = Character.getNumericValue(numString.charAt(i));
            int digit2 = Character.getNumericValue(numString.charAt(i + 1));
            // Check if the difference between adjacent digits is not equal to 1
            if (Math.abs(digit1 - digit2) != 1)
                return false; // If not, return false
        }
        return true; // If all adjacent digits have a difference of 1, return true
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user for the range A and B
        System.out.print("Enter the starting number (A): ");
        int A = scanner.nextInt();

        System.out.print("Enter the ending number (B): ");
        int B = scanner.nextInt();

        scanner.close(); // Close the scanner

        // Call the method to find stepping numbers within the specified range
        ArrayList<Integer> steppingNumbersInRange = steppingNumbers(A, B);
        // Print the result
        System.out.println("Stepping numbers between " + A + " and " + B + ": " + steppingNumbersInRange);
    }
}
