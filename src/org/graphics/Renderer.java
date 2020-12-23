package org.graphics;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.awt.TextRenderer;
import org.input.KeyInput;
import org.input.MouseInput;

import java.awt.*;

public class Renderer {

    private static GLWindow window = null;
    private static GLProfile profile = null;
    public static int screenWidth = 480;
    public static int screenHeight = /*(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * .8);*/ 580;
    public static float unitsWide = 10;


    public static void init() {
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setSize(screenWidth, screenHeight);

        window.addGLEventListener(new EventListener());
        window.addMouseListener(new MouseInput());
        window.addKeyListener(new KeyInput());


        /*FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();*/

        window.setFullscreen(false);
        window.setVisible(true);
        window.requestFocus();
        window.setResizable(false);

    }

    public static void render(){
        if(window == null){
            return;
        }
        window.display();
    }

    public static int getScreenWidth(){
        return window.getWidth();
    }

    public static int getScreenHeight(){
        return window.getHeight();
    }

    public static GLProfile getProfile(){
        return profile;
    }

}
