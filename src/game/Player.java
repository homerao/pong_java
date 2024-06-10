package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	
	public boolean right = false;
	public boolean left  = false;
	public int x, y=0;
	public int width, height;
	
	public Player(int x, int y) {
		System.out.println("Player instanciado");
		this.x = x;
		this.y = y;
		width = 40;
		height = 10;
		
	}
	
	public void tick() {
		if(right) {
			x++;
		} 
		else if (left) {
			x--;
		}
		if(x+ width > Game.WIDTH) {
			x = Game.WIDTH - width;
		} else if (x < 0) {
			x= 0;
		}
	}
	
	public void render( Graphics g) {
		   g.setColor(Color.YELLOW);
		   g.fillRect(this.x,this.y , width, height);
	}

}
