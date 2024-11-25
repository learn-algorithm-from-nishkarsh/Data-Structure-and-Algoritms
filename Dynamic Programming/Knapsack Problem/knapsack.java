/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

import java.util.Arrays;

class LearnAlgorithm {

    static int knapsack_solution(int weights[], int values[], int capacity)
    {
        int N = values.length;

        // Initializing a matrix of size (N+1)*(capacity+1)
        int[][] dp = new int[N + 1][capacity + 1];

        // Building dp[N+1][capacity+1] in bottom-up fashion
        for(int i = 1; i<=N; i++){
            for(int w = 1; w<=capacity; w++){
                if( weights[i-1] <= w){
                    // If current item can fit inside current capacity of bag   
                    int include_item = values[i-1] + dp[i-1][w-weights[i-1]];
                    int exclude_item = dp[i-1][w];
                    dp[i][w] = Math.max(include_item, exclude_item);
                }
                else{
                    // Current Item cannot fit inside current capacity of bag
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        return dp[N][capacity];
    }

    public static void main(String args[])
    {
        int weights[] = new int[] { 5, 4, 6, 3 };
        int values[] = new int[] { 10, 40, 30, 50 };
        int capacity = 5;

        int profit = knapsack_solution(weights,values,capacity);
        System.out.println("Profit = "+profit);
    }

}



