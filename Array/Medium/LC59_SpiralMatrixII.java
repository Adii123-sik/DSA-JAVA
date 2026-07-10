package Array.Medium;

/*

Problem: Spiral Matrix II
LeetCode: 59
Difficulty: Medium
Main Topic: Array / Matrix
Optimized By: Boundary Traversal


Approach:

Humein n x n matrix create karni hai aur usmein
1 se n * n tak numbers spiral order mein fill karne hain.

Hum matrix ki four boundaries maintain karenge:

startRow -> Starting row
endRow   -> Ending row
startCol -> Starting column
endCol   -> Ending column

Har round mein matrix ko four directions mein fill karenge:

1. Top: Left se Right
2. Right: Top se Bottom
3. Bottom: Right se Left
4. Left: Bottom se Top

Har element fill karne ke baad number ko increment karenge.

Har complete round ke baad boundaries ko andar ki taraf move kar denge.

Bottom traversal se pehle startRow < endRow check karenge,
taaki same row dobara fill na ho.

Left traversal se pehle startCol < endCol check karenge,
taaki same column dobara fill na ho.


Time Complexity: O(n * n)
Space Complexity: O(1)

Returned matrix ko extra space complexity mein include nahi kiya gaya hai.

*/


public class LC59_SpiralMatrixII {

    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int startRow = 0;
        int endRow = n - 1;

        int startCol = 0;
        int endCol = n - 1;

        int number = 1;


        while (startRow <= endRow && startCol <= endCol) {

            // Top: Left to Right
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j] = number;
                number++;
            }


            // Right: Top to Bottom
            for (int i = startRow + 1; i <= endRow; i++) {
                matrix[i][endCol] = number;
                number++;
            }


            // Bottom: Right to Left
            if (startRow < endRow) {

                for (int j = endCol - 1; j >= startCol; j--) {
                    matrix[endRow][j] = number;
                    number++;
                }
            }


            // Left: Bottom to Top
            if (startCol < endCol) {

                for (int i = endRow - 1; i > startRow; i--) {
                    matrix[i][startCol] = number;
                    number++;
                }
            }


            startRow++;
            endRow--;

            startCol++;
            endCol--;
        }

        return matrix;
    }


    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {

        int n = 3;

        int[][] result = generateMatrix(n);

        System.out.println("Spiral Matrix II:");

        printMatrix(result);
    }
}