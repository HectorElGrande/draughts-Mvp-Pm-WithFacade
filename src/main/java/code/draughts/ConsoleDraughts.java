package main.java.code.draughts;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.views.View;
import main.java.code.draughts.views.console.ConsoleView;

class ConsoleDraughts extends Draughts {

	@Override
	protected View createView(Logic logic) {
		return new ConsoleView(logic);
	}

	public static void main(String[] args) {
		new ConsoleDraughts().play();
	}

}
