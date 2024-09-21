/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

class nQueen {

    static int N = 4;

    static boolean solve_for(int board[], int currentRow)
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

    static boolean is_safe(int board[], int currentRow, int currentCol)
    {
        for(int row = 0; row <= currentRow; row++)
        {
            if(board[row] == currentCol || Math.abs(board[row] - currentCol) == Math.abs(row - currentRow) )
                return false;
        }
        return true;
    }

    static void displayBoard(int board[])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if(board[i] == j){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("_ ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String args[])
    {
        int board[] = {-1, -1, -1, -1};

        solve_for(board, 0);
        displayBoard(board);
    }

}






    

    


