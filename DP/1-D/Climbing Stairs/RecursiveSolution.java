//https://leetcode.com/problems/climbing-stairs/
public class RecursiveSolution {

	
	
    /*
    Recursion, Top Down Approach
    Time Complexity - 
    Space Complexity - 
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
