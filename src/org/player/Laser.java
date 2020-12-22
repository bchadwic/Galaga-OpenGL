package org.player;

import org.engine.GameLoop;
import org.graphics.Graphics;
import org.target.Enemy;
import org.world.GameObject;
import org.world.Space;

public class Laser extends GameObject {

    private final float START_Y = -3.4f;

    public Laser(float x){
        this.x = x;
        y = START_Y;
        Space.addPlayerObject(this);
    }

    public void update(){
        for(GameObject enemy : Space.getEnemies()) {
            if (((this.x > enemy.x-.5f)&&(this.x < enemy.x+.5f)) && ((this.y > enemy.y-.2f) && (this.y < enemy.y+.2f))){
                enemy.shot();
                this.y = 7;
            }
        }
        y += speed * GameLoop.updateDelta();
    }

    public void render(){
        Graphics.fillRect(x,y,.1f,.15f);
    }


}
