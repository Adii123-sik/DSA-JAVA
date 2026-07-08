 package Array.Easy;
 import java.util.*;

 /*

Problem: Contains Duplicate
LeetCode: 227
Difficulty: Easy
Main Topic: Array
Optimized By using Hashset


approch: by using a hashset ak new hashset create krlenge hashset duplicate element store nhii krta h toh
har k nums[i] k liye check krengee kya voh hashset m present h agr present hoga toh true return
or present nhii hoga toh usse hum hashset  m add krdengeeee  or agr element nhiii miltaa h loop
k end tak toh....false return;
 
 
 */


class LC227_ContainsDuplicate {

    public static boolean isDulicate(int nums[]){

        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
    return false;
        
    }

    public static void main(String[] args) {

        int nums[]={1,2,4,5,3,2};
        System.out.println(isDulicate(nums));
        
    }

    
}