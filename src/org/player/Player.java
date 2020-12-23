package org.player;

import com.jogamp.newt.event.KeyEvent;
import org.engine.GameLoop;
import org.graphics.Animation;
import org.graphics.Graphics;
import org.input.KeyInput;
import org.resource.ImageResource;
import org.world.GameObject;

public class Player extends GameObject {

    private boolean heldShot = false;
    private final int SPEED = 5;

    public Player(){
        x = 0;
        y = -4;

        width = 1.2f;
        height = 1.2f;

        animations[SHIP_SPRITE] = new Animation();
        animations[SHIP_SPRITE].frames = new ImageResource[5];
        animations[SHIP_SPRITE].frames[0] = new ImageResource("/res/ship.png");
        animations[SHIP_SPRITE].frames[1] = new ImageResource("/res/ex_1.png");
        animations[SHIP_SPRITE].frames[2] = new ImageResource("/res/ex_2.png");
        animations[SHIP_SPRITE].frames[3] = new ImageResource("/res/ex_3.png");
        animations[SHIP_SPRITE].frames[4] = new ImageResource("/res/ex_4.png");

    }

    public void update() {
        float xInput = 0;

        if (KeyInput.getKey(KeyEvent.VK_LEFT) && x >= -4.5)
            xInput--;

        if(KeyInput.getKey(KeyEvent.VK_RIGHT) && x <= 4.5)
            xInput++;

        if(KeyInput.getKey(KeyEvent.VK_S) && !heldShot) {
                heldShot = true;
                shoot();
        }

        if(!KeyInput.getKey(KeyEvent.VK_S))
            heldShot = false;

        x += xInput * SPEED * GameLoop.updateDelta();

    }

    public void render(){
        Graphics.drawImage(animations[SHIP_SPRITE].getImage(), x, y, width, height);
    }

    public void shoot(){
        new Laser(x);
    }


}
