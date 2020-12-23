/**
 * @author Ben Chadwick
 * last updated 12/22/20
 * This class represents the "space" all the game objects get rendered upon.
 */

package org.world;

import org.player.Player;
import org.scene.Background;
import org.scene.Text;
import org.target.Enemy;

import java.util.ArrayList;

public class Space {

    // Player objects include: Player, and Laser
    private final static ArrayList<GameObject> PLAYER_OBJECTS = new ArrayList<GameObject>();
    private final static ArrayList<GameObject> NEW_PLAYER_OBJECTS = new ArrayList<GameObject>();
    // Enemy objects include: Enemy, and TODO Bullet
    private final static ArrayList<Enemy> ENEMY_OBJECTS = new ArrayList<Enemy>();
    private final static ArrayList<Enemy> NEW_ENEMY_OBJECTS = new ArrayList<Enemy>();
    // Background objects include: Background
    private final static ArrayList<Background> BACKGROUND_OBJECTS = new ArrayList<Background>();
    private final static ArrayList<Background> NEW_BACKGROUND_OBJECTS = new ArrayList<Background>();
    // Text objects include: Gameover, Highscore
    private final static ArrayList<Text> TEXT_OBJECTS = new ArrayList<Text>();
    private final static ArrayList<Text> NEW_TEXT_OBJECTS = new ArrayList<Text>();
    // These fields keep track of objects that need to be removed from the game
    private static int removePlayerObject = -1;
    private static int removeEnemyObject = -1;
    private static int removeBackgroundObject = -1;
    private static int removeTextObject = -1;

    /**
     * update() runs any changes that need to be made behind the scenes
     */
    public static void update(){

        // *NEW GAME OBJECT INSERTION*

        // if there is a player object to be added, add the player object to the player object list
        if(!NEW_PLAYER_OBJECTS.isEmpty()) {
            PLAYER_OBJECTS.addAll(NEW_PLAYER_OBJECTS);
            NEW_PLAYER_OBJECTS.clear();;
        }
        // if there is a enemy object to be added, add the enemy object to the enemy object list
        if(!NEW_ENEMY_OBJECTS.isEmpty()) {
            ENEMY_OBJECTS.addAll(NEW_ENEMY_OBJECTS);
            NEW_ENEMY_OBJECTS.clear();
        }
        // if there is a background object to be added, add the background object to the background object list
        if(!NEW_BACKGROUND_OBJECTS.isEmpty()) {
            BACKGROUND_OBJECTS.addAll(NEW_BACKGROUND_OBJECTS);
            NEW_BACKGROUND_OBJECTS.clear();
        }

        // *INDEXING OBJECTS TO BE DEREFERENCE*

        // loop through player objects to determine if any objects can be dereference
        for(GameObject obj: PLAYER_OBJECTS){
            obj.update();
            // if a player object (Laser) goes out of the viewport, dereference the object
            if(obj.y > 6)
                removePlayerObject = PLAYER_OBJECTS.indexOf(obj);
        }
        // loop through enemy objects to determine if any objects can be dereference
        for(Enemy obj: ENEMY_OBJECTS){
            obj.update();
            // if enemy isn't alive, dereference the object
            if(!obj.isAlive())
                removeEnemyObject = ENEMY_OBJECTS.indexOf(obj);
        }
        for(Text obj: TEXT_OBJECTS){
            obj.update();
            // if enemy isn't alive, dereference the object
            if(!obj.isSet())
                removeTextObject = TEXT_OBJECTS.indexOf(obj);
        }

        // *GAME OBJECT DEREFERENCE*

        // after looping through the player objects, dereference any objects using the index marked, if any
        if(removePlayerObject != -1){
            PLAYER_OBJECTS.remove(removePlayerObject);
            removePlayerObject = -1;
        }
        // after looping through the player objects, dereference any objects using the index marked, if any
        if(removeEnemyObject != -1 ){
            ENEMY_OBJECTS.remove(removeEnemyObject);
            removeEnemyObject = -1;
        }
        // after looping through the background objects, dereference any objects using the index marked, if any
        if(removeBackgroundObject != -1 ){
            BACKGROUND_OBJECTS.remove(removeBackgroundObject);
            removeBackgroundObject = -1;
        }
        // after looping through the text objects, dereference any objects using the index marked, if any
        if(removeTextObject != -1 ){
            TEXT_OBJECTS.remove(removeTextObject);
            removeTextObject = -1;
        }
    }

    /**
     * render() sends the graphic representations to the window
     */
    public static void render(){
        // render background objects
        for(GameObject obj: BACKGROUND_OBJECTS){
            obj.render();
        }
        // render player objects
        for(GameObject obj: PLAYER_OBJECTS){
            obj.render();
        }
        // render enemy objects
        for(Enemy obj: ENEMY_OBJECTS){
            obj.render();
        }
        // render text objects
        for(Text obj: TEXT_OBJECTS){
            obj.render();
        }
    }

    /**
     * addPlayerObject adds a player object to the list
     * @param obj is a player object
     */
    public static void addPlayerObject(GameObject obj){
        NEW_PLAYER_OBJECTS.add(obj);
    }

    /**
     * addEnemyObject adds an enemy object to the list
     * @param obj is an enemy object
     */
    public static void addEnemyObject(Enemy obj){
        NEW_ENEMY_OBJECTS.add(obj);
    }

    /**
     * addBackgroundObject adds a background object to the list
     * @param obj is an background object
     */
    public static void addBackgroundObject(Background obj){
        NEW_BACKGROUND_OBJECTS.add(obj);
    }

    /**
     * addTextObject adds a text object to the list
     * @param obj is an text object
     */
    public static void addTextObject(Text obj){
        NEW_TEXT_OBJECTS.add(obj);
    }

    /**
     * getEnemies() returns the list of enemies
     * @return list of enemies
     */
    public static ArrayList<Enemy> getEnemies(){
        return ENEMY_OBJECTS;
    }

    /**
     * getPlayer() returns the player if it's not null
     * @return the player
     */
    public static GameObject getPlayer(){
        for(GameObject obj: PLAYER_OBJECTS){
            if(obj instanceof Player)
                return obj;
        }
        return null;
    }

}