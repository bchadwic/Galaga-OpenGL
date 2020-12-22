package org.world;

import org.graphics.Graphics;

import java.util.ArrayList;

public class World {

    private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private static ArrayList<GameObject> newObjects = new ArrayList<GameObject>();
    private static int removeIndex= 0;

    // Go through all objects and update them
    public static void update(){
        System.out.println("gameObjects: "+gameObjects.size());

        for(GameObject go: gameObjects){
            go.update();
            if(go.y > 7){
                removeIndex = gameObjects.indexOf(go);
            }
        }

        if(removeIndex != 0){
            gameObjects.remove(removeIndex);
            removeIndex = 0;
        }

        if(!newObjects.isEmpty()) {
            gameObjects.add(newObjects.get(0));
            newObjects.remove(newObjects.get(0));
        }





    }

    // Go through all objects and render them
    public static void render(){
        for(GameObject go: gameObjects){
            go.render();
        }
    }

    public static void addObject(GameObject go){
        newObjects.add(go);
    }

}
