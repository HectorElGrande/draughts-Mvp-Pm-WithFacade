package main.java.code.draughts.views.console;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.models.Coordinate;
import main.java.code.draughts.views.MessageView;
import main.java.code.utils.WithConsoleView;
import main.java.code.draughts.types.Error;

class CoordinateView extends WithConsoleView {

    Logic logic;

    CoordinateView(Logic logic) {
        this.logic = logic;
    }

    Coordinate read(String title) {
        Coordinate coordinate;
        do {
			this.console.writeln(title);
            int row = this.console.readInt(MessageView.READ_ROW.getMessage()) - 1;
            int column = this.console.readInt(MessageView.READ_COLUMN.getMessage()) - 1;
            coordinate = new Coordinate(row, column);
            assert logic.isCoordinateValid(coordinate);
            if (!this.logic.isCoordinateValid(coordinate)) {
                new ErrorView(Error.WRONG_COORDINATES).writeln();
            }
        } while (!this.logic.isCoordinateValid(coordinate));
        return coordinate;
    }
}