import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxlength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            while(map.containsKey(c)){
                char leftchar = s.charAt(left);
                map.remove(leftchar);
                left++;
            }
            map.put(c, right);
            int windowlength = right - left + 1;
            maxlength = Math.max(windowlength, maxlength);
        }
        return maxlength;
    }
}