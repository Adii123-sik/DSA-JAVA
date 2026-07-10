package Array.Medium;

import java.util.ArrayList;
import java.util.List;

/*

Problem: Spiral Matrix
LeetCode: 54
Difficulty: Medium
Main Topic: Array / Matrix
Optimized By: Boundary Traversal


Approach:

Hum matrix ki four boundaries maintain karenge:

startRow -> Starting row
endRow   -> Ending row
startCol -> Starting column
endCol   -> Ending column

Har round mein matrix ko four directions mein traverse karenge:

1. Top: Left se Right
2. Right: Top se Bottom
3. Bottom: Right se Left
4. Left: Bottom se Top

Har complete round ke baad boundaries ko andar ki taraf move kar denge.

Bottom traversal se pehle startRow < endRow check karna zaroori hai,
taaki single row hone par elements duplicate add na hon.

Left traversal se pehle startCol < endCol check karna zaroori hai,
taaki single column hone par elements duplicate add na hon.


Time Complexity: O(m * n)
Space Complexity: O(1)

Output result list ko extra space complexity mein include nahi kiya gaya hai.

*/


public class LC54_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int startRow = 0;
        int endRow = matrix.length - 1;

        int startCol = 0;
        int endCol = matrix[0].length - 1;


        while (startRow <= endRow && startCol <= endCol) {

            // Top: Left to Right
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }


            // Right: Top to Bottom
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }


            // Bottom: Right to Left
            if (startRow < endRow) {

                for (int j = endCol - 1; j >= startCol; j--) {
                    result.add(matrix[endRow][j]);
                }
            }


            // Left: Bottom to Top
            if (startCol < endCol) {

                for (int i = endRow - 1; i > startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
            }


            startRow++;
            endRow--;

            startCol++;
            endCol--;
        }

        return result;
    }


    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = spiralOrder(matrix);

        System.out.println("Spiral Order: " + result);
    }
}