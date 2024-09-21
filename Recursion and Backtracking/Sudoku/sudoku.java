/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

class Sudoku {

    static int N = 9;
	static int nextRow;
	static int nextCol;
	
	// This function returns False if we found vacant position
	// Otherwise returns True
	public static boolean getNextVacant(int grid[][]){
		for(int r=0;r<9;r++){
			for(int c=0;c<9;c++){
				if(grid[r][c] == 0){
					nextRow = r;
					nextCol = c;
					return false;
				}
			}
		}
		return true;
	}

	public static boolean is_safe(int grid[][],int row,int col, int num){
		// Check if we have same num in similar row
		for(int c=0; c<9; c++){
			if(grid[row][c] == num){
				return false;
			}
		}
		
		// Check if we have same num in similar column
		for(int r=0; r<9; r++){
			if(grid[r][col] == num){
				return false;
			}
		}
		
		// Check if we find the same num in
		// the particular 3*3 matrix,
		int startRow = row - (row%3);
		int startCol = col - (col%3);
		for(int i=startRow; i < startRow+3; i++){
			for(int j=startCol; j < startCol+3; j++){
				if(grid[i][j] == num){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean solve_for(int grid[][]){
		if(getNextVacant(grid)){
			return true;
		}
		
		int row = nextRow;
		int col = nextCol;
		
		for(int num =1; num<=9; num++){
			// Check if it is safe to place
			//  the num (1-9)  in the
			//  given row and col,
			//  if yes we move ahead 
			if(is_safe(grid, row, col, num)){
				
				// Assigning the num in the current (row,col)
				// position of the grid and assuming our assigned
				// num in the position is correct
				
				grid[row][col] = num;
				
				// Checking for next possibility
				// and see whether we can solve complete sudoku
				if(solve_for(grid)){
					return true;
				}
			}
			
			// Removing the assigned num,
			// since our assumption was wrong,
			// and we go for next assumption with
			// different num value
			grid[row][col] = 0;
		}
		return false;
	}
	
    public static void displayGrid(int grid[][])
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
			  System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}

    public static void main(String args[])
    {
        int grid[][]={{5,0,0,0,2,7,0,0,1}, 
					  {8,0,0,0,0,0,0,7,5}, 
					  {6,0,2,0,3,0,9,4,0}, 
					  {1,5,0,4,9,0,0,0,3}, 
					  {0,8,0,7,0,0,0,0,9}, 
					  {0,0,0,2,1,8,0,0,0}, 
					  {4,0,0,9,0,2,0,0,7}, 
					  {9,2,8,3,0,0,0,1,6}, 
					  {0,6,3,1,8,5,0,0,0}};
      
		solve_for(grid);
		displayGrid(grid);
    }

}
