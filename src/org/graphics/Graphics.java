package org.graphics;

import com.jogamp.opengl.GL2;

public class Graphics {

    // Color values
    private static float red = 0;
    private static float green = 1;
    private static float blue = .5f;
    private static float alpha = 1;

    public static void fillRect(float x, float y, float width, float height){
        GL2 gl = EventListener.gl;


        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(x - width / 2, y - height / 2);
            gl.glVertex2f(x + width / 2, y - height / 2);
            gl.glVertex2f(x + width / 2, y + height / 2);
            gl.glVertex2f(x - width / 2, y + height / 2);
        gl.glEnd();
    }

    public static void setColor(float r, float g, float b, float a){
        red = Math.max(0, Math.min(1, r));
        green = Math.max(0, Math.min(1, g));
        blue = Math.max(0, Math.min(1, b));
        alpha = Math.max(0, Math.min(1, a));
    }



}
