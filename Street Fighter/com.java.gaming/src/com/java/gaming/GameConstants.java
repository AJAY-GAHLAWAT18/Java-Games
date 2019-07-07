package com.java.gaming;

import java.awt.image.BufferedImage;

public interface GameConstants {
	int GWIDTH=900;
	int GHEIGHT=496;
	String TITLE="GAME-2019";
	String BACKGROUND="bigbg.jpg";
	String PLAYER_IMG="ryusprite.png";
	int FLOOR=GHEIGHT-35;
	int DELAY=100;
	int GRAVITY = 2;
	int DEFAULT_FORCE = -25;
	String ENEMY_IMG1 = "d1.png";
	String ENEMY_IMG2 = "d2.png";
	String ENEMY_IMG3 = "d3.png";
	int MAX_ENEMIES=3;
	int WGAP=40;
	int ENEMY_POS=100+GWIDTH;
	String camera_Image="bigbigbg.png";
}
