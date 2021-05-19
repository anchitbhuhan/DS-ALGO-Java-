class Main
{
    public static void main(String[] args) {
        

        int[] A = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        //Using Brute Force
        System.out.println(maxSum(A,k));
        System.out.println(maxSumSW(A,k));

        
    }

    //Brute Force O(n*k)
    public static int  maxSum(int[] A, int k)
    {
        int n = A.length;
        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i <= n-k; i++) { //(n-2) times

            int sum = 0;
            for (int j = i; j <= i+k-1; j++) { // 3 times

                sum += A[j];
            }
            MAX = Math.max(MAX, sum);
        }
        return MAX;
    }


     //Sliding Window O(n)
    public static int  maxSumSW(int[] A, int k)
    {
        int n = A.length;
        int MAX = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;

        while(j<n) // n times
        {
            sum += A[j];

            if( (j-i+1) == k)
            {
                MAX = Math.max(MAX, sum);
                sum -= A[i];
                i++;
                j++;
            }
            else if(j-i+1 < k)
                j++;
        }
        
        return MAX;
    }
}