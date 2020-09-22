package main.java.code.draughts.views.console;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.views.MessageView;
import main.java.code.utils.YesNoDialog;

class ResumeView {
	
	private Logic logic;
	
	ResumeView (Logic logic){
		this.logic = logic;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (newGame) {
			this.logic.newGame();
		}
		return newGame;
	}

}
