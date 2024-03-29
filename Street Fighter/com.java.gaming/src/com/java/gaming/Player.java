package com.java.gaming;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Sprite	implements GameConstants,IPlayer {
	private ArrayList<Bullet> bullets = new ArrayList<>();
	BufferedImage[] def;
	BufferedImage[] punch;
	int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Player()	{
		x=100;
		w=h=100;
		speed=10;
		y=FLOOR-h;
		image=ImageLoader.loadImage(PLAYER_IMG);
		def=loadDefaultMove();
		punch=loadPunch();
	}	
	
	private BufferedImage[] loadDefaultMove() {
		BufferedImage def[]=new BufferedImage[4];
		def[0]=image.getSubimage(15, 565, 45, 75);
		def[1]=image.getSubimage(83, 510, 36, 110);
		def[2]=image.getSubimage(152, 527, 32,103);
		def[3]=image.getSubimage(230, 545, 36, 98);
		return def;
	}
	public BufferedImage[] loadPunch() {
		
		BufferedImage punch[] = new BufferedImage[3];
		punch[0] = image.getSubimage(383, 20, 60, 82);
		punch[1] = image.getSubimage(456, 20, 54, 81);
		punch[2] = image.getSubimage(521, 5, 49, 96);
		return punch;
	}
	
	

	int punchIndex=0; 
	int timeIndex=0;
	public void printPunch(Graphics g) {
		if(timeIndex>=3)
		{
			punchIndex++;
			timeIndex=0;
		}
		if(punchIndex>=3)
		{
			punchIndex=0;
			state=MOVE;
		}
		else {
		g.drawImage(punch[punchIndex], x, y,w,h, null);
		}
		//moveIndex++;
		timeIndex++;
	}
	int moveIndex=0;
	public void printDefaultMove(Graphics g) {
		if(timeIndex>=3)
		{
			moveIndex++;
			timeIndex=0;
		}
		if(moveIndex>=4)
		{
			moveIndex=0;
		}
		else {
		g.drawImage(def[moveIndex], x, y,w,h, null);
		}
		//moveIndex++;
		timeIndex++;
	}
	
	@Override
	public void draw(Graphics g) {
		if(state==PUNCH) {
			printPunch(g);
		}
		else {
			
	
		printDefaultMove(g);
		}
	}
	
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}


	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}
	private int force;
	private boolean isJumped;
	
	public void jump() {
		// TODO Auto-generated method stub
		if(!isJumped) {
		force=DEFAULT_FORCE;
		y=y+force;
		isJumped=true;
		}
	}
	
	
	public void fire() {
		Bullet bullet = new Bullet((x+this.getW()/2+10), (y+(this.getH()/2-30)));
		bullets.add(bullet);
	}
	
	public void fall()
	{
		if(y>=FLOOR-h) {
			isJumped=false;
			y=FLOOR-h;
		}
		else
		{
			force=force+GRAVITY;
			y=y+force;
		}
	}
	
}
