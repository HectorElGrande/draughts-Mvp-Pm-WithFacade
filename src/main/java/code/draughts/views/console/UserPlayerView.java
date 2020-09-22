package main.java.code.draughts.views.console;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.models.Coordinate;
import main.java.code.draughts.types.Error;
import main.java.code.draughts.views.PlayerView;

class UserPlayerView extends PlayerView {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

    UserPlayerView(Logic logic) {
        super(logic);
    }

    @Override
    public Coordinate readCoordinateToPut() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = new CoordinateView(this.logic).read(ENTER_COORDINATE_TO_PUT);
            error = this.getPutCoordinateError(coordinate);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        return coordinate;
    }

    @Override
    public Coordinate[] readCoordinatesToMove() {
        Coordinate[] coordinates = new Coordinate[2];
        Error error;
        do {
            coordinates[0] = new CoordinateView(this.logic).read(ENTER_COORDINATE_TO_REMOVE);
            error = this.getMoveOriginCoordinateError(coordinates[0]);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        do {
            coordinates[1] = new CoordinateView(this.logic).read(ENTER_COORDINATE_TO_PUT);
            error = this.getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        return coordinates;
    }
}