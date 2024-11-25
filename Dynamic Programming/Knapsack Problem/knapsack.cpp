/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/


#include <bits/stdc++.h>
using namespace std;

int knapsack_solution(int weights[], int values[], int capacity, int N)
{
    // Initializing a matrix of size (N+1)*(capacity+1)
    vector<vector<int>> dp(N + 1, vector<int>(capacity + 1, 0));

    // Building dp[N+1][capacity+1] in bottom-up fashion
    for(int i = 1; i<=N; i++){
        for(int w = 1; w<=capacity; w++){
            if( weights[i-1] <= w){
                // If current item can fit inside current capacity of bag   
                int include_item = values[i-1] + dp[i-1][w-weights[i-1]];
                int exclude_item = dp[i-1][w];
                dp[i][w] = max(include_item, exclude_item);
            }
            else{
                // Current Item cannot fit inside current capacity of bag
                dp[i][w] = dp[i-1][w];
            }
        }
    }

    return dp[N][capacity];
}
    
int main(){

    int weights[] = { 5, 4, 6, 3 };
    int values[] = { 10, 40, 30, 50 };
    int capacity = 5;
    int N = sizeof(values) / sizeof(values[0]);

    int profit = knapsack_solution(weights,values,capacity,N);
    cout << "Profit = " << profit << endl;

    return 0;
}