package coding_problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArraySumEqualsK {

    public static void main(String[] args) {

        /*
            Negatives:
            - nums = [1, -1, 0], k = 0 → subarrays: [1,-1], [0], [1,-1,0] → 3

            All zeros:
            - nums = [0,0,0], k = 0 → 6 subarrays

            Mixed:
            - nums = [3,1,2,4], k = 6 → [3,1,2], [2,4] → 2 ✅ (your example)
        */

        int[] arr = {1,1,1};
        int targetSum = 2;

        System.out.println(getCountOfSubArraysUsingBruteForce(arr, targetSum));
        System.out.println(getCountOfSubArraysUsingOptimalApproach(arr, targetSum));
    }

    private static long getCountOfSubArraysUsingOptimalApproach(int[] arr, int targetSum) {

        long subArrayCount = 0L;
        long prefixSum = 0L;

        Map<Long, Long> freqmap = new HashMap<>();
        freqmap.put(0L,1L);

        for (int j : arr) {

            prefixSum += j;
            long neededPrefix = prefixSum - targetSum;

//            if(freqmap.containsKey(neededPrefix)) {
//                subArrayCount += freqmap.get(neededPrefix);
//            }

            // Optimization step to avoid Map Contains and get operations immediately to avoid ambiguity
            Long freq = freqmap.get(neededPrefix);
            if (freq != null)
                subArrayCount += freq;

            freqmap.put(prefixSum, freqmap.getOrDefault(prefixSum, 0L) + 1);
        }


        return subArrayCount;
    }

    private static int getCountOfSubArraysUsingBruteForce(int[] arr, int targetSum) {

        int arrayCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];

                if(sum == targetSum)
                    arrayCount++;
            }
        }

        return arrayCount;
    }
}
