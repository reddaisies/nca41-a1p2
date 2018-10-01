import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.JPanel;
import processing.core.PVector;

public class Food {
	private Animal a;
	
	public PVector pos;
	public double scale;
	public int size;
	
	public boolean hit;
	
	//constructor
    public Food(int x, int y, int size) {
    	this.pos = new PVector(x, y);
        this.size = size;
        this.scale = 0.7;
    }	

	//draws brine shrimp
    public void draw(Graphics2D g) {
        
        AffineTransform af = g.getTransform();
		g.translate((int)pos.x-pos.x/2, (int)pos.y-pos.y/2);
		g.scale(scale, scale); //scales shrimp 	
        g.setColor(Color.blue); //sets jellyfish color as randomized 
        
        //draw feelers
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(size/3 - size/3, size - size/5, size, size/6);
        g.fillOval(size/3 - size/3, size, size, size/6);
        g.fillOval(size/3 - size/3, size + size/5, size, size/6);
        g.fillOval(size/3 - size/3, size + size/5 + size/5, size, size/6);
        
        //draw body
        g.setColor(Color.white);
        g.fillOval(0, 0, size, size);
        g.fillOval(size - size/2 - size/4, size/2 + size/3 - size/5, size/2, size);
        
        g.setColor(Color.orange);
        g.fillOval(size - size/3 - size/4, size/2 + size/3 - size/5, size/4, size);
        
        //draw antennae
        g.setColor(Color.white);
        g.drawLine(0, 0, size/6, size/6);
        g.drawLine(size, 0, size-size/6, size/6);
        
        //draw eyes
        g.setColor(Color.DARK_GRAY);
        g.fillOval(size/5, size/5 + size/8, size/5, size/5);
        g.fillOval(size/5 + size/3, size/5 + size/8, size/5, size/5);
              
        g.setTransform(af);
	}    
}
