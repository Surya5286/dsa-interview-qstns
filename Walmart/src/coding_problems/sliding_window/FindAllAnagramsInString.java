package coding_problems.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {

    public static void main(String[] args) {

        var str = "cbaebabacdbaa";
        var pattern = "aab";

        System.out.println("Start Indexes Of the Anagrams are : " + getStartIndexOfAnagramsUsingSlidingWindow(str, pattern));
        System.out.println("Start Indexes Of the Anagrams are : " + getStartIndexOfAnagramsUsingSlidingWindowOptimizedApproach(str, pattern));

    }

    private static List<Integer> getStartIndexOfAnagramsUsingSlidingWindow(String str, String pattern) {

        // result list to return
        List<Integer> indexList = new ArrayList<>();

        if(str.length() < pattern.length())
            return indexList;

        int[] pcount = new int[26];
        int[] scount = new int[26];

        for (int i = 0; i < pattern.length(); i++) {
            pcount[pattern.charAt(i) - 'a']++;
            scount[str.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pcount, scount))
            indexList.add(0);

        for (int i = pattern.length(); i < str.length(); i++) {

            scount[str.charAt(i) - 'a']++;
            scount[str.charAt(i - pattern.length()) - 'a']--;

            if (Arrays.equals(pcount, scount))
                indexList.add(i - pattern.length() + 1);

        }
        return indexList;
    }

    // Optimized and Clean variation for Senior Role Candidates.
    private static List<Integer> getStartIndexOfAnagramsUsingSlidingWindowOptimizedApproach(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] freq = new int[26];
        for (char c : p.toCharArray()) freq[c - 'a']++;

        int left = 0, right = 0;
        int count = p.length();

        while (right < s.length()) {
            int r = s.charAt(right) - 'a';
            if (freq[r] > 0) count--;
            freq[r]--;
            right++;

            if (right - left == p.length()) {
                if (count == 0) res.add(left);

                int l = s.charAt(left) - 'a';
                freq[l]++;
                if (freq[l] > 0) count++;
                left++;
            }
        }
        return res;
    }

}
