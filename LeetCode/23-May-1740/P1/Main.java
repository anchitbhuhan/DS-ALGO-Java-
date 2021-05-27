import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {
    // public String licenseKeyFormatting(String s, int k) {
        
    //     int n = 0;
        
    //     String[] split = s.split("-");
    //     for(int i=0;i<split.length;i++)
    //     {
    //         n += split[i].length();
    //     }
        
    //     char[] c = new char[n];
    //     int j =  0;
    //     for(int i=0; i<n; i++)
    //     {
    //             if(s.charAt(j)=='-')
    //             {
    //                 while(s.charAt(j)=='-')
    //                     j++;
    //                 c[i] = s.charAt(j);
    //             }
    //             else if(s.charAt(j)!='-')
    //                 c[i] = s.charAt(j);
    //             j++;
    //     }
        
    //     String temp = "";
        
    //     int count = 0;
    //     for (int i = n-1; i >= 0; i--) {
            
    //         temp += Character.toUpperCase(c[i]);

    //         if(i!=0 && (count+1)%k==0)
    //                 temp += '-';
    //         count++;
    //     }
        
    //     return new StringBuffer(temp).reverse().toString();
        
    // }


    public String licenseKeyFormatting(String s, int k) {
        
        StringBuilder sb  = new StringBuilder();
        int count = 0;
        for (int i = s.length()-1; i >=0; i--) {
            
            char c = s.charAt(i);
            if(c=='-')
                continue;

            if(count==k)
            {
                sb.insert(0, "-");
                count = 0;
            }

            sb.insert(0, Character.toUpperCase(c));
            count++;
        }
        return sb.toString();
        
    }


    // public String licenseKeyFormatting(String s, int k) {
        
    //     int[] arr = s.chars().filter(e -> e!=45).toArray();
        
    //     StringBuilder sb  = new StringBuilder();
    //     int count = 0;
    //     for (int i =arr.length-1; i >=0; i--) {
            
    //         char c = (char)arr[i];
    //         if(c=='-')
    //             continue;

    //         if(count==k)
    //         {
    //             sb.insert(0, "-");
    //             count = 0;
    //         }

    //         sb.insert(0, Character.toUpperCase(c));
    //         count++;
    //     }
    //     return sb.toString();
        
    // }
}

public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scan = new Scanner(new File("input.txt"));

        String s = scan.nextLine();
        int k = scan.nextInt();

        Solution obj = new Solution();

        System.out.println(obj.licenseKeyFormatting(s, k));
    }
}