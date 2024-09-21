'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

inputSet = [5,10,15,20,25,30]

targetSum=30

def subsetSum(inputSet,subSet=[],sum=0):
    
    # If we current SubSet sum value is equal to target Sum
	# Print the SubSet
    if(sum == targetSum):
        print("[",",".join(map(str,subSet)),"]")
        return
        
    # If no more element is left => return
    if len(inputSet) ==0:
        return
    
    # Include the current element if adding it does not exceed the target Sum
    if(sum+inputSet[0] <= targetSum):
        subsetSum(inputSet[1:],subSet+[inputSet[0]],sum+inputSet[0])
    
    # Not consider the current element
    subsetSum(inputSet[1:],subSet,sum)
        
subsetSum(inputSet)


