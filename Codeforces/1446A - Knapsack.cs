/*
	Link to problem: https://codeforces.com/problemset/problem/1446/A

	This solution encounters a runtime error on test 3
	TODO: Optimize subset sum (maybe try removing elements instead of building up, try sorting, etc)

	CURRENT LOGIC:
	> Ignore items that exceed weight requirement
	> Return the current item if it satisfies the weight requirement
	> If item weighs less than the weight requirement, add to list of indices that we will iterate
		- Get the SubsetSum of the items in the list (this returns the indices in a subset that satisfies the weight requirement)
		- Return the indices if SubsetSum returned a valid subset

	SubsetSum logic:
	> Iterate over current subsets
	> Check if adding current item to subset will satisfy the requirement
		- If yes, return the valid subset
		- If less than weight requirement, add subset to lookup and subset list
		- If greater than weight requirement, ignore this new subset
	> Add current item to lookup and subset list
	> Return null if no new subset satisfies the requirement
*/

using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
	public static void Main()
	{
		var t = int.Parse(Console.ReadLine());
		
		for(int x = 0 ; x < t ; x++) {
			var nw = Console.ReadLine().Split(' ');
			var n = int.Parse(nw[0]);
			var maxweight = int.Parse(nw[1]);
			var minweight = (maxweight % 2 == 0 ? maxweight : maxweight + 1)/2;
			
			int[] numbers = new int[n];
			var nums = Console.ReadLine().Split(' ');
			for(int j = 0; j < n; j++) {
				numbers[j] = int.Parse(nums[j]);
			}
			
			var index = new List<int>();
			var flag = false;
			
			for(int j=0; j < n && !flag; j++) {
				if(numbers[j] >= minweight && numbers[j] <= maxweight) {
					flag = true;
					Console.WriteLine(1);
					Console.WriteLine((j+1));
				}
				else if(numbers[j] < maxweight)
					index.Add(j);
			}
			
			if(flag)
				continue;
			
			var lookup = new Dictionary<string, int>();
			if(index.Any()) {
				var subsets = new List<string>();
				foreach(var i in index) {
					var subset = SubsetSum(ref numbers, ref lookup, ref subsets, i, minweight, maxweight);
					if(subset != null) {
						flag = true;
						var result = subset.Split(' ');
						Console.WriteLine(result.Length);
						for(int r=0; r < result.Length; r++) {
							Console.Write((int.Parse(result[r]) + 1) + (r < result.Length - 1 ? " " : "\n"));
						}
						break;
					}
				}
				
				if(!flag)
					Console.WriteLine(-1);
			}
			else
				Console.WriteLine(-1);
		}
	}
	
	public static string SubsetSum(
		ref int[] numbers,
		ref Dictionary<string, int> lookup, 
		ref List<string> subsets,
		int index,
		int minweight,
		int maxweight)
	{
		var strIndex = index.ToString();
		var newSubsets = new List<string>(subsets.Count());
		
		foreach(var subset in subsets) {
			var newSubset = subset + " " + strIndex;
			var newSum = lookup[subset] + numbers[index];
			
			if(newSum >= minweight && newSum <= maxweight)
				return newSubset;
			else if(newSum < minweight) {
				newSubsets.Add(newSubset);
				lookup.Add(newSubset, newSum);
			}
		}
		
		subsets.AddRange(newSubsets);
		
		if(!lookup.ContainsKey(strIndex)) {
			lookup.Add(strIndex, numbers[index]);
			subsets.Add(strIndex);
		}
		
		return null;
	}
}
