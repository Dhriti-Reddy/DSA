class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
        }
        for(int j=0; j<t.length(); j++){
            char d = t.charAt(j);
            if(!map.containsKey(d)){
                return false;
            }
            map.put(d, map.get(d) - 1);
            if(map.get(d) == 0){
                map.remove(d);
            }
        }
        return map.isEmpty();
    }
}

//if(s.length() != t.length()) return false;
//int[] count = new int[26];
//for(int i = 0; i < s.length(); i++){
    //count[s.charAt(i) - 'a']++;
    //count[t.charAt(i) - 'a']--; 
//}
//for(int c : count){
    //if(c != 0) return false;
//}
//return true;