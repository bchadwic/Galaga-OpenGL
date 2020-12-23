package org.scene;

import org.graphics.Graphics;
import org.world.GameObject;

public class Text extends GameObject {

    private boolean isSet = true;

    public Text(String text, float x, float y, float width, float height){

    }

    @Override
    public void render() {
        printGameOver();
    }

    public void printGameOver(){
        Graphics.printText();
    }

    public boolean isSet() {
        return isSet;
    }
}
