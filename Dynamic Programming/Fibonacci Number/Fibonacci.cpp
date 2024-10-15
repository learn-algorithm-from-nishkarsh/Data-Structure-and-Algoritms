/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/


#include <bits/stdc++.h>
using namespace std;

#define n 10

int nth_fibonacci_top_down_appraoch(int N, vector<int>& memo)
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


int nth_fibonacci_bottom_up_appraoch(int N, vector<int>& dp)
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
    
int main(){
    // Create a memoization table and initialize with -1
    vector<int> memo(n + 1, -1);

    // Create a vector to store Fibonacci numbers
    vector<int> dp(n + 1);

    nth_fibonacci_bottom_up_appraoch(n,dp);

    cout << nth_fibonacci_top_down_appraoch(n,memo) << endl;
    cout << dp[10] << endl;

    return 0;
}