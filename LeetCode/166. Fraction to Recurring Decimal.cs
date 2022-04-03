//Link to problem: https://leetcode.com/problems/fraction-to-recurring-decimal/

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
