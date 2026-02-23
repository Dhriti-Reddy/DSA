class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int digit = 0;
        int reversed = 0;
        if(x < 0){
            return false;
        }
        while(x != 0){
            digit = x % 10;
            x = x / 10;
            reversed = reversed * 10 + digit;
        }
        if(original == reversed){
            return true;
        }
        else{
            return false;
        }
    }
}