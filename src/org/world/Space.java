package org.world;

import org.graphics.Graphics;
import org.target.Enemy;

import java.util.ArrayList;

public class Space {

    private static ArrayList<GameObject> playerObjects = new ArrayList<GameObject>();
    private static ArrayList<GameObject> newPlayerObjects = new ArrayList<GameObject>();

    private static ArrayList<GameObject> enemyObjects = new ArrayList<GameObject>();
    private static ArrayList<GameObject> newEnemyObjects = new ArrayList<GameObject>();

    private static int removePlayerObject = -1;
    private static int removeEnemyObject = -1;

    // Go through all objects and update them
    public static void update(){
        // Game object memory tester

        for(GameObject obj: playerObjects){
            obj.update();
            if(obj.y > 6)
                removePlayerObject = playerObjects.indexOf(obj);
        }

        for(GameObject obj: enemyObjects){
            obj.update();
            if(!obj.isAlive())
                removeEnemyObject = enemyObjects.indexOf(obj);
        }

        if(removePlayerObject != -1){
            playerObjects.remove(removePlayerObject);
            removePlayerObject = -1;
        }

        if(removeEnemyObject != -1 ){
            enemyObjects.remove(removeEnemyObject);
            removeEnemyObject = -1;
        }

        if(!newPlayerObjects.isEmpty()) {
            playerObjects.add(newPlayerObjects.get(0));
            newPlayerObjects.remove(newPlayerObjects.get(0));
        }

        if(!newEnemyObjects.isEmpty()) {
            enemyObjects.add(newEnemyObjects.get(0));
            newEnemyObjects.remove(newEnemyObjects.get(0));
        }


    }

    // Go through all objects and render them
    public static void render(){
        for(GameObject obj: playerObjects){
            obj.render();
        }

        for(GameObject obj: enemyObjects){
            obj.render();
        }
    }

    public static void addPlayerObject(GameObject obj){
        newPlayerObjects.add(obj);
    }

    public static void addEnemyObject(GameObject obj){
        newEnemyObjects.add(obj);
    }


    public static ArrayList<GameObject> getEnemies(){
        return enemyObjects;
    }

}
