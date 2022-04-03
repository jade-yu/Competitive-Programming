//Link to problem: https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

public class Solution {
    public int CountGoodRectangles(int[][] rectangles) {
        var maxlen = int.MinValue;
        var ctr = 0;
        foreach(var rectangle in rectangles) {
            var sq = Math.Min(rectangle[0], rectangle[1]);
            if(sq > maxlen) {
                maxlen = sq;
                ctr = 0;
            }
            if(sq == maxlen)
                ctr++;
        }
        return ctr;
    }
}
