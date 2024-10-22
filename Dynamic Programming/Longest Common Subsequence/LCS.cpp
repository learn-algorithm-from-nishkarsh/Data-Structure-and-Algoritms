/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/


#include <bits/stdc++.h>
using namespace std;

int LCS_RECURSIVE(string &S1, string &S2, int ind1, int ind2){

    // Base case: If either string is empty, the length of LCS is 0
    if(ind1 < 0 || ind2 < 0){
        return 0;
    }

    // If the last characters of both substrings match
    if(S1[ind1] == S2[ind2]){
        // Include this character in LCS and recur for remaining substrings
        return 1 + LCS_RECURSIVE(S1,S2, ind1 - 1, ind2 - 1);
    }
    else{
        // If the last characters do not match
        // Recur for two cases:
        // 1. Exclude the last character of S1 
        // 2. Exclude the last character of S2 
        // Take the maximum of these two recursive calls
        return max(LCS_RECURSIVE(S1,S2,ind1 - 1,ind2), LCS_RECURSIVE(S1,S2,ind1,ind2 - 1));
    }
}

int LCS_top_down_appraoch(string &S1,string &S2,int ind1,int ind2,vector<vector<int>>& memo)
{
    // Base case: If either string is empty, the length of LCS is 0
    if(ind1 < 0 || ind2 < 0){
        return 0;
    }

    // Already exists in the memorization table
    if (memo[ind1][ind2] != -1)
        return memo[ind1][ind2];

    // If the last characters of both substrings match
    if(S1[ind1] == S2[ind2]){
        // Include this character in LCS and recur for remaining substrings
        return memo[ind1][ind2] =  1 + LCS_top_down_appraoch(S1,S2, ind1 - 1, ind2 - 1,memo);
    }
    else{
        // If the last characters do not match
        // Recur for two cases:
        // 1. Exclude the last character of S1 
        // 2. Exclude the last character of S2 
        // Take the maximum of these two recursive calls
        return memo[ind1][ind2] = max(LCS_top_down_appraoch(S1,S2,ind1 - 1,ind2,memo), LCS_top_down_appraoch(S1,S2,ind1,ind2 - 1,memo));
    }
}


int LCS_bottom_up_appraoch(string &S1, string &S2)
{

    int M = S1.size();
    int N = S2.size();
    
    // Initializing a matrix of size (M+1)*(N+1)
    vector<vector<int>> dp(M + 1, vector<int>(N + 1, 0));

    // Building dp[M+1][N+1] in bottom-up fashion
    for (int i = 1; i <= M; i++) {
        for (int j = 1; j <= N; j++) {
            if (S1[i - 1] == S2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        }
    }

    // dp[M][N] contains length of LCS for S1[0..M-1] and S2[0..N-1]
    return dp[M][N];
}
    
int main(){

    string S1 = "CBDE";
    string S2 = "CDEB";
    int M = S1.size();
    int N = S2.size();

    int res = LCS_RECURSIVE(S1,S2,M - 1,N -1);
    cout << "LCS : " << res << endl;

    // Create a memoization table and initialize with -1
    vector<vector<int>> memo(M + 1, vector<int>(N + 1, -1));

    res = LCS_top_down_appraoch(S1,S2,M-1,N-1,memo);
    cout << "LCS : " << res << endl;

    res = LCS_bottom_up_appraoch(S1,S2);
    cout << "LCS : " << res << endl;

    return 0;
}