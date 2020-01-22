public class Problem30{

	public static int getValume(int[] height){
		int n = height.length;
		if(n < 3){
			return 0;
		}
		int result = 0;
		for(int i=1; i<n-1; i++){
			int l = i-1;
			int r = i+1;
			int maxL = height[l];
			int maxR = height[r];
			while(l >= 0){
				maxL = Math.max(maxL, height[l]);
				l--;
			}
			while(r < n){
				maxR = Math.max(maxR, height[r]);
				r++;
			}
			int min = Math.min(maxL, maxR);
			if(min > height[i]){
				result += (min - height[i]);
			}
		}
		return result;
	}

	public static void main(String[] args){

		int[] height = {2, 0, 2};
		int result = getValume(height);
		System.out.println(result);

	}
}

/*
This problem was asked by Facebook.

You are given an array of non-negative integers that represents a 
two-dimensional elevation map where each element is unit-width wall and the integer is the height. 
Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second,
 and 3 in the fourth index (we cannot hold 5 since it would run off to the left), 
 so we can trap 8 units of water.
*/