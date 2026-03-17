class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int currentrow = 0;
        boolean goingdown = true;
        StringBuilder[] row = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            row[i] = new StringBuilder();
        }
        for(char c : s.toCharArray()){
            row[currentrow].append(c);
            if(currentrow == 0){
                goingdown = true;
            }
            else if(currentrow == numRows - 1){
                goingdown = false;
            }

            if(goingdown){
                currentrow++;
            }
            else{
                currentrow--;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i<numRows; i++){
            result.append(row[i]);
        }
        return result.toString();
    }
}