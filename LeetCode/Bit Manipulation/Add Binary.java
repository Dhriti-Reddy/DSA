class Solution {
    public String addBinary(String a, String b) {
        int result = 0;
        int carry = 0;
        int len = Math.max(a.length(), b.length());
        StringBuilder ans = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {

            int bit1 = (i >= len - a.length()) ? a.charAt(i - (len - a.length())) - '0' : 0;
            int bit2 = (i >= len - b.length()) ? b.charAt(i - (len - b.length())) - '0' : 0;

            result = bit1 + bit2 + carry;

            int ones = result % 2;  
            ans.append(ones);

            carry = result / 2;     
        }

        if (carry != 0) {            
            ans.append(carry);
        }

        return ans.reverse().toString();
    }
}