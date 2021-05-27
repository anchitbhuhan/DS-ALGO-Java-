import java.io.BufferedReader;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Q number of Queries
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {

            // N (Number of Integer in Set)
            int n = Integer.parseInt(br.readLine());

            // Input set
            String[] str = br.readLine().split(" ");

            // Array
            int[] Arr = new int[str.length];

            int i = 0;
            for (String s : str)
                Arr[i++] = Integer.parseInt(s);

            int sum = Integer.parseInt(br.readLine());

            tarGetSum obj = new tarGetSum(Arr,sum);

            System.out.println(obj.waysTargetSum());

        }
    }
}