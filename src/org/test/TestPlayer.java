package org.test;

import org.graphics.Animation;
import org.graphics.Graphics;
import org.resource.ImageResource;
import org.world.GameObject;

public class TestPlayer extends GameObject {

    public TestPlayer(){
        animations = new Animation[1];
        animations[0] = new Animation();
        animations[0].frames = new ImageResource[5];
        animations[0].frames[0] = new ImageResource("/res/ship.png");
        animations[0].frames[1] = new ImageResource("/res/ex_1.png");
        animations[0].frames[2] = new ImageResource("/res/ex_2.png");
        animations[0].frames[3] = new ImageResource("/res/ex_3.png");
        animations[0].frames[4] = new ImageResource("/res/ex_4.png");

    }

    public void update(){
        /*x += 0.1f;*/
    }


}
