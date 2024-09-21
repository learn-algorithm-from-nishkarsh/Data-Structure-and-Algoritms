'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

N = 8
def solve_for(board, currentRow=0):
    if currentRow >= N:
        return True
        
    for currentCol in range(N):
        if is_safe(board, currentRow, currentCol):
            board[currentRow] = currentCol
            if(solve_for(board, currentRow+1) ):
                return True
    return False
    
def is_safe(board, currentRow, currentCol):
    for row in range(currentRow):
        if(board[row] == currentCol or abs(board[row] - currentCol) == abs(row - currentRow)):
            return False
            
    return True

    
def displayBoard(board):
    for row in range(N):
        for col in range(N):
            if board[row] == col:
                print("Q",end=" ")
            else:
                print("_",end=" ")
        print()

def main():
    board = [-1 for _ in range(N)]
    solve_for(board)
    displayBoard(board)
main()


