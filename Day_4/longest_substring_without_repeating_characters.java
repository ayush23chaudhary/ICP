package Day_4;

import java.util.*;

public class longest_substring_without_repeating_characters {
    public static void main(String[] args) {

        String s="abcabcbb";

        int maxLength = 0;
        int l = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c, 0) + 1);

            while (count.get(c) > 1) {
                char leftChar = s.charAt(l);
                count.put(leftChar, count.get(leftChar) - 1);
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }

//        return maxLength;
        System.out.println(maxLength);
    }
}
