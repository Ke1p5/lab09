package it.unibo.mvc;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberStdView;
import it.unibo.mvc.view.DrawNumberSwingView;
import java.lang.reflect.*;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        
        final Class<DrawNumberStdView> std = DrawNumberStdView.class;
        final Class<DrawNumberSwingView> swing = DrawNumberSwingView.class;
        Constructor<DrawNumberStdView> stdConstructor = null;
        Constructor<DrawNumberSwingView> swingConstructor = null;
        try {
            stdConstructor = std.getConstructor();
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        try {
            swingConstructor = swing.getConstructor();
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        
        for (int i = 0; i < 3; i++) {
            try {
                app.addView(stdConstructor.newInstance());
            } catch (InvocationTargetException e) {
                System.out.println(e.getMessage());
            } catch (InstantiationException e) {
                System.out.println(e.getMessage());
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
            try {
                app.addView(swingConstructor.newInstance());
            } catch (InvocationTargetException e) {
                System.out.println(e.getMessage());
            } catch (InstantiationException e) {
                System.out.println(e.getMessage());
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}