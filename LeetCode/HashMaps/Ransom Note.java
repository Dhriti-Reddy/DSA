class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int j=0; j<ransomNote.length(); j++){
            char b = ransomNote.charAt(j);
            if(!map.containsKey(b)){
                return false;
            }
            map.put(b, map.get(b)-1);
            if(map.get(b) == 0){
                map.remove(b);
            }
        }
        return true;
    }
}

//class Solution {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        int[] count = new int[26];
//        for(char c : magazine.toCharArray()){
//            count[c - 'a']++;
//        }
//        for(char c : ransomNote.toCharArray()){
//            count[c - 'a']--;
//            if(count[c - 'a'] < 0){
//                return false;
//            }
//        }
//        return true;
//    }
//}