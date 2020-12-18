package org.engine;

import org.graphics.Renderer;

public class GameLoop {

    private static boolean running = false;
    private static int targetFPS = 60;
    private static int targetTime = 1000000000 / targetFPS;

    public static void start(){
        Thread thread = new Thread(){
            public void run(){
                running = true;
                while(running){
                    long startTime = System.nanoTime();
                    // Poll input
                    // Update Game

                    Renderer.render();

                    long timeTaken = System.nanoTime() - startTime;
                    if(timeTaken < targetTime){
                        try {
                            Thread.sleep((targetTime - timeTaken) / 1000000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        };

        thread.setName("GameLoop");
        thread.start();
    }
}
