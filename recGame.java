public class recGame
{	
	public static void main (String[] args)
	{
		GameArena arena = new GameArena(800, 600);
		Rectangle player = new Rectangle(400, 400, 25,25, "BLUE");
		arena.addRectangle(player);
	}
}