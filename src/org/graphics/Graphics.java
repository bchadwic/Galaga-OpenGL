package org.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import org.resource.ImageResource;

public class Graphics {

    // Color values
    private static float red = 0;
    private static float green = 0;
    private static float blue = 0;
    private static float alpha = 1;

    private static float rotation = 30;
    private static GL2 gl = EventListener.gl;

    public static void drawImage(ImageResource image, float x, float y, float width, float height){


        Texture tex = image.getTexture();

        if(tex != null){
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }

        gl.glTranslatef(x,y,0);



        /*gl.glColor4f(red, green, blue, alpha);*/
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2d(0,1);
        gl.glVertex2f(-width / 2, -height / 2);
        gl.glTexCoord2d(1,1);
        gl.glVertex2f(width / 2, -height / 2);
        gl.glTexCoord2d(1,0);
        gl.glVertex2f(width / 2, height / 2);
        gl.glTexCoord2d(0,0);
        gl.glVertex2f(-width / 2, height / 2);
        gl.glEnd();
        gl.glFlush();

        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
        /*gl.glRotatef(-rotation, 0,0,1);*/
        gl.glTranslatef(-x,-y,0);

    }

    public static void fillRect(float x, float y, float width, float height){
        GL2 gl = EventListener.gl;
        setColor(0,100,100,0);
        gl.glTranslatef(x,y,0);
        gl.glRotatef(rotation,0,0,1);


        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(-width / 2, -height / 2);
            gl.glVertex2f(width / 2, -height / 2);
            gl.glVertex2f(width / 2, height / 2);
            gl.glVertex2f(-width / 2, height / 2);
        gl.glEnd();
        gl.glFlush();

        /*gl.glRotatef(-rotation, 0,0,1);*/
        gl.glTranslatef(-x,-y,0);

    }

    public static void setColor(float r, float g, float b, float a){
        red = Math.max(0, Math.min(1, r));
        green = Math.max(0, Math.min(1, g));
        blue = Math.max(0, Math.min(1, b));
        alpha = Math.max(0, Math.min(1, a));
    }

    public static void setRotation(float r){
        rotation = r;
    }

}
