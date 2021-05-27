import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    // static int[] row = { -2, -2, 2, 2, -1, 1, -1, 1 };
    // static int[] col = { 1, -1  , 1, -1, 2, 2, -2, -2};

    static int[] row = {  2, 1, -1, -2, -2, -1,  1,  2 };
    static int[] col = {  1, 2,  2,  1, -1, -2, -2, -1 };
    static int N;
    static int[][] M;
    static int count;


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("input.txt"));

        // N = scan.nextInt();
        // M = new int[N][N];

        // for (int[] row : M) {
        //     Arrays.fill(row, -1);
        // }

        // int i = scan.nextInt();
        // int j = scan.nextInt();

        // M[i][j] = count;

        // KnightTour(i, j, 1);
        // print(M);

        Solution s = new Solution();
        // System.out.println(s.knightProbability(3,2,0,0));
        System.out.println(s.knightProbability(1,1,0,0));

    }

    public static boolean KnightTour(int i, int j, int count) {
        
        if (count == N * N)
        {
            return true;
        }
        else {

            for (int k = 0; k < 8; k++) {
                int i1 = i + row[k];
                int j1 = j + col[k];

                if(isValid(i1, j1))
                {
                        M[i1][j1] = count;
                        
                        if(KnightTour(i1, j1, count+1))
                            return true;
                        M[i1][j1] = -1;
                }
            }
            return false;
        }
    }

    public static boolean isValid(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N && M[i][j]==-1;
    }

    public static void print(int [][]  A)
    {
        for (int[] row : A) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}