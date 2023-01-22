package com.anchit.BestTimeToBuyAndSellStock;

import java.util.Arrays;

public class Memoization {

	
	class Solution {
		public int maxProfit(int[] prices) {
	        
	        int[] dp = new int[prices.length+1];
	        Arrays.fill(dp, -1);
	        return func(prices.length-1, prices, dp);
	    }
	    
	    public int func(int idx, int[] prices, int[] dp)
	    {
	        if(idx == 0)
	            return 0;
	        if(dp[idx] != -1)
	            return dp[idx];
	        
	        int max = Integer.MIN_VALUE;
	        
	        for(int j=0; j<idx; j++)
	        {
	            max = Math.max(max, (prices[idx] - prices[j]));
	        }
	        
	        
	        return dp[idx] = Math.max(max, func(idx-1, prices, dp));
	    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
