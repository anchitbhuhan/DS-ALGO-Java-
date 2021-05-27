import java.util.Arrays;

class Solution {
    int N;
    int[][] M;
    int[] rows = {  2, 1, -1, -2, -2, -1,  1,  2 };
    int[] cols = {  1, 2,  2,  1, -1, -2, -2, -1 };
    int count;
    int result;
    public double knightProbability(int n, int k, int row, int column) {
        double res = 0.0;
        N = n;
        M = new int[N][N];
        count = 0;
        result=  0;
        for(int[] r: M)
            Arrays.fill(r, -1);
        
        M[row][column] = 0;
        KnightTour(row, column, 1, k);

        
        if(result==0)
            return 1;
        res = 1/(Math.pow(2,result));
        return res;
        
    }
    
    public void KnightTour(int i, int j, int count, int k)
    {
        k--;
        if(k<0 || count==N*N)
            return;
        else
        {   
            for(int p=0; p<8; p++)
            {
                int i1 = i + rows[p];
                int j1 = j + cols[p];
                
                if(isValid(i1, j1))
                {
                    M[i1][j1] = count;
                    result++;
                    KnightTour(i1, j1, count+1, k);
                    
                }
            }
        }
        
    }
    
    public boolean isValid(int i, int j)
    {
        return i>=0 && i<N && j>=0 && j<N && M[i][j]==-1;
    }
}