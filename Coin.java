
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Coin extend Sprite
{
	static bufferedImage = image = null;
	Model model;
	int h_velocity;
	
	public Coin(int x1, int y1, Model m)
	{
		x = x1;
		y = y1;
		w = 75;
		h = 75;
		model = m;
		loadImage();
		Random rand = new Random();
		h_velocity;
		
	}
	
	@Override
	boolean isCoin()
	{
		return true;
		
	}

	public void update()
	{
		x += h_velocity;
		if( y > 300)
		{
			y_velocity = 0;
			y = 300;
		}
	}


	void draw(Graphics g)
	{
		
	}
	
	void loadImage()
	{
		
		
	}


}