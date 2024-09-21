/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

class KnightTour {

    static int N = 8;
	
	// Move patterns of Knight 
	static int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
	// Return True if Knight can go to x,y position otherwise False
	public static boolean is_safe_place(int x,int y,int board[][]){
		if( x<0 || y<0 || x >= N || y >= N || board[x][y] != -1)
			return false;
		return true;
	}
	
	// Solve the knight Tour Problem,
	// return True if knight can cover each square
	// Otherwise returns False
	public static boolean solve_for_knight_tour(int x,int y,int pos,int board[][]){
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
	
    public static void printSolution(int board[][])
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
			  System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

    public static void main(String args[])
    {
        int board[][] = new int[N][N];
		
		// Initialization of board matrix
        for(int x = 0; x < N; x++)
            for(int y = 0; y < N; y++)
                board[x][y] = -1;
		
		// Since the Knight is initially at the first square
		board[0][0] = 0;
		if(!solve_for_knight_tour(0, 0, 1, board)){
			System.out.println("There is no path");
			return;
		}
		printSolution(board);
    }
}



