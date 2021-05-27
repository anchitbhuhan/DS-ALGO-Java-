import java.util.*;

class Main
{
    public static void main(String[] args) {
        
        int [] A = {1,3,-1,2,0,6,-5,7,8};
        int k = 3;


        //Sliding Window
        System.out.println(findMaxInAllWindow(A, k));

    }

    public static  List<Integer> findMaxInAllWindow(int[] A, int k)
    {
        int n = A.length;
        int i = 0;
        int j = 0;
        

        List<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.add(Integer.MIN_VALUE);

        while(j<n)
        {
            while( !queue.isEmpty() &&  A[j]>queue.peek())
            {
                queue.poll();
            }
            
            queue.add(A[j]);

            if((j-i+1)<k)
                j++;
            else if( (j-i+1) ==k)
            {
                int max = queue.peek();
                res.add(max);

                if(A[i]==max)
                    queue.poll();
                i++;
                j++;
            }
        }
        return res;
    }
}