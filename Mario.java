/*
David Esterer
10/20/2021
Homework 5:
Java Basics- Polymorph
*/

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics;

class Mario extends Sprite
{
	static int x;
	int	y, prevX, prevY;
	final int w = 60;
	final int h = 95;
	static BufferedImage[] images = null;
	int marioNum;
	int marioScreenSpot;
	
	public Mario()
	{
		x = 0;
		y = 0;
		marioNum = 1;
		marioScreenSpot = 150;
		y_velocity = 0;
		if(images == null)
		{
			images = new BufferedImage[5];
			images[0] = View.loadImage("mario1.png");
			images[1] = View.loadImage("mario2.png");
			images[2] = View.loadImage("mario3.png");
			images[3] = View.loadImage("mario4.png");
			images[4] = View.loadImage("mario5.png");
		}
	}
	
	@Override
	public void update()
	{
		y_velocity += 6.2;
		y += y_velocity;
		if( y > 300)
		{
			y_velocity = 0;
			y = 300;
		}
	}
	
	void moveOut(Sprite s)
	{
		//LEFT
		if(this.x + this.w >= s.x && this.prevX + this.w <= s.x)
			this.x = s.x - this.w;
		//RIGHT
		if(this.x <= s.x + s.w && this.prevX >= s.x + s.w)
			this.x = s.x + s.w;
		//TOP
		if(this.y + this.h > s.y && this.prevY + this.h <= s.y)
		{
			this.y = s.y - this.h;
			y_velocity = 0;
		}
		//BOTTOM
		if(this.y <= s.y + s.h && this.prevY >= s.y + s.h)
		{
			this.y = s.y - this.h;
			y_velocity = 0;
		}
		
		
	}
	
	void updateMarioNum()
	{
		marioNum++;
		if(marioNum > 4)
			marioNum = 0;
	}
	
	void setPrevCoords()
	{
		prevX = x;
		prevY = y;
	}
	
	@Override
	boolean isMario()
	{
		return true;
	}
	
	void drawMario(Graphics g)
	{
		g.drawImage(images[marioNum], x - Mario.x + marioScreenSpot, y, null);
		
	}
}