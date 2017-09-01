package leetcode;

public class LC657 {
    /**
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,
     * which means it moves back to the original place.

     The move sequence is represented by a string. And each move is represent by a character.The valid robot moves are R
     (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

     Example 1:
     Input: "UD"
     Output: true

     Example 2:
     Input: "LL"
     Output: false
     */
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() < 1) return true;
        int x=0, y=0;
        for(int i=0; i<moves.length(); i++) {
            if(moves.charAt(i) == 'U') ++x;
            else if(moves.charAt(i) == 'D') --x;
            else if(moves.charAt(i) == 'L') --y;
            else ++y;
        }
        return x == 0 && y == 0;
    }
}
