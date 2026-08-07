package Strings.Easy;

/*
Problem: Defanging an IP Address
LeetCode: 1108
Difficulty: Easy
Main Topic: String
Optimized Pattern: String Traversal

Approach:
Hume ek valid IP address string di jaati hai.

IP address me har dot '.' ko "[.]" se replace karna hai.

Hum address string ke har character ko traverse karenge.

Agar current character dot '.' hai:
result me "[.]" append karenge.

Otherwise:
current character ko normally result me append karenge.

Example:
address = "1.1.1.1"

Processing:
'1' -> "1"
'.' -> "1[.]"
'1' -> "1[.]1"
'.' -> "1[.]1[.]"

Final Output:
"1[.]1[.]1[.]1"

Why StringBuilder?
String immutable hoti hai.
StringBuilder repeated characters append karne ke liye efficient hota hai.

Time Complexity: O(n)
Space Complexity: O(n)

Here:
n = address string ki length
*/

public class LC1108_DefangingAnIPAddress {

    public static String defangIPaddr(String address) {

        StringBuilder result = new StringBuilder();

        int start = 0;

        while (start < address.length()) {

            if (address.charAt(start) == '.') {
                result.append("[.]");
            } else {
                result.append(address.charAt(start));
            }

            start++;
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String address = "1.1.1.1";

        String result = defangIPaddr(address);

        System.out.println("Original Address: " + address);
        System.out.println("Defanged Address: " + result);
    }
}