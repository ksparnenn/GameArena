public class recGame
{	
	public static void main (String[] args)
	{
		GameArena arena = new GameArena(800, 600); // creates the arena (black box)
		Rectangle player = new Rectangle(400, 400, 80,80, "BLUE", 0, 0); // creates the player rectangle
		Rectangle rBump = new Rectangle (480,400,80,80, "GREEN",0,0);
		Rectangle lBump = new Rectangle (320,400,80,80, "GREEN",0,0);
		Rectangle[] lBlocks = new Rectangle[2000]; // creates the left enemy array
		Rectangle[] rBlocks = new Rectangle[2000]; // creates the right enemy array
		int lCount = 0; // left enemy count
		int rCount = 0; // right enemy count
		int score = 0;
		double speed = 1;
		int f = 0;
		int g = 0;
		boolean lClick = false;
		boolean rClick = false;
    
		arena.addRectangle(player); // adds player to stage
		arena.addRectangle(rBump);
		arena.addRectangle(lBump);
		
		while (true)
		{	
			if (arena.rightPressed()) {
				f++;
				if (f > 25) {				
					rClick = true;
				}
			} else {
				rClick = false;
				f = 0;
			}
			
			if (arena.leftPressed()) {
				g++;
				if (g > 25) {				
					lClick = true;
				}
			} else {
				lClick = false;
				g = 0;
			}
			if (Math.random() > 0.99)
			{
				lBlocks[lCount] = new Rectangle(0, 400, Math.random()*20+60, Math.random()*20+60, "RED", speed, 0);
				arena.addRectangle(lBlocks[lCount]);
				lCount++;
			} 
			if (Math.random() > 0.99)
			{
				rBlocks[rCount] = new Rectangle(800, 400, Math.random()*20+60, Math.random()*20+60, "RED", speed*-1, 0);
				arena.addRectangle(rBlocks[rCount]);
				rCount++;
			} 
			for (int i = 0; i < lCount; i++)
			{
				if (lBlocks[i] == null) {
				} else if (player.collides(lBlocks[i])) 
				{
					System.out.println( "Game Over! Score: " + "" + score);
					arena.exit();
				} else if (lBump.collides(lBlocks[i]))
				{
					if (arena.leftPressed() && lClick == false)
					{
						arena.removeRectangle(lBlocks[i]);
						lBlocks[i] = null;
						score++;
						speed = speed + 0.25;
						
					} else {
						lBlocks[i].move();
					}
				} else {					
					lBlocks[i].move();

					
				}
			}
			for (int i = 0; i < rCount; i++)
			{
				if (rBlocks[i] == null) {
				} else if (player.collides(rBlocks[i])) 
				{
					System.out.println( "Game Over! Score: " + "" + score);
					arena.exit();
				} else if (rBump.collides(rBlocks[i]))
				{
					if (arena.rightPressed() && rClick == false)
					{
						arena.removeRectangle(rBlocks[i]);
						rBlocks[i] = null;
						score++;
						speed = speed + 0.25;						
					} else {
						rBlocks[i].move();
					}
				} else {
					rBlocks[i].move();
				}
			}
			
			
			arena.pause();
		}
	}
}