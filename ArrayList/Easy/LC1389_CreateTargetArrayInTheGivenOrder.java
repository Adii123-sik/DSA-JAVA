package Array.Easy;

/*
Problem: Create Target Array in the Given Order
LeetCode: 1389
Difficulty: Easy
Main Topic: Array
Pattern: ArrayList Insertion

Approach:
Hume do arrays nums aur index diye jaate hain.

Har position i par:
nums[i] ki value ko target ke index[i] position par
insert karna hota hai.

Insertion ka matlab replacement nahi hota.

Agar specified position par pehle se koi element present hai,
toh woh element aur uske baad ke elements right side shift
ho jaate hain.

Java ArrayList ka add(index, value) method exactly ye kaam karta hai.

Syntax:
list.add(index[i], nums[i]);

Yahan:
nums[i]  = kya value insert karni hai
index[i] = kis position par insert karni hai

Example:
nums  = [0, 1, 2, 3, 4]
index = [0, 1, 2, 2, 1]

Processing:

i = 0:
list.add(0, 0)
list = [0]

i = 1:
list.add(1, 1)
list = [0, 1]

i = 2:
list.add(2, 2)
list = [0, 1, 2]

i = 3:
list.add(2, 3)
list = [0, 1, 3, 2]

i = 4:
list.add(1, 4)
list = [0, 4, 1, 3, 2]

Finally, ArrayList ke elements ko int[] target array me
copy karke return karenge.

Why ArrayList?
ArrayList beech ke kisi bhi index par element insert karne ki
facility deta hai aur existing elements ko automatically
right side shift kar deta hai.

Time Complexity: O(n^2)
Space Complexity: O(n)

Time O(n^2) isliye hai kyunki middle position par insertion
ke time elements ko right side shift karna pad sakta hai.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class LC1389_CreateTargetArrayInTheGivenOrder {

    public static int[] createTargetArray(int[] nums, int[] index) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] target = new int[nums.length];

        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }

        return target;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};

        int[] result = createTargetArray(nums, index);

        System.out.println("Nums Array: " + Arrays.toString(nums));
        System.out.println("Index Array: " + Arrays.toString(index));
        System.out.println("Target Array: " + Arrays.toString(result));
    }
}