package org.input;


import com.jogamp.newt.Display;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL;
import org.graphics.EventListener;
import org.graphics.Graphics;
import org.graphics.Renderer;

public class KeyInput implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeySymbol() == 27)
            System.exit(0);
        if(e.getKeySymbol() == 32)
            // TODO make a method to shoot a bullet from the galaga ship
            System.out.println(e.getKeySymbol());
    }
}
