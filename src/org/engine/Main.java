package org.engine;

import org.graphics.Graphics;
import org.graphics.Renderer;
import org.player.Player;
import org.scene.Background;
import org.scene.Text;
import org.target.Enemy;
import org.world.Space;

public class Main {

    public static void main(String[] args) {

        Renderer.init();
        GameLoop.start();

        Space.addBackgroundObject(new Background());
        Space.addPlayerObject(new Player());
        for(int row=3; row<=5; row++){
            for(int col=-3; col<=3; col++){
                Space.addEnemyObject(new Enemy(col,row));
            }
        }
        Space.addTextObject(new Text("gameover",0,0,1,1));
    }
}
