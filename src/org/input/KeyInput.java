package org.input;


import com.jogamp.newt.Display;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import org.graphics.EventListener;
import org.graphics.Graphics;
import org.graphics.Renderer;

public class KeyInput implements KeyListener {

    private static GL2 gl = EventListener.gl;
    public static boolean[] keys = new boolean[256];

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeySymbol() == 32)
            System.exit(0);
        if(0 == (InputEvent.AUTOREPEAT_MASK & e.getModifiers()))
        { keys[e.getKeyCode()] = true;}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(0 == (InputEvent.AUTOREPEAT_MASK & e.getModifiers()))
        { keys[e.getKeyCode()] = false;}
    }

    public static boolean getKey(int keyCode){
        return keys[keyCode];
    }
}
