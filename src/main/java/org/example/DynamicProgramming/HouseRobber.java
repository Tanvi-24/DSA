package org.example.DynamicProgramming;

/*You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.*/

/*
    Tumi ek robber ahat, jya street madhil gharatun paisa choryacha plan kartoy.
    Condition:
    Tumhi adjacent ghar nahi chorू शकत (security alert yeil).
    nums[] ha array dila aahe jithe pratek gharachya paisach value ahe.
    Find the maximum amount je tumhi chorू shakta without robbing adjacent houses.
    Dynamic Programming (Bottom-Up)
    We decide at each house whether to rob it or skip it based on max profit.
    Let dp[i] = max money rob-able from house 0 to i.
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    For each i from 2 to n-1:
    dp[i] = max(nums[i] + dp[i-2], dp[i-1])
    rob current + i-2 OR skip current
    He DP problem classic ahe, je maximum non-adjacent sum kadhnyacha example ahe.
    Real-world + interview-friendly scenario.

    Let's walk through an example step-by-step and prove why returning dp[n-1] is correct,
    and why dp[n] may be wrong or irrelevant — depending on how you compute it.
    Let’s Take an Example:

    nums = {2, 7, 9, 3, 1};
    n = nums.length = 5;
    We’ll simulate the DP process as per your code:
    Step 1: Initialization
    dp[0] = nums[0] = 2
    dp[1] = Math.max(nums[0], nums[1]) = Math.max(2, 7) = 7
    Now dp = [2, 7, _, _, _, _]
    Step 2: DP Loop
    i = 2: dp[2] = max(nums[2] + dp[0], dp[1]) = max(9 + 2, 7) = 11
    i = 3: dp[3] = max(nums[3] + dp[1], dp[2]) = max(3 + 7, 11) = 11
    i = 4: dp[4] = max(nums[4] + dp[2], dp[3]) = max(1 + 11, 11) = 12
    At this point:
    dp = [2, 7, 11, 11, 12, _]
    Step 3: Extra line in your code:
    dp[i] = Math.max(dp[i-2], dp[i-1]); // this writes into dp[5], i.e. dp[n]
    i = 5 now (after loop)
    dp[5] = max(dp[3], dp[4]) = max(11, 12) = 12
    So now:
    dp = [2, 7, 11, 11, 12, 12]
    🔍 Now let’s compare:
    dp[n-1] = dp[4] = 12 ✅
    dp[n] = dp[5] = 12 ✅
    Seems same, but why is dp[n] wrong? Here's why:
    ⚠️ Key Point:

    dp[n] is not part of the actual valid DP state.
    dp[i] = max(nums[i] + dp[i-2], dp[i-1]) is defined only for 0 to n-1
    When you calculate dp[n] = max(dp[n-2], dp[n-1]), you're skipping the last house's value (nums[4] = 1) completely.
    You’re just doing a comparison between two prior states — not considering the last house's value at all, and thus logically it's an irrelevant and redundant value.
    ✅ Conclusion

    Return Value	Valid?	Reason
    dp[n-1]	✅ Yes	Represents optimal solution up to last house
    dp[n]	❌ No	Computed outside the valid DP range and skips last house's value
    🧠 Final Fix (Correct Code):

    return dp[n-1]; // ✅ Always correct
    Let me know if you want the optimized version too (O(1) space)!
 */
public class HouseRobber {
    public static int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            Math.max(nums[0],nums[1]);
        }

        int n = nums.length;
        int dp[] = new int[n+1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int i=2;
        for(;i<nums.length;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        dp[i] = Math.max(dp[i-2],dp[i-1]);
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }
}
