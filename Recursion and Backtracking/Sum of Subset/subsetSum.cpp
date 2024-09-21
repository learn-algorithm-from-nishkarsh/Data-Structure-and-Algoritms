/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void subsetSum(int i, int n,int inputSet[],vector<int>& subSet,int targetSum,int sum){
    
	// If we current SubSet sum value is equal to target Sum
	// Print the SubSet
    if(sum == targetSum){
        cout <<"[ ";
        for (int j = 0; j < subSet.size(); j++) {
            cout << subSet[j] << " ";
        }
        cout << "]\n";
        return;
    }
    
	// If no more element is left => return
    if(i == n){
        return;
    }
    
	// Include the current element if adding it does not exceed the target Sum
    if(sum+inputSet[i] <= targetSum){
        subSet.push_back(inputSet[i]);
        subsetSum(i+1,n,inputSet,subSet,targetSum,sum+inputSet[i]);
        subSet.pop_back();
    }
    
	// Not consider the current element
    subsetSum(i+1,n,inputSet,subSet,targetSum,sum);
    
}

int main() {
    // Write C++ code here
    int targetSum = 30;
    int inputSet[] = { 5,10,15,20,25,30 };
    int n = sizeof(inputSet) / sizeof(inputSet[0]);
    vector<int> subSet;
    
    subsetSum(0,n,inputSet,subSet,targetSum,0);
    
    

    return 0;
}



