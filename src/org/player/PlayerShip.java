package org.player;

import com.jogamp.newt.event.KeyEvent;
import org.engine.GameLoop;
import org.graphics.Animation;
import org.graphics.Graphics;
import org.input.KeyInput;
import org.resource.ImageResource;
import org.world.GameObject;

import java.security.Key;
import java.util.ArrayList;

public class PlayerShip extends GameObject {

    private boolean heldShot = false;

    public PlayerShip(){
        x = 0;
        y = -4;

        width = 1.5f;
        height = 1.5f;

        animations = new Animation[1];
        animations[0] = new Animation();
        animations[0].frames = new ImageResource[5];
        animations[0].frames[0] = new ImageResource("/res/ship.png");
        animations[0].frames[1] = new ImageResource("/res/ex_1.png");
        animations[0].frames[2] = new ImageResource("/res/ex_2.png");
        animations[0].frames[3] = new ImageResource("/res/ex_3.png");
        animations[0].frames[4] = new ImageResource("/res/ex_4.png");

    }

    public void update() {
        float xInput = 0;

        if (KeyInput.getKey(KeyEvent.VK_LEFT) && x > -4.5)
            xInput--;

        if(KeyInput.getKey(KeyEvent.VK_RIGHT) && x < 4.5)
            xInput++;

        if(KeyInput.getKey(KeyEvent.VK_S) && !heldShot) {
            heldShot = true;
            shoot();
        }

        if(!KeyInput.getKey(KeyEvent.VK_S))
            heldShot = false;

        x += xInput * speed * GameLoop.updateDelta();

    }

    public void render(){
        Graphics.drawImage(animations[currentAnimation].getImage(), x, y, width, height);
    }

    public void shoot(){
        new Laser(x);
    }


}
