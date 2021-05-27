import java.util.HashMap;

import java.util.*;

class Main
{
    public static void main(String[] args) {
        

        String s = "aabaabaa";
        String t = "aaba";




        // Using Brute Force O(n*k)
        System.out.println(countOfAnagram(s,t));

        // Sliding Window
        System.out.println(CountAnagramOccurence(s, t));
        
        // //Sliding Window 2nd Approach
        // System.out.println(maxSumSW2(A,k));

        
    }


    // O(n*k)
    public static int  countOfAnagram(String s, String pattern)
    {
        int n = s.length();
        int k = pattern.length();
        int count = 0;


        HashMap<Character, Integer> t = new HashMap<>();

        for (int c=0; c<k; c++) { // k times
            
            char temp =  pattern.charAt(c);
            if(t.get(pattern.charAt(c))==null)
            {
                t.put(temp, 1);
            }
            else{
                t.replace(temp, t.get(temp)+1);
            }
        }

        
        for (int i = 0; i <= n-k; i++) { //(n-k+1) times

            if(cohmare2Hashmap(s.substring(i,i+k), t)) //O(k)
                count++;
            
        }
        return count;
    }

    public  static boolean cohmare2Hashmap(String s, HashMap<Character, Integer> t)
    {
        boolean flag = true;

        HashMap<Character, Integer> ss = new HashMap<>();

        for (int c=0; c<s.length(); c++) { // k times
            
            char temp =  s.charAt(c);
            if(ss.get(s.charAt(c))==null)
            {
                ss.put(temp, 1);
            }
            else{
                ss.replace(temp, ss.get(temp)+1);
            }
        }

        for (Character ch : t.keySet())
        {
            if(ss.containsKey(ch) && (ss.get(ch)==t.get(ch)))
            {
                flag = true;
            }
            else{
                flag = false;
                break;
            }

        }

        return flag;
        
    }


// ===========================================================
// 2nd Brute Force

//  O(n*(k*logk))
    // public static int  countOfAnagram(String s, String pattern)
    // {
    //     int n = s.length();
    //     int k = pattern.length();
    //     int count = 0;


        
    //     for (int i = 0; i <= n-k; i++) { //(n-k+1) times

    //         if(isAnagram(s.substring(i, i+k), pattern)) //O(klogk)
    //             count++;
            
    //     }
    //     return count;
    // }

    // public static  boolean isAnagram(String s, String t)
    // {
    //     char charArray[] = s.toCharArray();
    //     Arrays.sort(charArray); // O(klogk)

    //     char charArray2[] = t.toCharArray();
    //     Arrays.sort(charArray2);

    //     return new String(charArray).equals(new String(charArray2));


    // }






    





    // O(n)
    public static int  CountAnagramOccurence(String s, String t)
    {
        int n = s.length();
        int k = t.length();
        int i = 0;
        int j = 0;
        int result = 0;
        
        
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int c=0; c<k; c++) {
            
            char temp =  t.charAt(c);
            if(hm.get(t.charAt(c))==null)
            {
                hm.put(temp, 1);
            }
            else{
                hm.replace(temp, hm.get(temp)+1);
            }
        }

        int count = hm.size();

        while(j<n) // n times
        {
            char sc = s.charAt(j);
            if(hm.containsKey(sc))
            {
                hm.put(sc,hm.get(sc)-1);
                if(hm.get(sc) == 0)
                {
                    count--;
                }
            }

            if( (j-i+1) < k)
                j++;
            else if((j-i+1) == k)
            {

                if(count==0)
                {
                    result++;
                }
                
                char left = s.charAt(i);
                if(hm.containsKey(left))
                {
                    hm.replace(left, hm.get(left)+1);
                    if(hm.get(left)==1)
                        count++;
                }    

                i++;
                j++;
            }
        }
        return result;
    }

    

}