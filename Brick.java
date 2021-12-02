/*
David Esterer
10/20/2021
Homework 5:
Java Basics- Polymorph
*/

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Brick extends Sprite
{
	int x, y, w, h;
	static BufferedImage image = null;
	
	public Brick()
	{
		x = 400;
		y = 400;
		w = 200;
		h = 100;
		loadImage();
		
	}
	
	Brick(int brick_x, int brick_y, int brick_w, int brick_h)
	{
		x = brick_x;
		y = brick_y;
		w = brick_w;
		h = brick_h;
		loadImage();
	}
	
	public Brick(int brick1_x, int brick1_y)
	{
		x = brick1_x;
		y = brick1_y;
		w = 10;
		h = 10;
		loadImage();
		
	}
	
	void loadImage()
	{
		if(image == null)
			image = View.loadImage("brick.png");
	}
	
	public void endBrick(int x1, int y1)
	{
		w = Math.abs(x1 - x);
		h = Math.abs(y1 - y);
		if(x1 < x)
		{
			x = x1;
		}
		
		if(y1 < y)
		{
			y = y1;
		}
	}
	
	public Brick(Json ob)
	{
		x = (int)ob.getLong("x");
		y = (int)ob.getLong("y");
		w = (int)ob.getLong("w");
		h = (int)ob.getLong("h");
		loadImage();
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
	
	boolean isBrick()
	{
		return true;
	}
	
	void drawBrick(Graphics g, int marioSpot)
	{
		g.drawImage(image, x - Mario.x + marioSpot, y, w, h, null);
	}
}