/*
    Link: https://leetcode.com/problems/fraction-to-recurring-decimal/

    Took a few tries because of some corner cases that I failed to take into consideration (negative numbers, overflow)

    Important notes:
    > Check if numerator and denominator are negative and create a negative flag for the final result
    > Convert numbers to long and take the absolute values
        - use absolute value to avoid complications with negative numbers
        - long type needed for test case with int.MinValue
    > Calculate remainder
        - for each iteration, store the index of the remainder (so we can go back to insert the parenthesis where we encountered that remainder)
        - we can stop when we encounter a remainder we've encountered (since we know that the next divisions after this will be the repeating digits) and insert the parenthesis in the corresponding index
*/

public class Solution {
    public string FractionToDecimal(int numerator, int denominator) {
        var sb = new StringBuilder();
        
        var negative = numerator != 0 && (numerator < 0 ^ denominator < 0);
        var num = Math.Abs((long)numerator);
        var denom = Math.Abs((long)denominator);
        var r = num % denom;
        var flag = true;
        if (r > 0)
        {
            var currIndex = 0;
            var done = new Dictionary<long, int>();
            while(r > 0 && flag) {
                done[r] = currIndex;
                r *= 10;
                var temp = r / denom;
                sb.Append(temp);
                r %= denom;
                if (done.ContainsKey(r)) {
                    sb.Insert(done[r], '(');
                    sb.Append(')');
                    flag = false;
                }
                currIndex++;
            }

            sb.Insert(0, ".");
        }

        sb.Insert(0, num / denom);
        if (negative)
            sb.Insert(0, '-');
        return sb.ToString();
    }
}
