import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.util.Random;

public class snakeGame extends JPanel implements ActionListener,KeyListener  {
	//properties
	Random random ;
	Timer timer ;
	long starttime;
	static  int frameWIDTH = 700 ;
	static  int frameHEIGHT = 550;
	
	static final int objAppered = 616;
	final int x[] = new int[objAppered];
	final int y[] = new int[objAppered];
	static  int objSize = 25;
	//snake
	int snakeLength = 3;
	
	long score;
	
	//game system
	int direction = 0;//0=right 1=left 2=up 3=down
	boolean playing = false;
	//constructor
	public snakeGame(){
		starttime=System.currentTimeMillis();
		random = new Random();
		//set panel
		setPreferredSize(new Dimension(frameWIDTH,frameHEIGHT));
		setBackground(new Color(153,102,0));
		setFocusable(true);
		addKeyListener(this);
		gamestart();
		//add to frame
		JFrame frame = new JFrame("Snake game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(frameWIDTH,frameHEIGHT));
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(this);
	}
	//method
	public void gamestart() {
		
		playing = true;
		timer = new Timer(60,this);
		timer.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(playing) {
			
			//head
			g.setColor(new Color(0,102,0));
			g.fillRect(x[0], y[0], objSize, objSize);
			//body
			for(int n = 1;n<snakeLength;n++) {
				g.setColor(Color.green);
				g.fillOval(x[n], y[n], objSize, objSize);
			}
			//score
			g.setColor(Color.white);
			g.setFont(new Font("SansSerif", Font.BOLD, 30));
			FontMetrics fontMet = getFontMetrics(g.getFont());//for getting font width
			g.drawString("Score: " + score, (frameWIDTH - fontMet.stringWidth("Score: " + score)) / 2, g.getFont().getSize());
		}
		else {
			//game over
			g.setColor(Color.red);
			g.setFont(new Font("SansSerif", Font.BOLD, 60));
			FontMetrics fontMet1 = getFontMetrics(g.getFont());//for getting font width
			g.drawString("You Dead",480-fontMet1.stringWidth("You Dead"),frameHEIGHT/2);
			//show final score
			g.setColor(Color.white);
			g.setFont(new Font("SansSerif", Font.BOLD, 30));
			FontMetrics fontMet2 = getFontMetrics(g.getFont());//for getting font width
			g.drawString("Score: " + score, (frameWIDTH - fontMet2.stringWidth("Score: " + score)) / 2, g.getFont().getSize());
		}
		
	}
	
	public void move(){
		for(int n = snakeLength;n>0;n--) {
			x[n] = x[n-1];
			y[n] = y[n-1];
		}
		if(direction == 2) {
			y[0] = y[0]-objSize;
		}
		else if (direction == 3) {
			y[0] = y[0]+objSize;
		}
		else if (direction == 0) {
			x[0] = x[0]+objSize;
		}
		else if (direction == 1) {
			x[0] = x[0]-objSize;
		}
		
		
	}
	
	public void checkCollision() {
		//head to body
		for(int n = snakeLength;n>0;n--) {
			if(x[0]==x[n]&&y[0]==y[n]) {
				playing = false;
			} 
		}
		//head to up
		if(y[0]<0) {
			playing = false;
		}
		//head to down
		if(y[0]>frameHEIGHT) {
			playing = false;
		}
		//head to left
		if(x[0]<0) {
			playing = false;
		}
		//head to right
		if(x[0]>frameWIDTH) {
			playing = false;
		}
	}
	
	@Override
 	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W && direction != 3) {
			direction = 2;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A && direction != 0) {
			direction = 1;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S && direction != 2) {
			direction = 3;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D && direction != 1) {
			direction = 0;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (playing) {
			int snakeLengthforMath = (int) Math.pow(snakeLength, 1);//explicit //static method in the Math class
			for(int n = snakeLengthforMath;n>0;n--) {
				x[n] = x[n-1];
				y[n] = y[n-1];
			}
			if(direction == 2) {
				y[0] = y[0]-objSize;
			}
			else if (direction == 3) {
				y[0] = y[0]+objSize;
			}
			else if (direction == 0) {
				x[0] = x[0]+objSize;
			}
			else if (direction == 1) {
				x[0] = x[0]-objSize;
			}
			long now=System.currentTimeMillis();
			long elapsed=now-starttime;
			score = elapsed/250;
		if((elapsed/100) % 2 == 0) {
			snakeLength++;
		}	
			checkCollision();
		}
		repaint();
	}
	
	
	
}
