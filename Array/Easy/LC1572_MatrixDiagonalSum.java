package Array.Easy;

/*
Problem: Matrix Diagonal Sum
LeetCode: 1572
Difficulty: Easy
Main Topic: Array / Matrix
Optimized Pattern: Single Traversal

Approach:
Hume square matrix ki primary diagonal aur secondary diagonal
ke elements ka total sum calculate karna hai.

Primary Diagonal:
- Primary diagonal ke elements matrix[i][i] par milte hain.

Secondary Diagonal:
- Secondary diagonal ke elements matrix[i][n - 1 - i] par milte hain.

Important:
Agar matrix ka size odd hai, toh center element primary aur
secondary dono diagonals me common hota hai.

Isliye center element ko double count hone se bachane ke liye
use ek baar subtract karenge.

Example:
Matrix:
1 2 3
4 5 6
7 8 9

Primary Diagonal:
1 + 5 + 9 = 15

Secondary Diagonal:
3 + 5 + 7 = 15

Center element 5 double count hua hai.

Final Sum:
15 + 15 - 5 = 25

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC1572_MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {

        int n = mat.length;
        int diagonalSum = 0;

        for (int i = 0; i < n; i++) {

            // Primary diagonal element
            diagonalSum = diagonalSum + mat[i][i];

            // Secondary diagonal element
            diagonalSum = diagonalSum + mat[i][n - 1 - i];
        }

        // Odd-sized matrix me center element double count hota hai
        if (n % 2 != 0) {

            int middle = n / 2;

            diagonalSum = diagonalSum - mat[middle][middle];
        }

        return diagonalSum;
    }

    public static void main(String[] args) {

        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int result = diagonalSum(mat);

        System.out.println("Matrix Diagonal Sum: " + result);
    }
}