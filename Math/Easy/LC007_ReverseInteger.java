package Math.Easy;



/*
Problem: Reverse Number
LeetCode: 7
Difficulty: Easy
Main Topic: Math


Approch find a  last digit
   ld=num%10;
find reverse=reverse*10+ld;
num=num/10;


time complxity 0(N)
space complexity 0(1)

*/

import java.util.Scanner;

public class LC007_ReverseInteger {
    public static int reverse(int x) {
        int reverse = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            if (reverse > Integer.MAX_VALUE / 10 ||
                (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (reverse < Integer.MIN_VALUE / 10 ||
                (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reverse = reverse * 10 + digit;
        }

        return reverse;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=sc.nextInt();
        System.out.println(reverse(n));


    }
}
