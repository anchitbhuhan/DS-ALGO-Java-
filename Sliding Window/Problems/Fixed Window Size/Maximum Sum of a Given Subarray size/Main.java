class Main
{
    public static void main(String[] args) {
        

        int[] A = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        //Using Brute Force
        System.out.println(maxSum(A,k));

        //Sliding Window
        System.out.println(maxSumSW(A,k));
        
        //Sliding Window 2nd Approach
        System.out.println(maxSumSW2(A,k));

        
    }

    //Brute Force O(n*k)
    public static int  maxSum(int[] A, int k)
    {
        int n = A.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n-k; i++) { //(n-2) times

            int sum = 0;
            for (int j = i; j <= i+k-1; j++) { // 3 times

                sum += A[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }


     //Sliding Window O(n)
    public static int  maxSumSW(int[] A, int k)
    {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;

        while(j<n) // n times
        {
            sum += A[j];

            if( (j-i+1) == k)
            {
                max = Math.max(max, sum);
                sum -= A[i];
                i++;
                j++;
            }
            else if(j-i+1 < k)
                j++;
        }
        
        return max;
    }


    // O(n)
    public static int  maxSumSW2(int[] A, int k)
    {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < k; i++) { // k times
            
            sum += A[i];
        }

        max = sum;

        for (int j = k; j < n; j++) { // n-k times
            
            sum = sum  + A[j] - A[j-k];
            max = Math.max(max, sum);
        }
        return max;
    }
}