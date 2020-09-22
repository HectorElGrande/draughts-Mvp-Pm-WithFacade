package main.java.code.draughts.controllers;

import main.java.code.draughts.models.Game;
class StartController extends Controller {
    
    StartController(Game game) {
		super(game);
	}

	void createPlayers(int numberOfUsers) {
		this.game.createPlayers(numberOfUsers);
	}
}