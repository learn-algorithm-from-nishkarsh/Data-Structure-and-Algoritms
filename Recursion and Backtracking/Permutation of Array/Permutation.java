// Basic initialization
List<Integer> list= new ArrayList<>();
List<Integer> numbers= new ArrayList<Integer>(Arrays.asList(60, 25, 12));
// Or
Integer[] arr = {2,3,4,4};
List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

// Two dimentional list
List<List<String>> countries = new ArrayList<>();
for(int i = 0; i < 100; i++){
  countries.add(new ArrayList<>());
}
// Or
List<String>[] countries = new ArrayList[100];
for(int i = 0; i < 100; i++){
  list[i] = new ArrayList<>();
}

// Returns the array size
list.size();

// Add new item
list.add(10);
list.add(20);
list.add(int index, E element) // insert data in specific position 
list.addAll(numbers);

// Get element from given index
list.get(int index)

// Remove element from given index
list.remove(int index)
list.clear() // clear all data;

list.contains(120)); // returns true/false
list.indexOf(Object element) // returns first index of given element or -1 
list.isEmpty() // returns true/false

list.toString(); // make the array string
list.toArray() // Returns an array containing all of the elements

// Sorting and changed the data source for both cases
list.sort(Comparator.naturalOrder()); // ASC
list.sort(Comparator.reverseOrder()); // DSC
// Or
Collections.sort(list); // ASC
Collections.sort(list, Collections.reverseOrder()); // DSC







































/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

import java.util.*;

class LEARNALGORITHM {
	
	// Swap 2 elements of an array at index i and j
	static void swap(char inputArray[],int i, int j){
		char temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}
	
    static void permutation(char inputArray[],int start){
        
		// If we reach at end of array, print current permutation
		if(start == inputArray.length){
			System.out.print("[ ");
            for (int i = 0; i < inputArray.length; i++) {
                System.out.print(inputArray[i] + " ");
            }
            System.out.println("]");
            return;
		}
		
		// Recur for index start to end
		for(int i=start; i< inputArray.length; i++){
			swap(inputArray,start,i);
			permutation(inputArray,start+1);
			// Backtrack
			swap(inputArray,start,i);
		}
    }
    
    public static void main(String[] args) {
        
        char inputArray[] = { 'A','B','C' };
    
		permutation(inputArray,0);
    }
}


