/*
    Link: https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

    > Get the smaller side from each rectangle (this is the maximum size of the square we can create for each rectangle)
    > Reset counter if maxlen is overwritten
    > Add to counter if square is equal to maxlen
*/

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
