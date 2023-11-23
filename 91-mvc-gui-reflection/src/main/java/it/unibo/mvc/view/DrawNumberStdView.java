package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdView implements DrawNumberView {

    private static final String NEW_GAME = ": a new game starts!";

    @Override
    public void start() {
        System.out.println("Start game.");
    }

    @Override
    public void setController(final DrawNumberController observer) {

    }

    @Override
    public void result(final DrawResult res) {
        switch (res) {
            case YOURS_HIGH, YOURS_LOW -> {
                System.out.println(res.getDescription());
                return;
            }
            case YOU_WON, YOU_LOST -> System.out.println(res.getDescription() + NEW_GAME);
            default -> throw new IllegalStateException("Unknown game state");
        }
    }
}
