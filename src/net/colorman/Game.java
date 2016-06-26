package net.colorman;

import javafx.application.Application;
import javafx.stage.Stage;
import net.colorman.gui.GameScene;
import net.colorman.gui.MainMenu;
import net.colorman.handler.GameHandler;
import net.colorman.handler.ObjectHandler;
import net.colorman.threads.ActThread;

public class Game extends Application{

    private static Game instance;
    private Stage window;
    private MainMenu mainMenu;
    private GameScene gameScene;
    private GameHandler mainHandler;
    private ObjectHandler objectHandler;
    private ActThread actThread;


    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        window = primaryStage;

        mainMenu = new MainMenu();
        gameScene = new GameScene();
        mainHandler = new GameHandler();
        objectHandler = new ObjectHandler();
        actThread = new ActThread(80);

        window.setResizable(false);
        window.setFullScreenExitHint("");
        window.setScene(mainMenu.getScene());
        window.setOnShowing(event -> window.setFullScreen(true));
        window.setOnCloseRequest(event -> mainHandler.handelGameEnd());
        window.getIcons().add(Game.getInstance().getObjectHandler().getResourceLoader().getImage("windowIcon.png"));
        window.setTitle("ColorMan");
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

    public GameScene getGameScene() {
        return gameScene;
    }

    public ObjectHandler getObjectHandler() {
        return objectHandler;
    }

    public ActThread getActThread() {
        return actThread;
    }
}
