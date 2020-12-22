package org.engine;

import org.graphics.Renderer;
import org.player.PlayerShip;
import org.world.World;

public class Main {

    public static void main(String[] args) {

        Renderer.init();
        GameLoop.start();

        // Test
        World.addObject(new PlayerShip());

    }

}
