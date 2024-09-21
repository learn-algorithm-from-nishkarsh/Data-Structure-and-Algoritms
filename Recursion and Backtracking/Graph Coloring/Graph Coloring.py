'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

# Number of vertices in the graph
V = 4

def is_safe(v,graph,color,c):
    # Check whether adjacent vertices has same colors
    for i in range(V):
        if(graph[v][i] and color[i]==c):
            return False
    
    return True

def graph_coloring(graph, m, color, v):
    
    # If all vertices are assigned some color, return true
    if (v == V):
        return True
    
    # For current vertex v, try different colors c
    for c in range (1,m+1):
     
        # Check if it is safe to assign color c to vertex v
        if is_safe(v,graph,color,c):
            color[v] = c
            
            # Go to next vertex
            if graph_coloring(graph,m,color,v+1):
                return True
                
            # Backtrack
            color[v] = 0
    
    # If no color can be assigned to vertex v, return False
    return False
    

def main():
    # Adjacent Matrix to represent a graph
    graph = [
        [0, 1, 1, 1],
        [1, 0, 1, 0],
        [1, 1, 0, 1],
        [1, 0, 1, 0],
    ]
    
    # Color array to store color for particular vertex
    color = [0] * V

    # Number of colors
    m = 3
    
    if graph_coloring(graph, m, color, 0):
        print(color)
    else:
        print("No Solution")
    
main()



