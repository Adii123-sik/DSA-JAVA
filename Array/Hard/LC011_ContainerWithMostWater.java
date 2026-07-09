package Array.Hard;

/*
Problem: Container With Most Water
LeetCode: 11
Difficulty: Medium
Main Topic: Array
Optimized Pattern: Two Pointers

Approach:
Hume do vertical lines choose karni hain jinke beech maximum water store ho sake.

Area ka formula:
area = min(height[left], height[right]) * (right - left)

Two Pointer Approach:
- left pointer start se chalega
- right pointer end se chalega
- Har step par current area calculate karenge
- maxWater me maximum area store karenge
- Jis side ki height chhoti hogi, us pointer ko move karenge

Why move smaller height pointer?
Because water ki height hamesha smaller line decide karti hai.
Agar hum bigger height wale pointer ko move karenge, to width kam hogi but height improve hone ka chance nahi hoga.
Isliye smaller height pointer move karte hain taaki better height mil sake.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC011_ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;

        while (left < right) {

            int currentHeight = Math.min(height[left], height[right]);
            int width = right - left;

            int currentArea = currentHeight * width;

            maxWater = Math.max(maxWater, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        int result = maxArea(height);

        System.out.println("Maximum Water Container Area: " + result);
    }
}