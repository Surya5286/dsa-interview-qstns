package coding_problems.sliding_window;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {

        var inputString = "cadbzabcd";

        System.out.println(getMaxSubstringLengthUsingBruteForceApproach(inputString));
        System.out.println(getMaxSubstringLengthUsingSlidingWindow(inputString));

    }

    private static int getMaxSubstringLengthUsingBruteForceApproach(String str) {

        if (str == null || str.isEmpty()) return 0;

        int maxLength = 0;
        int[] hash = new int[256];


        for (int i = 0; i < str.length(); i++) {
            Arrays.fill(hash, 0);
            for (int j = i; j < str.length(); j++) {

                char ch = str.charAt(j);
                if(hash[ch] != 0)
                    break;

                maxLength = Math.max(maxLength, j-i+1);
                hash[ch] = 1;
            }
        }

        return maxLength;
    }


    private static int getMaxSubstringLengthUsingSlidingWindow(String str) {

        if (str == null || str.isEmpty()) return 0;

        int maxLen = 0;
        int l = 0;
        int r = 0;

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while(r < str.length()) {

            char ch = str.charAt(r);
            if(hash[ch] != -1) {
                if(hash[ch] >= l)
                    l = hash[ch] + 1;
            }

            maxLen = Math.max(maxLen, r-l+1);
            hash[ch] = r;
            r++;
        }

        return maxLen;
    }
}