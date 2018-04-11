package chess;

import java.util.Scanner;

public class Game {

	boolean gameIsOver = false;
	Player player1;
	Player player2;
	Board board;
	String turn = "p1";
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Game game = new Game();
		game.initGame();
		while(game.gameIsOver == false){
			game.choosePieceToMove();
		}
	}
	
	public void initGame(){
		// initializing players
		this.initPlayers();
		this.initBoard();
	}

	/**
	 * this will init players and provide colors to those players
	 */
	public void initPlayers(){
		System.out.println("To select white color piece press 1");
		System.out.println("To select black color piece press 2\n\n");
		System.out.print("Player1 choose your option : ");
		int option = this.scan.nextInt();
		System.out.println(option);
		// checking if correct option is selected or not
		if(option != 1 && option != 2){
			System.out.println("!!!!!!Please provide a correct option\n\n");
			this.initPlayers();
			// returning here to break the recursion
			return;
		}
		
		// if correct option is selected
		String colorPlayer1;
		String colorPlayer2;

		if(option == 1){
			colorPlayer1 = "white";
			colorPlayer2 = "black";
		}else{
			colorPlayer1 = "black";
			colorPlayer2 = "white";
		}
		
		// creating players instances
		this.player1 = new Player(colorPlayer1);
		this.player2 = new Player(colorPlayer2);

		System.out.println("Players successfully initialized...");
	}
	
	/**
	 * This will initialize the board
	 */
	public void initBoard(){
		this.board = new Board();
		//board.getCurrentSnapshot();
	}
	
	/**
	 * This will help to choose piece to move
	 */
	public void choosePieceToMove(){
		System.out.print("Enter the X location of piece :");
		int x = this.scan.nextInt();
		System.out.print("Enter the Y location of piece :");
		int y = this.scan.nextInt();
	
		// checking if correct piece is selected or not
		try{
			this.board.checkCorrectPieceSelected(x,y,this.player1);
		}catch(Exception e){
			System.out.println(e.getMessage());
			this.choosePieceToMove();
			return;
		}
		
		// if correct piece is selected then show the movement projections
		this.board.getMovementProjections(x,y);
	}
	
}
