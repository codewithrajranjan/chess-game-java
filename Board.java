package chess;

import chess.pieces.*;

public class Board {
	Piece[][] board; 
	Player p1;
	Player p2;
	int minRow = 1;
	int maxRow = 8;
	int minCol = 1;
	int maxCol = 8;

	public Board(){
		this.board = new Piece[9][9];
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
				this.board[i][j] = null;
			}
		}
		this.init();
	}
	/**
	 * This will initialize the board
	 */
	public void init(){
		this.initBlack();
		this.initWhite();
	}

	public void initWhite(){
		// initializing rook
		this.board[1][1] = new Rook("white");
		this.board[1][8] = new Rook("white");
		// initializing knight
		this.board[1][2] = new 	Knight("white");
		this.board[1][7] = new 	Knight("white");
		// initializing bishops
		this.board[1][3] = new Bishop("white");
		this.board[1][6] = new Bishop("white");
		// initialing king
		this.board[1][4] = new King("white");
		// initialing queen
		this.board[1][5] = new Queen("white");
		
		// initializing pawns
		for(int i=1;i<=8;i++){
			this.board[2][i] = new Pawn("white");
		}
	}
	public void initBlack(){
		// initializing rook
		this.board[8][1] = new Rook("black");
		this.board[8][8] = new Rook("black");
		// initializing knight
		this.board[8][2] = new 	Knight("black");
		this.board[8][7] = new 	Knight("black");
		// initializing bishops
		this.board[8][3] = new Bishop("black");
		this.board[8][6] = new Bishop("black");
		// initializing king
		this.board[8][4] = new King("black");
		// initializing queen
		this.board[8][5] = new Queen("black");

		// initializing pawns
		for(int i=1;i<=8;i++){
			this.board[7][i] = new Pawn("black");
		}
	}
	public void getCurrentSnapshot(){
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
				if(this.board[i][j] != null){
					System.out.print(this.board[i][j].getIdentifier()+"  ");
				}else{
					
					System.out.print("-----  ");
				}
			}
			System.out.println();
		}
	}
	public boolean isValidPosition(int xPosition,int yPosition){
		if(xPosition >= this.minCol && xPosition <= this.maxCol && yPosition>=this.minRow && yPosition <= this.maxRow){
			return true;
		}else{
			return false;
		}
	}
	public boolean isPositionEmpty(int xPosition,int yPosition){
		if(this.isValidPosition(xPosition,yPosition) == false){
			System.out.println("Invalid Position");
			return false;
		}
		if(this.board[xPosition][yPosition] == null){
			return true;
		}else{
			return false;
		}
	}
	public void checkCorrectPieceSelected(int xPosition,int yPosition,Player player) throws Exception{
		
		// first check if the position is is board boundary
		if(xPosition<this.minCol || xPosition>this.maxCol || yPosition < this.minRow || yPosition>this.maxRow){
			throw new Exception("The location is out of boundary");
		}
		// first checking if player selected his own color
		Piece currentPieceSelected = this.board[xPosition][yPosition];
		// checking if the position selected is null
		if(currentPieceSelected == null){
			throw new Exception("No piece at current location");
		}

		if(player.getColor().equals(currentPieceSelected.getColor()) == false){
			throw new Exception("Please select "+player.getColor()+" color piece. You have choosed opponent piece");
		}
	}
	
	int[][] getMovementProjections(int xPosition,int yPosition){
		
		// first getting the piece instance to move
		Piece currentPiece = this.board[xPosition][yPosition];
		return currentPiece.showMoveMentProjections(xPosition, yPosition);
	}
}
