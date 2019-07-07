package com.java.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Board extends JPanel implements GameConstants,IPlayer{
	Player player;
	Camera camera;
	private Timer timer;
	Enemy enemies [] = new Enemy[MAX_ENEMIES];
	BufferedImage enemyImages[] = new BufferedImage[MAX_ENEMIES];
	private boolean iscollide(Player player,Enemy enemy)
	{
		int xDistance=Math.abs( player.getX()-enemy.getX());
		int yDistance=Math.abs( player.getY()-enemy.getY());
		int w=Math.max(player.getW(), enemy.getW());
		int h=Math.max(player.getH(), enemy.getH());
		return (xDistance<=(w-WGAP) && yDistance<=h);
	}
	private boolean gameOver=false;
	private void gameOverPrint(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("GAME OVER", GWIDTH/2, GHEIGHT/2);

	}
	private void collisionCheck(Graphics g) {
		for(Enemy enemy:enemies) {
			if(iscollide(player,enemy)) {
				gameOver=true;
				gameOverPrint(g);
				timer.stop();
				break;
			}
		}
	}	
	public void loadEnemyImages() {
		enemyImages[0]=ImageLoader.loadImage(ENEMY_IMG1);
		enemyImages[1]=ImageLoader.loadImage(ENEMY_IMG2);
		enemyImages[2]=ImageLoader.loadImage(ENEMY_IMG3);
	}
	
	public void loadEnemy() {
		int speed =-10;
		int diff=1;
		int gap=1;
		for(int i=0;i<enemies.length;i++)
		{
			enemies[i] = new Enemy(ENEMY_POS+gap, enemyImages[i], speed + diff);
			diff+=3;
			gap+=100;
		}
	}
	
	public void drawEnemyImages(Graphics g) {
		for(Enemy en : enemies) {
			en.draw(g);
			en.move();
		}
		
	}
	private void registerEvents() {
		System.out.println("Register Events Call");
		this.addKeyListener(new KeyAdapter() {
			// if i use keylistner here then it will override 3 functions
													//but we wnat only two so we will use key adapter as it is abstract class
			//which has already implemented key listner so we can use funtion only we want
			
		/*@Override
			public void keyTyped(KeyEvent e) {
			System.out.println("key type call "+e.getKeyChar()+" "+e.getKeyCode());
				// TODO Auto-generated method stub
			
			}*/
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("key release call "+e.getKeyChar()+" "+e.getKeyCode());
				camera.setSpeed(0);
				//player.setSpeed(0);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key Press Call "+e.getKeyCode());
				if(e.getKeyCode()==KeyEvent.VK_P) {
					player.setState(IPlayer .PUNCH);;
				}
				else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					player.jump();
				}
			else
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				System.out.println(" print right"+e.getKeyChar()+ " "+e.getKeyCode());
				camera.setSpeed(+10);
				camera.move();
				//player.setSpeed(5);
				//player.move();
				
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				camera.setSpeed(-10);
				camera.move();
			
				//player.setSpeed(-5);
			//	player.move();
			}
			else if(e.getKeyCode()==KeyEvent.VK_F)
			{
				player.fire();
			}
			}
		});
	}
	private void printBullets(Graphics g) {
		for(Bullet bullet : player.getBullets()) {
			bullet.drawBullet(g);
		}
	}
	private void gameLoop() {
		// Lambda Style
		timer = new Timer(DELAY,(e)->{
			//player.move();                 //automtic move
			player.fall();
			repaint();
		});
		timer.start();}
	public Board() {
		 camera=new Camera();
			loadEnemyImages();
			loadEnemy();
		setFocusable(true);
		registerEvents();

		
		player=new Player();
		setSize(GWIDTH, GHEIGHT);
		setBackground(Color.BLACK);//to choose color
		gameLoop(); //it represents timer it is called here as timer will always work

	}
	public  void drawBackground(Graphics g) {
		camera.drawCamera(g);
		//BufferedImage image =ImageLoader.loadImage(BACKGROUND);		//to load
		//g.drawImage( image, 0, 0, GWIDTH, GHEIGHT, null);		//where to print
	}
//		public void drawPlayer(Graphics g) {
	//	g.drawImage( image, 100, 450, 100, 100, null);	
//}
	
	@Override
	protected void paintComponent(Graphics g) {         //used for painting on board // is called once automattically
		// TODO Auto-generated method stub
		super.paintComponent(g);   //first will erase then paint
		drawBackground(g);
		player.draw(g);
		drawEnemyImages(g);
		collisionCheck(g);
		printBullets(g);
		                       
	}



}


