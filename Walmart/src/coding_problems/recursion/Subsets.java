package coding_problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] arr = {2,1,1};
        List<List<Integer>> result1 = getSubsetsUsingRecursiveApproach(arr);
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Recursive Subset Count :- " + result1.size());
        System.out.println("Recursive Subsets :- " + result1);

        System.out.println();

        // To handle the duplicates need to update slightly the approach to solve using Iterative approach.
        List<List<Integer>> subsets1 = getUniqueSubsets(arr);
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Unique Subset Count :- " + subsets1.size());
        System.out.println("Unique Subsets :- " + subsets1);

        System.out.println("------------------------------------------------");

        int[] arr2 = {0, 0, 0};

        List<List<Integer>> result2 = getSubsetsUsingRecursiveApproach(arr2);
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Recursive Subset Count :- " + result2.size());
        System.out.println("Recursive Subsets :- " + result2);

        System.out.println();

        List<List<Integer>> subsets2 = getUniqueSubsets(arr2);
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Unique Subset Count :- " + subsets2.size());
        System.out.println("Unique Subsets :- " + subsets2);
    }

    private static List<List<Integer>> getSubsetsUsingRecursiveApproach(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        helper(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] arr, int index, List<Integer> currentList, List<List<Integer>> result) {

        if (index == arr.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Not Take Condition
        helper(arr, index+1, currentList, result);

        // Take Condition
        currentList.add(arr[index]);
        helper(arr, index+1, currentList, result);

        // Backtrack the current List by removing last element
        currentList.removeLast();
    }

    private static List<List<Integer>> getUniqueSubsets(int[] arr) {

        if (arr == null)
            return List.of();

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        List<List<Integer>> result = new ArrayList<>();
        uniqueSubsetHelper(sortedArr, 0, new ArrayList<>(), result);

        return result;
    }

    private static void uniqueSubsetHelper(int[] arr, int startIndex, List<Integer> currentList, List<List<Integer>> result) {

        // Add a snapshot of the current subset
        result.add(new ArrayList<>(currentList));

        for (int i = startIndex; i < arr.length ; i++) {

            // Skip duplicates at the same recursion depth
            if(i > startIndex && arr[i] == arr[i-1])
                continue;

            currentList.add(arr[i]);
            uniqueSubsetHelper(arr, i+1, currentList, result);
            currentList.removeLast(); // Backtrack
        }
    }
}
