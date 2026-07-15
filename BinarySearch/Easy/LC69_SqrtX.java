package BinarySearch.Easy;

/*
Problem: Sqrt(x)
LeetCode: 69
Difficulty: Easy
Main Topic: Binary Search / Mathematics
Optimized Pattern: Binary Search on Answer

Approach:
Hume ek non-negative integer x diya gaya hai.

Hume x ka square root return karna hai.

Important:
Agar square root decimal me aata hai, toh decimal part ko remove
karke sirf integer part return karna hai.

Mathematically hume sabse bada integer answer find karna hai jiske liye:

answer * answer <= x

Example 1:
Input:
x = 4

Square Root:
sqrt(4) = 2

Return:
2

Example 2:
Input:
x = 8

Square Root:
sqrt(8) = 2.828...

Decimal part remove karne ke baad:

Return:
2

Kyunki:

2 * 2 = 4 <= 8
3 * 3 = 9 > 8

Isliye 8 ka integer square root 2 hai.

Example 3:
Input:
x = 1

Square Root:
sqrt(1) = 1

Return:
1

Why Binary Search:
Possible answer 0 se x ke beech ho sakta hai.

Har iteration me:
1. Middle number calculate karenge.
2. Check karenge ki mid ka square x se chhota, equal ya bada hai.
3. Agar mid possible answer hai, toh larger answer right side me search karenge.
4. Agar mid bahut bada hai, toh left side me search karenge.

Overflow Problem:
Hum directly ye condition use nahi karenge:

mid * mid <= x

Kyunki bade mid ke case me mid * mid integer range se bahar ja sakta hai
aur integer overflow ho sakta hai.

Isliye equivalent condition use karenge:

mid <= x / mid

Variables:
- left:
  Possible answer range ka starting point.

- right:
  Possible answer range ka ending point.

- mid:
  Current search range ka middle number.

- answer:
  Ab tak mila sabse bada valid integer square root.

Time Complexity: O(log x)
Space Complexity: O(1)
*/

public class LC69_SqrtX {

    public static int mySqrt(int x) {

        /*
         Base Case:

         sqrt(0) = 0
         sqrt(1) = 1
        */
        if (x < 2) {
            return x;
        }

        /*
         x >= 2 ke liye square root x / 2 se bada nahi ho sakta.

         Example:
         x = 8

         Possible search range:
         1 se 4
        */
        int left = 1;
        int right = x / 2;

        int answer = 0;

        while (left <= right) {

            /*
             Safe way se middle index calculate kar rahe hain.

             Ye avoid karta hai:

             (left + right) ke overflow ko
            */
            int mid = left + (right - left) / 2;

            /*
             Instead of:

             mid * mid <= x

             Hum use kar rahe hain:

             mid <= x / mid

             Taaki integer overflow na ho.
            */
            if (mid <= x / mid) {

                /*
                 mid ka square x se chhota ya equal hai.

                 Isliye mid ek possible answer hai.
                */
                answer = mid;

                /*
                 Hume sabse bada valid integer chahiye,
                 isliye right side me search karenge.
                */
                left = mid + 1;

            } else {

                /*
                 mid ka square x se bada hai.

                 Isliye mid aur usse bade numbers answer nahi ho sakte.
                 Left side me search karenge.
                */
                right = mid - 1;
            }
        }

        // Sabse bada valid integer square root return karo
        return answer;
    }


    public static void main(String[] args) {

        int x = 8;

        int squareRoot = mySqrt(x);

        System.out.println("Input: " + x);
        System.out.println("Integer Square Root: " + squareRoot);
    }
}