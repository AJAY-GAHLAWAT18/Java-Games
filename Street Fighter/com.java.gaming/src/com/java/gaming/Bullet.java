package com.java.gaming;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Sprite implements GameConstants {
	Bullet(int x,int y)
	{
		this.x=x;
		this.y=y;
		this.w=h=10;
		this.speed=20;
		
	}
	public void drawBullet(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y,w, h);
		move();
	}

}
