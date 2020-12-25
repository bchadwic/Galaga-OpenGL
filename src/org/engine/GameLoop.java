package org.engine;

import com.jogamp.newt.event.KeyEvent;
import org.graphics.Renderer;
import org.input.KeyInput;
import org.player.Player;
import org.scene.Background;
import org.scene.Text;
import org.target.Enemy;
import org.world.Space;

public class GameLoop {

    private static boolean running = false;
    private static boolean paused = false;

    private static int updates = 0;
    private static final int MAX_UPDATES = 5;

    private static long lastUpdateTime = 0;

    private static int targetFPS = 100;
    private static int targetTime = 1000000000 / targetFPS;

    public static void start() {
        Thread thread = new Thread(() -> {
//            Space.addTextObject(new Text("gameover",0,0,2,.2f));
            /*Space.addTextObject(new Text("logo",0,2,5,3));
            Space.addTextObject(new Text("creation",0, -1,8 ,.8f));
            Space.addTextObject(new Text("instructions",0, -4,7 ,1.2f));*/
            running = true;
            paused = false;

            lastUpdateTime = System.nanoTime();

            int enemyCount = 0;
            int row = 4;
            int col = -3;
            int fps = 0;
            long lastFpsCheck = System.nanoTime();

            Space.addBackgroundObject(new Background());
            Space.addPlayerObject(new Player());
            /*for(int row=3; row<=5; row++){
                for(int col=-3; col<=3; col++){
                    Space.addEnemyObject(new Enemy(col,row));
                }
            }*/
            long timeStarted = System.nanoTime();
            while (running) {

                if(System.nanoTime() - timeStarted > 2000000000f && enemyCount <= 4) {
                    if(enemyCount < 4) {
                        for (int i = 0; i < 3; i++) {
                            Space.addEnemyObject(new Enemy(col + i, row, i));
                        }
                        if (enemyCount % 2 == 0)
                            col += 4;
                        else {
                            row--;
                            col -= 4;
                        }
                    } else {
                        Space.addEnemyObject(new Enemy(0,4, 0));
                        Space.addEnemyObject(new Enemy(0,3, 1));
                    }
                    enemyCount++;
                    timeStarted = System.nanoTime();
                }


                if (KeyInput.getKey(KeyEvent.VK_ESCAPE))
                    running = false;

                long currentTime = System.nanoTime();
                updates = 0;
                while (currentTime - lastUpdateTime >= targetTime) {
                    Space.update();
                    lastUpdateTime += targetTime;
                    updates++;

                    if (updates > MAX_UPDATES) {
                        break;
                    }
                }

                Renderer.render();

                fps++;
                if (System.nanoTime() >= lastFpsCheck + 1000000000) {
                    /*System.out.println(fps);*/
                    fps = 0;
                    lastFpsCheck = System.nanoTime();
                }

                long timeTaken = System.nanoTime() - currentTime;
                if (targetTime > timeTaken) {
                    try {
                        Thread.sleep((targetTime - timeTaken) / 1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.setName("GameLoop");
        thread.start();
    }

    public static float updateDelta() {
        return 1.0f / 1000000000 * targetTime;
    }
}
