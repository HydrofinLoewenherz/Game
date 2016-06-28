package net.colorman.handler;

import net.colorman.objects.Object;
import net.colorman.objects.entitys.player.Player;
import net.colorman.resources.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 13.06.2016.
 */
public class ObjectHandler {

    private ResourceLoader resourceLoader;
    private List<Object> objectsAct, objectsActTemp;

    public ObjectHandler() {
        resourceLoader = new ResourceLoader();

        objectsAct = new ArrayList<>();
        objectsActTemp = new ArrayList<>();
    }

    public void addObjectAct(Object object) {
        objectsAct.add(object);
    }

    public void removeObjectsAct(Object object) {
        objectsAct.remove(object);
    }

    public void addToTemp(Object object) {
        objectsActTemp.add(object);
    }

    public void removeFromTemp(Object object) {
        objectsActTemp.add(object);
    }

    public void clearTemp() {
        objectsActTemp.clear();
    }

    public List<Object> getObjectsAct() {
        return objectsAct;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public List<Object> getObjectsActTemp() {
        return objectsActTemp;
    }

    public Player getPlayer() {
        return (Player) (objectsAct.stream().filter(object -> object instanceof Player).toArray())[0];
    }
}
