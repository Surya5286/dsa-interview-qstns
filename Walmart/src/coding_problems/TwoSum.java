package coding_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(printTargetIndiciesBruteForceAppraoch(nums, target)));
        System.out.println(Arrays.toString(printTargetIndiciesBetterAppraoch(nums, target)));
        System.out.println(Arrays.toString(printTargetIndiciesOptimalAppraoch(nums, target)));

    }

    private static int[] printTargetIndiciesOptimalAppraoch(int[] nums, int target) {

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            if(nums[start] + nums[end] == target)
                return new int[] {start, end};
            else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }

        return new int[] {-1, -1};
    }

    private static int[] printTargetIndiciesBetterAppraoch(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int requiredInt = target - nums[i];
            Integer j = indexMap.get(requiredInt);
            if(j != null)
                return new int[] {Math.min(i, indexMap.getOrDefault(requiredInt, -1)), Math.max(i, indexMap.getOrDefault(requiredInt, -1))};

            indexMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    private static int[] printTargetIndiciesBruteForceAppraoch(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[] {Math.min(i,j), Math.max(i,j)};
            }
        }

        return new int[] {-1, -1};
    }
}
