package net.colorman;

import javafx.application.Application;
import javafx.stage.Stage;
import net.colorman.gui.GameScene;
import net.colorman.gui.MainMenu;
import net.colorman.handler.ExceptionHandler;
import net.colorman.handler.GameHandler;
import net.colorman.handler.ObjectHandler;

public class Game extends Application{

    private static Game instance;
    private Stage window;
    private MainMenu mainMenu;
    private GameScene gameScene;
    private GameHandler mainHandler;
    private ObjectHandler objectHandler;
    private ExceptionHandler exceptionHandler;


    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        window = primaryStage;

        mainMenu = new MainMenu();
        gameScene = new GameScene();
        mainHandler = new GameHandler();
        objectHandler = new ObjectHandler();
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

    public GameScene getGameScene() {
        return gameScene;
    }

    public ObjectHandler getObjectHandler() {
        return objectHandler;
    }
}
