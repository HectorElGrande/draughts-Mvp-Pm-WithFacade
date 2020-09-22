package main.java.code.draughts.views.console;

import main.java.code.draughts.types.Token;
import main.java.code.draughts.views.MessageView;
import main.java.code.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void writeln(int winner) {
        this.console.write(Token.values()[winner].getChar());
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}