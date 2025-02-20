package rsp;
//import javax.swing.JComponent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class rspGame extends JPanel implements ActionListener,MouseListener  {
	  JButton rock = new JButton("Rock (left click)");
	  JButton paper = new JButton("Paper (middle click)");
	  JButton scissors = new JButton("Scissors (right click)");
	  JLabel result = new JLabel(" Enter Your Choice ");
	  JLabel computerChoice = new JLabel("  ");
	  JRadioButton usemouse = new JRadioButton("Use Mouse");
	  
	  JTextField name = new JTextField("Hello Welcome to RSP game!",1);
	  JPanel textPanel = new JPanel();
	  JPanel choicePanel = new JPanel();
	  JPanel rbPanel = new JPanel();
	  JPanel namePanel = new JPanel();
	  JLabel imagedisplay;
	  ImageIcon image;
	  ImageIcon rockIm;
	  ImageIcon paperIm;
	  ImageIcon scissorsIm;
	  //Image scale;
	  Font textFont = new Font("SansSerif", Font.PLAIN, 40);
     
     public rspGame() {    	
    	//frame
    	 JFrame frame = new JFrame("rsp");
 		 frame.setLayout(new BorderLayout());
         frame.setSize(600, 450);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(false); //can't resize
         frame.setLocationRelativeTo(null);
         frame.setLayout(new BorderLayout());
         frame.add(this,BorderLayout.CENTER);
         setLayout(new BorderLayout());
         textPanel.setLayout(new GridLayout(3,1));
         choicePanel.setLayout(new GridLayout(1,3,10,50));
         rbPanel.setLayout(new GridLayout(1,1));
         //tf
         name.setFont(textFont);
         textPanel.add(name);
         
         
         
         //image setting
         image = new ImageIcon(getClass().getResource("image.png"));
         Image reimage = image.getImage();
         Image newimg = reimage.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH);
         image = new ImageIcon(newimg);
         
         rockIm = new ImageIcon(getClass().getResource("rock.png"));
         Image rerock = rockIm.getImage();
         Image newrockIm = rerock.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
         rockIm = new ImageIcon(newrockIm);
         
         paperIm = new ImageIcon(getClass().getResource("paper.png"));
         Image repaper = paperIm.getImage();
         Image newpaperIm = repaper.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
         paperIm = new ImageIcon(newpaperIm);
         
         scissorsIm = new ImageIcon(getClass().getResource("scissors.png"));
         Image rescissors = scissorsIm.getImage();
         Image newscissorsIm = rescissors.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
         scissorsIm = new ImageIcon(newscissorsIm);
         
         //add image
         imagedisplay = new JLabel(image);
         add(imagedisplay,BorderLayout.CENTER);
         //add choice component
         choicePanel.add(rock);
         choicePanel.add(paper);
         choicePanel.add(scissors);
         add(choicePanel,BorderLayout.SOUTH);
         //add text
         textPanel.add(result);
         textPanel.add(computerChoice);
         result.setFont(textFont);
         computerChoice.setFont(textFont);
         add(textPanel,BorderLayout.NORTH);
         //add mouse option
         rbPanel.add(usemouse);
         add(rbPanel,BorderLayout.EAST);
         //add Listener
         rock.addActionListener(this);
         paper.addActionListener(this);
         scissors.addActionListener(this);
         //usemouse.addItemListener(this);
         frame.addMouseListener(this);
         
         
     }
    
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		byte p = 0;
		int playerChoice = p;
        double c = 0;
        int comChoice = (int)c;
        String winner;
        Random randomCom = new Random();
		if(usemouse.isSelected() == true) {
			if((e.getModifiersEx() == InputEvent.BUTTON1_DOWN_MASK)) {
				playerChoice = 0;
			}
			else if (e.getModifiersEx() == InputEvent.BUTTON2_DOWN_MASK) {
	        	playerChoice = 1;
	        }
	        else if (e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {
	        	playerChoice = 2;
	        }
			//random choice
	        comChoice = randomCom.nextInt(3);
	        winner = findWinner(playerChoice, comChoice);
	        result.setText(" "+winner + "!"); 
	        if (comChoice == 0) { 
	        	computerChoice.setText(" Computer choice is rock ");
	        	imagedisplay.setIcon(rockIm);
	        }
	        else if (comChoice == 1) {
	        	computerChoice.setText(" Computer choice is paper ");
	        	imagedisplay.setIcon(paperIm);
	        }
	        else if (comChoice == 2){
	        	computerChoice.setText(" Computer choice is scissors ");
	        	imagedisplay.setIcon(scissorsIm);
	        }
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		byte p = 0;
		int playerChoice = p;//implicit
        double c = 0;
        int comChoice = (int)c;//explicit
        String winner;
        Random randomCom = new Random();
        
        if(usemouse.isSelected()== false) {
        	if (e.getSource()== rock) {
				playerChoice = 0;
				}
        	else if (e.getSource() == paper) {
        		playerChoice = 1;
        	}
        	else if (e.getSource() == scissors) {
        		playerChoice = 2;
        	}
        	//random choice
        	comChoice = randomCom.nextInt(3);
        	winner = findWinner(playerChoice, comChoice);
        	result.setText(" "+winner + "!"); 
        	if (comChoice == 0) { 
        		computerChoice.setText(" Computer choice is rock ");
        		imagedisplay.setIcon(rockIm);
        	}
        	else if (comChoice == 1) {
        		computerChoice.setText(" Computer choice is paper ");
        		imagedisplay.setIcon(paperIm);
        	}
        	else if (comChoice == 2){
        		computerChoice.setText(" Computer choice is scissors ");
        		imagedisplay.setIcon(scissorsIm);
        		
        	}
        }
        
	}
	 protected String findWinner(int playerChoice, int comChoice) {
        String winner;
        if (playerChoice == comChoice) { 
            winner = "tie";
        } else if (playerChoice == 0 && comChoice == 1) {
            winner = "Computer win"; 
        } else if (playerChoice == 1 && comChoice == 2) {
            winner = "Computer win"; 
        } else if (playerChoice == 2 && comChoice == 0) {
            winner = "Computer win"; 
        } else {
            winner = "Player win"; 
        } return winner; 
    }
     
    

}
