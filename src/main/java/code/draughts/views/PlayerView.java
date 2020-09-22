package main.java.code.draughts.views;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.models.Coordinate;
import main.java.code.draughts.types.Error;

public abstract class PlayerView {

    protected Logic logic;

    public PlayerView(Logic logic) {
        this.logic = logic;
    }
  
    public abstract Coordinate readCoordinateToPut();
    public abstract Coordinate[] readCoordinatesToMove();

    public Error getPutCoordinateError(Coordinate coordinate) {
        return this.logic.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		return this.logic.getMoveOriginCoordinateError(originCoordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.logic.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}
}