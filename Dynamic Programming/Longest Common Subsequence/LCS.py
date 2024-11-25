
'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

def LCS_RECURSIVE(S1, S2, ind1, ind2):
    
    # Base case: If either string is empty, the length of LCS is 0
    if(ind1 < 0 or ind2 < 0):
        return 0

    # If the last characters of both substrings match
    if(S1[ind1] == S2[ind2]):
        # Include this character in LCS and recur for remaining substrings
        return 1 + LCS_RECURSIVE(S1,S2, ind1 - 1, ind2 - 1)
    else:
        # If the last characters do not match
        # Recur for two cases:
        # 1. Exclude the last character of S1 
        # 2. Exclude the last character of S2 
        # Take the maximum of these two recursive calls
        return max(LCS_RECURSIVE(S1,S2,ind1 - 1,ind2), LCS_RECURSIVE(S1,S2,ind1,ind2 - 1))

def LCS_top_down_appraoch(S1, S2, ind1, ind2, memo):

    # Base case: If either string is empty, the length of LCS is 0
    if(ind1 < 0 or ind2 < 0):
        return 0

    # Check if the result is already exists in the memo table
    if memo[m][n] != -1:
        return memo[m][n]

    # If the last characters of both substrings match
    if(S1[ind1] == S2[ind2]):
        # Include this character in LCS and recur for remaining substrings
        memo[ind1][ind2] = 1 + LCS_RECURSIVE(S1,S2, ind1 - 1, ind2 - 1)
        return memo[ind1][ind2]
    else:
        # If the last characters do not match
        # Recur for two cases:
        # 1. Exclude the last character of S1 
        # 2. Exclude the last character of S2 
        # Take the maximum of these two recursive calls
        memo[ind1][ind2] =  max(LCS_RECURSIVE(S1,S2,ind1 - 1,ind2), LCS_RECURSIVE(S1,S2,ind1,ind2 - 1));
        return memo[ind1][ind2]

def LCS_bottom_up_appraoch(S1,S2):
  
    M = len(S1)
    N = len(S2)

    # Initializing a matrix of size (M+1)*(N+1)
    dp = [[0] * (N + 1) for x in range(M + 1)]

    # Building dp[M+1][N+1] in bottom-up fashion
    for i in range(1, M + 1):
        for j in range(1, N + 1):
            if S1[i - 1] == S2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

    # dp[M][N] contains length of LCS for S1[0..M-1] and S2[0..N-1]
    return dp[M][N]

def main():
    S1 = "CBDE"
    S2 = "CDEB"
    M = len(S1)
    N = len(S2)

    res = LCS_RECURSIVE(S1,S2,M - 1,N -1);
    print("LCS : ",res,end="\n");

    # Create a memoization table and initialize with -1
    memo = [[-1 for _ in range(N + 1)] for _ in range(M + 1)]

    res = LCS_top_down_appraoch(S1,S2,M-1,N-1,memo);
    print("LCS : ",res,end="\n");

    res = LCS_bottom_up_appraoch(S1,S2);
    print("LCS : ",res,end="\n");
    
main()

