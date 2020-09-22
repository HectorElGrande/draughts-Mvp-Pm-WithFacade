package main.java.code.draughts.types;

public enum Token {

	WMAN_TOKEN('w'),
	BMAN_TOKEN('b'),
	WKING_TOKEN('W'),
	BKING_TOKEN('B');

	private char character;

	Token(char character){
		this.character = character;
	}

	public char getChar() {
		return this.character;
	}

}
