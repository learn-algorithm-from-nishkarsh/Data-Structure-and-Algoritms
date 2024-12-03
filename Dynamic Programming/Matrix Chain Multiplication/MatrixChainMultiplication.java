/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

import java.util.Arrays;

class LearnAlgorithm {

    static int MCM_RECURSIVE(int arr[], int start, int end){
        // Base case: If there is only one matrix
        if(start + 1 == end){
            return 0;    
        }

        int res = Integer.MAX_VALUE;

        // Place the first bracket at different
        // positions or k and for every placed
        // first bracket, recursively compute
        // minimum cost for remaining brackets
        // (or subproblems)
        for(int k = start + 1; k < end; k++){
            int curr = MCM_RECURSIVE(arr, start, k) + MCM_RECURSIVE(arr, k, end) + arr[start] * arr[k] * arr[end];

            res = Math.min(curr, res);
        }
        
        // Return minimum count
        return res;
    }

    static int MCM_top_down_appraoch(int arr[], int start, int end, int[][] memo)
    {
        // Base case: If there is only one matrix
        if(start + 1 == end){
            return 0;    
        }

        // Check if the result is already exists in the memoziation table
        if (memo[start][end] != -1)
            return memo[start][end];

        int res = Integer.MAX_VALUE;

        // Place the first bracket at different
        // positions or k and for every placed
        // first bracket, recursively compute
        // minimum cost for remaining brackets
        // (or subproblems)
        for(int k = start + 1; k < end; k++){
            int curr = MCM_top_down_appraoch(arr, start, k, memo) + MCM_top_down_appraoch(arr, k, end, memo) + arr[start] * arr[k] * arr[end];

            res = Math.min(curr, res);
        }
        
        // Store the result in memoziation table
        memo[start][end] = res;
        // Return minimum count
        return res;
    }

    static int MCM_bottom_up_appraoch(int arr[])
    {
        int N = arr.length;

        // Initializing a matrix of size (N)*(N)
        int[][] dp = new int[N][N];

        // Building dp[N][N] in bottom-up fashion
        for(int len = 2; len < N; len++){
            for(int i=0; i < N-len; i++){
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = i+1; k < j; k++){
                    int cost = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        

        // Minimum cost is in dp[0][N-1]
        return dp[0][N-1];
    }

    public static void main(String args[])
    {
        int[] arr = { 1, 2, 3, 4, 3 };
        int N = arr.length;

        int res = MCM_RECURSIVE(arr, 0, N-1);
        System.out.println("MCM Cost : "+res);

        // Create a memoization table
        int[][] memo = new int[N][N];
        // Initialize the memo table with -1
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], -1);
        }

        res = MCM_top_down_appraoch(arr, 0, N-1, memo);
        System.out.println("MCM Cost : "+res);

        res = MCM_bottom_up_appraoch(arr);
        System.out.println("MCM Cost : "+res);
    }

}



