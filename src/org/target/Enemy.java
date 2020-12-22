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

    public Enemy(float x, float y){

        this.x = x;
        this.y = y;
        /*endX = x;
        endY = y;
        if(x > 0)
            x = 6;
        else
            x = -6;
        y = -2;*/

        width = .8f;
        height = .8f;

        animations[enemySprite] = new Animation();
        animations[enemySprite].frames = new ImageResource[7];
        animations[enemySprite].frames[0] = new ImageResource("/res/bu_d.png");
        animations[enemySprite].frames[1] = new ImageResource("/res/en_ex_1.png");
        animations[enemySprite].frames[2] = new ImageResource("/res/en_ex_2.png");
        animations[enemySprite].frames[3] = new ImageResource("/res/en_ex_3.png");
        animations[enemySprite].frames[4] = new ImageResource("/res/en_ex_4.png");
        animations[enemySprite].frames[5] = new ImageResource("/res/en_ex_5.png");
        animations[enemySprite].frames[6] = new ImageResource("/res/empty.png");


    }

    @Override
    public void update() {
/*
        if(startPath) {
            if (x < endX)
                x+=.01f;
            else if (x > endX)
                x-=.01f;
            else
                startPath = false;

            if (y < endY){
                y+=.01f;
                startPath = true;
            } else
                startPath = false;
        }
*/
    }

    @Override
    public void render() {
        Graphics.drawImage(animations[enemySprite].getImage(),x,y,width,height);
        if(shot){
            animations[enemySprite].play();
            if(animations[enemySprite].currentFrame == 6)
                setAlive(false);
        }
    }

    public void shot(){
        shot = true;
    }
}

