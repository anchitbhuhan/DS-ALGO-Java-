import java.util.Arrays;

public class equalSum {
    int n;
    int[] Arr;
    int sum;
    int[][] t;

    // Constructor
    public equalSum(int[] Arr) {
        this.n = Arr.length;
        this.Arr = Arr;
        int res = 0;
        for (int i : Arr) {
            res += i;
        }
        this.sum = res;
        t = new int[n + 1][sum + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

    }

    // Helper Method
    public boolean ispartitionPossible() {
        if(sum%2!=0)
            return false;
        return bottomUppartitionSum(n, sum/2);
    }

    // Recursive Brute-Force Approach
    boolean recursivePartitionSum(int n, int sum) {

        if (sum == 0)
            return true;

        else if (n == 0)
            return false;
            
        else {

            if (Arr[n - 1] <= sum)
                return (recursivePartitionSum(n - 1, sum - Arr[n - 1]) || recursivePartitionSum(n - 1, sum));
            else
                return recursivePartitionSum(n - 1, sum);

        }
    }

    // Recursive Memoized Approach
    boolean recursiveMemoPartitionSum(int n, int sum) {

        if (sum == 0)
            return true;

        else if (n == 0)
            return false;

        else if (t[n][sum] != -1)
            return t[n][sum] == 1 ? true : false;
        else {

            if (Arr[n - 1] <= sum) {
                boolean res = (recursiveMemoPartitionSum(n - 1, sum - Arr[n - 1]) || recursiveMemoPartitionSum(n - 1, sum));
                t[n][sum] = res ? 1 : 0;
                return res;
            } else {
                boolean res = recursiveMemoPartitionSum(n - 1, sum);
                t[n][sum] = res ? 1 : 0;
                return res;
            }

        }
    }

    // Bottom-Up KnapSack
    boolean bottomUppartitionSum(int n, int sum) {

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
