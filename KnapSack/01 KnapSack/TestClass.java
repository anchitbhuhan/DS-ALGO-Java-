import java.util.Scanner;
import java.io.File;
class TestClass {

    static int N;
    static int C;
    static int[] values;
    static int[] weights;
    static int[] T;
    static int totalWeight;
    static int totalValue;

    public static void main (String args[]) throws Exception {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        C = scan.nextInt();

        values = new int[N];
        weights = new int[N];

        for (int i = 0; i < N; i++)
        {
            values[i] = scan.nextInt();
            totalValue += values[i];
        }


        for (int i = 0; i < N; i++)
        {
            weights[i] = scan.nextInt();
            totalWeight += weights[i];
        }


        System.out.println(KnapSackBottomUp());

    }

    static int KnapSackBottomUp() {

        if(totalWeight<=C)
        {
            return totalValue;
        }
        T = new int[C + 1];

        for (int i = 0; i < N; i++) {
            for (int j = C; j >= weights[i]; j--) {

                T[j] = Math.max(values[i] + T[j - weights[i]], T[j]);
            }
        }
        return T[C];

    }

}

