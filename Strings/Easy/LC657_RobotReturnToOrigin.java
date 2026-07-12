package Strings.Easy;

/*
Problem: Robot Return to Origin
LeetCode: 657
Difficulty: Easy
Main Topic: String / Simulation
Optimized Pattern: Coordinate Tracking

Approach:
Ek robot starting position (0, 0) par khada hai.

Hume moves ki ek string di gayi hai, jisme:

U -> Up
D -> Down
R -> Right
L -> Left

Har move ke according robot ke x aur y coordinates
update karenge.

Coordinate Rules:

U:
y = y + 1

D:
y = y - 1

R:
x = x + 1

L:
x = x - 1

Saare moves complete hone ke baad check karenge ki robot
dobara starting position (0, 0) par aaya hai ya nahi.

Agar:
x == 0 aur y == 0

Toh robot origin par return kar chuka hai.
Isliye true return karenge.

Otherwise false return karenge.

Example 1:
Input:
moves = "UD"

Positions:

Start:
(0, 0)

U:
(0, 1)

D:
(0, 0)

Robot starting position par return aa gaya.

Output:
true

Example 2:
Input:
moves = "LL"

Positions:

Start:
(0, 0)

L:
(-1, 0)

L:
(-2, 0)

Robot starting position par return nahi aaya.

Output:
false

Variables:

x:
Robot ki horizontal position ko track karta hai.

y:
Robot ki vertical position ko track karta hai.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC657_RobotReturnToOrigin {

    public static boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {

            char currentMove = moves.charAt(i);

            // Robot ko upward move karo
            if (currentMove == 'U') {

                y++;

            }
            // Robot ko downward move karo
            else if (currentMove == 'D') {

                y--;

            }
            // Robot ko right side move karo
            else if (currentMove == 'R') {

                x++;

            }
            // Robot ko left side move karo
            else if (currentMove == 'L') {

                x--;
            }
        }

        /*
         Agar final x aur y coordinates zero hain,
         toh robot origin par return aa gaya.
        */
        if (x == 0 && y == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String moves = "UD";

        boolean result = judgeCircle(moves);

        System.out.println("Moves: " + moves);
        System.out.println("Robot Returned to Origin: " + result);
    }
}