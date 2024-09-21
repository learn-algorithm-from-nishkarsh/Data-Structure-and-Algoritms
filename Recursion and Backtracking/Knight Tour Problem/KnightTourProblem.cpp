/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

#include <bits/stdc++.h>
using namespace std;

// N is the size of the 2D board N*N
#define N 8

// Move patterns of Knight 
const int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
const int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };


// Return True if Knight can go to x,y position otherwise False
bool is_safe_place(int x, int y,int board[N][N]){
    if( x<0 || y<0 || x >= N || y >= N || board[x][y] != -1)
		return false;
	return true;
}

// Solve the knight Tour Problem,
// return True if knight can cover each square
// Otherwise returns False
bool solve_for_knight_tour(int x,int y,int pos,int board[N][N]) {
    if(pos == N*N){
		return true;
	}
		
	for(int i=0;i<8;i++){
		int newX = x + dx[i];
		int newY = y + dy[i];
		// Check for all possible 8 moves
		if(is_safe_place(newX,newY,board)){
			board[newX][newY] = pos;
			if(solve_for_knight_tour(newX,newY,pos+1,board))
				return true;
				
			// Backtrack because solution is not possible from this move
			board[newX][newY] = -1;
		}
	}
	return false;
}

void printSolution(int board[N][N])
{
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        {
         cout<<board[i][j]<<" ";
        }
        cout<<endl;
    }
}

int main() {
	
	int board[N][N];
	
	// Initialization of board matrix
    for(int x = 0; x < N; x++)
        for(int y = 0; y < N; y++)
            board[x][y] = -1;
	
	// Since the Knight is initially at the first square
	board[0][0] = 0;
    if(!solve_for_knight_tour(0, 0, 1, board)){
		cout << "There is no path" <<endl;
		return 0;
	}
	printSolution(board);
	return 0;
}



