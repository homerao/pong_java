package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x, y;
	public int height, width;
	public double dx, dy;
	public double speed = 0.8;
	
	public Ball(double x, double y) {
		this.x = x;
		this.y = y;
		this.height = 5;
		this.width = 5;
		dx = new Random().nextGaussian();
		dy = new Random().nextGaussian();
	}
	
	public void tick() {

		if(x  < 0) {
			System.out.println("DX 1 "+ dx + " "+ x);
			dx*=-1;
		} else if (x + width >= Game.WIDTH) {
			System.out.println("DX 2 "+ dx + " "+ x);
			dx*=-1;
		}
		if(y  <= 0) {
			System.out.println("DY 3 "+ dy + " "+ y);
			dy *=-1;	
		}
		else if (y + height >= Game.HEIGHT) {
			System.out.println("DY 4 "+ dy + " "+ y);
			dy *=-1;
		}
		x += dx*speed;
		y += dy*speed;
		
		Rectangle ball = new Rectangle((int)(x+(dx+speed)),(int)(y+(dy+speed)),width, height);
		Rectangle player = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle Enemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		if(ball.intersects(player)) {
			dy*=-1;
			speed+=0.01;
		}
		else if (ball.intersects(Enemy)) {
			dy*=-1;
			speed+=0.01;
		}
	}
	

	
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval((int)x, (int)y, width, height);
	}

}
