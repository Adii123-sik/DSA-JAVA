package Array.Medium;

/*
Problem: Search a 2D Matrix II
LeetCode: 240
Difficulty: Medium
Main Topic: Array / Matrix
Optimized Pattern: Staircase Search

Approach:
Hume ek aise matrix me key search karni hai jisme:

- Har row left se right sorted hai
- Har column top se bottom sorted hai

Hum matrix ke top-right corner se search start karenge.

Logic:
- Agar current element key ke equal hai, return true
- Agar current element key se chhota hai, next row me move karenge
- Agar current element key se bada hai, previous column me move karenge

Why Top-Right Corner?
Top-right position se:
- Left side ke elements chhote hote hain
- Down side ke elements bade hote hain

Isliye har comparison ke baad ek row ya column eliminate ho jata hai.

Time Complexity: O(rows + columns)
Space Complexity: O(1)
*/

public class LC240_SearchInSortedMatrix {

    public static boolean searchInSortedMatrix(int[][] matrix, int key) {

        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {

            if (matrix[row][column] == key) {

                System.out.println(
                        "The key is present in the matrix at index "
                                + "(" + row + ", " + column + ")"
                );

                return true;
            }

            if (matrix[row][column] < key) {

                // Current element key se chhota hai,
                // isliye neeche wali row me move karenge
                row++;

            } else {

                // Current element key se bada hai,
                // isliye left column me move karenge
                column--;
            }
        }

        System.out.println("The key is not present in the matrix");

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };

        int key = 33;

        boolean result = searchInSortedMatrix(matrix, key);

        System.out.println("Key Found: " + result);
    }
}