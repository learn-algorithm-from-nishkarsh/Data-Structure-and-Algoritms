/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

class GraphColoring{
    
	// Number of vertices in the graph
    static final int V = 4;
    
    static boolean isSafe(int v, boolean[][] graph, int[] color, int c) {
		// Check whether adjacent vertices has same colors
        for (int i = 0; i < V; i++){
            if (graph[v][i] && c == color[i]){
                return false;
			}
		}
        return true;
    }
    
    public static boolean graphColoring(boolean[][] graph,int m,int[] color,int v){
		
		// If all vertices are assigned some color, return true
        if(v == V)
            return true;

		// For current vertex v, try different colors c
        for(int c = 1; c <= m; c++) {
			
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
    
    public static void main(String args[]){
		// Adjacent Matrix to represent a graph
        boolean[][] graph = {
            { false, true, true, true },
            { true, false, true, false },
            { true, true, false, true },
            { true, false, true, false }
        };
        
		// Color array to store color for particular vertex
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        // Number of colors
        int m = 3;

        if(graphColoring(graph, m, color, 0)){
            for (int i = 0; i < V; i++)
                System.out.print(" " + color[i] + " ");
            System.out.println();
        }
        else{
            System.out.println("No Solution");
        }
    }
}