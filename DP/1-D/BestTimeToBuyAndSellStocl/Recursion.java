package com.anchit.BestTimeToBuyAndSellStock;

public class Recursion {

	
	class Solution {
	    public int maxProfit(int[] prices) {
	        return func(prices.length-1, prices);
	    }
	    
	    public int func(int idx, int[] prices)
	    {
	        if(idx == 0)
	            return 0;
	        
	        int max = Integer.MIN_VALUE;
	        
	        for(int j=0; j<idx; j++)
	        {
	            max = Math.max(max, (prices[idx] - prices[j]));
	        }
	        
	        
	        return Math.max(max, func(idx-1, prices));
	    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
