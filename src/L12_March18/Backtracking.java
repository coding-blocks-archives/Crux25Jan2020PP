package L12_March18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Backtracking {

	static int count = 0;

	public static void main(String[] args) {

		// QueenPermutation(new boolean[5], 0, 3, "");
		// QueenCombination(new boolean[4], 0, 2, "", -1);

		// CoinChange(new int[] { 2, 3, 5, 6 }, 10, "", 0);

		// CoinChangeP(new int[] { 2, 3, 5, 6 }, 10, "");

		// QueenCombinationBoxRespect(new boolean[4], 0, 0, 2, "");

		// CoinChangeCoinRespect(new int[] { 1, 2, 3 }, 0, 4, "");

		// QueenCombinationBoxRespect2DKill(new boolean[3][4], 0, 0, 0, 3, "");

		// boolean[][] board = new boolean[5][5] ;
		// NQueen(board, 0, 0, 0, board.length , "");

		// boolean[][] board = new boolean[3][3];
		// NKnights(board, 0, 0, 0, board.length, "");

		// NQueen2(new boolean[4][4], 0, 0, 4, "");

		// KQueen(new boolean[4][4], 0, 0, 3, "");
		
		int[][] maze = {{0,1,0,0} ,{0,0,0,0}, {0,1,0,0} , {0,0,1,0} } ;
		BlockedMaze(maze, 0, 0, "" , new boolean[maze.length][maze[0].length]);

	}

	public static void QueenPermutation(boolean[] boxes, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = 0; i < boxes.length; i++) {

			if (boxes[i] == false) {
				boxes[i] = true;
				QueenPermutation(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ");
				boxes[i] = false; // undo

			}
		}

	}

	public static void QueenCombination(boolean[] boxes, int qpsf, int tq, String ans, int lastBoxUsed) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = lastBoxUsed + 1; i < boxes.length; i++) {

			boxes[i] = true;
			QueenCombination(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ", i);
			boxes[i] = false; // undo

		}

	}

	public static void CoinChange(int[] denom, int amount, String ans, int lastDenomIdx) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = lastDenomIdx; i < denom.length; i++) {
			if (amount >= denom[i])
				CoinChange(denom, amount - denom[i], ans + denom[i], i);
		}

	}

	public static void CoinChangeP(int[] denom, int amount, String ans) {

		if (amount == 0) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		if (amount < 0) {
			return;
		}

		for (int i = 0; i < denom.length; i++) {
			CoinChangeP(denom, amount - denom[i], ans + denom[i]);
		}

	}

	public static void QueenCombinationBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans) {

		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		// negative bc
		if (col == board.length) {
			return;
		}

		// place
		board[col] = true;
		QueenCombinationBoxRespect(board, col + 1, qpsf + 1, tq, ans + "b" + col);
		board[col] = false;

		// not place
		QueenCombinationBoxRespect(board, col + 1, qpsf, tq, ans);

	}

	public static void CoinChangeCoinRespect(int[] denom, int vidx, int amount, String ans) {

		// positive bc
		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		// negative bc
		if (amount < 0 || vidx == denom.length) {
			return;
		}

		// yes
		CoinChangeCoinRespect(denom, vidx, amount - denom[vidx], ans + denom[vidx]);
		// no
		CoinChangeCoinRespect(denom, vidx + 1, amount, ans);

	}

	public static void QueenCombinationBoxRespect2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		// manually variables change
		if (col == board[0].length) {
			row++;
			col = 0;
		}

		// negative bc
		if (row == board.length) {
			return;
		}

		// place
		board[row][col] = true;
		QueenCombinationBoxRespect2D(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
		board[row][col] = false;

		// not place
		QueenCombinationBoxRespect2D(board, row, col + 1, qpsf, tq, ans);

	}

	public static void QueenCombinationBoxRespect2DRecCall(boolean[][] board, int row, int col, int qpsf, int tq,
			String ans) {

		// positive bc
		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return;
		}

		// extra rec call
		if (col == board[0].length) {
			QueenCombinationBoxRespect2DRecCall(board, row + 1, 0, qpsf, tq, ans);
			return;
		}

		// negative bc
		if (row == board.length) {
			return;
		}

		// place
		board[row][col] = true;
		QueenCombinationBoxRespect2DRecCall(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
		board[row][col] = false;

		// not place
		QueenCombinationBoxRespect2DRecCall(board, row, col + 1, qpsf, tq, ans);

	}

	public static void QueenCombinationBoxRespect2DKill(boolean[][] board, int row, int col, int qpsf, int tq,
			String ans) {

		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		// manually variables change
		if (col == board[0].length) {
			row++;
			col = 0;
		}

		// negative bc
		if (row == board.length) {
			return;
		}

		// place only if it is safe
		if (isItSafeToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;
			QueenCombinationBoxRespect2DKill(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		// not place
		QueenCombinationBoxRespect2DKill(board, row, col + 1, qpsf, tq, ans);

	}

	public static boolean isItSafeToPlaceTheQueen(boolean[][] board, int row, int col) {

		// vertically upward
		int r = row - 1;
		int c = col;

		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}

		// horizontally left
		r = row;
		c = col - 1;

		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}
			c--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c++;
		}

		return true;

	}

	public static void NQueen(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		// manually variables change
		if (col == board[0].length) {
			row++;
			col = 0;
		}

		// negative bc
		if (row == board.length) {
			return;
		}

		// place only if it is safe
		if (isItSafeToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;
			NQueen(board, row + 1, 0, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		// not place
		NQueen(board, row, col + 1, qpsf, tq, ans);

	}

	public static void NKnights(boolean[][] board, int row, int col, int kpsf, int tk, String ans) {

		if (kpsf == tk) {
			System.out.println(++count + ". " + ans);
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}

		if (row == board.length) {
			return;
		}

		// place
		if (isItSafeToPlaceTheKnight(board, row, col)) {
			board[row][col] = true;
			NKnights(board, row, col + 1, kpsf + 1, tk, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		// not place
		NKnights(board, row, col + 1, kpsf, tk, ans);

	}

	public static boolean isItSafeToPlaceTheKnight(boolean[][] board, int row, int col) {

		int[] rowArr = { -1, -2, -2, -1 };
		int[] colArr = { 2, 1, -1, -2 };

		for (int i = 0; i < 4; i++) {

			int r = row + rowArr[i];
			int c = col + colArr[i];

			if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {

				if (board[r][c]) {
					return false;
				}
			}

		}

		return true;

	}

	public static void NQueen2(boolean[][] board, int row, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeToPlaceTheQueen(board, row, col)) {
				board[row][col] = true;
				NQueen2(board, row + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}

		}

	}

	public static void KQueen(boolean[][] board, int row, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		// option : cols
		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeToPlaceTheQueen(board, row, col)) {
				board[row][col] = true;
				KQueen(board, row + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}

		}

		// not place
		KQueen(board, row + 1, qpsf, tq, ans);

	}

	public static void BlockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {

		// positive bc
		if(row == maze.length-1 && col == maze[0].length-1) {
			System.out.println(ans);
			return ;
		}
		
		if(row ==-1 || row == maze.length ||col ==-1 || col == maze[0].length || maze[row][col] == 1 || visited[row][col]) {
			return ;
		}
		
		// put a mark
		visited[row][col] = true ;
		
		// T
		BlockedMaze(maze, row - 1, col, ans + "T", visited);
		// D
		BlockedMaze(maze, row + 1, col, ans + "D", visited);
		// L
		BlockedMaze(maze, row, col - 1, ans + "L", visited);
		// R
		BlockedMaze(maze, row, col + 1, ans + "R", visited);

		// undo
		visited[row][col] = false ;
	}

}





