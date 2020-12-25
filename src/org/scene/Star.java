package org.scene;

import org.engine.GameLoop;
import org.graphics.Graphics;
import org.world.GameObject;

public class Star extends GameObject {

    private final float SPEED = 2;

    public Star(float x, float y){
        this.x = x;
        this.y = y;
        this.height = .05f;
        this.width = .05f;
    }

    @Override
    public void update() {
        y = y < -5.8f ?  5.8f : y - SPEED * GameLoop.updateDelta();
    }

    @Override
    public void render() {
        Graphics.fillRect(x,y,width,height);
    }
}
