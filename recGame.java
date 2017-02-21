public class recGame
{	
	public static void main (String[] args)
	{
		GameArena arena = new GameArena(800, 600); // creates the arena (black box)
		Rectangle player = new Rectangle(400, 400, 80,80, "BLUE", 0, 0); // creates the player rectangle
		Rectangle rBump = new Rectangle (480,400,80,80, "GREEN",0,0);
		Rectangle lBump = new Rectangle (320,400,80,80, "GREEN",0,0);
		Rectangle[] lBlocks = new Rectangle[50]; // creates the left enemy array
		Rectangle[] rBlocks = new Rectangle[50]; // creates the right enemy array
		int lCount = 0; // left enemy count
		int rCount = 0; // right enemy count
		float speed = 2;
    
		arena.addRectangle(player); // adds player to stage
		arena.addRectangle(rBump);
		arena.addRectangle(lBump);
		
		while (true)
		{
	
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
        lBlocks[i].move();
      }
      for (int i = 0; i < rCount; i++)
      {
        rBlocks[i].move();
      }
      arena.pause();
		}
	}
}