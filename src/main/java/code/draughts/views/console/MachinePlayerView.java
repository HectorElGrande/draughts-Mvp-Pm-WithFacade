package main.java.code.draughts.views.console;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.models.Coordinate;
import main.java.code.draughts.types.Error;
import main.java.code.draughts.views.PlayerView;

class MachinePlayerView extends PlayerView {

	MachinePlayerView(Logic logic) {
		super(logic);
	}

	@Override
	public Coordinate readCoordinateToPut() {
		Coordinate coordinate;
		Error error;
		do {
			coordinate = this.logic.generateRandomCoordinate();
			error = this.getPutCoordinateError(coordinate);
		} while (error != null);
		return coordinate;
	}

	@Override
	public Coordinate[] readCoordinatesToMove() {
		Coordinate[] coordinates = new Coordinate[2];
		Error error;
		do {
			coordinates[0] = this.logic.generateRandomCoordinate();
			error = this.getMoveOriginCoordinateError(coordinates[0]);
		} while (error != null);
		do {
			coordinates[1] = this.logic.generateRandomCoordinate();
			error = this.getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
		} while (error != null);
		return coordinates;
	}

}