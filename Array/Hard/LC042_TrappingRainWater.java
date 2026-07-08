package Array.Hard;

/*
Problem: Trapping Rain Water
LeetCode: 42
Difficulty: Hard
Main Topic: Array
Optimized Pattern: Two Pointers

Approach:
Hume calculate karna hai ki bars ke beech kitna rain water trap hoga.

Two pointer approach:
- left pointer start se chalega
- right pointer end se chalega
- leftMax aur rightMax track karenge
- Jis side ki height chhoti hogi, us side se water calculate karenge

Why Two Pointers?
Because water kisi index par minimum(leftMax, rightMax) - height[i] ke basis par trap hota hai.
Two pointers se hum bina extra array ke O(1) space me answer nikal sakte hain.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC042_TrappingRainWater {

    public static int trap(int[] height) {

        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {

            leftMax[i] = Math.max(height[i], leftMax[i - 1]);

        }
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]) - height[i];
            trappedWater = trappedWater + waterLevel;
        }

        return trappedWater;

    }

    public static void main(String[] args) {

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        int result = trap(height);

        System.out.println("Trapped Rain Water: " + result);

    }
}
