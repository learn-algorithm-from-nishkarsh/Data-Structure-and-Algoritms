/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

class RatInMaze {

    static int N = 6;
	static int endX = N-1;
	static int endY = N-1;
	
	//Return True if rat can go to x,y position otherwise false
	public static boolean is_safe_place(int x,int y,int grid[][],int sol[][]){
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
	
	// Solve the rat maze,
	// return True if rat can reach final position
	// Otherwise returns False
	public static boolean solve_for_rat_maze(int x,int y,int grid[][],int sol[][]){
		sol[x][y] = 1;
		if(x == endX && y == endY){
			return true;
		}
		
		int nextX, nextY;
		char direction[] = { 'R', 'D'};
		for(char move : direction){
			if(move == 'R'){
				nextX = x;
				nextY = y+1;
			}
			else{
				nextX = x+1;
				nextY = y;
			}
			
			if(is_safe_place(nextX,nextY,grid,sol)){
				boolean res = solve_for_rat_maze(nextX,nextY,grid,sol);
				if(res)
					return true;
			}
		}
					
		sol[x][y] = 0;
		return false;
	}
	
    public static void showPath(int sol[][])
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
			  System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}

    public static void main(String args[])
    {
        int grid[][]= {{1, 0, 0, 0, 0, 0},
     				   {1, 1, 1, 0, 0, 1},
     				   {0, 0, 1, 1, 1, 1},
     				   {1, 1, 1, 1, 0, 0},
     				   {1, 0, 0, 1, 1, 0},
     				   {1, 0, 0, 0, 1, 1}};
        
        int sol[][] = new int[N][N];
      
		if(!solve_for_rat_maze(0, 0,grid,sol)){
			System.out.println("There is no path");
			return;
		}
		showPath(sol);
    }
}



