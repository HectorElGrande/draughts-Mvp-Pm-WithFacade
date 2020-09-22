package main.java.code.draughts.views.console;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.models.Coordinate;
import main.java.code.draughts.views.MessageView;
import main.java.code.utils.WithConsoleView;

class BoardView extends WithConsoleView {
    
    private Logic logic;

    BoardView(Logic logic) {
        this.logic = logic;
    }

    void write() {
        this.console.writeln(MessageView.SEPARATOR.getMessage());
		for (int i = 0; i < this.logic.getCoordinateDimension(); i++) {
			this.printRowBoard(i);
        }
        this.console.writeln(MessageView.SEPARATOR.getMessage());
	}

	private void printRowBoard(int row) {
        this.console.write(MessageView.VERTICAL_LINE_LEFT.getMessage());
		for (int j = 0; j < this.logic.getCoordinateDimension(); j++) {
			this.printSquareBoard(new Coordinate(row, j));
		}
		this.console.writeln();
	}

	private void printSquareBoard(Coordinate coordinate) {
		if (this.logic.isEmptyToken(coordinate)) {
            this.console.write(MessageView.EMPTY.getMessage());
		} else {
			this.console.write(this.logic.getTokenChar(coordinate));
        }
        this.console.write(MessageView.VERTICAL_LINE_CENTERED.getMessage());
	}
}