package com.java.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants{
	public static GameFrame frame;
	public GameFrame() {
		frame=this;
		Board board = new Board();
		add(board);
	
	setSize(GWIDTH,GHEIGHT);
	setTitle(TITLE);
	setResizable(false);
	setVisible(true);
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameFrame();	
	}

}
