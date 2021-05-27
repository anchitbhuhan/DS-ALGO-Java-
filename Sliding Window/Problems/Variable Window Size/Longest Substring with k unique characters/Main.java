import java.util.*;

class Main
{
    public static void main(String[] args) {
        

        // String s  = "aabacbebebe";
        // String s  = "abbaacccccccdddd";
        int[] s  = {1,2,1,3,4};
        int k = 3;

        System.out.println(LSKUC(s, k));
    }

    // public static int  LSKUC(String s, int k)
    // {

    //     int i = 0;
    //     int j = 0;
    //     int n = s.length();
    //     int max = Integer.MIN_VALUE;
    //     HashMap<Character, Integer> hm = new HashMap<>();

    
    //     while(j<n)
    //     {
    //         char c = s.charAt(j);

    //         if(!hm.containsKey(c))
    //         {
    //             hm.put(c, 1);
    //         }else
    //             hm.replace(c, hm.get(c)+1);



    //         if(hm.size()==k)
    //         {
    //             max = Math.max(max, (j-i+1) );
    //             j++;
    //         }

    //         else if(hm.size()<k)
    //             j++;

    //         else if(hm.size()>k)
    //         {
    //             while(hm.size()>k)
    //             {
    //                 hm.replace(s.charAt(i), hm.get(s.charAt(i))-1);
    //                 if(hm.get(s.charAt(i))==0)
    //                     hm.remove(s.charAt(i));
    //                 i++;
    //             }
    //             j++;
    //         }

    //     }

    //     return max;
    // }

    public static int  LSKUC(int[] nums, int k)
    {

        int i = 0;
        int j = 0;
        int n = nums.length;
        int count = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        
        while(j<n)
        {
            int c = nums[j]; 
            
            if(!hm.containsKey(c))
                hm.put(c, 1);
            else
                hm.replace(c, hm.get(c)+1);
            
            
            if(hm.size()==k)
            {
                count++;
                j++;
            }
            else if(hm.size()<k)
            {
                j++;
            }
            else if(hm.size() > k)
            {
                while(hm.isEmpty() && hm.size() > k)
                {
                    hm.replace(nums[i], hm.get(nums[i])-1 );
                    if(hm.get(nums[i])==0)
                        hm.remove(nums[i]);
                    i++;

                }
                // if(hm.size()==k)
                //     count++;
                j++;
            }
        }
        return count;
    }
}