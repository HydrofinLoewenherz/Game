package net.colorman;

import javafx.application.Application;
import javafx.stage.Stage;
import net.colorman.gui.GameScene;
import net.colorman.gui.MainMenu;
import net.colorman.handler.GameHandler;
import net.colorman.handler.ObjectHandler;
import net.colorman.handler.RoundHandler;
import net.colorman.handler.SettingsHandler;
import net.colorman.threads.ActThread;

public class Game extends Application{

    /**
     * The instance representing the Game
     */
    private static Game instance;

    /**
     * The mainWindow
     */
    private Stage window;

    /**
     * The MainMenu
     */
    private MainMenu mainMenu;

    /**
     * The GameScene
     */
    private GameScene gameScene;

    /**
     * The MainHandler (GameHandler)
     */
    private GameHandler mainHandler;

    /**
     * The ObjectHandler
     */
    private ObjectHandler objectHandler;

    /**
     * The ActThread
     */
    private ActThread actThread;

    /**
     * The RoundHandler
     */
    private RoundHandler roundHandler;

    /**
     * The SettingsHandler
     */
    private SettingsHandler settingsHandler;


    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        window = primaryStage;

        settingsHandler = new SettingsHandler();
        mainMenu = new MainMenu();
        gameScene = new GameScene();
        mainHandler = new GameHandler();
        objectHandler = new ObjectHandler();
        actThread = new ActThread(80);
        roundHandler = new RoundHandler();

        window.setResizable(false);
        window.setFullScreenExitHint("");
        window.setScene(mainMenu.getScene());
        window.setOnShowing(event -> window.setFullScreen(true));
        window.setOnCloseRequest(event -> mainHandler.handelGameEnd());
        window.getIcons().add(Game.getInstance().getObjectHandler().getResourceLoader().getImage("windowIcon.png"));
        window.setTitle("ColorMan");
        window.show();

        mainHandler.handelGameStart();
    }

    /**
     * The Main-Method that starts the Game
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * A Getter for the Instance
     *
     * @return Instance
     */
    public static Game getInstance() {
        return instance;
    }

    /**
     * A Getter for the MainHandler
     *
     * @return MainHandler
     */
    public GameHandler getMainHandler() {
        return mainHandler;
    }

    /**
     * A Getter for the Window
     *
     * @return Window
     */
    public Stage getWindow() {
        return window;
    }

    /**
     * A Getter for the MainMenu
     *
     * @return MainMenu
     */
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    /**
     * A Getter for the GameScene
     *
     * @return GameScene
     */
    public GameScene getGameScene() {
        return gameScene;
    }

    /**
     * A Getter for the ObjectHandler
     *
     * @return ObjectHandler
     */
    public ObjectHandler getObjectHandler() {
        return objectHandler;
    }

    /**
     * A Getter for the ActThread
     *
     * @return ActThread
     */
    public ActThread getActThread() {
        return actThread;
    }

    /**
     * A Getter for the RoundHandler
     *
     * @return RoundHandler
     */
    public RoundHandler getRoundHandler() {
        return roundHandler;
    }

    /**
     * A Getter for the SettingsHandler
     *
     * @return SettingsHandler
     */
    public SettingsHandler getSettingsHandler() {
        return settingsHandler;
    }
}
