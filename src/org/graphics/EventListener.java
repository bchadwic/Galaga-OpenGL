package org.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import org.resource.ImageResource;
import org.world.Space;

public class EventListener implements GLEventListener {

    public static GL2 gl = null;
    public static ImageResource image = null;
    /*float dx = 0.01f;
    float dy = 0.01f;*/

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0,0,0,1);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.setSwapInterval(0);


    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        Space.render();

        // testing ortho setup
        /*Graphics.setColor(0,1,0,1);
        Graphics.fillRect(-4.5f, 0,1,1);
        Graphics.fillRect(4.5f, 0,1,1);
        Graphics.fillRect(-1, 0,1,1);
        Graphics.fillRect(1, 0,1,1);
        Graphics.fillRect(-2.5f, 0,1,1);
        Graphics.fillRect(2.5f, 0,1,1);
        Graphics.fillRect(0, 1,1,1);
        Graphics.fillRect(0, -1,1,1);
        Graphics.fillRect(0, 2,1,1);
        Graphics.fillRect(0, -2,1,1);*/

        // Graphics tester
        /*for (int i = 0; i < 10; i++){
            Random random = new Random();

            float x = (random.nextFloat()*10) - 5;
            float y = (random.nextFloat()*10) - 5;
            float width = random.nextFloat();
            float height = random.nextFloat();
            Graphics.fillRect(x,y,width,height);

        }*/

        // Moving circle
        /*gl.glBegin(GL2.GL_POINTS);
        for(int i=0;i<1000;++i)
        {
            gl.glVertex3f((float)Math.cos(2*Math.PI*i/1000.0),(float) Math.sin(2*Math.PI*i/1000.0),0);
        }
        gl.glEnd();

        gl.glTranslatef(x,y,0);*/

        /*Graphics.setColor(0,1,0,1);
        Graphics.fillRect(0, 0,1,1);*/
        /*gl.glTranslatef(dx,dy,0);*/

        /*Graphics.drawImage(image,0,0,1,1);*/
        /*Graphics.fillRect(1,2,2,1);*/

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
