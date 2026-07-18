package Strings.Easy;

/*
Problem: Valid Anagram
LeetCode: 242
Difficulty: Easy
Main Topic: String / Hashing
Optimized Pattern: Character Frequency Array

Approach:

Hume do strings di gayi hain:

s
t

Hume check karna hai ki string t,
string s ka anagram hai ya nahi.

Anagram ka matlab:

Dono strings me same characters,
same number of times present hone chahiye.

Characters ka order alag ho sakta hai.

Example:

s = "anagram"
t = "nagaram"

Dono strings me:

a = 3 baar
n = 1 baar
g = 1 baar
r = 1 baar
m = 1 baar

Characters ka order alag hai,
lekin characters aur unki frequency same hai.

Isliye output:

true

--------------------------------------------------

Length Check:

Sabse pehle dono strings ki length compare karenge.

Agar dono strings ki length different hai,
toh woh anagram nahi ho sakti.

Example:

s = "apple"
t = "app"

s ki length = 5
t ki length = 3

Dono strings ki length different hai.

Isliye direct false return karenge.

--------------------------------------------------

Frequency Array:

Question me lowercase English letters diye gaye hain.

Lowercase English letters total 26 hote hain:

a se z tak

Isliye hum 26 size ka integer array banayenge:

int[] frequency = new int[26];

Initially frequency array ke sabhi elements 0 honge.

Character ka index nikalne ke liye:

character - 'a'

use karenge.

Example:

'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2

Isi tarah:

'z' - 'a' = 25

--------------------------------------------------

Main Logic:

String s ke har character ki frequency
increase karenge.

frequency[s.charAt(i) - 'a']++;

String t ke har character ki frequency
decrease karenge.

frequency[t.charAt(i) - 'a']--;

Agar dono strings me same characters
same frequency ke saath present honge,
toh increment aur decrement ek doosre ko
cancel kar denge.

Final frequency array ke sabhi elements
0 hone chahiye.

Agar frequency array me koi bhi value
0 nahi hai, toh strings anagram nahi hain.

--------------------------------------------------

Dry Run:

Input:

s = "anagram"
t = "nagaram"

Starting frequency array:

Sabhi values = 0

Step 1:

s ka character = 'a'
t ka character = 'n'

'a' ki frequency increase:

frequency[a] = 1

'n' ki frequency decrease:

frequency[n] = -1

Step 2:

s ka character = 'n'
t ka character = 'a'

'n' ki frequency increase:

frequency[n] = 0

'a' ki frequency decrease:

frequency[a] = 0

Isi tarah poori strings process hone ke baad
sabhi character frequencies 0 ho jayengi.

Isliye output:

true

--------------------------------------------------

False Example:

Input:

s = "rat"
t = "car"

String s se:

r = +1
a = +1
t = +1

String t se:

c = -1
a = -1
r = -1

Final frequency:

a = 0
r = 0
t = 1
c = -1

Frequency array me kuch values 0 nahi hain.

Isliye output:

false

--------------------------------------------------

Example 1:

Input:

s = "anagram"
t = "nagaram"

Output:

true

--------------------------------------------------

Example 2:

Input:

s = "rat"
t = "car"

Output:

false

--------------------------------------------------

Variables:

frequency:

Har lowercase character ki frequency ko
store karta hai.

Index 0 character 'a' ko represent karta hai.

Index 1 character 'b' ko represent karta hai.

Isi tarah index 25 character 'z' ko
represent karta hai.

i:

Strings ke current character ke index ko
track karta hai.

count:

Frequency array ke current element ko
represent karta hai.

--------------------------------------------------

Time Complexity: O(n)

Dono strings ke characters ko ek baar
process karte hain.

Uske baad 26 size ke frequency array ko
check karte hain.

Total time complexity:

O(n)

Space Complexity: O(1)

Frequency array ka size hamesha 26 rahega.

String kitni bhi badi ho,
extra space increase nahi hoga.

Isliye space complexity:

O(1)
*/

public class LC242_ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        /*
         Agar dono strings ki length different hai,
         toh woh anagram nahi ho sakti.

         Isliye direct false return karo.
        */
        if (s.length() != t.length()) {
            return false;
        }

        /*
         Lowercase English characters total
         26 hote hain.

         Har character ki frequency store karne
         ke liye 26 size ka array banaya hai.
        */
        int[] frequency = new int[26];

        /*
         Dono strings ki length same hai.

         Isliye ek hi loop me:

         String s ke character ki frequency
         increase karenge.

         String t ke character ki frequency
         decrease karenge.
        */
        for (int i = 0; i < s.length(); i++) {

            /*
             String s ka current character nikalo.

             Character me se 'a' subtract karke
             uska array index nikalo.

             Example:

             character = 'c'

             'c' - 'a' = 2

             Isliye frequency[2] increase hogi.
            */
            frequency[s.charAt(i) - 'a']++;

            /*
             String t ka current character nikalo.

             Character me se 'a' subtract karke
             uska array index nikalo.

             Us character ki frequency decrease karo.
            */
            frequency[t.charAt(i) - 'a']--;
        }

        /*
         Frequency array ke sabhi elements
         check karo.

         Agar koi bhi frequency 0 nahi hai,
         toh dono strings anagram nahi hain.
        */
        for (int count : frequency) {

            if (count != 0) {
                return false;
            }
        }

        /*
         Agar frequency array ke sabhi elements
         0 hain, toh dono strings me same characters
         same frequency ke saath present hain.

         Isliye true return karo.
        */
        return true;
    }

    public static void main(String[] args) {

        /*
         Test case 1:

         Dono strings anagram hain.
        */
        String s1 = "anagram";
        String t1 = "nagaram";

        boolean result1 = isAnagram(s1, t1);

        System.out.println("String s: " + s1);
        System.out.println("String t: " + t1);
        System.out.println("Is Valid Anagram: " + result1);

        System.out.println();

        /*
         Test case 2:

         Dono strings anagram nahi hain.
        */
        String s2 = "rat";
        String t2 = "car";

        boolean result2 = isAnagram(s2, t2);

        System.out.println("String s: " + s2);
        System.out.println("String t: " + t2);
        System.out.println("Is Valid Anagram: " + result2);
    }
}