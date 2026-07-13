package Strings.Easy;

/*
Problem: Length of Last Word
LeetCode: 58
Difficulty: Easy
Main Topic: String
Optimized Pattern: Reverse Traversal

Approach:
Hume ek string s di gayi hai, jisme words aur spaces
ho sakte hain.

Hume string ke last word ki length return karni hai.

Word ka matlab hai:

Ek ya ek se zyada non-space characters ka sequence.

String ke end me extra spaces bhi ho sakte hain.

Example:

s = "Hello World   "

Yahan string ke end me spaces hain.

Last word:

World

Last word ki length:

5

Hum string ko last index se traverse karenge.

Starting me agar trailing spaces milti hain,
toh unhe ignore karenge.

Jab pehla non-space character milega,
toh last word ki counting start karenge.

Har non-space character ke liye:

count++

Jab count start hone ke baad space mil jaaye,
toh iska matlab last word complete ho gaya.

Isliye loop ko break kar denge.

Example 1:
Input:

s = "Hello World"

Right side traversal:

d -> count = 1
l -> count = 2
r -> count = 3
o -> count = 4
W -> count = 5
space -> break

Output:
5

Example 2:
Input:

s = "   fly me   to   the moon  "

Trailing spaces ignore hongi.

Last word:

moon

Length:

4

Output:
4

Example 3:
Input:

s = "luffy is still joyboy"

Last word:

joyboy

Length:

6

Output:
6

Variables:

count:
Last word ke characters ki total count store karta hai.

i:
String ko right se left traverse karne ke liye
current index ko track karta hai.

ch:
Current index ke character ko store karta hai.

Time Complexity:
O(n)

Worst case me hume poori string traverse karni
pad sakti hai.

Space Complexity:
O(1)

Hum koi extra array ya string use nahi kar rahe.
*/

public class LC58_LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        int count = 0;

        /*
         String ko last index se starting index
         ki taraf traverse karo.
        */
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            /*
             Agar current character space nahi hai,
             toh woh last word ka character hai.

             Isliye count ko increase karo.
            */
            if (ch != ' ') {

                count++;
            }

            /*
             Agar space milti hai aur count already
             greater than 0 hai, toh iska matlab
             last word ki counting start ho chuki thi
             aur ab last word complete ho gaya hai.

             Isliye loop ko break karo.
            */
            else if (count > 0) {

                break;
            }

            /*
             Agar space milti hai aur count 0 hai,
             toh woh trailing space hai.

             Us space ko ignore karke traversal
             continue hoga.
            */
        }

        return count;
    }

    public static void main(String[] args) {

        String s = "   fly me   to   the moon  ";

        int result = lengthOfLastWord(s);

        System.out.println("String: \"" + s + "\"");
        System.out.println("Length of Last Word: " + result);
    }
}