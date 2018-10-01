import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimalPanel extends JPanel implements ActionListener {
	
	private Animal animal;
	private Food food;
	private Timer t;
	public boolean hit;
	
	//for saving initial width and height of screen
	private int initialWidth;
	private int initialHeight;
	
	Random randnum = new Random(); // for calling random numbers within ranges
	
	
	public AnimalPanel(Dimension initialSize) {
        super();
        
        //int x, int y, int size, int speedx, int speedy, Color animalColor, Color cheekColor, int cheekSize, int tentacleHeight
        animal = new Animal(randnum.nextInt(initialSize.width) - 0, 
        				randnum.nextInt(initialSize.width) - 00,
                        Math.min(initialSize.width,
                        		initialSize.height)/5, 
                        (randnum.nextInt(20) - 10), (randnum.nextInt(20) - 10),
                        new Color((int) (Math.random() * 200), (int) (Math.random() * 200), (int) (Math.random() * 200)),
                        new Color((int) (Math.random() * 200), (int) (Math.random() * 200), (int) (Math.random() * 200)),
                        (randnum.nextInt(2) + 2),
                        (randnum.nextInt(5) + 2)
                        );
        
        //int x, int y, int size
        food = new Food(randnum.nextInt(initialSize.width) + 50, 
        		randnum.nextInt(initialSize.height) + 50, 
        		Math.min(initialSize.width, initialSize.height)/20);
        
        //save the initial values to variables to be used when calling new jellyfish
        initialWidth = initialSize.width;
        System.out.println(initialWidth);
        initialHeight = initialSize.height;
        System.out.println(initialHeight);
        
        //timer for actionPerformed
        t = new Timer(33, this);
        t.start();
    }

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g); //refreshes system
		setBackground(Color.black); // draws a black background
		
		animal.draw(g2); //calls animal (jellyfish)
		food.draw(g2); //calls food
	}

	@Override
    public void actionPerformed(ActionEvent e) {	
			animal.move(animal, food); //moves animal based on where the food is
			animal.checkBoundaries(animal, this.getSize()); //moves animal away from screen boundaries
			animal.hit(food, this.getSize()); //checks if animal has hit the food
	        repaint();
	        
	        //creates a new food with new random variables if the old one has been eaten
	        if (animal.hitCharacter() == true) {
	        	animal.hit = false;
	        	food = new Food(randnum.nextInt(initialWidth) +50, 
	        			randnum.nextInt(initialHeight) +50, 
	        			Math.min(initialWidth, initialHeight)/20);
	        	System.out.println(animal.pos);
		}
	}
}

