package org.scene;

import org.engine.GameLoop;
import org.graphics.Graphics;
import org.world.GameObject;

public class Star extends GameObject {

    private final float SPEED;

    public Star(float x, float y, float speed){
        this.x = x;
        this.y = y;
        this.height = .05f;
        this.width = .05f;
        this.SPEED = speed;
    }

    @Override
    public void update() {
        if (y < -5.8f) {
            y = 5.8f;
            x = -x;
        } else y = y - SPEED * GameLoop.updateDelta();

    }

    @Override
    public void render() {
        Graphics.fillRect(x,y,width,height);
    }
}
