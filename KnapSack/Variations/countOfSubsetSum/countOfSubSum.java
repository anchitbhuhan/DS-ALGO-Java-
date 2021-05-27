import java.util.Arrays;

public class countOfSubSum {
    int n;
    int[] Arr;
    int sum;
    int[][] t;

    // Constructor
    public countOfSubSum(int[] Arr, int sum) {
        this.n = Arr.length;
        this.Arr = Arr;
        this.sum = sum;
        t = new int[n + 1][sum + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

    }

    // Helper Method
    public int countSubset() {
        return recursiveCountSetSum(n, sum);
    }

    // Recursive Brute-Force Approach
    int recursiveCountSetSum(int n, int sum) {

        if (sum == 0)
            return 1;

        else if (n == 0)
            return 0;
        else {

            if (Arr[n - 1] <= sum)
                return (recursiveCountSetSum(n - 1, sum - Arr[n - 1]) + recursiveCountSetSum(n - 1, sum));
            else
                return recursiveCountSetSum(n - 1, sum);

        }
    }

    // Recursive Memoized Approach
    int recursiveMemoCountSetSum(int n, int sum) {

        if (sum == 0)
            return 1;

        else if (n == 0)
            return 0;

        else if (t[n][sum] != -1)
            return t[n][sum];
        else {

            if (Arr[n - 1] <= sum) {

                t[n][sum]= (recursiveMemoCountSetSum(n - 1, sum - Arr[n - 1]) + recursiveMemoCountSetSum(n - 1, sum));
                return t[n][sum] ;
                
            } else 
            {

                t[n][sum] = recursiveMemoCountSetSum(n - 1, sum);
                return t[n][sum];
                
            }

        }
    }

    // Bottom-Up KnapSack
    int bottomUpsubSetSum(int n, int sum) {

        for (int i = 0; i < n + 1; i++) {
            
            for (int j = 0; j < sum + 1; j++) {
                
                if (j == 0)
                    t[i][j] = 1;
                else if (i == 0)
                    t[i][j] = 0;
                else {
                    if (Arr[i - 1] <= j)
                        t[i][j] = t[i - 1][j - Arr[i - 1]] + t[i - 1][j];
                    else
                        t[i][j] = t[i - 1][j];
                }
                
            }
        }

        return t[n][sum];
    }

}
