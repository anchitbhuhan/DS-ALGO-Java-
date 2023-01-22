package com.anchit.climbingStairs;

//https://leetcode.com/problems/climbing-stairs/
public class SpaceOptimized {

	
	
    /*
    Space Optimized, Top Down Approach
    Time Complexity - O(N)
    Space Complexity - O(1)
    */
	public static int climbStairs(int n) {
        
    	if(n < 2)
    		return n;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++)
        {
        	dp[i%3] = dp[(i-1)%3] + dp[(i-2)%3];
        }
        
        return dp[n%3];
        
    }
    
	
	
	public static void main(String[] args) {
		
		System.out.println(climbStairs(10));

	}

}
