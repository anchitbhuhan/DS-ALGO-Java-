package com.anchit.climbingStairs;

import java.util.Arrays;

//https://leetcode.com/problems/climbing-stairs/
public class Memoization {

	
	
    /*
    Memoization, Top Down Approach
    Time Complexity - O(N)
    Space Complexity - O(N) + O(N)
    */
    public static int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return recur(n, dp);
        
    }
    
    public static int recur(int n, int[] dp)
    {
    	if(n <= 2)
            return n;
    	
    	if(dp[n] != -1)
    		return dp[n];
    	
        return dp[n] = recur(n-1, dp) + recur(n-2, dp);
    }
	
	
	public static void main(String[] args) {
		
		System.out.println(climbStairs(10));

	}

}
