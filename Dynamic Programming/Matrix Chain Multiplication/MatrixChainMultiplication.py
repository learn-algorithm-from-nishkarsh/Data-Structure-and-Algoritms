'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

import sys

def MCM_RECURSIVE(arr, start, end):
    
    # Base case: If there is only one matrix
    if(start + 1 == end):
        return 0

    res = sys.maxsize

    # Place the first bracket at different
    # positions or k and for every placed
    # first bracket, recursively compute
    # minimum cost for remaining brackets
    # (or subproblems)
    for k in range(start + 1, end):
        curr = MCM_RECURSIVE(arr, start, k) + MCM_RECURSIVE(arr, k, end) + arr[start] * arr[k] * arr[end]

        res = min(curr, res)

    # Return minimum count
    return res

def MCM_top_down_appraoch(arr, start, end, memo):

    # Base case: If there is only one matrix
    if(start + 1 == end):
        return 0

    # Check if the result is already exists in the memoziation table
    if memo[start][end] != -1:
        return memo[start][end]

    res = sys.maxsize

    # Place the first bracket at different
    # positions or k and for every placed
    # first bracket, recursively compute
    # minimum cost for remaining brackets
    # (or subproblems)
    for k in range(start + 1, end):
        curr = MCM_top_down_appraoch(arr, start, k, memo) + MCM_top_down_appraoch(arr, k, end, memo) + arr[start] * arr[k] * arr[end]

        res = min(curr, res)

    # Store the result in memoziation table
    memo[start][end] = res
    # Return minimum count
    return res


def MCM_bottom_up_appraoch(arr):
  
    N = len(arr)

    # Initializing a matrix of size (N)*(N)
    dp = [[0] * N for x in range(N + 1)]

    # Building dp[N][N] in bottom-up fashion
    for length in range(2, N):
        for i in range(N - length):
            j = i + length
            dp[i][j] = sys.maxsize

            for k in range(i + 1, j):
                cost = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]
                dp[i][j] = min(dp[i][j], cost)

    # Minimum cost is in dp[0][N-1]
    return dp[0][N-1]

def main():
    arr = [1, 2, 3, 4, 3]
    N = len(arr)

    res = MCM_RECURSIVE(arr, 0, N-1)
    print("MCM Cost : ",res,end="\n");

    # Create a memoization table and initialize with -1
    memo = [[-1 for _ in range(N)] for _ in range(N)]

    res = MCM_top_down_appraoch(arr, 0, N-1 ,memo)
    print("MCM Cost : ",res,end="\n")

    res = MCM_bottom_up_appraoch(arr)
    print("MCM Cost : ",res,end="\n")
    
main()