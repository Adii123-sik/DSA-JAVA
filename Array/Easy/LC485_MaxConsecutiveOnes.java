package Array.Easy;

/*
Problem: Max Consecutive Ones
LeetCode: 485
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Linear Traversal + Running Count

Approach:
Hume ek binary array nums diya gaya hai.

Binary array me sirf do values hoti hain:

0 aur 1

Hume array me continuously aane wale maximum
1s ki count find karke return karni hai.

Example:

nums = [1, 1, 0, 1, 1, 1]

Array me pehle:

1, 1

continuously aaye hain.

Inki count 2 hai.

Uske baad zero aata hai, isliye consecutive
ones ki sequence break ho jaati hai.

Zero ke baad:

1, 1, 1

continuously aaye hain.

Inki count 3 hai.

Maximum consecutive ones:

3

Output:

3

Logic:

Hum do variables use karenge:

1. currentCount

Ye current consecutive ones ki count store karega.

Agar current element 1 hai, toh:

currentCount++

Agar current element 0 hai, toh consecutive ones
ki sequence break ho jayegi.

Isliye:

currentCount = 0

2. maxCount

Ye ab tak mile maximum consecutive ones ki count
store karega.

Har element process karne ke baad hum compare
karenge:

currentCount > maxCount

Agar currentCount bada hai, toh maxCount ko update
kar denge.

Example 1:

Input:

nums = [1, 1, 0, 1, 1, 1]

Calculation:

Element = 1
currentCount = 1
maxCount = 1

Element = 1
currentCount = 2
maxCount = 2

Element = 0
currentCount = 0
maxCount = 2

Element = 1
currentCount = 1
maxCount = 2

Element = 1
currentCount = 2
maxCount = 2

Element = 1
currentCount = 3
maxCount = 3

Output:

3

Example 2:

Input:

nums = [1, 0, 1, 1, 0, 1]

Calculation:

Maximum continuous sequence of ones:

1, 1

Output:

2

Example 3:

Input:

nums = [0, 0, 0]

Array me koi bhi 1 present nahi hai.

Output:

0

Example 4:

Input:

nums = [1, 1, 1, 1]

Saare elements continuously 1 hain.

Output:

4

Variables:

nums:
Input binary array jisme sirf 0 aur 1 present
hote hain.

currentCount:
Current consecutive ones ki count store karta hai.

Agar zero milta hai, toh ye reset hokar zero
ho jaata hai.

maxCount:
Ab tak mile maximum consecutive ones ki count
store karta hai.

Time Complexity: O(n)

Hum array ke har element ko sirf ek baar traverse
kar rahe hain.

Space Complexity: O(1)

Hum sirf fixed variables currentCount aur maxCount
use kar rahe hain.

Koi extra array ya data structure use nahi kiya
gaya hai.
*/

public class LC485_MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        /*
         Current continuous ones ki count store
         karne ke liye variable.
        */
        int currentCount = 0;

        /*
         Maximum continuous ones ki count store
         karne ke liye variable.
        */
        int maxCount = 0;

        /*
         Array ke har element ko traverse karenge.
        */
        for (int i = 0; i < nums.length; i++) {

            /*
             Agar current element 1 hai, toh current
             consecutive count ko increase karenge.
            */
            if (nums[i] == 1) {
                currentCount++;
            } else {

                /*
                 Agar current element 0 hai, toh
                 consecutive ones ki sequence break
                 ho jayegi.

                 Isliye currentCount ko reset karenge.
                */
                currentCount = 0;
            }

            /*
             Agar current consecutive count ab tak ki
             maximum count se zyada hai, toh maxCount
             ko update karenge.
            */
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1, 1, 1};

        int result = findMaxConsecutiveOnes(nums);

        System.out.println("Maximum Consecutive Ones: " + result);
    }
}