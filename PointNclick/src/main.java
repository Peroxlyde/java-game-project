import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import rsp.rspGame;
public class main extends JFrame implements ActionListener{
	private JButton rspButton;
    private JButton exitButton;
    private JPanel gameName;
    private JLabel gameNameLabel;
    protected Font titleFont = new Font("SansSerif", Font.PLAIN, 40);
    private JButton gameButton;
    
    public main() {
    	//frame
    	super("Main Menu");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //can't resize
        setLocationRelativeTo(null);
        
        //menu panel
        gameName = new JPanel();
        gameName.setBounds(45, 100, 400, 150);
        gameNameLabel = new JLabel("Mini Game");
        gameNameLabel.setFont(titleFont);
        gameName.add(gameNameLabel);
        add(gameName);
        //button
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 150, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(200, 100, 60, 100));
        rspButton = new JButton("Start RSP Game");
        rspButton.setBackground(Color.white);
        rspButton.addActionListener(this);
        gameButton = new JButton("Start SnakeTron Game");
        gameButton.setBackground(Color.white);
        gameButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.setBackground(Color.white);
        exitButton.addActionListener(this);
        mainPanel.add(rspButton);
        mainPanel.add(gameButton);
        mainPanel.add(exitButton);
        add(mainPanel);
       
   
        
       
        
        
    }

	public static void main(String[] args) {
		new main();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==rspButton) {
			new rspGame();
		
			
		}
		else if (e.getSource()==gameButton) {
			new snakeGame();
		}
		else if (e.getSource()==exitButton) {
			System.exit(0);
		}
			
	}

}
