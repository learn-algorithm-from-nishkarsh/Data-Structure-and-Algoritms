/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

#include <bits/stdc++.h>
using namespace std;

// N is the size of the 2D matrix   N*N
#define N 6

int endX = N-1;
int endY = N-1;

//Return True if rat can go to x,y position otherwise false
bool is_safe_place(int x, int y,int grid[N][N],int sol[N][N]){
    if( x<0 || y<0)
		return false;
	else if( x >= N || y >= N)
		return false;
	else if(grid[x][y] == 0)
		return false;
	else if(sol[x][y] == 1)
		return false;
	return true;
}

bool solve_for_rat_maze(int x,int y,int grid[N][N],int sol[N][N]){
    sol[x][y] = 1;
	if(x == endX && y == endY){
		return true;
	}
	
	//Check for R direction
	int nextX = x;
	int nextY = y+1;
	if(is_safe_place(nextX,nextY,grid,sol)){
		bool res = solve_for_rat_maze(nextX,nextY,grid,sol);
		if(res)
			return true;
	}
	
	//Check for D direction
	nextX = x+1;
	nextY = y;
	if(is_safe_place(nextX,nextY,grid,sol)){
		bool res = solve_for_rat_maze(nextX,nextY,grid,sol);
		if(res)
			return true;
	}
					
	sol[x][y] = 0;
	return false;
}

void showPath(int grid[N][N])
{
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        {
         cout<<grid[i][j]<<" ";
        }
        cout<<endl;
    }
}

int main() {
	
	int grid[N][N]={{1, 0, 0, 0, 0, 0},
     				{1, 1, 1, 0, 0, 1},
     				{0, 0, 1, 1, 1, 1},
     				{1, 1, 1, 1, 0, 0},
     				{1, 0, 0, 1, 1, 0},
     				{1, 0, 0, 0, 1, 1}};
      
	int sol[N][N] = {0};
    if(!solve_for_rat_maze(0, 0,grid,sol)){
		cout << "There is no path" <<endl;
		return 0;
	}
	showPath(sol);
	return 0;
}



