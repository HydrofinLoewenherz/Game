package net.colorman.handler;

import net.colorman.objects.Object;
import net.colorman.objects.entitys.player.Player;
import net.colorman.resources.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

public class ObjectHandler {

    /**
     * The ResourceLoader
     *
     * @see ResourceLoader
     */
    private ResourceLoader resourceLoader;

    /**
     * Lists of Objects
     */
    private List<Object> objectsAct, objectsActTemp, objectsToRemove;

    public ObjectHandler() {
        resourceLoader = new ResourceLoader();

        objectsAct = new ArrayList<>();
        objectsActTemp = new ArrayList<>();
        objectsToRemove = new ArrayList<>();
    }

    /**
     * Adder for the ObjectAct List
     *
     * @see #objectsAct
     *
     * @param object    Object that should be abel to act
     */
    public void addObjectAct(Object object) {
        objectsAct.add(object);
    }

    /**
     * Remover for the ObjectsAct List
     *
     * @see #objectsAct
     *
     * @param object
     */
    public void removeObjectsAct(Object object) {
        objectsAct.remove(object);
    }

    /**
     * Adder to the Temp List to be added to the main List (objectsAct)
     *
     * @see #objectsAct
     * @see #objectsActTemp
     *
     * @param object
     */
    public void addToTemp(Object object) {
        objectsActTemp.add(object);
    }

    /**
     * Remover to the Temp List to be removed from the main List (objectsAct)
     *
     * @see #objectsAct
     * @see #objectsActTemp
     *
     * @param object
     */
    public void removeFromTemp(Object object) {
        objectsActTemp.add(object);
    }

    /**
     * This Method clears the objectsActTemp List
     *
     * @see #objectsActTemp
     */
    public void clearTemp() {
        objectsActTemp.clear();
    }

    /**
     * Getter for the objectsToRemove List
     *
     * @see #objectsToRemove
     *
     * @return List </Object>    objectsToRemove List
     */
    public List<Object> getObjectsToRemove() {
        return objectsToRemove;
    }

    /**
     * Getter for the objectsAct List
     *
     * @return List </Object>   objectsAct
     */
    public List<Object> getObjectsAct() {
        return objectsAct;
    }

    /**
     * Getter for the ResourceLoader
     *
     * @return ResourceLoader
     */
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    /**
     * Getter for the objectsActTemp List
     *
     * @return List </Object>   objectsActTemp
     */
    public List<Object> getObjectsActTemp() {
        return objectsActTemp;
    }

    /**
     * Getter for the Player
     *
     * @return Player   the Player
     */
    public Player getPlayer() {
        return (Player) (objectsAct.stream().filter(object -> object instanceof Player).toArray())[0];
    }
}
