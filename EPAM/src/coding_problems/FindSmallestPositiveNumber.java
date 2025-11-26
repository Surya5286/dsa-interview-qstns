package coding_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindSmallestPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingSorting(arr));

        int[] arr2 = {1, 2, 0};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingSorting(arr2));

        int[] arr3 = {7, 8, 9, 11, 12};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingTreeSet(arr3));

        int[] arr4 = {-3, -2, -1};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingTreeSet(arr4));

        int[] arr5 = {-3, -2, -1, 1, 2, 3};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingSet(arr5));
    }

    private static int findSmallestMissingPositiveUsingSorting(int[] arr) {

        Arrays.sort(arr);
        int smallestMissing = 1;
        for (int i = 0; i < arr.length; i++) {

            if(arr[i] <= 0)
                continue;

            if (i+1 < arr.length && arr[i] == arr[i + 1])
                continue; // Skip duplicates
            else {
                if (arr[i] == smallestMissing) {
                    smallestMissing++;
                } else if (arr[i] > smallestMissing) {
                    break; // No need to check further
                }
            }

        }

        return smallestMissing;
    }

    private static int findSmallestMissingPositiveUsingTreeSet(int[] arr) {

        int smallestMissing = 1;
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0)
                set.add(arr[i]);
        }

        for (Integer num : set) {
            if (num == smallestMissing) {
                smallestMissing++;
            } else if (num > smallestMissing) {
                break; // No need to check further
            }
        }

        return smallestMissing;
    }

    private static int findSmallestMissingPositiveUsingSet(int[] arr) {
        int smallestMissing = 1;

        if(arr == null || arr.length == 0)
            return smallestMissing;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0)
                set.add(arr[i]);
        }

        while (set.contains(smallestMissing)) {
            smallestMissing++;
        }

        return smallestMissing;
    }
}
