package Array.Easy;

/*
Problem: Find the Highest Altitude
LeetCode: 1732
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Prefix Sum / Running Sum

Approach:
Ek biker altitude 0 se journey start karta hai.

gain array ka har element batata hai ki current altitude
kitni increase ya decrease hui.

Hum do variables maintain karenge:

1. currentAltitude
   Journey ke current point ki altitude store karega.

2. highestAltitude
   Journey me ab tak ki highest altitude store karega.

Har gain ko currentAltitude me add karenge.

Uske baad Math.max() ki help se currentAltitude aur
highestAltitude me se maximum value save karenge.

Starting altitude 0 bhi journey ka part hoti hai,
isliye highestAltitude ko initially 0 rakhenge.

Example:
gain = [-5, 1, 5, 0, -7]

Starting altitude = 0

0 + (-5) = -5
-5 + 1   = -4
-4 + 5   = 1
1 + 0    = 1
1 + (-7) = -6

All Altitudes:
[0, -5, -4, 1, 1, -6]

Highest Altitude:
1

Why Running Sum?
Because current altitude previous altitude aur current gain
ko add karke directly calculate ho jaati hai.

Hume har index ke liye starting point se dobara sum
calculate karne ki zarurat nahi padti.

Time Complexity: O(n)
Space Complexity: O(1)

Here:
n = gain array ki length
*/

import java.util.Arrays;

public class LC1732_FindTheHighestAltitude {

    public static int largestAltitude(int[] gain) {

        int currentAltitude = 0;
        int highestAltitude = 0;

        for (int i = 0; i < gain.length; i++) {

            currentAltitude = currentAltitude + gain[i];

            highestAltitude = Math.max(
                    highestAltitude,
                    currentAltitude
            );
        }

        return highestAltitude;
    }

    public static void main(String[] args) {

        int[] gain = {-5, 1, 5, 0, -7};

        int result = largestAltitude(gain);

        System.out.println("Gain Array: " + Arrays.toString(gain));
        System.out.println("Highest Altitude: " + result);
    }
}