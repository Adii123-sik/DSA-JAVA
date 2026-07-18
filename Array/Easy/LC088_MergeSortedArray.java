package Array.Easy;

import java.util.Arrays;

/*
Problem: Merge Sorted Array
LeetCode: 88
Difficulty: Easy
Main Topic: Array / Two Pointers
Optimized Pattern: Three Pointers + Reverse Traversal

Approach:

Hume do integer arrays diye gaye hain:

nums1
nums2

Dono arrays ascending order me sorted hain.

nums1 ke andar total m + n size available hai.

nums1 ke starting ke m elements valid hain.

nums1 ke last ke n positions empty space hain,
jahan nums2 ke elements ko merge karna hai.

nums2 ke andar n valid elements hain.

Example:

nums1 = [1, 2, 3, 0, 0, 0]
m = 3

nums2 = [2, 5, 6]
n = 3

nums1 ke valid elements:

[1, 2, 3]

nums1 ke last ke zeros actual elements nahi hain.

Ye nums2 ke elements ko store karne ke liye
empty positions hain.

nums2 ke valid elements:

[2, 5, 6]

Hume dono arrays ko merge karke sorted result
nums1 ke andar hi store karna hai.

Final nums1:

[1, 2, 2, 3, 5, 6]

Important:

Hume koi new result array return nahi karna hai.

Original nums1 array ko hi modify karna hai.

--------------------------------------------------

Normal Starting Approach Ki Problem:

Agar hum arrays ko starting se merge karenge,
toh nums1 ke valid elements overwrite ho sakte hain.

Example:

nums1 = [1, 2, 3, 0, 0, 0]
nums2 = [2, 5, 6]

Agar starting se nums2 ka element nums1 me insert karenge,
toh nums1 ke existing elements ko shift karna padega.

Isse solution complicated aur slow ho sakta hai.

Isliye hum arrays ko last se merge karenge.

nums1 ke last me already empty positions available hain.

Hum dono arrays ke sabse bade elements compare karenge
aur bade element ko nums1 ki last empty position par rakhenge.

--------------------------------------------------

Three Pointers:

Hum teen pointers use karenge:

i:
nums1 ke last valid element ko point karega.

i = m - 1

j:
nums2 ke last element ko point karega.

j = n - 1

k:
nums1 ki last available position ko point karega.

k = m + n - 1

Example:

nums1 = [1, 2, 3, 0, 0, 0]
               i        k

nums2 = [2, 5, 6]
               j

i = 2
j = 2
k = 5

--------------------------------------------------

Working:

Jab tak nums1 aur nums2 dono me elements available hain,
nums1[i] aur nums2[j] ko compare karenge.

Agar:

nums1[i] > nums2[j]

toh nums1[i] bada element hai.

Use nums1[k] par store karenge.

nums1[k] = nums1[i]

Uske baad i ko ek position peeche karenge.

i--

Otherwise nums2[j] bada ya equal element hoga.

Use nums1[k] par store karenge.

nums1[k] = nums2[j]

Uske baad j ko ek position peeche karenge.

j--

Har element store karne ke baad k ko bhi
ek position peeche karenge.

k--

--------------------------------------------------

Dry Run:

Input:

nums1 = [1, 2, 3, 0, 0, 0]
m = 3

nums2 = [2, 5, 6]
n = 3

Initial pointers:

i = 2
j = 2
k = 5

Step 1:

nums1[i] = 3
nums2[j] = 6

6 bada hai.

nums1[k] = 6

nums1:

[1, 2, 3, 0, 0, 6]

j = 1
k = 4

Step 2:

nums1[i] = 3
nums2[j] = 5

5 bada hai.

nums1[k] = 5

nums1:

[1, 2, 3, 0, 5, 6]

j = 0
k = 3

Step 3:

nums1[i] = 3
nums2[j] = 2

3 bada hai.

nums1[k] = 3

nums1:

[1, 2, 3, 3, 5, 6]

i = 1
k = 2

Step 4:

nums1[i] = 2
nums2[j] = 2

Dono equal hain.

Else condition execute hogi aur nums2[j]
ko nums1[k] par store karenge.

nums1[k] = 2

nums1:

[1, 2, 2, 3, 5, 6]

j = -1
k = 1

Ab nums2 ke saare elements process ho gaye hain.

nums1 ke remaining elements already apni correct
position par hain.

Final Output:

[1, 2, 2, 3, 5, 6]

--------------------------------------------------

Remaining nums2 Elements:

Main comparison loop tab tak chalega jab tak:

i >= 0 && j >= 0

Ho sakta hai nums1 ke elements pehle finish ho jaayein
aur nums2 ke kuch elements bach jaayein.

Example:

nums1 = [4, 5, 6, 0, 0, 0]
m = 3

nums2 = [1, 2, 3]
n = 3

Main loop ke baad nums2 ke elements bach sakte hain.

Isliye nums2 ke remaining elements ko nums1 me
copy karne ke liye ek extra loop chalayenge:

while (j >= 0)

nums1[k] = nums2[j]

nums1 ke remaining elements ke liye extra loop
ki zarurat nahi hai.

Agar nums1 ke elements bach jaate hain,
toh woh already apni correct positions par hote hain.

--------------------------------------------------

Example 1:

Input:

nums1 = [1, 2, 3, 0, 0, 0]
m = 3

nums2 = [2, 5, 6]
n = 3

Output:

[1, 2, 2, 3, 5, 6]

--------------------------------------------------

Example 2:

Input:

nums1 = [1]
m = 1

nums2 = []
n = 0

Output:

[1]

nums2 empty hai.

Isliye nums1 me koi change nahi hoga.

--------------------------------------------------

Example 3:

Input:

nums1 = [0]
m = 0

nums2 = [1]
n = 1

Output:

[1]

nums1 me koi valid element nahi hai.

nums2 ka element nums1 me copy ho jaayega.

--------------------------------------------------

Variables:

i:

nums1 ke last valid element ka index store karta hai.

Starting value:

i = m - 1

j:

nums2 ke last valid element ka index store karta hai.

Starting value:

j = n - 1

k:

nums1 ki last available position ka index store karta hai.

Starting value:

k = m + n - 1

nums1:

Final merged sorted array nums1 ke andar hi
store hota hai.

nums2:

Second sorted array jiske elements nums1 me
merge karne hain.

m:

nums1 me present valid elements ki count.

n:

nums2 me present valid elements ki count.

--------------------------------------------------

Time Complexity: O(m + n)

Worst case me nums1 aur nums2 ke sabhi valid
elements ko ek baar process karenge.

Isliye total time complexity:

O(m + n)

Space Complexity: O(1)

Hum koi extra array use nahi kar rahe hain.

Sirf teen pointer variables use kar rahe hain:

i
j
k

Isliye space complexity:

O(1)
*/

public class LC088_MergeSortedArray {

    public static void merge(
            int[] nums1,
            int m,
            int[] nums2,
            int n
    ) {

        /*
         i nums1 ke last valid element ko
         point karega.

         Example:

         nums1 = [1, 2, 3, 0, 0, 0]
         m = 3

         Last valid element 3 ka index 2 hai.

         i = m - 1
         i = 2
        */
        int i = m - 1;

        /*
         j nums2 ke last valid element ko
         point karega.

         Example:

         nums2 = [2, 5, 6]
         n = 3

         Last element 6 ka index 2 hai.

         j = n - 1
         j = 2
        */
        int j = n - 1;

        /*
         k nums1 ki last available position ko
         point karega.

         nums1 ka total valid final size:

         m + n

         Last index:

         m + n - 1
        */
        int k = m + n - 1;

        /*
         Jab tak nums1 aur nums2 dono arrays me
         compare karne ke liye elements available hain,
         loop chalao.
        */
        while (i >= 0 && j >= 0) {

            /*
             nums1 aur nums2 ke current elements
             ko compare karo.

             Jo element bada hoga,
             use nums1 ki current last position k
             par store karenge.
            */
            if (nums1[i] > nums2[j]) {

                /*
                 Agar nums1[i] bada hai,
                 toh use nums1[k] par store karo.
                */
                nums1[k] = nums1[i];

                /*
                 nums1 ka current element process
                 ho gaya hai.

                 Isliye i ko ek position peeche karo.
                */
                i--;

            } else {

                /*
                 Agar nums2[j] bada ya equal hai,
                 toh use nums1[k] par store karo.
                */
                nums1[k] = nums2[j];

                /*
                 nums2 ka current element process
                 ho gaya hai.

                 Isliye j ko ek position peeche karo.
                */
                j--;
            }

            /*
             nums1 ki current last position fill
             ho chuki hai.

             Isliye k ko ek position peeche karo.
            */
            k--;
        }

        /*
         Ho sakta hai nums1 ke elements pehle
         process ho jaayein aur nums2 ke kuch
         elements bach jaayein.

         nums2 ke remaining elements ko nums1
         me copy karo.
        */
        while (j >= 0) {

            /*
             nums2 ke current element ko nums1 ki
             current empty position par store karo.
            */
            nums1[k] = nums2[j];

            /*
             Dono pointers ko ek position peeche karo.
            */
            j--;
            k--;
        }

        /*
         nums1 ke remaining elements ko copy karne
         ke liye extra loop ki zarurat nahi hai.

         Agar nums1 ke elements bach jaate hain,
         toh woh already nums1 me apni correct
         positions par present hote hain.
        */
    }

    public static void main(String[] args) {

        /*
         nums1 ke starting ke 3 elements valid hain.

         Last ke 3 zeros nums2 ke elements ke liye
         empty positions hain.
        */
        int[] nums1 = {1, 2, 3, 0, 0, 0};

        int m = 3;

        /*
         nums2 me total 3 valid elements hain.
        */
        int[] nums2 = {2, 5, 6};

        int n = 3;

        /*
         Merge hone se pehle arrays print karo.
        */
        System.out.println(
                "nums1 before merge: "
                        + Arrays.toString(nums1)
        );

        System.out.println(
                "nums2: "
                        + Arrays.toString(nums2)
        );

        /*
         Method call karke nums2 ke elements ko
         nums1 me merge karo.
        */
        merge(nums1, m, nums2, n);

        /*
         Merge hone ke baad final nums1 print karo.
        */
        System.out.println(
                "nums1 after merge: "
                        + Arrays.toString(nums1)
        );
    }
}