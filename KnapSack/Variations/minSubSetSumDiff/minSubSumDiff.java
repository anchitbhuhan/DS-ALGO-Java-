import java.util.Arrays;

public class minSubSumDiff {
    int n;
    int[] Arr;
    int Arrsum;
    int[][] t;

    // Constructor
    public minSubSumDiff(int[] Arr) {
        this.n = Arr.length;
        this.Arr = Arr;
        for (int i : Arr) {
            Arrsum += i;
        }
        t = new int[n + 1][Arrsum + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

    }

    // Helper Method
    public int minDiff() {

        int[] lastRow = bottomUpsubSetSumDiff(n, Arrsum);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= Arrsum / 2; i++) {

            if (lastRow[i] == 1)
                res = Math.min(res, Arrsum - 2 * i);
        }

        return res;
    }

    // Bottom-Up KnapSack
    int[] bottomUpsubSetSumDiff(int n, int Arrsum) {

        for (int i = 0; i < n + 1; i++) {

            for (int j = 0; j < Arrsum + 1; j++) {

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

        return t[n];
    }

}
