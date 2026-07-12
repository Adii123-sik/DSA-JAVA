package Strings.Medium;

/*
Problem: Find the Lexicographically Largest String From the Box I
LeetCode: 3403
Difficulty: Medium
Main Topic: String
Optimized Pattern: Substring Traversal / Lexicographical Comparison

Approach:
Hume given word ko exactly numFriends non-empty parts me
har possible valid way se divide karna hai.

Har division me banne wali strings ko box me add kiya jata hai.
Hume box me present lexicographically largest string return
karni hai.

Important Observation:
Agar word ki length n hai aur total numFriends friends hain,
toh kisi ek friend ko milne wali string ki maximum possible
length hogi:

maximumLength = n - numFriends + 1

Kyunki remaining numFriends - 1 friends ko kam-se-kam
ek-ek character dena zaroori hai.

Example:
word = "dbca"
numFriends = 2

n = 4

maximumLength:
4 - 2 + 1 = 3

Har index se maximum allowed substring:

Index 0:
"dbc"

Index 1:
"bca"

Index 2:
"ca"

Index 3:
"a"

Lexicographical comparison:

"dbc" > "ca" > "bca" > "a"

Answer:
"dbc"

Why Maximum-Length Substring Only?
Suppose ek index se possible strings hain:

"d"
"db"
"dbc"

In sabka starting part same hai.

Lexicographical order me longer string larger hogi:

"dbc" > "db" > "d"

Isliye har starting index se sirf maximum allowed length ki
substring check karna sufficient hai.

Special Case:
Agar numFriends == 1 hai, toh string ko split nahi karna hai.
Complete word hi answer hoga.

Methods Used:

Math.min(a, b):
Dono values me se smaller value return karta hai.

substring(start, end):
start index se end - 1 index tak ki string return karta hai.

compareTo():
Do strings ko lexicographically compare karta hai.

Result:
- Positive: current string larger hai.
- Negative: current string smaller hai.
- Zero: dono strings same hain.

Time Complexity: O(n²)
Substring creation aur comparison ki wajah se worst case O(n²).

Space Complexity: O(n)
Substring store karne ke liye.
*/

public class LC3403_FindTheLexicographicallyLargestStringFromTheBoxI {

    public static String answerString(String word, int numFriends) {

        // Sirf ek friend hai toh complete word answer hoga
        if (numFriends == 1) {
            return word;
        }

        int n = word.length();

        /*
         Kisi ek friend ko milne wali string ki
         maximum possible length.
        */
        int maximumLength = n - numFriends + 1;

        String largestString = "";

        // Har index ko substring ka starting point banao
        for (int i = 0; i < n; i++) {

            /*
             Substring ka ending index calculate karo.

             Math.min() ensure karta hai ki end index
             string ki length se bahar na jaye.
            */
            int end = Math.min(n, i + maximumLength);

            // Current index se maximum allowed substring
            String currentString = word.substring(i, end);

            /*
             Agar currentString lexicographically larger hai,
             toh largestString ko update karo.
            */
            if (currentString.compareTo(largestString) > 0) {
                largestString = currentString;
            }
        }

        return largestString;
    }

    public static void main(String[] args) {

        String word = "dbca";
        int numFriends = 2;

        String result = answerString(word, numFriends);

        System.out.println("Word: " + word);
        System.out.println("Number of Friends: " + numFriends);
        System.out.println("Lexicographically Largest String: " + result);
    }
}