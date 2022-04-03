//Link to problem: https://leetcode.com/problems/roman-to-integer/

public class Solution {
    Dictionary<string, int> dict1 = new Dictionary<string, int>
    {
        ["I"] = 1,
        ["X"] = 10,
        ["C"] = 100,
        ["M"] = 1000,
    };
    
    Dictionary<string, int> dict2 = new Dictionary<string, int>
    {
        ["V"] = 5,
        ["L"] = 50,
        ["D"] = 500,
    };
    
    public int RomanToInt(string s) {
        var result = 0;
        for(int i = 0 ; i < s.Length ; i++)
        {
            var currChar = s[i].ToString();
            if(dict1.TryGetValue(currChar, out var value))
            {
                if(i + 1 < s.Length)
                {
                    var nextChar = s[i + 1].ToString();
                    if ((dict2.TryGetValue(nextChar, out var nextValue) && nextValue > value) || 
                       (dict1.TryGetValue(nextChar, out nextValue) && nextValue > value))
                        result -= value;
                    else result += value;
                }
                else result += value;
            }
            else if (dict2.TryGetValue(currChar, out var value2)) {
                result += value2;
            }
        }
        return result;
    }
}
