import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class DodgeballMain extends JFrame implements ActionListener
{
	private ArrayList<Ball> ballsLeft, ballsRight;
	private Stickman dodgeman1, dodgeman2; 
	
	public DodgeballMain()
	{
		setBounds(100,100,600,400);
		setTitle("Dodgeball");
		setLayout(null);
		
		dodgeman1 = new Stickman(100,100,Color.BLUE);
		dodgeman2 = new Stickman(500,100,Color.RED);
		
		add(dodgeman1);
		add(dodgeman2);
		
		Timer t1 = new Timer(15,this);
		t1.start();
		
//		Insets inset = this.getInsets();
//		inset.set(10, 10, this.getHeight()-40, this.getWidth()-25);
//		
//		this.addComponentListener(new ComponentListener()
//				{
//					public void componentResized(ComponentEvent e) 
//					{
//						inset.set(10, 10, getHeight()-40, getWidth()-25);
//					}
//					public void componentMoved(ComponentEvent e) {	
//					}
//					public void componentShown(ComponentEvent e) {	
//					}
//					public void componentHidden(ComponentEvent e) {
//					}
//				});
		
		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_A)
					dodgeman1.setDx(-5);
				else if(e.getKeyCode() == e.VK_D)
					dodgeman1.setDx(5);
				else if(e.getKeyCode() == e.VK_W)
					dodgeman1.setDy(-5);
				else if(e.getKeyCode() == e.VK_S)
					dodgeman1.setDy(5);
				
				if(dodgeman1.getY() < 0 || dodgeman1.getY() > getHeight())
					dodgeman1.setDy(0);
				if(dodgeman1.getX() < 0 || dodgeman1.getX() > getWidth())
					dodgeman1.setDx(0);
				
				if(e.getKeyCode() == e.VK_SPACE)
				{
				}
					
				if(e.getKeyCode() == e.VK_LEFT)
					dodgeman2.setDx(-5);
				else if(e.getKeyCode() == e.VK_RIGHT)
					dodgeman2.setDx(5);
				else if(e.getKeyCode() == e.VK_UP)
					dodgeman2.setDy(-5);
				else if(e.getKeyCode() == e.VK_DOWN)
					dodgeman2.setDy(5);
				
				if(dodgeman2.getY() < 0 || dodgeman2.getY() > getHeight())
					dodgeman2.setDy(0);
				if(dodgeman2.getX() < 0 || dodgeman2.getX() > getWidth())
					dodgeman2.setDx(0);
				
				if(e.getKeyCode() == e.VK_ENTER)
				{
				}
			}
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_LEFT)
					dodgeman2.setDx(0);
				else if(e.getKeyCode() == e.VK_RIGHT)
					dodgeman2.setDx(0);
				else if(e.getKeyCode() == e.VK_UP)
					dodgeman2.setDy(0);
				else if(e.getKeyCode() == e.VK_DOWN)
					dodgeman2.setDy(0);
				
				if(e.getKeyCode() == e.VK_A)
					dodgeman1.setDx(0);
				else if(e.getKeyCode() == e.VK_D)
					dodgeman1.setDx(0);
				else if(e.getKeyCode() == e.VK_W)
					dodgeman1.setDy(0);
				else if(e.getKeyCode() == e.VK_S)
					dodgeman1.setDy(0);
			}
			public void keyTyped(KeyEvent e) {
			}});
		
		setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new DodgeballMain();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(dodgeman1.getX() < 0)
			dodgeman1.setLocation(0,dodgeman1.getY());
		if(dodgeman1.getX() + dodgeman1.getWidth() > getWidth())
			dodgeman1.setLocation(getWidth()-30,dodgeman1.getY());
		if(dodgeman1.getY() < 0)
			dodgeman1.setLocation(dodgeman1.getX(),0);
		if(dodgeman1.getY() + dodgeman1.getHeight() > getHeight())
			dodgeman1.setLocation(dodgeman1.getX(),getHeight()-70);
		
		if(dodgeman2.getX() < 0)
			dodgeman2.setLocation(0, dodgeman2.getY());
		if(dodgeman2.getX() + dodgeman1.getWidth() > getWidth())
			dodgeman2.setLocation(getWidth()-30, dodgeman2.getY());
		if(dodgeman2.getY() < 0)
			dodgeman2.setLocation(dodgeman2.getX(), 0);
		if(dodgeman2.getY() + dodgeman2.getHeight() > getHeight())
			dodgeman2.setLocation(dodgeman2.getX(),getHeight()-70);
		
		dodgeman1.update();
		dodgeman2.update();
		
		repaint();
	}

}