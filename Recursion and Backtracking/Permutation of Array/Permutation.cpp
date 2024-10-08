/*
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
*/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void swap(char inputArray[],int i, int j){
	char temp = inputArray[i];
	inputArray[i] = inputArray[j];
	inputArray[j] = temp;
}

void permutation(char inputArray[],int index,int N){
    
	if(index == N){
		cout <<"[ ";
		for(int i=0;i<N;i++){
			cout << inputArray[i] << " ";
		}
		cout << "]" << endl;
		return;
	}
	
	for(int i = index; i < N; i++){
		swap(inputArray,index,i);
		permutation(inputArray,index+1,N);
		swap(inputArray,index,i);
	}
}

int main() {
    char inputArray[] = { 'A','B','C' };
    int N = sizeof(inputArray) / sizeof(inputArray[0]);
    
    permutation(inputArray,0,N);
    
    return 0;
}



