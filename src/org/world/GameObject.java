package org.world;

import org.graphics.Animation;
import org.graphics.Graphics;

public class GameObject {

    public float x;
    public float y;

    public float width = 1;
    public float height = 1;

    public float rotation = 0;

    public Animation[] animations = new Animation[2];
    public int shipSprite = 0;
    public int enemySprite = 1;


    public int speed = 5;

    public void update(){

    }

    public void render(){
        //animations[currentAnimation].play();
        /*Graphics.setRotation(rotation);*/
/*
        Graphics.drawImage(animations[currentAnimation].getImage(), x, y, width, height);
*/
        /*Graphics.setRotation(0);*/
    }

}
