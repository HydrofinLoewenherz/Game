package net.colorman.enums;

public enum KeyAction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public String getName(KeyAction action) {
        switch (action) {
            case UP:
                return "Up";
            case DOWN:
                return "Down";
            case LEFT:
                return "Left";
            case RIGHT:
                return "Right";
            default:
                return null;
        }
    }
}
