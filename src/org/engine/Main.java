package org.engine;

import org.graphics.Renderer;
import org.player.PlayerShip;
import org.target.Enemy;
import org.world.Space;

public class Main {

    public static void main(String[] args) {

        Renderer.init();
        GameLoop.start();

        // Test
        Space.addPlayerObject(new PlayerShip());

        for(int row=3; row<=5; row++){
            for(int col=-3; col<=3; col++){
                Space.addEnemyObject(new Enemy(col,row));
            }
        }

        /*Space.addEnemyObject(new Enemy(0,5));*/

    }

}
