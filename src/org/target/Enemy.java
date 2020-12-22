package org.target;

import org.graphics.Animation;
import org.graphics.Graphics;
import org.resource.ImageResource;
import org.world.GameObject;
import org.world.Space;

public class Enemy extends GameObject {

    public Enemy(){
        this.x = 0;
        this.y = 3;

        animations[enemySprite] = new Animation();
        animations[enemySprite].frames = new ImageResource[1];
        animations[enemySprite].frames[0] = new ImageResource("/res/bu_d.png");


    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Graphics.drawImage(animations[enemySprite].getImage(),x,y,width,height);
    }
}

