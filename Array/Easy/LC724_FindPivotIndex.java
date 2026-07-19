package Array.Easy;

/*
Problem: Find Pivot Index
LeetCode: 724
Difficulty: Easy
Main Topic: Array / Prefix Sum
Optimized Pattern: Total Sum + Running Left Sum

Approach:
Hume integers ka ek array diya gaya hai.

Hume array ka pivot index find karna hai.

Pivot index woh index hota hai jiske left side
ke sabhi elements ka sum aur right side ke
sabhi elements ka sum equal hota hai.

Important:

Pivot index par present element ko left sum
ya right sum mein include nahi karna hai.

Example:

Input:

nums = {1, 7, 3, 6, 5, 6}

Index 3 par element 6 hai.

Left side ke elements:

1, 7, 3

Left Sum:

1 + 7 + 3 = 11

Right side ke elements:

5, 6

Right Sum:

5 + 6 = 11

Left Sum aur Right Sum equal hain.

Isliye pivot index:

3

Brute-force approach mein hum har index ke liye
left sum aur right sum separately calculate kar
sakte hain.

Lekin us approach ki Time Complexity O(n²) hogi.

Optimized approach ke liye sabse pehle array ke
sabhi elements ka total sum calculate karenge.

totalSum = array ke sabhi elements ka sum

Uske baad ek leftSum variable maintain karenge.

Initially:

leftSum = 0

Har index par right side ka sum calculate karenge:

rightSum = totalSum - leftSum - nums[i]

Yahan nums[i] current pivot element hai.

Current element ko total sum se remove karna zaroori
hai kyunki pivot element left ya right sum ka part
nahi hota.

Agar:

leftSum == rightSum

Toh current index pivot index hoga.

Agar sums equal nahi hain, toh current element ko
leftSum mein add karke next index par jayenge.

leftSum = leftSum + nums[i]

Array ko left se right traverse karne ke kaaran
agar multiple pivot indexes available hain, toh
sabse leftmost pivot index return hoga.

Agar koi pivot index nahi milta, toh -1 return karenge.

Example 1:

Input:
nums = {1, 7, 3, 6, 5, 6}

Output:
3

Explanation:

Index 3 par:

Left Sum = 1 + 7 + 3 = 11
Right Sum = 5 + 6 = 11

Example 2:

Input:
nums = {1, 2, 3}

Output:
-1

Explanation:

Kisi bhi index par left sum aur right sum
equal nahi hain.

Example 3:

Input:
nums = {2, 1, -1}

Output:
0

Explanation:

Index 0 ke left side koi element nahi hai.

Left Sum = 0

Right Sum:

1 + (-1) = 0

Isliye pivot index 0 hai.

Variables:

totalSum:
Array ke sabhi elements ka total sum store karta hai.

leftSum:
Current index ke left side wale elements ka sum
store karta hai.

rightSum:
Current index ke right side wale elements ka sum
store karta hai.

i:
Array ke current index ko represent karta hai.

Time Complexity: O(n)

Pehli loop total sum calculate karti hai.

Dusri loop pivot index find karti hai.

O(n) + O(n) = O(n)

Space Complexity: O(1)

Koi extra array ya data structure use nahi kiya gaya.
*/

public class LC724_FindPivotIndex {

    public static int pivotIndex(int[] nums) {

        /*
         Array ke sabhi elements ka total sum
         store karne ke liye variable.
        */
        int totalSum = 0;

        /*
         Array ke sabhi elements ko add karke
         total sum calculate karo.
        */
        for (int num : nums) {
            totalSum += num;
        }

        /*
         First index ke left side koi element
         nahi hota, isliye initial left sum 0 hai.
        */
        int leftSum = 0;

        /*
         Array ke har index ko possible pivot
         index maan kar check karo.
        */
        for (int i = 0; i < nums.length; i++) {

            /*
             Total sum mein se left sum aur current
             element remove karke right sum nikalo.
            */
            int rightSum =
                    totalSum - leftSum - nums[i];

            /*
             Agar left sum aur right sum equal hain,
             toh current index pivot index hai.
            */
            if (leftSum == rightSum) {
                return i;
            }

            /*
             Next index par jane se pehle current
             element ko left sum mein add karo.
            */
            leftSum += nums[i];
        }

        /*
         Koi pivot index available nahi hai,
         isliye -1 return karo.
        */
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {
                1,
                7,
                3,
                6,
                5,
                6
        };

        int result = pivotIndex(nums);

        System.out.print("Array: ");

        for (int number : nums) {
            System.out.print(number + " ");
        }

        System.out.println();
        System.out.println(
                "Pivot Index: " + result
        );
    }
}