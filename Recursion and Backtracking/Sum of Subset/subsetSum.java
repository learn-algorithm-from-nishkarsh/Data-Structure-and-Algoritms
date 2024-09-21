/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

import java.util.*;

class LEARNALGORITHM {
    
    static void subsetSum(int i, int n,int[] inputSet,List<Integer> subSet,int targetSum,int sum){
        
		// If we current SubSet sum value is equal to target Sum
		// Print the SubSet
        if(sum == targetSum){
            System.out.print("[ ");
            for (int j = 0; j < subSet.size(); j++) {
                System.out.print(subSet.get(j) + " ");
            }
            System.out.println("]");
            return;
        }
        
		// If no more element is left => return
        if(i == n){
            return;
        }
        
		// Include the current element if adding it does not exceed the target Sum
        if(sum+inputSet[i] <= targetSum){
            subSet.add(inputSet[i]);
            subsetSum(i+1,n,inputSet,subSet,targetSum,sum+inputSet[i]);
            subSet.remove(subSet.size() - 1);
        }
        
		// Not consider the current element
        subsetSum(i+1,n,inputSet,subSet,targetSum,sum);
    }
    
    public static void main(String[] args) {
        
        int targetSum = 30;
        int[] inputSet = { 5,10,15,20,25,30 };
        int n = inputSet.length;
        List<Integer> subSet = new ArrayList<>();
        
        subsetSum(0,n,inputSet,subSet,targetSum,0);
        
    }
}


