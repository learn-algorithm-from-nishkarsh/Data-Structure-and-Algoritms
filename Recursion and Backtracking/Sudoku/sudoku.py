'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

# This function returns False if we found vacant position
# Otherwise returns True
def getNextVacant(grid,nextCell):
    for i in range(0,9):
        for j in range(0,9):
            if grid[i][j] == 0:
                nextCell[0] = i
                nextCell[1] = j
                return False
    return True

def is_safe(grid,row,col,num):
    #Check if cell is not empty
    if grid[row][col] != 0:
        return False
       
    # Check if we have same num in similar row
    for c in range(0,9):
        if grid[row][c] == num:
            return False
    
    # Check if we have same num in similar column
    for r in range(0,9):
        if grid[r][col] == num:
            return False
    
    # Check if we find the same num in
    # the particular 3*3 matrix,
    startRow  = row - row%3
    startCol = col - col%3
    for i in range(startRow, startRow+3):
        for j in range(startCol, startCol+3):
            if grid[i][j] == num:
                return False
                
    return True

def solve_for(grid):
    nextCell = [0,0]
    if(getNextVacant(grid,nextCell)):
        return True
    
    row = nextCell[0]
    col = nextCell[1]
    
    for num in range(1,10):
        # Check if it is safe to place
        # the num (1-9)  in the
        # given row and col,
        # if yes we move ahead
        if(is_safe(grid,row,col,num)):
        
            # Assigning the num in the current (row,col)
            # position of the grid and assuming our assigned
            # num in the position is correct
            grid[row][col] = num
            
            # Checking for next possibility
            # and see whether we can solve complete sudoku
            if(solve_for(grid)):
                return True
        
        # Removing the assigned num,
        # since our assumption was wrong,
        # and we go for next assumption with
        # different num value
        grid[row][col] = 0
    return False
    
def displayGrid(grid):
    for i in range(0,9):
        for j in range(0,9):
            print(grid[i][j],end=" ")
        print()
        
        
def main():
    grid=[[5,0,0,0,2,7,0,0,1], 
           [8,0,0,0,0,0,0,7,5], 
           [6,0,2,0,3,0,9,4,0], 
           [1,5,0,4,9,0,0,0,3], 
           [0,8,0,7,0,0,0,0,9], 
           [0,0,0,2,1,8,0,0,0], 
           [4,0,0,9,0,2,0,0,7], 
           [9,2,8,3,0,0,0,1,6], 
           [0,6,3,1,8,5,0,0,0]] 
      
    solve_for(grid)
    displayGrid(grid)
    
main()

