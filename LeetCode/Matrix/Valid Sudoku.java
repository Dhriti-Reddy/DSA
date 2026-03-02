import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> setr = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (setr.contains(val)) return false;
                    setr.add(val);
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            Set<Character> setc = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char val = board[i][j];
                if (val != '.') {
                    if (setc.contains(val)) return false;
                    setc.add(val);
                }
            }
        }
        for (int rowstart = 0; rowstart < 9; rowstart += 3) {
            for (int colstart = 0; colstart < 9; colstart += 3) {
                Set<Character> setbox = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char val = board[rowstart + i][colstart + j];
                        if (val != '.') {
                            if (setbox.contains(val)) return false;
                            setbox.add(val);
                        }
                    }
                }
            }
        }
        return true;
    }
}