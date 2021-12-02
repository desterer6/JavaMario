/*
David Esterer
10/20/2021
Homework 5:
Java Basics- Polymorph
*/


import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements MouseListener, KeyListener
{
	View view;
	Model model;
	Brick brick;
	Sprite sprite;
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	boolean keySpace;
	boolean edit = false;
	
	Controller(Model m)
	{
		model = m;
	}
	
	void setView(View v)
	{
		view = v;
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(edit == true)
			brick =  new Brick(e.getX() + Mario.x - model.mario.marioScreenSpot, e.getY());	
	}
	
	public void mouseReleased(MouseEvent e) 
	{    
		if(edit)
		{
			brick.endBrick(e.getX() + Mario.x - model.mario.marioScreenSpot, e.getY());
			model.sprites.add(brick);
			
		}
	}
	
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {    }
	
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: 
				keyRight = true; 
				break;
			case KeyEvent.VK_LEFT: 
				keyLeft = true; 
				break;
			case KeyEvent.VK_UP: 
				keyUp = true; 
				break;
			case KeyEvent.VK_DOWN: 
				keyDown = true; 
				break;
			case KeyEvent.VK_SPACE: 
				keySpace = true;
				break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: 
				keyRight = false; 
				break;
			case KeyEvent.VK_LEFT: 
				keyLeft = false; 
				break;
			case KeyEvent.VK_UP: 
				keyUp = false; 
				break;
			case KeyEvent.VK_DOWN: 
				keyDown = false; 
				break;
			case KeyEvent.VK_SPACE: 
				keySpace = false; 
				break;
		}
		
		char c = e.getKeyChar();
		if(c == 's' || c == 'S')
		{
			model.marshal().save("map.json");
			System.out.println("Map Saved...");
		}
		if(c == 'l' || c == 'L')
		{
			Json j = Json.load("map.json");
			model.unmarshal(j);
			System.out.println("Map Loaded...");
		}
		if(c == 'q' || c == 'Q')
		{
			System.out.println("Quitting Game...");
			System.exit(0);
			
		}
		if(c == 'e' || c == 'E')
		{
			edit = !edit;
			System.out.println("Edit Status: " + edit);
		}
		
	}

	public void keyTyped(KeyEvent e) {  }
	
	void update()
	{
		if(keyRight)
		{
			model.mario.x += 8;
			model.mario.updateMarioNum();
		}
		
		if(keyLeft)
		{
			model.mario.x -= 8;
			model.mario.updateMarioNum();
		}
		
		if(keySpace)
		{
			//model.mario.y_velocity -= 45;
			model.mario.y_velocity -= 10;
			
		}
		
	}
	

}