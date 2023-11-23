package it.unibo.mvc;

import java.util.List;
/**
 *
 */
public interface Controller {

    void setNextString(String line);

    String getNextString();
    
    List<String> getStringHistory();
    
    void printCurrentString();

}
