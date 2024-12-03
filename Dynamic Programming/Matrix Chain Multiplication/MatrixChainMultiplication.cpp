/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

#include <bits/stdc++.h>
using namespace std;

int MCM_RECURSIVE(int arr[], int start, int end){
    // Base case: If there is only one matrix
    if(start + 1 == end){
        return 0;    
    }

    int res = INT_MAX;

    // Place the first bracket at different
    // positions or k and for every placed
    // first bracket, recursively compute
    // minimum cost for remaining brackets
    // (or subproblems)
    for(int k = start + 1; k < end; k++){
        int curr = MCM_RECURSIVE(arr, start, k) + MCM_RECURSIVE(arr, k, end) + arr[start] * arr[k] * arr[end];

        res = min(curr, res);
    }
        
    // Return minimum count
    return res;
}

int MCM_top_down_appraoch(int arr[], int start, int end, vector<vector<int>> &memo)
{
    // Base case: If there is only one matrix
    if(start + 1 == end){
        return 0;    
    }

    // Check if the result is already exists in the memoziation table
    if (memo[start][end] != -1)
        return memo[start][end];

    int res = INT_MAX;

    // Place the first bracket at different
    // positions or k and for every placed
    // first bracket, recursively compute
    // minimum cost for remaining brackets
    // (or subproblems)
    for(int k = start + 1; k < end; k++){
        int curr = MCM_top_down_appraoch(arr, start, k, memo) + 
                MCM_top_down_appraoch(arr, k, end, memo) + arr[start] * arr[k] * arr[end];

        res = min(curr, res);
    }
        
    // Store the result in memoziation table
    memo[start][end] = res;
    // Return minimum count
    return res;
}

int MCM_bottom_up_appraoch(int arr[], int N)
{
    
    // Initializing a matrix of size (N)*(N)
    vector<vector<int>> dp(N, vector<int>(N, 0));

    // Building dp[N][N] in bottom-up fashion
    for(int len = 2; len < N; len++){
        for(int i=0; i < N-len; i++){
            int j = i + len;
            dp[i][j] = INT_MAX;

            for(int k = i+1; k < j; k++){
                int cost = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
                dp[i][j] = min(dp[i][j], cost);
            }
        }
    }
        

    // Minimum cost is in dp[0][N-1]
    return dp[0][N-1];
}

int main(){

    int arr[] = {1, 2, 3, 4, 3};
    int N = sizeof(arr) / sizeof(arr[0]);

    int res = MCM_RECURSIVE(arr, 0, N-1);
    cout << "MCM Cost : " << res << endl;

    // Create a memoization table and initialize with -1
    vector<vector<int>> memo(N, vector<int>(N, -1));

    res = MCM_top_down_appraoch(arr, 0, N-1, memo);
    cout << "MCM Cost : " << res << endl;

    res = MCM_bottom_up_appraoch(arr, N);
    cout << "MCM Cost : " << res << endl;

    return 0;
}
    






