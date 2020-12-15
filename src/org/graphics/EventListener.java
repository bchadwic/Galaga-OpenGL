package org.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.util.Random;

public class EventListener implements GLEventListener {

    public static GL2 gl = null;

    public static float x = -5;

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0,0,0,1);

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        Graphics.setColor(0,1,0,1);
        Graphics.fillRect(-.5f, -.5f,1,1);

        // Graphics tester
        /*for (int i = 0; i < 1000; i++){
            Random random = new Random();

            float x = (random.nextFloat()*10) - 5;
            float y = (random.nextFloat()*10) - 5;
            float width = random.nextFloat();
            float height = random.nextFloat();
            Graphics.fillRect(x,y,width,height);

        }*/

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        float unitsTall = Renderer.getScreenHeight() / (Renderer.getScreenWidth() / Renderer.unitsWide);
        gl.glOrtho(-Renderer.unitsWide/2, Renderer.unitsWide/2, -unitsTall/2, unitsTall/2, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

    }
}