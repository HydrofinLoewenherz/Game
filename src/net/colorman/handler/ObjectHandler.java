package net.colorman.handler;

import net.colorman.objects.Object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 13.06.2016.
 */
public class ObjectHandler {

    List<Object> objectsAct, objectsActTemp;

    public ObjectHandler() {
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
}
