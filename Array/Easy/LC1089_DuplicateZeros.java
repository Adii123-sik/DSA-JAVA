package Array.Easy;

/*
Problem: Duplicate Zeros
LeetCode: 1089
Difficulty: Easy
Main Topic: Array

Easy Approach:
- Ek new array banayenge.
- Original array ke elements new array me copy karenge.
- Jab zero milega, toh zero ko 2 baar add karenge.
- Last me new array ko original array me copy kar denge.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class LC1089_DuplicateZeros {

    public static void duplicateZeros(int[] arr) {

        int[] temp = new int[arr.length];

        int j = 0;

        for (int i = 0; i < arr.length; i++) {

            // Current element temp array me add karo
            temp[j] = arr[i];
            j++;

            // Agar element zero hai toh ek aur zero add karo
            if (arr[i] == 0 && j < arr.length) {
                temp[j] = 0;
                j++;
            }

            // Temp array full ho gaya toh loop stop
            if (j == arr.length) {
                break;
            }
        }

        // Temp array ko original array me copy karo
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};

        duplicateZeros(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}