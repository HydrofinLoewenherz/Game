package net.colorman.handler;

import net.colorman.Game;
import net.colorman.level.Level;
import net.colorman.level.Level_1;
import net.colorman.level.Level_2;
import net.colorman.level.Level_3;
import net.colorman.level.Level_R;
import net.colorman.objects.Object;
import net.colorman.threads.ActThread;

import java.util.ArrayList;
import java.util.List;

public class RoundHandler {

    /**
     * A List with all the Levels
     */
    private List<Level> levels;

    /**
     * The Level that is loaded right now
     */
    private Level playingLevel;

    public RoundHandler() {
        setupLevelList();
    }

    /**
     * This Method handel's a round Win
     *
     */
    public void handelRoundWin() {
        handelRoundEnd();
    }

    /**
     * This Method handel's the end of a Round and starts the setup of the next
     *
     */
    public void handelRoundEnd() {
        ActThread.WORK = false;
        clear();
    }

    /**
     * This Method clears the clears the Scene by all Objects
     *
     */
    private void clear() {
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(Object::remove);
    }

    /**
     * This Method switches the Round and setup one
     *
     */
    public void setupLevel(Level level) {
        if (level != null) {
            level.setup();
            playingLevel = level;
            ActThread.WORK = true;
        }
    }

    /**
     * This Method adds the different Levels to the levelList
     *
     * @see #levels
     *
     */
    private void setupLevelList(){
        levels = new ArrayList<>();

        levels.add(new Level_1());
        levels.add(new Level_2());
        levels.add(new Level_3());
        levels.add(new Level_R());
    }

    /**
     * A Getter for the levelList
     *
     * @return List </Level>    List of all the Levels
     */
    public List<Level> getLevels() {
        return levels;
    }

    /**
     * A Getter for the Level that is loaded right now
     *
     * @return Level
     */
    public Level getPlayingLevel() {
        return playingLevel;
    }
}
