package Strings.Medium;

/*
Problem: String Compression
LeetCode: 443
Difficulty: Medium
Main Topic: String / Character Array
Optimized Pattern: Two Pointers / In-Place Compression

Approach:
Hume given character array ko compress karna hai.

Compression Rules:
1. Consecutive same characters ko ek group maana jayega.
2. Sabse pehle character write karna hai.
3. Agar character ek se zyada baar aaya hai, toh uska count
   character ke baad write karna hai.
4. Agar count 1 hai, toh count ko write nahi karna hai.
5. Compression original char array ke andar hi karna hai.
6. Method ko compressed array ki final length return karni hai.

Example 1:
Input:
['a', 'a', 'b', 'b', 'c', 'c', 'c']

Groups:
aa  -> a2
bb  -> b2
ccc -> c3

Compressed Array:
['a', '2', 'b', '2', 'c', '3']

Return:
6

Example 2:
Input:
['a']

Character sirf ek baar aaya hai.

Compressed Array:
['a']

Return:
1

Example 3:
Input:
['a', 'a', 'a', 'a', 'a', 'a',
 'a', 'a', 'a', 'a', 'a', 'a']

'a' total 12 baar hai.

Compressed Result:
a12

Count 12 ko array me alag-alag characters ke form me likhenge:

'a', '1', '2'

Important:
LeetCode 3163 me output count + character hota hai:

3a

LeetCode 443 me output character + count hota hai:

a3

LeetCode 443 me count ki maximum limit 9 nahi hai.
Count 10, 12, 100 ya usse zyada bhi ho sakta hai.

Variables:
- i:
  Character array ko traverse karta hai.

- count:
  Consecutive same characters ki frequency store karta hai.

- write:
  Compressed result ko original array me write karne ka index hai.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC443_StringCompression {

    public static int compress(char[] chars) {

        int write = 0;

        for (int i = 0; i < chars.length; i++) {

            int count = 1;

            /*
             Consecutive same characters ko count karo.

             Jab current character aur next character same ho:
             - count increase karo
             - i ko next index par move karo
            */
            while (i < chars.length - 1
                    && chars[i] == chars[i + 1]) {

                count++;
                i++;
            }

            // Sabse pehle character ko array me write karo
            chars[write] = chars[i];
            write++;

            /*
             Agar character ek se zyada baar aaya hai,
             tabhi uska count write karo.
            */
            if (count > 1) {

                String countString = String.valueOf(count);

                /*
                 Count ke har digit ko separately array me write karo.

                 Example:
                 count = 12

                 "12" ke characters:
                 '1', '2'
                */
                for (int j = 0; j < countString.length(); j++) {

                    chars[write] = countString.charAt(j);
                    write++;
                }
            }
        }

        // Compressed array ki final length
        return write;
    }

    
    public static void main(String[] args) {

        char[] chars = {
                'a', 'a',
                'b', 'b',
                'c', 'c', 'c'
        };

        int compressedLength = compress(chars);

        System.out.println("Compressed Length: " + compressedLength);

        System.out.print("Compressed Array: ");

        for (int i = 0; i < compressedLength; i++) {

            System.out.print(chars[i]);

            if (i < compressedLength - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }
}