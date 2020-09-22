package main.java.code.draughts.views.console;

import main.java.code.utils.Console;
import main.java.code.draughts.types.Error;

class ErrorView extends main.java.code.draughts.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}

}
