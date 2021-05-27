import java.io.BufferedReader;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Q number of Queries
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {

            // N (Number of Objects)
            int n = Integer.parseInt(br.readLine());

            // Weights of Object
            String[] str = br.readLine().split(" ");

            // Weight Array
            int[] weights = new int[str.length];

            int i = 0;
            for (String s : str)
                weights[i++] = Integer.parseInt(s);

            // Values of Object
            String[] str2 = br.readLine().split(" ");

            // Values Array
            int[] values = new int[str2.length];

            int j = 0;
            for (String s : str2)
                values[j++] = Integer.parseInt(s);

            //Max Capacity of Knapsack
            int capacity = Integer.parseInt(br.readLine());

            KnapSack obj = new KnapSack(weights, values, capacity);

            System.out.println(obj.maxProfit());


            

        }
    }
}