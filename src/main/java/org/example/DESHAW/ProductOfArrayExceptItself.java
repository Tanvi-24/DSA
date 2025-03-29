package org.example.DESHAW;

import java.util.Arrays;
/*
    Ek int[] nums array dilela aahe. Tumhala pratek index sathi product of all other elements calculate
    karaycha aahe without using division and in O(n) time.
    ✅ Logic (Prefix & Suffix Product):
    Use two passes:
    Left to Right (Prefix Product)
    Store product of all elements to the left of current index.
    Right to Left (Suffix Product)
    Multiply previously stored values with product of all elements to the right.
    ✅ Code Explanation:
    int[] answer = new int[nums.length];
    int prefix_product = 1;
    int suffix_product = 1;
    1️⃣ First Loop:
    for (int i = 0; i < nums.length; i++) {
        answer[i] = prefix_product;
        prefix_product *= nums[i];
    }
    answer[i] gets product of elements before i
    2️⃣ Second Loop:
    for (int j = nums.length - 1; j >= 0; j--) {
        answer[j] *= suffix_product;
        suffix_product *= nums[j];
    }
    Multiply answer[j] with product of elements after j
    ✅ Example:
    Input: [1, 2, 3, 4]
    Prefix: [1, 1, 2, 6]
    Suffix: [24, 12, 4, 1]
    Final Answer: [24, 12, 8, 6]
    ✅ Time & Space Complexity:
    Time: O(n)
    Space: O(1) (excluding output array)
    ✅ Conclusion:
    He code product calculation karat without using division, ani optimal space madhe run hota.
    Useful in system design, competitive coding, etc.
 */
public class ProductOfArrayExceptItself {

    public static int[] productExceptSelf(int[] nums) {
        int answer[] = new int[nums.length];
        int prefix_product=1;
        int suffix_product=1;

        for(int i=0;i<nums.length;i++){
            answer[i]=prefix_product;
            prefix_product=prefix_product*nums[i];
        }

        for(int j=(nums.length)-1;j>=0;j--){
            answer[j]*=suffix_product;
            suffix_product= suffix_product*nums[j];
        }
        return answer;
    }

    public static void main(String[] args) {
        Arrays.stream(productExceptSelf(new int[]{1, 2, 3, 4})).forEach(System.out::println);
    }
}
