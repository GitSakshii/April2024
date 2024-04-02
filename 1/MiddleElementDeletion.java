import java.util.Scanner;

public class MiddleElementDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int N = scanner.nextInt(); // Number of elements in the stack
            int[] stack = new int[N + 1]; // Stack array

            // Input the elements into the stack
            for (int i = 0; i <= N; i++) {
                stack[i] = scanner.nextInt();
            }

            // Remove the middle element
            if ((N + 1) % 2 == 1) {
                // Odd number of elements
                int middleIndex = (N + 1) / 2;
                for (int i = 0; i <= N; i++) {
                    if (i != middleIndex) {
                        System.out.print(stack[i] + " ");
                    }
                }
            } else {
                // Even number of elements
                int middleIndex = (N + 1) / 2 - 1;
                for (int i = 0; i <= N; i++) {
                    if (i != middleIndex) {
                        System.out.print(stack[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

