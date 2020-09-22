package main.java.code.draughts.controllers;

import main.java.code.draughts.models.Game;

public class ResumeController extends Controller {

	public ResumeController(Game game) {
		super(game);
	}

	public void newGame() {
		this.game.newGame();
	}

}
