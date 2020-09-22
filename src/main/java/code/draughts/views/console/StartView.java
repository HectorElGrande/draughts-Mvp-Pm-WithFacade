package main.java.code.draughts.views.console;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.models.Turn;
import main.java.code.draughts.views.MessageView;
import main.java.code.utils.PlayersDialog;
import main.java.code.utils.WithConsoleView;

class StartView extends WithConsoleView {

	private Logic logic;

	StartView(Logic logic) {
		this.logic = logic;
	}

    void interact() {
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
		this.logic.createPlayers(numberOfUsers);
	}
}