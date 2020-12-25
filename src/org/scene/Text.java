package org.scene;

import org.graphics.Animation;
import org.graphics.Graphics;
import org.resource.ImageResource;
import org.world.GameObject;

public class Text extends GameObject {

    private boolean isSet = true;

    public Text(String text, float x, float y, float width, float height){
        animations[TEXT_SPRITE] = new Animation();
        animations[TEXT_SPRITE].frames = new ImageResource[1];
        animations[TEXT_SPRITE].frames[0] = new ImageResource("/res/"+text+".png");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    @Override
    public void render() {
        Graphics.drawImage(animations[TEXT_SPRITE].getImage(), x, y, width, height);
    }

    public boolean isSet() {
        return isSet;
    }
}
