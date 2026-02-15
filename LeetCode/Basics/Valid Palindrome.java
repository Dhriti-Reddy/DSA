class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        String reversed = "";
        for(int i = s.length()-1; i>=0; i--){
            reversed += s.charAt(i);
        }
        return s.equals(reversed);
    }
}