package Array.Easy;

/*
Problem: Best Time to Buy and Sell Stock
LeetCode: 121
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Greedy / Single Pass

Approach:
Hume stock ek din buy karna hai aur future ke kisi din sell karna hai.
Maximum profit nikalna hai.

Hum minimum buy price track karenge.
Har din check karenge ki agar aaj sell karein to profit kitna banega.
Maximum profit ko update karte rahenge.

Why Greedy / Single Pass?
Because har step par hum best minimum buy price maintain kar rahe hain
aur current price ke saath maximum possible profit calculate kar rahe hain.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC121_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {

        int buyPrice=prices[0];
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            buyPrice=Math.min(buyPrice, prices[i]);
            maxProfit=Math.max(maxProfit, prices[i]-buyPrice);
        }

    return maxProfit;
    }

    public static void main(String[] args) {

        int arr[]={7,6,4,3,1};
        System.out.println(maxProfit(arr));

    }
}
