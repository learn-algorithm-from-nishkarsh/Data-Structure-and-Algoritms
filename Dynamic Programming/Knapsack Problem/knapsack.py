
'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

def knapsack_solution(weights,values,capacity):

    N = len(values)

    # Initializing a matrix of size (N + 1) * (capacity+1)
    dp = [[0] * (capacity + 1) for x in range(N + 1)]
    
    # Building dp[N+1][capacity+1] in bottom-up fashion
    for i in range(1, N+1):
        for w in range(1, capacity+1):
            if( weights[i-1] <= w):
                # If current item can fit inside current capacity of bag
                include_item = values[i-1] + dp[i-1][w-weights[i-1]]
                exclude_item = dp[i-1][w]
                dp[i][w] = max(include_item, exclude_item)
            else:
                #Current Item cannot fit inside current capacity of bag
                dp[i][w] = dp[i-1][w]

    return dp[N][capacity]


def main():

    weights = [5, 4, 6, 3]
    values = [10, 40, 30, 50]
    capacity = 5

    profit = knapsack_solution(weights,values,capacity)
    print("Profit = ",profit)
    
    
main()

