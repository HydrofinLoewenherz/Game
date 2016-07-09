package net.colorman.handler;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import net.colorman.Game;

import java.awt.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CommandHandler {

    private Queue<Point> queue;

    public CommandHandler(Scene scene) {
        queue = new ConcurrentLinkedQueue<>();

        scene.setOnKeyPressed(this::handelPress);
        scene.setOnMouseClicked(this::handelMouse);
    }

    private void handelPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            Game.getInstance().getWindow().setMaximized(true);
            Game.getInstance().getMainHandler().handelPauseOn();
        }
    }

    private void handelMouse(MouseEvent event) {
        queue.add(new Point((int) event.getSceneX(), (int) event.getSceneY()));
    }

    public boolean isKeyCommandAvailable() {
        return queue.size() > 0;
    }

    public Point getCurrentCommand() {
        return queue.poll();
    }
}
