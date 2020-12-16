package LogicalProgrammingQuestions;

public class BoardProblem {
	public static void main(String[] args) {
		char[][] c= new char[4][4];
		char a= 'A';
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				c[i][j] = (char)((int)a+1);
				a= c[i][j];
			}
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(c[i][j]);
			}
			System.out.println("");
		}
		
		System.out.println(exist(c, "EIMQ"));
		
	}
	
	
	public static boolean exist(char[][] board,String word) {
		boolean result=false;
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(dfs(board, word, i, j, 0)) {
					result = true;
				}
			}
		}
		return result;
	}
	
	public static boolean dfs(char[][] board,String word,int i,int j,int k) {
		int m = board.length;
		int n = board[0].length;
		
		if(i<0 || j<0 || i>=m || j>=n ) {
			return false;
		}
		if(board[i][j]==word.charAt(k)) {
			if(k ==word.length()-1) {
				return true;
			}else if(dfs(board, word, i, j+1 , k+1)  || dfs(board, word, i, j-1, k+1) ||
			   dfs(board, word, i+1 , j ,k+1)  || dfs(board,word,i-1,j,k+1)) {
				return true;
			}
		}
		
		return false;
		
	}
}
