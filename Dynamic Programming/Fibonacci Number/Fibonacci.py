def nth_fibonacci_top_down_appraoch(N, memo):

    # Base case: if N is 0 or 1, return N
    if N <= 1:
        return N

    # Check if the result is already in the memorization table
    if memo[N] != -1:
        return memo[N]

    # Recursive case: calculate Fibonacci number
    # and store it in memorization Table
    memo[N] = nth_fibonacci_top_down_appraoch(N - 1, memo) +
                nth_fibonacci_top_down_appraoch(N - 2, memo)

    # Return the Nth Fibonacci number
    return memo[N]

def nth_fibonacci_bottom_up_appraoch(N,dp):
  
    # Base case: if N is 0 or 1, return N
    if N <= 1:
        return N

    # Initialize the first two Fibonacci numbers
    dp[0] = 0
    dp[1] = 1

    # Fill the list iteratively
    for i in range(2, N + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    # Return the DP Table
    return dp[N]

def main():
    N = 10
    
    # Create a memoization table and initialize with -1
    memo = [-1] * (N + 1)
    
    # Create a list to store Fibonacci numbers
    dp = [0] * (N + 1)
    
    nth_fibonacci_bottom_up_appraoch(N,dp)

    print(nth_fibonacci_top_down_appraoch(N,memo))
    print(dp[10])
    
main()


'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''