package org.world;

import org.graphics.Animation;
import org.graphics.Graphics;

public class GameObject {

    public float x;
    public float y;

    public float width;
    public float height;

    public float rotation = 0;

    public Animation[] animations;
    public int currentAnimation = 0;

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
