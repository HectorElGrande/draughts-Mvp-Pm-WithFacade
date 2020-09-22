package main.java.code.draughts;

import main.java.code.draughts.controllers.Logic;
import main.java.code.draughts.views.View;

public abstract class Draughts {

    private Logic logic;

    private View view;

    protected Draughts() {
        this.logic = new Logic();
		this.view = this.createView(this.logic);
    }

    protected abstract View createView(Logic logic);

    protected void play() {
        this.view.interact();
    }
}