package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String line;
    private List<String> stringList;

    public SimpleController() {
        this.line = "";
        this.stringList = new ArrayList<>();
    }

    public void setNextString(final String line) {
        Objects.requireNonNull(line, "String cannot be null");
        this.line = line;
    }

    public String getNextString() {
        return System.console().readLine();
    }

    public List<String> getStringHistory() {
        return this.stringList;
    }

    public void printCurrentString() {
        System.out.println(this.line);
    }

    public void addPrintedStringToHistory(final String line) {
        this.stringList.add(line);
    }
}
