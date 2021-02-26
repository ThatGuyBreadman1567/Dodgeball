import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Stickman extends JComponent
{
	private Ellipse2D.Double head;
	private Rectangle2D.Double arms,body,leg1,leg2;
	private int dx, dy;
	private Color color;
	
	public Stickman(int x, int y, Color c)
	{
		head = new Ellipse2D.Double(0,0,10,10);
		arms = new Rectangle2D.Double(0,10,10,5);
		body = new Rectangle2D.Double(4,10,3,10);
		leg1 = new Rectangle2D.Double(1,20,3,7);
		leg2 = new Rectangle2D.Double(7,20,3,7);
		
		dx = 0;
		dy = 0;
		color = c;
		
		this.setSize(11,35);
		this.setLocation(x,y);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(color);
		g2.fill(head);
		g2.fill(arms);
		g2.fill(body);
		g2.fill(leg1);
		g2.fill(leg2);
	}
	
	public void setDx(int x)
	{
		dx = x;
	}
	
	public void setDy(int y)
	{
		dy = y;
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
}