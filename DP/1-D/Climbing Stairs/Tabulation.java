package com.anchit.climbingStairs;

//https://leetcode.com/problems/climbing-stairs/
public class Tabulation {

	
	
    /*
    Tabulation, Top Down Approach
    Time Complexity - O(N)
    Space Complexity - O(N)
    */
    public static int climbStairs(int n) {
        
    	if(n < 2)
    		return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++)
        {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
        
    }
    
	
	
	public static void main(String[] args) {
		
		System.out.println(climbStairs(10));

	}

}
