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
    public static int reverseInteger(int n){

        int num=n;
        int reverse=0;
        while (num>0) {

            int ld=num%10;
            reverse=reverse*10+ld;
            num=num/10;
            
        }
    return reverse;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=sc.nextInt();
        System.out.println(reverseInteger(n));


    }
}
