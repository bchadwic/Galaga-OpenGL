package org.graphics;

import org.resource.ImageResource;

public class Animation {

    public ImageResource[] frames;
    public int currentFrame = 0;
    public int fps = 15;
    private long lastFrameTime = 0;
    public boolean loop = false;

    public void play(){
        long currentTime = System.nanoTime();
        if(currentTime > lastFrameTime + 1000000000 / fps){
            currentFrame++;
            if(currentFrame >= frames.length){
                if(loop){
                    currentFrame = 0;
                } else {
                    currentFrame--;
                }
            }

            lastFrameTime = currentTime;
        }

    }

    public ImageResource getImage() {
        return frames[currentFrame];
    }
}
