package main.java.code.draughts.views.console;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.models.Coordinate;
import main.java.code.draughts.types.PlayerType;
import main.java.code.draughts.views.PlayerView;

class PlayView {

    Logic logic;

    PlayView(Logic logic) {
        this.logic = logic;
    }

    boolean interact() {
        new BoardView(this.logic).write();
        PlayerView playerView = this.logic.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView(this.logic)
                : new MachinePlayerView(this.logic);
        if (!this.logic.isEmptyOfTokens()) {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            this.logic.moveTokenPlayerFromTurn(coordinates[0], coordinates[1]);
        }
        new BoardView(this.logic).write();
        if (this.logic.isTicTacToe()) {
            new ResultView().writeln(this.logic.getValueFromTurn());
            return true;
        }
        this.logic.changeTurn();
        return false;
    }
}