package chess.pieces;


public abstract class Piece {
	public String color;
	public abstract void move(int xPostion,int yPosition);
	public abstract int[][] showMoveMentProjections(int xPosition,int yPosition);

	public String getColor(){
		return this.color;
	}
	public String getIdentifier(){
		String className = this.getClass().getSimpleName();
		String color = this.getColor();
		if(color.equals("white")){
			color = "W";
		}else if(color.equals("black")){
			color = "B";
		}
		return color.concat("-").concat(className);
	}
}
