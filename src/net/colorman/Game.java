package net.colorman;

import javafx.application.Application;
import javafx.stage.Stage;
import net.colorman.gui.MainMenu;
import net.colorman.handler.ExceptionHandler;
import net.colorman.handler.GameHandler;

public class Game extends Application{

    private static Game instance;
    private Stage window;
    private MainMenu mainMenu;
    private GameHandler mainHandler;
    private ExceptionHandler exceptionHandler;


    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        window = primaryStage;

        mainMenu = new MainMenu();
        mainHandler = new GameHandler();
        exceptionHandler = new ExceptionHandler();

        window.setScene(mainMenu.getScene());
        window.setOnCloseRequest(event -> mainHandler.handelGameEnd());
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //--Getter--

    public static Game getInstance() {
        return instance;
    }

    public GameHandler getMainHandler() {
        return mainHandler;
    }

    public Stage getWindow() {
        return window;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public ExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }
}
