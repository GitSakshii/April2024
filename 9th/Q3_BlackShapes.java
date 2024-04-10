
import java.util.Stack;
import java.util.Scanner;

public class Q3_BlackShapes {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int blackShapes(char[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;

        int n = A.length;
        int m = A[0].length;
        int count = 0;

        boolean[][] visited = new boolean[n][m];

        // Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Stack<Pair> stack = new Stack<>();

        // Iterate through each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 'X' && !visited[i][j]) {
                    stack.push(new Pair(i, j));
                    count++;

                    // Perform DFS
                    while (!stack.isEmpty()) {
                        Pair curr = stack.pop();
                        int x = curr.x;
                        int y = curr.y;
                        visited[x][y] = true;

                        // Check neighboring cells
                        for (int k = 0; k < 4; k++) {
                            int newX = x + dx[k];
                            int newY = y + dy[k];
                            if (newX >= 0 && newX < n && newY >= 0 && newY < m &&
                                    A[newX][newY] == 'X' && !visited[newX][newY]) {
                                stack.push(new Pair(newX, newY));
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int m = scanner.nextInt();

        char[][] A = new char[n][m];

        System.out.println("Enter the matrix row by row (use 'X' for black and 'O' for white):");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.next().toCharArray();
        }

        System.out.println("Number of black shapes: " + blackShapes(A));
    }
}
