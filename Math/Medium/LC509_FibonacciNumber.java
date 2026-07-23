package Math.Medium;

/*
Problem: Fibonacci Number
LeetCode: 509
Difficulty: Easy
Main Topic: Recursion / Math
Pattern: Basic Recursion

Problem Statement:
Fibonacci series mein har number apne pichhle do numbers
ke sum ke equal hota hai.

Fibonacci Sequence:
0, 1, 1, 2, 3, 5, 8, 13...

Rules:
F(0) = 0
F(1) = 1
F(n) = F(n - 1) + F(n - 2)

Hume given integer n ka nth Fibonacci number return karna hai.

Example 1:
Input:
n = 2

Output:
1

Explanation:
F(2) = F(1) + F(0)
     = 1 + 0
     = 1

Example 2:
Input:
n = 4

Output:
3

Explanation:
Fibonacci sequence:
0, 1, 1, 2, 3

F(4) = 3

Approach:
Hum recursion ka use karenge.

Base Cases:
- Agar n == 0 hai, toh 0 return karenge.
- Agar n == 1 hai, toh 1 return karenge.

Recursive Case:
fib(n) = fib(n - 1) + fib(n - 2)

Example:
fib(5)

fib(5)
= fib(4) + fib(3)
= 3 + 2
= 5

Why Recursion?
Fibonacci ki definition khud recursive hai because har number
pichhle do Fibonacci numbers par depend karta hai.

Time Complexity: O(2^n)
Space Complexity: O(n)

Space recursion call stack ki wajah se use hoti hai.
*/

public class LC509_FibonacciNumber {

    public static int fib(int n) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Base case
        if (n == 1) {
            return 1;
        }

        // Recursive call
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        int n = 6;

        int result = fib(n);

        System.out.println(
            "Fibonacci number at position " + n + ": " + result
        );
    }
}