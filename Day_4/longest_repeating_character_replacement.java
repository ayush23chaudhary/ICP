package Day_4;

public class longest_repeating_character_replacement {
    public static void main(String[] args) {

        String s= "ABAB";
        int k=2;


        int left = 0, n = s.length(), maxLen = 0, maxCount = 0;
        int[] freq = new int[26];
        for(int right = 0; right < n; right++){
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
            if(right - left + 1 - maxCount > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
//        return maxLen;
        System.out.println(maxLen);
    }

}

