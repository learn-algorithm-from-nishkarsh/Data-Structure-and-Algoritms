'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

N = 8

board = [[-1 for x in range(N)] for y in range(N)]

# Since the Knight is initially at the first square
board[0][0] = 0

# Move patterns of Knight  
dx = [2, 1, -1, -2, -2, -1, 1, 2]  
dy = [1, 2, 2, 1, -1, -2, -2, -1] 

def printSolution():
    print("The solution:")
    for i in range(N):
        for j in range(N):
            print(board[i][j],end=" ")
        print()

# Return True if Knight can go to x,y position otherwise False
def is_safe_place(x,y):
    if x<0 or y<0 or x >= N or y >= N or board[x][y] != -1:
        return False
    return True
        
# Solve the knight Tour Problem,
# return True if knight can cover each square
# Otherwise returns False
def solve_for_knight_tour(x,y,pos):
    if(pos == N*N):
        return True
    
    for i in range(8):
        newX = x + dx[i]
        newY = y + dy[i]
        # Check for all possible 8 moves
        if(is_safe_place(newX,newY)):
            board[newX][newY] = pos
            if(solve_for_knight_tour(newX,newY,pos+1)):
                return True
                
            # Backtrack because solution is not possible from this move
            board[newX][newY] = -1
            
    return False
    
def findSolution():
    if not solve_for_knight_tour(0, 0, 1):
        print("There is no solution")
        return False
    printSolution()
   
def main():
    findSolution()

main()



