/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

import java.util.Arrays;

class LearnAlgorithm {

    static int N = 10;

    static int nth_fibonacci_top_down_appraoch(int N, int[] memo)
    {
        // Base case: if N is 0 or 1, return N
        if (N <= 1) {
            return N;
        }

        // Check if the result is already in the memorization table
        if (memo[N] != -1) {
            return memo[N];
        }

        // Recursive case: calculate Fibonacci number
        // and store it in memorization Table
        memo[N] = nth_fibonacci_top_down_appraoch(N - 1, memo) +
            nth_fibonacci_top_down_appraoch(N - 2, memo);

        return memo[N];
    }

    static int nth_fibonacci_bottom_up_appraoch(int N, int[] dp)
    {
        // Base case: if N is 0 or 1, return N
        if(N <= 1){
            return N;
        }

        // Initialize the first two Fibonacci numbers
        dp[0] = 0;
        dp[1] = 1;

        // Fill the array iteratively
        for(int i = 2; i< N+1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the DP Table
        return dp[N];
    }

    public static void main(String args[])
    {
        // Create a memoization table and initialize with -1
        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);
    
        // Create a array to store Fibonacci numbers
        int[] dp = new int[N + 1];

        nth_fibonacci_bottom_up_appraoch(N,dp);

        System.out.println(nth_fibonacci_top_down_appraoch(N,memo));
        System.out.print(dp[10]);
    }

}
