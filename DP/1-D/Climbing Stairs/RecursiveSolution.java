package com.anchit.climbingStairs;

//https://leetcode.com/problems/climbing-stairs/
public class RecursiveSolution {

	
	
    /*
    Recursion, Top Down Approach
    Time Complexity - O(2^N)
    Space Complexity - O(N)
    */
    public static int climbStairs(int n) {
        
        if(n <= 2)
            return n;
        return climbStairs(n-1) + climbStairs(n-2);
        
    }
	
	
	public static void main(String[] args) {
		
		System.out.println(climbStairs(10));

	}

}
