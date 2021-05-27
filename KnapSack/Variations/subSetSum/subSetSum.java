import java.util.Arrays;

public class subSetSum {
    int n;
    int[] Arr;
    int sum;
    int[][] t;

    // Constructor
    public subSetSum(int[] Arr, int sum) {
        this.n = Arr.length;
        this.Arr = Arr;
        this.sum = sum;
        t = new int[n + 1][sum + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

    }

    // Helper Method
    public boolean isSumPossible() {
        return bottomUpsubSetSum(n, sum);
    }

    // Recursive Brute-Force Approach
    boolean recursivesubSetSum(int n, int sum) {

        if (sum == 0)
            return true;

        else if (n == 0)
            return false;
        else {

            if (Arr[n - 1] <= sum)
                return (recursivesubSetSum(n - 1, sum - Arr[n - 1]) || recursivesubSetSum(n - 1, sum));
            else
                return recursivesubSetSum(n - 1, sum);

        }
    }

    // Recursive Memoized Approach
    boolean recursiveMemosubSetSum(int n, int sum) {

        if (sum == 0)
            return true;

        else if (n == 0)
            return false;

        else if (t[n][sum] != -1)
            return t[n][sum] == 1 ? true : false;
        else {

            if (Arr[n - 1] <= sum) {
                boolean res = (recursivesubSetSum(n - 1, sum - Arr[n - 1]) || recursivesubSetSum(n - 1, sum));
                t[n][sum] = res ? 1 : 0;
                return res;
            } else {
                boolean res = recursivesubSetSum(n - 1, sum);
                t[n][sum] = res ? 1 : 0;
                return res;
            }

        }
    }

    // Bottom-Up KnapSack
    boolean bottomUpsubSetSum(int n, int sum) {

        for (int i = 0; i < n + 1; i++) {
            
            for (int j = 0; j < sum + 1; j++) {
                
                if (j == 0)
                    t[i][j] = 1;
                else if (i == 0)
                    t[i][j] = 0;
                else {
                    if (Arr[i - 1] <= j)
                        t[i][j] = t[i - 1][j - Arr[i - 1]] | t[i - 1][j];
                    else
                        t[i][j] = t[i - 1][j];
                }
                
            }
        }

        return t[n][sum] == 1 ? true : false;
    }

}
