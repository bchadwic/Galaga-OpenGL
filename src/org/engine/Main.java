package org.engine;

import org.graphics.Graphics;
import org.graphics.Renderer;
import org.player.Player;
import org.scene.Background;
import org.scene.Text;
import org.target.Enemy;
import org.world.Space;

public class Main {

    public static void main(String[] args) {

        Renderer.init();
        GameLoop.start();

    }
}
