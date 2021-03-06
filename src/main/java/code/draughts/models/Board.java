package main.java.code.draughts.models;

import main.java.code.utils.Direction;
import main.java.code.draughts.types.Token;

public class Board {

	static final char EMPTY = '-';

	private Coordinate[][] coordinates;

	public Board() {
		this.coordinates = new Coordinate[Turn.NUM_PLAYERS][Player.PIECES];
		/*for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
			for (int j = 0; j < Player.PIECES; j++) {
				this.coordinates[i][j] = null;
			}
		}*/
		int contWhite=0;
		int contBlack=0;
		for(int row = 0; row < Coordinate.DIMENSION; row++){
			for(int column = 0; column < Coordinate.DIMENSION; column++) {
				if(row!=3 && row!=4){
					if(row<=2){
						if((row%2==1 && column%2==0) || (row%2==0 && column%2==1)){
							this.coordinates[0][contWhite] = new Coordinate(row, column);
							contWhite++;
						}
					}else{
						if((row%2==1 && column%2==0) || (row%2==0 && column%2==1)){
							this.coordinates[1][contBlack] = new Coordinate(row, column);
							contBlack++;
						}
					}
				}
			}
		}
	}

	public Token getToken(Coordinate coordinate) {
		for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
			for (int j = 0; j < Player.PIECES; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					return Token.values()[i];
				}
			}
		}
		return null;
	}

	void move(Coordinate originCoordinate, Coordinate coordinate) {
		Token token = this.getToken(originCoordinate);
		assert !this.isEmpty(originCoordinate);
		this.remove(originCoordinate);
		assert this.isEmpty(coordinate);
		this.put(coordinate, token);
	}

	void put(Coordinate coordinate, Token token) {
		int i = 0;
		assert this.isEmpty(coordinate);
		while (this.coordinates[token.ordinal()][i] != null) {
			i++;
		}
		this.coordinates[token.ordinal()][i] = coordinate;
	}

	private void remove(Coordinate coordinate) {
		for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
			for (int j = 0; j < Player.PIECES; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					this.coordinates[i][j] = null;
				}
			}
		}
	}

	boolean isTicTacToe(Token token) {
		Coordinate[] coordinates = this.coordinates[token.ordinal()];
		return this.checkNumberOfCoordinates(coordinates) && this.checkDirectionOfFirstCoordinates(coordinates)
				&& this.checkDirectionOfAllCoordinates(coordinates);
	}

	private boolean checkNumberOfCoordinates(Coordinate[] coordinates) {
		return this.numberOfCoordinates(coordinates) == Coordinate.DIMENSION;
	}

	private boolean checkDirectionOfFirstCoordinates(Coordinate[] coordinates) {
		return coordinates[0].inDirection(coordinates[1]);
	}

	private boolean checkDirectionOfAllCoordinates(Coordinate[] coordinates) {
		Direction direction = coordinates[0].getDirection(coordinates[1]);
		for (int i = 1; i < coordinates.length - 1; i++) {
			if (direction != coordinates[i].getDirection(coordinates[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private int numberOfCoordinates(Coordinate[] coordinates) {
		int count = 0;
		for (int i = 0; i < coordinates.length; i++) {
			if (coordinates[i] != null) {
				count++;
			}
		}
		return count;
	}

	boolean isCompleted() {
		for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isEmptyOfTokens(int player) {
		for (int i = 0; i < coordinates[player].length; i++){
			for (int j = 0; j < Player.PIECES; j++) {
				if (this.coordinates[i][j] != null) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isEmpty(Coordinate coordinate) {
		return this.isOccupied(coordinate, null);
	}

	boolean isOccupied(Coordinate coordinate, Token token) {
		return this.getToken(coordinate) == token;
	}

}
