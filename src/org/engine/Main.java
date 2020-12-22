package org.engine;

import org.graphics.Renderer;
import org.player.PlayerShip;
import org.target.Enemy;
import org.world.Space;

public class Main {

    public static void main(String[] args) {

        Renderer.init();
        GameLoop.start();

        // Test
        Space.addObject(new PlayerShip());
        Space.addObject(new Enemy());

    }

}
