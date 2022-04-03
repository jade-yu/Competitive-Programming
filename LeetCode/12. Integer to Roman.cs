//Link to problem: https://leetcode.com/problems/integer-to-roman/

public class Solution {
    char[] romanNums = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    public string IntToRoman(int num) {
        var sb = new StringBuilder();
        var curr = 1000;
        var currIndex = 0;
        
        while(curr > 0 && currIndex < romanNums.Count())
        {
            var value = num / curr;
            if (value >= 5 && value != 9)
            {
                sb.Append(romanNums[currIndex - 1]);
                value -= 5;
            }
            switch(value)
            {
                case 0:
                    break;
                case 4:
                    sb.Append($"{romanNums[currIndex]}{romanNums[currIndex - 1]}");
                    break;
                case 9:
                    sb.Append($"{romanNums[currIndex]}{romanNums[currIndex - 2]}");
                    break;
                default:
                    sb.Append(new String(romanNums[currIndex], value));
                    break;
            }
            
            num %= curr;
            curr /= 10;
            currIndex += 2;
        }
        
        return sb.ToString();
    }
}
