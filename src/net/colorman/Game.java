package net.colorman;

import javafx.application.Application;
import net.colorman.gui.MainStage;

public class Game {

    MainStage mainStage;

    public Game(String[] args) {
        mainStage = new MainStage();
        Application.launch(args);
    }

    public void main(String[] args) {
        new Game(args);
    }
}
