package Strings.Easy;

/*
Problem: Add Binary
LeetCode: 67
Difficulty: Easy
Main Topic: String
Optimized Pattern: Two Pointers + Carry

Approach:
Hume do binary strings a aur b di gayi hain.

Hume dono binary numbers ko add karke unka
result bhi binary string ke form me return karna hai.

Binary string me sirf do characters hote hain:

'0'
'1'

Binary addition normal decimal addition ki tarah
right side se start hoti hai.

Binary Addition Rules:

0 + 0 = 0
0 + 1 = 1
1 + 0 = 1
1 + 1 = 10

1 + 1 ka result binary me 10 hota hai.

Isme:

Current digit = 0
Carry = 1

Agar carry bhi present ho:

1 + 1 + 1 = 11

Isme:

Current digit = 1
Carry = 1

Hum dono strings ko unke last index se traverse
karenge.

Pointer i:
String a ke last character ko track karega.

Pointer j:
String b ke last character ko track karega.

Har iteration me:

sum = carry

Agar string a me character available hai,
toh us digit ko sum me add karenge.

Agar string b me character available hai,
toh us digit ko bhi sum me add karenge.

Current binary digit calculate karne ke liye:

sum % 2

New carry calculate karne ke liye:

sum / 2

Calculated digits right se left milengi.

Isliye unhe StringBuilder me append karne ke baad
final result ko reverse karna padega.

Example 1:
Input:

a = "11"
b = "1"

Binary addition:

   11
+   1
-----
  100

Right side traversal:

1 + 1 + carry 0 = 2

Current digit:
2 % 2 = 0

Carry:
2 / 2 = 1

Next:

1 + carry 1 = 2

Current digit:
2 % 2 = 0

Carry:
2 / 2 = 1

Ab dono strings complete ho gayi hain,
lekin carry 1 remaining hai.

Carry ko result me add karenge.

StringBuilder me result:

"001"

Reverse karne ke baad:

"100"

Output:
"100"

Example 2:
Input:

a = "1010"
b = "1011"

Binary addition:

   1010
+  1011
-------
  10101

Output:
"10101"

Variables:

i:
String a ko right se left traverse karne ke liye
current index ko track karta hai.

j:
String b ko right se left traverse karne ke liye
current index ko track karta hai.

carry:
Previous addition se generate hui carry ko
store karta hai.

sum:
Current digits aur carry ka total store karta hai.

answer:
Calculated binary digits ko store karne ke liye
StringBuilder use kiya gaya hai.

Time Complexity:
O(max(n, m))

Hum dono strings ke har character ko maximum
ek baar process karte hain.

Yahan:

n = String a ki length
m = String b ki length

Space Complexity:
O(max(n, m))

Result ko store karne ke liye StringBuilder use
kiya gaya hai.

Final answer ki length maximum:

max(n, m) + 1

ho sakti hai.
*/

public class LC67_AddBinary {

    public static String addBinary(String a, String b) {

        /*
         Pointer i string a ke last index se
         traversal start karega.
        */
        int i = a.length() - 1;

        /*
         Pointer j string b ke last index se
         traversal start karega.
        */
        int j = b.length() - 1;

        /*
         Previous binary addition se generate hui
         carry ko store karega.
        */
        int carry = 0;

        /*
         Binary result ke digits ko temporarily
         reverse order me store karega.
        */
        StringBuilder answer = new StringBuilder();

        /*
         Loop tab tak chalega jab tak:

         String a me characters remaining hain,
         ya string b me characters remaining hain,
         ya carry remaining hai.
        */
        while (i >= 0 || j >= 0 || carry > 0) {

            /*
             Current sum ko previous carry se
             initialize karo.
            */
            int sum = carry;

            /*
             Agar string a me current digit available
             hai, toh character ko integer me convert
             karke sum me add karo.

             '0' - '0' = 0
             '1' - '0' = 1
            */
            if (i >= 0) {

                sum += a.charAt(i) - '0';

                i--;
            }

            /*
             Agar string b me current digit available
             hai, toh character ko integer me convert
             karke sum me add karo.
            */
            if (j >= 0) {

                sum += b.charAt(j) - '0';

                j--;
            }

            /*
             sum % 2 se current binary digit milega.

             sum = 0 -> digit = 0
             sum = 1 -> digit = 1
             sum = 2 -> digit = 0
             sum = 3 -> digit = 1
            */
            int currentDigit = sum % 2;

            answer.append(currentDigit);

            /*
             sum / 2 se next addition ke liye
             carry calculate hogi.

             sum = 0 -> carry = 0
             sum = 1 -> carry = 0
             sum = 2 -> carry = 1
             sum = 3 -> carry = 1
            */
            carry = sum / 2;
        }

        /*
         Digits right se left calculate hui hain,
         isliye StringBuilder me reverse order me
         stored hain.

         Final binary result ke liye answer ko
         reverse karke String me convert karo.
        */
        return answer.reverse().toString();
    }

    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";

        String result = addBinary(a, b);

        System.out.println("First Binary String: " + a);
        System.out.println("Second Binary String: " + b);
        System.out.println("Binary Sum: " + result);
    }
}