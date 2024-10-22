/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

import java.util.Arrays;

class LearnAlgorithm {

    static int LCS_RECURSIVE(String S1, String S2, int ind1, int ind2){
        // Base case: If either string is empty, the length of LCS is 0
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }

        // If the last characters of both substrings match
        if(S1.charAt(ind1) == S2.charAt(ind2)){
            // Include this character in LCS and recur for remaining substrings
            return 1 + LCS_RECURSIVE(S1,S2, ind1 - 1, ind2 - 1);
        }
        else{
            // If the last characters do not match
            // Recur for two cases:
            // 1. Exclude the last character of S1 
            // 2. Exclude the last character of S2 
            // Take the maximum of these two recursive calls
            return Math.max(LCS_RECURSIVE(S1,S2,ind1 - 1,ind2), LCS_RECURSIVE(S1,S2,ind1,ind2 - 1));
        }
    }

    static int LCS_top_down_appraoch(String S1,String S2,int ind1,int ind2,int[][] memo)
    {
        // Base case: If either string is empty, the length of LCS is 0
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }

        // Already exists in the memorization table
        if (memo[ind1][ind2] != -1)
            return memo[ind1][ind2];

        // If the last characters of both substrings match
        if(S1.charAt(ind1) == S2.charAt(ind2)){
            // Include this character in LCS and recur for remaining substrings
            return memo[ind1][ind2] =  1 + LCS_top_down_appraoch(S1,S2, ind1 - 1, ind2 - 1,memo);
        }
        else{
            // If the last characters do not match
            // Recur for two cases:
            // 1. Exclude the last character of S1 
            // 2. Exclude the last character of S2 
            // Take the maximum of these two recursive calls
            return memo[ind1][ind2] = Math.max(LCS_top_down_appraoch(S1,S2,ind1 - 1,ind2,memo), LCS_top_down_appraoch(S1,S2,ind1,ind2 - 1,memo));
        }
    }

    static int LCS_bottom_up_appraoch(String S1, String S2)
    {
        int M = S1.length();
        int N = S2.length();

        // Initializing a matrix of size (M+1)*(N+1)
        int[][] dp = new int[M + 1][N + 1];

        // Building dp[M+1][N+1] in bottom-up fashion
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        // dp[M][N] contains length of LCS for S1[0..M-1] and S2[0..N-1]
        return dp[M][N];
    }

    public static void main(String args[])
    {
        String S1 = "CBDE";
        String S2 = "CDEB";
        int M = S1.length();
        int N = S2.length();

        int res = LCS_RECURSIVE(S1,S2,M - 1,N -1);
        System.out.println("LCS : "+res);

        // Create a memoization table
        int[][] memo = new int[M + 1][N + 1];
        // Initialize the memo table with -1
        for (int i = 0; i <= M; i++) {
            Arrays.fill(memo[i], -1);
        }

        res = LCS_top_down_appraoch(S1,S2,M-1,N-1,memo);
        System.out.println("LCS : "+res);

        res = LCS_bottom_up_appraoch(S1,S2);
        System.out.println("LCS : "+res);
    }

}



