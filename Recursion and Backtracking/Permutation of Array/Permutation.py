'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

inputArray = ['A','B','C']

# Swap 2 elements of an array at index i and j
def swap(inputArray,i,j):
    inputArray[i],inputArray[j] = inputArray[j],inputArray[i]

def permutation(inputArray,start):
    
    # If we reach at end of array, print current permutation
    if(start == len(inputArray)):
        print(inputArray)
        return
    
    # Recur for index start to end
    for i in range(start,len(inputArray)):
        
        swap(inputArray,start,i)
        permutation(inputArray,start+1)
        # Backtrack
        swap(inputArray,start,i)
        
permutation(inputArray,0)


