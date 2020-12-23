package org.scene;

import org.graphics.Animation;
import org.graphics.Graphics;
import org.graphics.Renderer;
import org.resource.ImageResource;
import org.world.GameObject;

public class Background extends GameObject {

    private float x = 0;
    private float y = 0;
    private float width = Renderer.getScreenWidth();
    private float height = Renderer.getScreenHeight();

    public Background(){
        animations[BACKGROUND_SPRITE] = new Animation();
        animations[BACKGROUND_SPRITE].setFps(.6f);
        animations[BACKGROUND_SPRITE].frames = new ImageResource[1];
        animations[BACKGROUND_SPRITE].frames[0] = new ImageResource("/res/b_1.png");

    }

    @Override
    public void update() {

    }

    @Override
    public void render(){
        Graphics.drawImage(animations[BACKGROUND_SPRITE].getImage(),x,y,10,15);

    }
}
