import java.util.Arrays;

class Main {
    public static void main(String[] args) {

        // int[] A = {-4, -3, -2, -1,  0, 5, 6, 7, 8};
        int[] A = {-4,0,4};

        Solution s = new Solution();

        int[] res = s.sortedSquares(A);
        s.print(res);
    }
}

class Solution {
    // public int[] sortedSquares(int[] nums) {

    //     int l = -1;
    //     int m = -1;
    //     int n = -1;
    //     int a = 0;
    //     int length = nums.length;

    //     if (a < length && nums[a] < 0) {
    //         l = a;
    //         while (a < length && nums[a] < 0) {
    //             a++;
    //         }
    //         m = a - 1;
    //     }
    //     n = a;

    //     int[] res = new int[length];


        
    //     int i = n;
    //     int j = m;
    //     int k = 0;

    //     int asquare = 0;
    //     int bsquare = 0;
    //     while (i < length && j >= 0) {
    //         asquare = nums[i]*nums[i];
    //         bsquare = nums[j]*nums[j];

    //         if (asquare <= bsquare) {
    //             res[k++] = asquare;
    //             i++;
    //         } else {
    //             res[k++] = bsquare;
    //             j--;
    //         }

    //         print(res);
    //     }

    //     if (i < length) {
    //         while (i < length) {
    //             res[k++] = nums[i]*nums[i];
    //             i++;
    //         }
    //     }
    //     if (j >= 0) {
    //         while (j >= 0) {
    //             res[k++] = nums[j]*nums[j];
    //             j--;
    //         }
    //     }

    //     return res;
    // }

    // public int[] sortedSquares(int[] nums) {

    //     int n = nums.length;
    //     int i = 0;
    //     int j = n-1;
    //     int k = n-1;

    //     int[] res = new int[n];

    //     while(i<=j)
    //     {
    //         int a = Math.abs(nums[i]);
    //         int b = Math.abs(nums[j]);

    //         if(a>b)
    //         {
    //             res[k--] = a*a;
    //             i++;
    //         }
    //         else
    //         {
    //             res[k--] = b*b;
    //             j--;
    //         }

    //     }
    //     return res;
    // }


    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);

        return nums;
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

}