/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

#include <bits/stdc++.h>
using namespace std;

#define N 8

bool is_safe(int board[N], int currentRow, int currentCol)
{
    for(int row = 0; row <= currentRow; row++)
    {
        if(board[row] == currentCol || abs(board[row] - currentCol) == abs(row - currentRow) )
            return false;
    }
    return true;
}

bool solve_for(int board[N],int currentRow)
{
    if(currentRow >= N)
        return true;

    for(int currentCol = 0; currentCol < N; currentCol++)
    {
        if(is_safe(board, currentRow, currentCol)){
            board[currentRow] = currentCol;
            if(solve_for(board, currentRow+1) )
                return true;
        }
    }
    return false;
}
    
void displayBoard(int board[N])
{
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++){
            if(board[i] == j){
                cout << "Q  ";
            }
            else{
                cout << "_  ";
            }
        }
        cout << endl;
    }
}
    

int main(){
    int board[N] = {-1, -1, -1, -1};

    solve_for(board, 0);
    displayBoard(board);
    return 0;
}


