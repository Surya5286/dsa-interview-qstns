package coding_problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {

    public static void main(String[] args) {

        String str = "abc";


        List<String> subsequenceList = getSubsequenceUsingBitManipulation(str);
        System.out.println("Printing all the Subsequences using Bit Manipulation Approach:- " + subsequenceList + "\n" +
                "Total number of Combinations are :- " + subsequenceList.size());

        subsequenceList.clear();

        subsequenceList = getSubsequenceUsingRecursion(str);
        System.out.println("Printing all the Subsequences using Recursion:- " + subsequenceList + "\n" +
                "Total number of Combinations are :- " + subsequenceList.size());

    }

    private static List<String> getSubsequenceUsingBitManipulation(String str) {

        int n = str.length();
        List<String> result = new ArrayList<>();

        int totalCombinations = 1 << n;

        for (int mask = 0; mask < totalCombinations; mask++) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if((mask & (1<<i)) != 0)
                    sb.append(str.charAt(i));
            }
            result.add(sb.toString());
        }

        return result;
    }

    private static List<String> getSubsequenceUsingRecursion(String str) {

        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        helper(str, 0, current, result);
        return result;
    }

    private static void helper(String str, int index, StringBuilder current, List<String> result) {

        if(index == str.length()){
            result.add(current.toString());
            return;
        }

        // Not Take condition
        helper(str, index + 1, current, result);

        // Take Condition
        current.append(str.charAt(index));
        helper(str, index + 1, current, result);

        // BackTrack by removing last Character
        current.deleteCharAt(current.length() - 1);
    }
}
