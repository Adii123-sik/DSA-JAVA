package Stack.Easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Problem: Valid Parentheses
LeetCode: 20
Difficulty: Easy
Main Topic: Stack / String
Optimized Pattern: Stack Matching

Approach:
Hume brackets ki ek string s di gayi hai.

String ke andar teen types ke brackets ho sakte hain:

() -> Round Brackets
{} -> Curly Brackets
[] -> Square Brackets

String valid tab hogi jab:

1. Har opening bracket ka matching closing bracket ho.
2. Brackets correct order me close hon.
3. Koi closing bracket bina opening bracket ke na aaye.
4. End me koi opening bracket unmatched na bache.

Hum Stack ka use karenge.

Jab opening bracket milega, hum uska expected closing
bracket Stack me push karenge.

Example:

Agar '(' mile:
Stack me ')' push karenge.

Agar '{' mile:
Stack me '}' push karenge.

Agar '[' mile:
Stack me ']' push karenge.

Jab closing bracket milega, check karenge:

1. Stack empty toh nahi hai.
2. Stack ke top par wahi expected closing bracket hai ya nahi.

Agar Stack empty hai, iska matlab closing bracket ke liye
koi opening bracket available nahi hai.

Agar Stack se pop hua bracket current closing bracket ke
equal nahi hai, toh brackets ka order galat hai.

Isliye false return karenge.

Saari string traverse karne ke baad Stack empty honi chahiye.

Agar Stack empty hai:
Saare brackets correctly match ho gaye hain.

Output:
true

Agar Stack empty nahi hai:
Kuch opening brackets close nahi hue hain.

Output:
false

Example 1:
Input:
s = "()"

Process:

'(' mila:
Stack me ')' push kiya.

')' mila:
Stack se ')' pop hua aur current character se match ho gaya.

Stack empty hai.

Output:
true

Example 2:
Input:
s = "()[]{}"

Process:

'(' -> ')' push
')' -> match

'[' -> ']' push
']' -> match

'{' -> '}' push
'}' -> match

Stack empty hai.

Output:
true

Example 3:
Input:
s = "(]"

Process:

'(' mila:
Stack me ')' push kiya.

']' mila:
Stack se ')' pop hua.

Expected ')' tha, lekin current bracket ']' hai.

Output:
false

Example 4:
Input:
s = "([)]"

Process:

'(' -> ')' push
'[' -> ']' push

')' mila:
Stack ke top par ']' tha.

Order galat hai.

Output:
false

Variables:

stack:
Expected closing brackets ko store karta hai.

currentBracket:
String ke current bracket ko represent karta hai.

Time Complexity: O(n)

String ke har character ko sirf ek baar traverse kiya jata hai.

Space Complexity: O(n)

Worst case me saare characters opening brackets ho sakte hain,
jo Stack me store honge.
*/

public class LC20_ValidParentheses {

    public static boolean isValid(String s) {

        /*
         ArrayDeque ko Stack ki tarah use kar rahe hain.

         Deque<Character> interface use karne se code
         flexible aur recommended rehta hai.
        */
        Deque<Character> stack = new ArrayDeque<>();

        // String ke har bracket ko traverse karo
        for (int i = 0; i < s.length(); i++) {

            char currentBracket = s.charAt(i);

            /*
             Opening round bracket mile toh expected
             closing bracket ')' push karo.
            */
            if (currentBracket == '(') {

                stack.push(')');
            }

            /*
             Opening curly bracket mile toh expected
             closing bracket '}' push karo.
            */
            else if (currentBracket == '{') {

                stack.push('}');
            }

            /*
             Opening square bracket mile toh expected
             closing bracket ']' push karo.
            */
            else if (currentBracket == '[') {

                stack.push(']');
            }

            /*
             Closing bracket milne par Stack ke top
             bracket se match karo.
            */
            else {

                /*
                 Agar Stack empty hai, toh current closing
                 bracket ka opening bracket available nahi hai.

                 Agar Stack ka top current bracket ke equal
                 nahi hai, toh brackets ka order galat hai.
                */
                if (stack.isEmpty()
                        || stack.pop() != currentBracket) {

                    return false;
                }
            }
        }

        /*
         Valid parentheses ke liye end me Stack empty
         honi chahiye.
        */
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "{[()]}";

        boolean result = isValid(s);

        System.out.println("String: " + s);
        System.out.println("Valid Parentheses: " + result);
    }
}