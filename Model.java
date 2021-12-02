/*
David Esterer
10/20/2021
Homework 5:
Java Basics- Polymorph
*/


import java.util.ArrayList;
import java.util.Iterator;

class Model
{
	ArrayList<Sprite> sprites;
	Mario mario;

	Model()
	{
		sprites = new ArrayList<Sprite>();
		mario = new Mario();
		sprites.add(mario);
		Json j = Json.load("map.json");
		this.unmarshal(j);
		System.out.println("Map Loaded...");
	}
	
	public void update()
	{
		//mario.update();
		//collisions();
		Iterator<Sprite> sprit = sprites.iterator();
		while(sprit.hasNext())
		{
			Sprite s = sprit.next();
			
			if(s.isBrick())
			{
				if(mario.checkCollision(s));
					mario.moveOut(s);
				
			}
			
			
		}
	}
	/*
	void collisions()
	{
		for (int i = 0; i < bricks.size(); i++)
		{
			Brick b = bricks.get(i);
			if(marioCollision(b))
			{
				if(top && left && right)
				{
					mario.y = b.y - mario.h;
					System.out.println("OUCH - top");
				}
				else if(left)
				{
					mario.x = b.x - (mario.w);
					System.out.println("OUCH - left");
				}
				else if(right)
				{
					mario.x = b.x + b.h + mario.w;
					System.out.println("OUCH - right");
				}
				else if(bottom)
				{
					mario.y = b.y + mario.h;
					System.out.println("OUCH - bottom");
				}
				
				
	
			}
		}
	}
	*/

	Json marshal()
	{
		Json ob = Json.newObject();
		Json tmpList = Json.newList();
		ob.add("sprites",tmpList);
		for(int i = 0; i < tmpList.size(); i++)
			tmpList.add(sprites.get(i).marshal());
		return ob;
	}
	
	void unmarshal(Json ob)
	{
		sprites = new ArrayList<Sprite>();
		Json tmpList = ob.get("sprites");
		//for(int i = 0; i < tmpList.size(); i++)
			//sprites.add(Sprite(tmpList.get(i)));
	}
	
}