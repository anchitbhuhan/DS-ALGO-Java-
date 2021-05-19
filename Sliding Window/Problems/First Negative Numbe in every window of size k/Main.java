import java.util.*;

class Main
{
    public static void main(String[] args) {
        

        int[] A = {12, -1, -7, 8, -16, 30, 16, 28};
        int k = 3;


        //Using Brute Force
        System.out.println(firstNeagtive(A,k));

        // //Sliding Window
        // System.out.println(maxSumSW(A,k));
        
        // //Sliding Window 2nd Approach
        // System.out.println(maxSumSW2(A,k));

        
    }


    // O(n*k)
    public static List<Integer>  firstNeagtive(int[] A, int k)
    {
        int n = A.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n-k; i++) { //(n-k) times

            for (int j = i; j <= i+k-1; j++) { // k times

                if(A[j]<0)
                {
                    res.add(A[j]);
                    break;
                }
            }
        }
        return res;
    }


    // public static int  maxSumSW(int[] A, int k)
    // {
    //     return max;
    // }


    // public static int  maxSumSW2(int[] A, int k)
    // {
        
    // }
}