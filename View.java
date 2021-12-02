/*
David Esterer
10/20/2021
Homework 5:
Java Basics- Polymorph
*/

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel
{
	Model model;
	static BufferedImage background = null;

	View(Controller c, Model m)
	{
		c.setView(this);
		model = m;
	}
	
	static BufferedImage loadImage(String filename)
	{
		BufferedImage pic = null;
		try
		{
			pic = ImageIO.read(new File(filename));
		}
		catch(Exception e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
		return pic;
	}
	
	public void paintComponent(Graphics g)
	{
		//Background
		background = loadImage("background.jpg");
		g.drawImage(background, this.getWidth(), this.getHeight(), null);
		
		//Ground
		g.setColor(Color.gray);
		g.drawLine(0, 400, 2000, 400);
		
		
		//Draw Bricks
		g.setColor(new Color(220,20,60));
		for(int i = 0; i < model.sprites.size(); i++)
		{
			Sprite s = model.sprites.get(i);
			//g.fillRect(b.x - camerapos, b.y, b.w, b.h);
			s.draw(g);
		}
		
		//Mario
		model.mario.draw(g);
	}
	
}
