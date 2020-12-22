package org.player;

import org.engine.GameLoop;
import org.graphics.Graphics;
import org.world.GameObject;
import org.world.Space;

public class Laser extends GameObject {

    private final float START_Y = -3.4f;

    public Laser(float x){
        this.x = x;
        y = START_Y;
        Space.addObject(this);
    }

    public void update(){
        y += speed * GameLoop.updateDelta();
    }

    public void render(){
        Graphics.fillRect(x,y,.1f,.2f);
    }


}
