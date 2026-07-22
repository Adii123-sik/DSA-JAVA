package Array.Medium;

/*
Problem: Count Primes
LeetCode: 204
Difficulty: Medium
Main Topic: Mathematics / Sieve of Eratosthenes

Approach:
- Hume n se chhote total prime numbers count karne hain.
- Ek boolean array isPrime banayenge.
- Initially 2 se n - 1 tak sabhi numbers ko prime maanenge.
- Sieve of Eratosthenes use karke har prime number ke multiples
  ko non-prime mark karenge.
- Multiples ko i * i se mark karna start karenge,
  kyunki usse chhote multiples pehle hi mark ho chuke honge.
- Last me true values ko count karke return karenge.

Example 1:
Input:
n = 10

Prime Numbers:
2, 3, 5, 7

Output:
4

Example 2:
Input:
n = 0

Output:
0

Example 3:
Input:
n = 2

Output:
0

Time Complexity: O(n log log n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class LC204_CountPrimes {

    public static int countPrimes(int n) {

        // 2 se chhote kisi bhi number ke andar prime number nahi hota
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];

        // Initially sabhi numbers ko prime maan rahe hain
        Arrays.fill(isPrime, true);

        // 0 aur 1 prime nahi hote
        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {

            // Agar current number prime hai
            if (isPrime[i]) {

                // Current prime ke multiples ko non-prime mark karo
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        // Total prime numbers count karo
        for (int i = 2; i < n; i++) {

            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 10;

        int result = countPrimes(n);

        System.out.println("Prime numbers less than " + n + ": " + result);
    }
}