package org.target;

import org.graphics.Animation;
import org.graphics.Graphics;
import org.resource.ImageResource;
import org.world.GameObject;
import org.world.Space;

public class Enemy extends GameObject {

    private boolean shot = false;
    private boolean startPath = true;
    private float endX;
    private float endY;
    private boolean isAlive = true;

    public Enemy(float x, float y, int delay){

        /*this.x = x;
        this.y = y;*/
        endX = x;
        endY = y;
        if(x > 0)
            this.x = -7 - delay;
        else
            this.x = 7 + delay;
        this.y = -2 - delay;

        width = .8f;
        height = .8f;

        animations[ENEMY_SPRITE] = new Animation();
        animations[ENEMY_SPRITE].setLoop(false);
        animations[ENEMY_SPRITE].setFps(50);
        animations[ENEMY_SPRITE].frames = new ImageResource[7];
        animations[ENEMY_SPRITE].frames[0] = new ImageResource("/res/bu_d.png");
        animations[ENEMY_SPRITE].frames[1] = new ImageResource("/res/en_ex_1.png");
        animations[ENEMY_SPRITE].frames[2] = new ImageResource("/res/en_ex_2.png");
        animations[ENEMY_SPRITE].frames[3] = new ImageResource("/res/en_ex_3.png");
        animations[ENEMY_SPRITE].frames[4] = new ImageResource("/res/en_ex_4.png");
        animations[ENEMY_SPRITE].frames[5] = new ImageResource("/res/en_ex_5.png");
        animations[ENEMY_SPRITE].frames[6] = new ImageResource("/res/black.png");


    }

    @Override
    public void update() {
        if(startPath) {
            if (x < endX - .03f)
//                x = (float)Math.pow(.001, -x);
                x+=.06f;
            else if (x > endX + .03f)
//                x = (float)Math.pow(.001, x);
                x-=.06f;
            if (y < endY)
//                y = (float)Math.pow(.001,y);
                y+=.04f;
            /*    startPath = true;
            } else
                startPath = false;*/
            }
    }

    @Override
    public void render() {
        Graphics.drawImage(animations[ENEMY_SPRITE].getImage(),x,y,width,height);
        if(shot){
            animations[ENEMY_SPRITE].play();
            if(animations[ENEMY_SPRITE].currentFrame == 6)
                setAlive(false);
        }
    }

    public void shot(){
        shot = true;
    }

    public void setAlive(boolean alive){
        isAlive = alive;
    }

    public boolean isAlive(){
        return isAlive;
    }
}
