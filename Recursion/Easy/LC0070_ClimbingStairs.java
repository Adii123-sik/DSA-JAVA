package Recursion.Easy;

/*
Problem: Climbing Stairs
LeetCode: 70
Difficulty: Easy
Main Topic: Recursion / Dynamic Programming
Optimized Pattern: Recursion with Memoization

Approach:
Hume n stairs ke top tak pahunchna hai.

Har step par humare paas do choices hoti hain:

1. Ek stair climb karna
2. Do stairs climb karna

Agar hum ek step lete hain, to remaining problem:
climbStairs(n - 1)

Agar hum do steps lete hain, to remaining problem:
climbStairs(n - 2)

Recurrence:
ways(n) = ways(n - 1) + ways(n - 2)

Base Cases:
n = 0 -> 1 way
n = 1 -> 1 way

Memoization:
Normal recursion same values ko baar-baar calculate karti hai.
Isliye memo array me already calculated answers store karenge.

Agar memo[n] me answer available hai, to recursion dobara
calculate karne ke bajay stored answer return karegi.

Example:
n = 3

Possible ways:
1 + 1 + 1
1 + 2
2 + 1

Output:
3

Why Recursion with Memoization?
Recursion problem ko smaller subproblems me divide karti hai.
Memoization repeated calculations ko avoid karti hai.

Time Complexity: O(n)
Space Complexity: O(n)

Space includes:
- Memoization array
- Recursion call stack
*/

import java.util.Arrays;

public class LC0070_ClimbingStairs {

    public static int climbStairs(int n) {

        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);

        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        // Take one step
        int oneStepWays = countWays(n - 1, memo);

        // Take two steps
        int twoStepWays = countWays(n - 2, memo);

        memo[n] = oneStepWays + twoStepWays;

        return memo[n];
    }

    public static void main(String[] args) {

        int n = 5;

        int result = climbStairs(n);

        System.out.println("Number of Stairs: " + n);
        System.out.println("Total Ways: " + result);
    }
}