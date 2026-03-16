class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        String result = "";
        for(int i=strs.length-1; i>=0; i--){
            result += strs[i];
            if(i != 0){
                result += " ";
            }
        }
        return result;
    }
}