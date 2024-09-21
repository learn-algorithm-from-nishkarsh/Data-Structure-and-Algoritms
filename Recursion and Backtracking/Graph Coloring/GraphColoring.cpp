/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

#include <iostream>
using namespace std;

// Number of vertices in the graph
#define V 4

bool isSafe(int v, bool graph[V][V], int color[], int c){
	// Check whether adjacent vertices has same colors
    for (int i = 0; i < V; i++){
        if (graph[v][i] && c == color[i]){
            return false;
		}
	}

    return true;
}

bool graphColoring(bool graph[V][V], int m, int color[],int v){

	// If all vertices are assigned some color, return true
    if (v == V)
        return true;

    // For current vertex v, try different colors c
    for (int c = 1; c <= m; c++) {

        // Check if it is safe to assign color c to vertex v
        if (isSafe(v, graph, color, c)) {
            color[v] = c;

			// Go to next vertex
            if (graphColoring(graph, m, color, v + 1))
                return true;

            // Backtrack
            color[v] = 0;
        }
    }

	// If no color can be assigned to vertex v, return False
    return false;
}

int main() {
	// Adjacent Matrix to represent a graph
    bool graph[V][V] = {
        { 0, 1, 1, 1 },
        { 1, 0, 1, 0 },
        { 1, 1, 0, 1 },
        { 1, 0, 1, 0 },
    };
    
	// Color array to store color for particular vertex
    int color[V];
    for (int i = 0; i < V; i++)
        color[i] = 0;

    // Number of colors
    int m = 3;

    if(graphColoring(graph, m, color, 0)){
        for (int i = 0; i < V; i++)
            cout << " " << color[i] << " ";

        cout << "\n";
    }
    else{
        cout << "No Solution\n";
    }
    return 0;
}