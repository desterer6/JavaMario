/*
David Esterer
10/20/2021
Homework 5:
Java Basics- Polymorph
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
abstract class Sprite
{
	int x, y, w, h;
	double y_velocity = 6.2;
	
	abstract void update();
	abstract boolean draw(Graphics g);
	
	public Sprite()
	{
	}
	
	boolean isBrick()
	{
		return false;
	}
	
	boolean isCoinBrick()
	{
		return false;
	}
	
	boolean isMario()
	{
		return false;
	}
	
	boolean isCoin()
	{
		return false;
		
	}
	
	public boolean checkCollision(Sprite s)
	{
		//LEFT COLLISION
		if(s.x + s.w < this.x)
		{
			return false;
		}	
		
		//RIGHT COLLISION
		if(s.x > this.x + this.w)
		{
			return false;
		}	
		
		//TOP COLLISION
		if(s.y < this.h - this.y)
		{
			return false;
		}
		
		//BOTTOM COLLISION
		if(s.y > this.y + this.h)
		{
			return false;
		}
		
		return true;
	}
	
	Json marshal()
	{
		Json ob = Json.newObject();
		ob.add("x",x);
		ob.add("y",y);
		ob.add("w",w);
		ob.add("h",h);
		return ob;
		
	}
	
	
}