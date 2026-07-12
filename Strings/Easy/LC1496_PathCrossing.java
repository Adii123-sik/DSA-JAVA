package Strings.Easy;

import java.util.HashSet;
import java.util.Set;

/*
Problem: Path Crossing
LeetCode: 1496
Difficulty: Easy
Main Topic: String / HashSet
Optimized Pattern: Coordinate Tracking

Approach:
Hume ek path string di gayi hai jisme directions hoti hain:

N -> North
S -> South
E -> East
W -> West

Hum starting position (0, 0) se journey start karte hain.

Har direction ke according x aur y coordinates update karenge.

Coordinate Rules:

N:
y = y + 1

S:
y = y - 1

E:
x = x + 1

W:
x = x - 1

Hume check karna hai ki journey ke dauran koi position
dobara visit hui hai ya nahi.

Agar koi coordinate dobara visit hota hai:
return true

Agar complete path travel karne ke baad koi coordinate
repeat nahi hota:
return false

HashSet:
Hum har visited coordinate ko HashSet me store karenge.

Starting Position:
Journey (0, 0) se start hoti hai.

Isliye sabse pehle "0,0" ko visited set me add karenge.

Har movement ke baad current position ko String ke format me
store karenge:

x + "," + y

Example:
x = 1
y = 2

Current position:
"1,2"

Agar current position pehle se HashSet me present hai,
toh path cross hua hai.

Example 1:
Input:
path = "NES"

Positions:

Start:
(0, 0)

N:
(0, 1)

E:
(1, 1)

S:
(1, 0)

Koi position repeat nahi hui.

Output:
false

Example 2:
Input:
path = "NESWW"

Positions:

Start:
(0, 0)

N:
(0, 1)

E:
(1, 1)

S:
(1, 0)

W:
(0, 0)

Position (0, 0) dobara visit hui.

Output:
true

Why HashSet?
HashSet me kisi position ko search karna average O(1) time
leta hai.

Methods Used:

add():
HashSet me value add karta hai.

contains():
Check karta hai ki value pehle se HashSet me present hai
ya nahi.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class LC1496_PathCrossing {

    public static boolean isPathCrossing(String path) {

        int x = 0;
        int y = 0;

        /*
         Har visited coordinate ko store karne ke liye
         HashSet banaya hai.
        */
        Set<String> visitedPositions = new HashSet<>();

        // Starting position ko visited mark karo
        visitedPositions.add("0,0");

        for (int i = 0; i < path.length(); i++) {

            char direction = path.charAt(i);

            // North direction
            if (direction == 'N') {

                y++;

            }
            // South direction
            else if (direction == 'S') {

                y--;

            }
            // East direction
            else if (direction == 'E') {

                x++;

            }
            // West direction
            else if (direction == 'W') {

                x--;
            }

            /*
             Current x aur y coordinate ko ek unique
             String ke form me convert karo.
            */
            String currentPosition = x + "," + y;

            /*
             Agar current position pehle se visited hai,
             toh path cross hua hai.
            */
            if (visitedPositions.contains(currentPosition)) {

                return true;
            }

            // Current position ko visited set me add karo
            visitedPositions.add(currentPosition);
        }

        // Koi bhi position repeat nahi hui
        return false;
    }

    public static void main(String[] args) {

        String path = "NESWW";

        boolean result = isPathCrossing(path);

        System.out.println("Path: " + path);
        System.out.println("Is Path Crossing: " + result);
    }
}