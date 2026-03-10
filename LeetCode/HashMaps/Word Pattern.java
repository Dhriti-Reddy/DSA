class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<words.length; i++){
            char p = pattern.charAt(i);
            String w = words[i];
            if(map.containsKey(p)){
                if(!map.get(p).equals(w)){
                    return false;
                }
            }
            else{
                if(set.contains(w)){
                    return false;
                }
                map.put(p, w);
                set.add(w);
            }
        }
        return true;
    }
}