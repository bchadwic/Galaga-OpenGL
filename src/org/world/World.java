package org.world;

import org.graphics.Graphics;

import java.util.ArrayList;

public class World {

    private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    // Go through all objects and update them
    public static void update(){
        for(GameObject go: gameObjects){
            go.update();
        }

    }

    // Go through all objects and render them
    public static void render(){
        for(GameObject go: gameObjects){
            go.render();
        }
    }

    public static void addObject(GameObject go){
        gameObjects.add(go);
    }

}
