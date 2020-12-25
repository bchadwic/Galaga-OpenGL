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
    private final int STAR_AMOUNT = 15;


    public Background(){
        Random random = new Random();
        for(int i=1; i<=STAR_AMOUNT; i++) {
            STARS.add(new Star(random.nextFloat() * 10 - 5, random.nextFloat() * 10 - 5, random.nextFloat() * 2 + .5f));
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
