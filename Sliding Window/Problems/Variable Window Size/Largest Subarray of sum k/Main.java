import java.util.*;
class Main
{
    public static void main(String[] args) {
        

        int[] A = {4,1,1,1,2,3,5};
        // int[] A = {-5,8,-40,2,4,12};
        int k = 5;

        //Variable Sliding Window
        System.out.println(LargestSubArray(A, k));
    }

    public static int LargestSubArray(int[] A, int k)
    {
        int i = 0;
        int j = 0;
        int n = A.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while(j<n)
        {
            sum += A[j];

            if(sum==k)
            {
                max = Math.max(max, (j-i+1));
                j++;

            }else if(sum<k)
                j++;
            else
            {
                while(sum>k)
                {
                    sum -= A[i];
                    i++;
                }
                j++;
            }
        }
        return max;

    }
}