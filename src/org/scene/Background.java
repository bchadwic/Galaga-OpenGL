package org.scene;

import org.graphics.Animation;
import org.graphics.Graphics;
import org.graphics.Renderer;
import org.resource.ImageResource;
import org.world.GameObject;

import java.util.ArrayList;
import java.util.Random;

public class Background extends GameObject {

    private float x = 0;
    private float y = 0;
    private float width = Renderer.getDisplayWidth();
    private float height = Renderer.getDisplayHeight();
    private final ArrayList<Star> STARS = new ArrayList<Star>();
    private final int STAR_AMOUNT = 20;


    public Background(){
        animations[BACKGROUND_SPRITE] = new Animation();
        animations[BACKGROUND_SPRITE].setFps(5);
        animations[BACKGROUND_SPRITE].frames = new ImageResource[1];
        animations[BACKGROUND_SPRITE].frames[0] = new ImageResource("/res/background/b_1.png");
        /*animations[BACKGROUND_SPRITE].frames[1] = new ImageResource("/res/background/b_2.png");
        animations[BACKGROUND_SPRITE].frames[2] = new ImageResource("/res/background/b_3.png");
        animations[BACKGROUND_SPRITE].frames[3] = new ImageResource("/res/background/b_4.png");
        animations[BACKGROUND_SPRITE].frames[4] = new ImageResource("/res/background/b_5.png");
        animations[BACKGROUND_SPRITE].frames[5] = new ImageResource("/res/background/b_6.png");
        animations[BACKGROUND_SPRITE].frames[6] = new ImageResource("/res/background/b_7.png");
        animations[BACKGROUND_SPRITE].frames[7] = new ImageResource("/res/background/b_8.png");
        animations[BACKGROUND_SPRITE].frames[8] = new ImageResource("/res/background/b_9.png");*/
        /*animations[BACKGROUND_SPRITE].frames[9] = new ImageResource("/res/background/b_10.png");*/
/*        animations[BACKGROUND_SPRITE].frames[5] = new ImageResource("/res/background/b_11.png");
        *//*animations[BACKGROUND_SPRITE].frames[11] = new ImageResource("/res/background/b_12.png");*//*
        animations[BACKGROUND_SPRITE].frames[6] = new ImageResource("/res/background/b_13.png");
        *//*animations[BACKGROUND_SPRITE].frames[13] = new ImageResource("/res/background/b_14.png");*//*
        animations[BACKGROUND_SPRITE].frames[7] = new ImageResource("/res/background/b_15.png");
        *//*animations[BACKGROUND_SPRITE].frames[15] = new ImageResource("/res/background/b_16.png");*//*
        animations[BACKGROUND_SPRITE].frames[8] = new ImageResource("/res/background/b_17.png");*/

        Random random = new Random();
        for(int i=1; i<=STAR_AMOUNT; i++) {
            STARS.add(new Star(random.nextFloat() * 10 - 5, random.nextFloat() * 10 - 5));
        }
    }

    @Override
    public void update() {
        for (Star obj : STARS) {
            obj.update();
        }
    }

    @Override
    public void render(){
        for (Star obj : STARS) {
            obj.render();
        }


/*
        Graphics.fillRect(0,0,.05f,.05f);
*/
/*
        Graphics.drawImage(animations[BACKGROUND_SPRITE].getImage(),x,y,10,15);
*/
        /*animations[BACKGROUND_SPRITE].play();*/
    }
}
