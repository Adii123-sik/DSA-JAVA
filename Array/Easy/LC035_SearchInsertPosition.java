package Array.Easy;

/*
Problem: Search Insert Position
LeetCode: 35
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Binary Search

Approach:
Ak index varaible bana liyaaa jo ki batayegaa target konse index prr aayega
linier search laga dene poore array m or dekhengee kab nums[i] target value se 
badha hota h jab chota hoga toh index++; krdengee or jaise hi badhaaa ya barabar hoga
wahi loop se exit hoke index retrun kraa dengeee

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC035_SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target){
                index++;
            }else{
                break;
            }

        }
    return index;
    }
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 3;
        System.out.println(searchInsert(nums, target));
        
    }
}
