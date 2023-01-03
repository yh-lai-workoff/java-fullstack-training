package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LaunchTicTacToe {
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		ttt.runGame();
	}
	
	public static void test() {
		CheapAI ai = new CheapAI(0, 0);
		ai.updateEnvironment(new String[][] { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } });
		ai.getInput();
	}
}

class TicTacToe {
	Board b;
	void runGame() {
		int[] parameters = setup();
		Board b = new Board(parameters[0],parameters[1]);
		do {
			b.runGame(parameters[2],parameters[3]);
		} while (checkReplay());
	}
	
	public int[] setup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Player 1\n1) Player\n2) CPU Easy");
		int p1 = sc.nextInt()-1;
		System.out.println("Select Player 2\n1) Player\n2) CPU Easy");
		int p2 = sc.nextInt()-1;
		System.out.println("Enter Board Width");
		int w = sc.nextInt();
		System.out.println("Enter Board Height");
		int h = sc.nextInt();
		System.out.println("Setting up Board for %d x %d size...".formatted(w,h));
		return new int[] {w,h,p1,p2};
	}
	
	public boolean checkReplay() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Replay? (Y/N)");
		return sc.next().toLowerCase().equals("y");
	}
}

class Board {
	int boardWidth = 3;
	int boardHeight = 3;
	String[][] board = new String[boardHeight][boardWidth];

	Board() {
	}

	Board(int startWidth, int startHeight) {
		boardWidth = startWidth;
		boardHeight = startHeight;
		board = new String[boardHeight][boardWidth];
	}

	void runGame(int p1, int p2) {
		initialiseBoard();
		boolean winner = false;
		ArrayList<Player> players = new ArrayList<>();
		if (p1 == 1)
			players.add(new CheapAI(1,0));
		else
			players.add(new HumanPlayer(1, 0));
		if (p2 == 1)
			players.add(new CheapAI(2, 1));
		else
			players.add(new HumanPlayer(2, 1));

		boolean validInput = false;
		while (!winner) {
			
			int[] input;
			for (Player p : players) {
				if (p instanceof FakePlayer) {
					((FakePlayer) p).updateEnvironment(board);
				}
				System.out.println("Player %d's Turn\n".formatted(p.id));
				while (!validInput) {
					printBoard();
					input = p.getInput();
					System.out.println("Input Choice: (%d,%d)".formatted(input[0] + 1, input[1] + 1));
					validInput = this.updateBoard(input, p.id);
				}
				if (checkWinner()) {
					printBoard();
					winner = true;
					System.out.println("Winner is Player %d!".formatted(p.id));
					break;
				} else if (checkDraw()) {
					System.out.println("No winners can be found!\nGame Over!");
					winner = true;
					break;
				}
				validInput = false;
			}
		}

	}

	void printBoard() {
		StringBuilder borderGenerator = new StringBuilder();
		printSeparator();
		for (int height = 0; height < boardHeight; height++) {
			for (int width = 0; width < boardWidth; width++) {
				System.out.print(" " + board[height][width] + " ");
				if (height == 0) {
					borderGenerator.append(" " + (width + 1) + " |");
				}
				if (width != boardWidth - 1) {
					System.out.print("|");
				} else {
					System.out.println("|| %d ".formatted(height + 1));
				}
			}
			printSeparator();
		}
		System.out.println(borderGenerator.toString()+"\n");
	}

	private void initialiseBoard() {
		String symbol = " ";
		for (int height = 0; height < boardHeight; height++) {
			for (int width = 0; width < boardWidth; width++) {
				board[height][width] = symbol;
			}
		}
	}

	private boolean updateBoard(int[] position, int playerID) {
		if (board[position[0]][position[1]] != " ") {
			System.out.println("Slot occupied, please try again!");
			return false;
		}
		if (playerID == 1) {
			board[position[0]][position[1]] = "O";
		} else if (playerID == 2) {
			board[position[0]][position[1]] = "X";
		}
		return true;
	}

	private boolean checkWinner() {
		boolean colFailed = false;
		String[] colCheck = Arrays.copyOf(board[0], board[0].length);

		for (int row = 0; row < boardHeight; row++) {
			String rowCheck = board[row][0];
//			System.out.println("Debug: Array " + Arrays.toString(board[row]));

			for (int col = 0; col < boardWidth; col++) {
				String current = board[row][col];
				// Check if row can win
				if (rowCheck != board[row][col] || rowCheck == " ") {
					rowCheck = "F";
				}
				// Check if columns can win
				if (colCheck[col] != current || colCheck[col] == " ") {
					colCheck[col] = "F";
				}
				// Quick Exit if Row cannot win and no Columns can win (Faster loop)
				if (rowCheck != board[row][col] && colFailed) {
					break;
				}
			}
			// Send win if row can win
			if (rowCheck != "F")
				return true;

			// Update variable if all columns cannot win
			int countCol = 0;
			for (String value : colCheck) {
				if (value == "F") {
					countCol++;
				}
			}
			colFailed = colFailed || (countCol == boardWidth);
//			System.out.println("Debug: " + colFailed + Arrays.toString(colCheck));
		}
		// Send win if ANY Column can win;
		for (String value : colCheck) {
			if (value != "F") {
				return true;
			}
		}

		// Check diagonals
		int smaller = Math.min(boardHeight, boardWidth);
		int diagCounts = Math.max(boardHeight, boardWidth) - smaller + 1;

		for (int start = 0; start < (diagCounts); start++) {
			String[] diagCheck = new String[2];
			for (int index = 0; index < smaller; index++) {
				int reverse = smaller - index -1;
//				System.out.println("DEBUG: %d, %d, %d".formatted(index,start,reverse));
				if (index == 0) {
					if (smaller == boardHeight) {
						diagCheck[0] = board[index][index + start];
						diagCheck[1] = board[reverse][index + start];
					} else {
						diagCheck[0] = board[index + start][index];
						diagCheck[1] = board[index + start][reverse];
					}
				} else {
					if (smaller == boardHeight) {
						if (diagCheck[0] != board[index][index + start] || diagCheck[0] == " ")
							diagCheck[0] = "F";
						if (diagCheck[1] != board[reverse][index + start] || diagCheck[1] == " ")
							diagCheck[1] = "F";
					} else {
						
						if(diagCheck[0] != board[index + start][index] || diagCheck[0] == " ")
							diagCheck[0] = "F";
						if (diagCheck[1] != board[index + start][reverse] || diagCheck[1] == " ")
							diagCheck[1] = "F";
					}
				}

			}
			// TODO: Check back diagonal
			if (diagCheck[0] != "F"  || diagCheck[1] != "F") {
				return true;
			}
		}
		return false;
	}

	private boolean checkDraw() {
		for(String[] row : board) {
			for (String elem : row) {
				if (elem == " ")
					return false;
			}
		}
		return true;
	}
	
	private void printSeparator() {
		boolean alternator = true;
		StringBuilder sb = new StringBuilder();
		int width = boardWidth * 2 - 1;
		while (width > 0) {

			sb.append(alternator ? "---" : "+");
			alternator = !alternator;

			width--;
		}
		sb.append("||");
		System.out.println(sb.toString());
	}

}

abstract class Player {
	int id;
	int order;

	Player(int playerID, int turnOrder) {
		this.id = playerID;
		this.order = turnOrder;
	}

	abstract int[] getInput();
}

interface FakePlayer {
	void updateEnvironment(String[][] boardState);
}

class HumanPlayer extends Player {

	HumanPlayer(int playerID, int turnOrder) {
		super(playerID, turnOrder);
	}

	int[] getInput() {
		int[] output = new int[2];
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input: ");
		System.out.println("Row: ");
		output[0] = sc.nextInt() - 1;
		System.out.println("Column: ");
		output[1] = sc.nextInt() - 1;
		return output;
	}
}

class CheapAI extends Player implements FakePlayer {

	String[][] environment;

	CheapAI(int playerID, int turnOrder) {
		super(playerID, turnOrder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateEnvironment(String[][] boardState) {
		this.environment = boardState;
	}

	@Override
	int[] getInput() {
		int width = environment[0].length;
		int fields = environment.length * width;
		int selection = new Random().nextInt(fields);
		int[] output = new int[] { Math.floorDiv(selection, width), Math.floorMod(selection, width) };

		return output;
	}

}

class MiniMaxAI extends Player implements FakePlayer{
	String[][] environment;

	MiniMaxAI(int playerID, int turnOrder) {
		super(playerID, turnOrder);
	}

	@Override
	public void updateEnvironment(String[][] boardState) {
		this.environment = boardState;
	}

	@Override
	int[] getInput() {
		int currLevel = 0;
		ArrayList<int[]> nextMoves = getNextMoves();
		
		return null;
	}
	
	private ArrayList<int[]> getNextMoves(){
		ArrayList<int[]> output = new ArrayList<>();
		for (int row = 0; row < environment.length; row++) {
			for (int col = 0; col < environment.length; col++) {
				if (environment[row][col] == " ") {
					output.add(new int[] {row,col});
				}
			}
		}
		
		return output;
	}

}

class MMNode {
	int score =0;
	boolean max = true;
	
}

class Utils {
	static String[] flattenArray(String[][] array) {
		ArrayList<String> output = new ArrayList<>();
		for (String[] inner : array) {
			Arrays.stream(inner).forEach(output::add);
		}
		return output.toArray(new String[output.size()]);
	}
}