package main.java.code.draughts.controllers;

import main.java.code.draughts.models.Game;

abstract class Controller {
    
    protected Game game;

	Controller(Game game) {
		this.game = game;
	}
}