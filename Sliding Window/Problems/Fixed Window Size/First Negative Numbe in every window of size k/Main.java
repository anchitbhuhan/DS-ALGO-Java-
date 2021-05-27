import java.util.*;

class Main
{
    public static void main(String[] args) {
        

        int[] A = {-8, 2, 3, -6, 10};
        int k = 2;


        // Using Brute Force
        System.out.println(firstNeagtive(A,k));

        //Sliding Window
        System.out.println(firstNeagtiveSW(A,k));
        
        // //Sliding Window 2nd Approach
        // System.out.println(maxSumSW2(A,k));

        
    }


    // O(n*k)
    public static List<Integer>  firstNeagtive(int[] A, int k)
    {
        int n = A.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n-k; i++) { //(n-k) times

            boolean flag = false;
            for (int j = i; j <= i+k-1; j++) { // k times

                if(A[j]<0)
                {
                    res.add(A[j]);
                    flag = true;
                    break;
                }
            }

            if(!flag)
                res.add(0);
            
        }
        return res;
    }


    // O(n)
    public static  List<Integer>  firstNeagtiveSW(int[] A, int k)
    {
        int n = A.length;
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = 0;


        while(j<n) // n times
        {
            if(A[j]<0)
                queue.add(A[j]);


            if( (j-i+1) < k)
                j++;
            else if((j-i+1) == k)
            {
                if(!queue.isEmpty()) 
                {
                    if(A[i]==queue.peek())
                        res.add(queue.poll());
                    else if(A[i]!=queue.peek())
                        res.add(queue.peek());
                }
                else
                    res.add(0);
                i++;
                j++;
            }
        }
        return res;
    }

}