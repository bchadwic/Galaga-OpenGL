package org.world;

import org.graphics.Animation;
import org.graphics.Graphics;

public class GameObject {

    public float x, y, width, height, rotation;

    public  Animation[] animations = new Animation[4];
    public final byte SHIP_SPRITE = 0;
    public final byte ENEMY_SPRITE = 1;
    public final byte BACKGROUND_SPRITE = 2;
    public final byte TEXT_SPRITE = 3;


    public void update(){

    }

    public void render(){

    }
}