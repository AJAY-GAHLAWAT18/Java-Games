package com.java.gaming;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Sprite {
	 public int x;
	 public int y;
	 public int w;
	 public int h;
	 public int speed;
	 public BufferedImage image;
		public void move() {
			x+=speed;
		}
		public  void draw(Graphics g) {
			g.drawImage(image, x,y,w,h,null);
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getW() {
			return w;
		}
		public void setW(int w) {
			this.w = w;
		}
		public int getH() {
			return h;
		}
		public void setH(int h) {
			this.h = h;
		}
		public int getSpeed() {
			return speed;
		}
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		public BufferedImage getImage() {
			return image;
		}
		public void setImage(BufferedImage image) {
			this.image = image;
		}

}
