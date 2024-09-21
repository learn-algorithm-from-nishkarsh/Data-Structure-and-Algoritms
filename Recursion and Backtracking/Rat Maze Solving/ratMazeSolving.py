'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

N = 6

Grid = [
    [1, 0, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 1],
    [0, 0, 1, 1, 1, 1],
    [1, 1, 1, 1, 0, 0],
    [1, 0, 0, 1, 1, 0],
    [1, 0, 0, 0, 1, 1]
]

# startX,startY indicates starting point
startX = 0
startY = 0
# endX,endY indicates ending point
endX = N-1
endY = N-1

# To store the final solution of the maze path
sol = [[0] * N for _ in range(N)]

def showPath():
    print("The solution maze:")
    for row in sol:
        print(*row)
        
#Returns the next possible move for rat
def getNextPos(x,y,move):
    if move == 'R':
        return (x,y+1)
    elif move == 'D':
        return (x+1,y)

#Return True if rat can go to x,y position otherwise false
def is_safe_place(x,y):
    if x<0 or y<0:
        return False
    elif x >= N or y >= N:
        return False
    elif Grid[x][y] == 0:
        return False
    elif(sol[x][y] == 1):
        return False
    return True
        
# Solve the rat maze,
# return True if rat can reach final position
# Otherwise returns False
def solve_for_rat_maze(x,y):
    sol[x][y] = 1
    if x == endX and y == endY:
        return True
    
    for move in ['R','D']:
        nextX,nextY = getNextPos(x,y,move)
        if(is_safe_place(nextX,nextY)):
            
            res = solve_for_rat_maze(nextX,nextY)
            if(res):
                return True
                
    sol[x][y] = 0
    return False
    
def findSolution():
    if not solve_for_rat_maze(0, 0):
        print("There is no path")
        return False
    showPath()
    return True
   
def main():
    findSolution()

main()

