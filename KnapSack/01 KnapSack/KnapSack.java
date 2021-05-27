import java.util.Arrays;

public class KnapSack {
    int n;
    int[] weights;
    int[] values;
    int capacity;
    int[][] t;

    // Constructor
    public KnapSack(int[] weights, int[] values, int capacity) {
        this.n = weights.length;
        this.weights = weights;
        this.values = values;
        this.capacity = capacity;
        t = new int[n + 1][capacity + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

    }

    // Helper Method
    public int maxProfit() {
        return bottomUpKnapSack(n, capacity);
    }

    // Recursive Brute-Force Approach
    int recursiveKnapSack(int n, int capacity) {
        if (n == 0 || capacity == 0)
            return 0;
        else {
            if (weights[n - 1] <= capacity)
                return Math.max(values[n - 1] + recursiveKnapSack(n - 1, capacity - weights[n - 1]),
                        recursiveKnapSack(n - 1, capacity));
            else
                return recursiveKnapSack(n - 1, capacity);
        }
    }

    // Recursive Memoized Approach
    int recursiveMemoKnapSack(int n, int capacity) {

        if (n == 0 || capacity == 0)
            return 0;
        else if (t[n][capacity] != -1)
            return t[n][capacity];
        else {
            if (weights[n - 1] <= capacity) {
                t[n][capacity] = Math.max(values[n - 1] + recursiveMemoKnapSack(n - 1, capacity - weights[n - 1]),
                        recursiveMemoKnapSack(n - 1, capacity));
                return t[n][capacity];
            } else {
                t[n][capacity] = recursiveMemoKnapSack(n - 1, capacity);
                return t[n][capacity];
            }
        }

    }

    // Bottom-Up KnapSack
    int bottomUpKnapSack(int n, int capacity) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (j == 0 || i == 0)
                    t[i][j] = 0;
                else {
                    if (weights[i - 1] <= j)
                        t[i][j] = Math.max(values[i - 1] + t[i - 1][j - weights[i - 1]], t[i - 1][j]);
                    else
                        t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][capacity];
    }

}
